package com.revature.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.User;
import com.revature.util.ConnectionUtil;

public class UserRepository {
	
	ConnectionUtil util = ConnectionUtil.getInstance();
	Logger log = Logger.getLogger(UserRepository.class);
	
	
	/*
	 * CREATE
	 * add transient user to db
	 */
	public User save(User u) {
		Session session = util.getSession();
		try {
			Transaction tx = session.beginTransaction();
			int id = (int) session.save(u);
			tx.commit();
			u.setId(id);
		}
		finally {
			session.close();
		}
		return u; //return user with autogenerated ID
		
	}
	
	/*
	 * READ 
	 * retrieve detached user from DB by ID
	 * return null if not existent
	 */
	public User get(int id) {
		Session session = util.getSession();
		User u = (User) session.get(User.class, id);
		log.info("Session.GET()" + u);
		session.close();
		return u;
	}
	
	public User getByUsername(String username) {
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
	
	public List<User> getAllUsers(){
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
	 * UPDATE
	 * 
	 */
	public void follow(User user, User toFollow) {
		Session session = util.getSession();
		try {
			Transaction tx = session.beginTransaction();
			user.getFollowing().add(toFollow);
			session.update(user); //only want to be able to follow people from an account that exists
			tx.commit();
		}finally {
			session.close();
		}
	}
	
	public void unfollow(User user, User toUnfollow) {
		Session session = util.getSession();
		try {
			Transaction tx = session.beginTransaction();
			for(User u : user.getFollowing()) {
				if(u.getId() == toUnfollow.getId()) {
					user.getFollowing().remove(u);
				}
			}
			session.update(user); 
			tx.commit();
		}finally {
			session.close();
		}
	}
	
	
	
	
	

}
