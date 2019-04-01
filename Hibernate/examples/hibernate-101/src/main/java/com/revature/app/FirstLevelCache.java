package com.revature.app;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.User;
import com.revature.util.ConnectionUtil;

public class FirstLevelCache {
	
	/*
	 * Exploring caching in hibernate 
	 */
	
	static final Logger log = Logger.getLogger(FirstLevelCache.class);
	static ConnectionUtil util = ConnectionUtil.getInstance();
	
	public static void main(String[] args) {
		exploringL1();
	}
	
	static void exploringL1() {
		//open session -- which is where L1 cache lives 
		Session session = util.getSession();
		Transaction tx = session.beginTransaction();
		log.info("ABOUT TO RETRIEVE USER");
		User u = (User) session.get(User.class, 5);
		
		//log.info("CLEARING CACHE");
		//session.clear();
		log.info("RETRIEVED USER. ABOUT TO EXECUTE THE SAME QUERY AGAIN");
		User u1 = (User) session.get(User.class, 5);
		log.info("USER IS STORED IN CACHE " + session.contains(u));
		
		log.info("ABOUT TO CHANGE USER");
		session.evict(u);
		log.info("ABOUT TO EVICT EVICTED OBJECT");
		session.evict(u);
		u.setUsername("level 1 cache test");
		session.update(u);
		tx.commit();
	}
	
	static void twoSessions() {
		Session s1 = util.getSession();
		Session s2 = util.getSession();
		log.info("RETRIEVING USER FROM ONE SESSION");
		User u = (User) s1.get(User.class, 5);
		
		log.info("RETRIEVING USER FROM SESSION 2");
		User u2 = (User) s2.get(User.class, 5);
	}

}
