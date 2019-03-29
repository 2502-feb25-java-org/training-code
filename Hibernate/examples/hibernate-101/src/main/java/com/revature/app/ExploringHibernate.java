package com.revature.app;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.User;
import com.revature.util.ConnectionUtil;

public class ExploringHibernate {
	
	static ConnectionUtil util = ConnectionUtil.getInstance();
	final static Logger log = Logger.getLogger(ExploringHibernate.class);
	
	public static void main(String[] args) {
		save();
	}
	
	/*
	 * SAVE
	 * - session.save(Object);
	 * - adds instance to db
	 * - persists transient instance, returns whatever Serializable
	 * identifier is used for the instance 
	 * - saving a persisted instance does nothing 
	 * - saving a detached instance creates a new persistant instance
	 * and assigns it a new identifier, which results in a duplicate
	 * record. do not do!
	 */
	static User save() {
		
		User u = new User("Pooh Bear", "Hibernates!"); //TRANSIENT STATE

		//get a session so that we can call methods of the session interface
		Session session = util.getSession();
		log.info("OPENED SESSION " + session);
		try {
			//Session does not implement autoclosable, must close in finally block
			//in hibernate, we must MANAGE OUR TRANSACTIONS
			Transaction tx = session.beginTransaction();
			int id = (int) session.save(u); //NOW USER IS IN THE PERSISTENT STATE
			
			tx.commit();
			u.setId(id);
		}
		finally {
			log.info("ABOUT TO CLOSE SESSION");
			session.close();
		}
		return u;
	}

}
