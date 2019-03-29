package com.revature.app;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.revature.model.User;
import com.revature.util.ConnectionUtil;

public class ExploringHibernate {
	
	static ConnectionUtil util = ConnectionUtil.getInstance();
	final static Logger log = Logger.getLogger(ExploringHibernate.class);
	
	public static void main(String[] args) {
		System.out.println(findByUsername("test"));
		
	}
	
	/*
	 * SAVE
	 * - session.save(Object);
	 * - adds instance to db
	 * - persists transient instance, returns whatever Serializable
	 * identifier is used for the instance 
	 * - saving a persistent instance does nothing 
	 * - saving a detached instance creates a new persistant instance
	 * and assigns it a new identifier, which results in a duplicate
	 * record. do not do!
	 */
	static User save() {
		
		User u = new User("Pooh Bear2", "Hibernates!"); //TRANSIENT STATE
		u.setUsername("transient");

		//get a session so that we can call methods of the session interface
		Session session = util.getSession();
		log.info("OPENED SESSION " + session);
		try {
			//Session does not implement autoclosable, must close in finally block
			//in hibernate, we must MANAGE OUR TRANSACTIONS
			Transaction tx = session.beginTransaction();
			int id = (int) session.save(u); //NOW USER IS IN THE PERSISTENT STATE
			
			
			u.setUsername("testing auto dirty checking");
			u.setPassword("more tests");
		
			tx.commit();
			u.setId(id);
		}
		finally {
			log.info("ABOUT TO CLOSE SESSION");
			session.close(); //NOW U IS DETACHED
		}
		u.setUsername("detached");
		return u;
	}
	
	
	/* PERSIST
	 * The persist method is intended for adding a new entity 
	 * instance to the persistence context
	 * Close behavior to save(), except if we attempt to call 
	 * persist on a detached object, an exception will be thrown
	 */

	static void saveVSpersist() {
		User u = new User(1, "test2", "user"); //attempting to save a user with an ID that exists
		Session session = util.getSession();
		try {
			Transaction tx = session.beginTransaction();
			/*
			 * This works fine with save(), but with persist, 
			 * if we attempt to call the method on an object
			 * with an ID that exists ( call persist() on
			 * a detached object) we get a
			 *   org.hibernate.PersistentObjectException: detached entity passed to persist
			 */
			session.persist(u); 
			tx.commit();
		}
		finally {
			session.close();
		}
	}
	static void persist() {
		//does not work 
		//User u = new User(15, "test2", "user"); //attempting to persist a user with an ID that isnt in db
		
		//cannot give an ID to an object you wish to persist
		User u = new User("persisting", "user");
		Session session = util.getSession();
		try {
			Transaction tx = session.beginTransaction();
			session.persist(u); 
			tx.commit();
		}
		finally {
			session.close();
		}
	}

	
	/*
	 * GET
	 *  Session.get(id)
	 * - returns persisted object with specified identifier
	 * - if the object does not exist, the method will return null
	 * - method hits the database immediately, regardless of whether
	 * or not any methods are called on the object in the persistent state
	 * - use this method to retrieve data that we are not sure exists
	 */
	
	static User get(int id) {
		Session session = util.getSession();
		User u = (User) session.get(User.class, id);
		log.info("GOT USER without calling any methods");
		session.close();
		return u;
	}
	
	/*
	 * Session.load(id)
	 * - retrieves a persisted instance by id. 
	 * - load will throw an ObjectNotFoundException if it attempts 
	 * to load a nonexistent row 
	 * - this method returns a PROXY of the object and does not 
	 * hit the database until a method of the object is called
	 * while the session is still open
	 * - If a method is called on a proxy, we see a LazyInitializationException
	 * - a proxy is a hibernate object that allows for lazy loading
	 * of data; it is basically a shell of an object that holds the 
	 * ID of it without any actual data from DB. Gets data when it 
	 * has a method called on it 
	 */
	static User load(int id) {
		Session session = util.getSession();
		User u = (User) session.load(User.class, id);
		log.info("LOADED USER without calling any methods on it");
		log.info(u.toString());
		
		session.close();
		return u;
	}
	
	/*
	 * session.update(Object)
	 * - acts upon method passed in (void return type)
	 * - transitions the object passed in as param from detached to persistent 
	 * - throws an exception if you pass it a transient entity
	 * - org.hibernate.StaleStateException: 
	 */
	static void update() {
		Session session = util.getSession();
		try {
			User u = new User("HI THERE", "test");
			Transaction tx = session.beginTransaction();
			u.setUsername("syzgvuysgdu");
			session.update(u);		
			tx.commit();
		}
		finally {
			session.close();
		}
	}
	

	/*
	 * session.merge(Object)
	 * - main purpose of this method is to update a 
	 * persistent entity instance with new 
	 * fields from a detached entity instance 
	 * - if the entity is detached, it is copied upon an
	 * existing persistent entity (in practice, it's updated
	 * and brought into the persistent state)
	 * - if the entity is transient, the values are 
	 * copied to a newly persistent entity 
	 */
	static void merge() {
		Session session = util.getSession();
		try {
			User u = new User("THIS WILL WORK", "test");
			Transaction tx = session.beginTransaction();
			u.setUsername("IM OVER THIS");
			session.merge(u);		
			tx.commit();
		}
		finally {
			session.close();
		}
	}
	
	/*
	 * QUERY
	 * Hibernate's interface to write queries with HQL
	 */
	
	static User findByUsername(String username) {
		User u = null;
		Session session = util.getSession();
		try {
			Query query = session.createQuery("from User where lower(username) = :param");
			query.setParameter("param", username.toLowerCase());
			u = (User) query.uniqueResult();
		}
		finally {
			session.close();
		}
		
		return u;
		
	}
	
	
	static List<User> findAll(){
		Session session = util.getSession();
		try {
			Query query = session.createQuery("from User");
			return query.list();
		}
		finally {
			log.info("in finally block");
			session.close();
		}
	}
	
	/*
	 * CRITERIA - Hibernate's interface to programatically (basically, via methods)
	 * write queries
	 */
	static List<User> findAllCriteria(){
		Session session = util.getSession();
		try {
			Criteria criteria = session.createCriteria(User.class)
					.addOrder(Order.asc("username"))
					.add(Restrictions.ge("id", 4));
			
			return criteria.list();
		}
		finally {
			session.close();
		}
	}
}



