package com.revature.data;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.User;

/*
 * @Transactional - we need this annotation to indicate
 * that the TX manager should be used here, and to manage
 * our transactions. This annotation can be applied to 
 * classes, as well as methods to provide more information
 * on how you want your transactions to be managed
 * 
 * @Repository - annotate classes at the persistence 
 * layer, which will act as a DB repository, but it is
 * not necessary
 */


@Transactional 
@Repository
public class UserRepository {
	
	@Autowired 
	SessionFactory sf;
	
	public User getById(int id) {
		return (User) sf.getCurrentSession().get(User.class, id);
	}
	
	public List<User> getAll(){
		Criteria c = sf.getCurrentSession().createCriteria(User.class);
		return c.list();
	}
	
	//DO NOT NEED TO COMMIT TO PERSIST DATA 
	//TRANSACTION MANAGER HANDLES THIS NOW
	public User save(User u) {
		int id = (int) sf.getCurrentSession().save(u);
		u.setId(id);
		return u;
	}
	
	public User getByUsername(String username) {
		Query q  = sf.getCurrentSession().createQuery("From User where lower(username) = :param");
		q.setString("param", username.toLowerCase());
		return (User) q.uniqueResult();
	}
	

}
