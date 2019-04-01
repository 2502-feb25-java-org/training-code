package com.revature.data;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.Post;
import com.revature.model.User;
import com.revature.util.ConnectionUtil;

public class PostRepository {
	
	ConnectionUtil util = ConnectionUtil.getInstance();
	
	public List<Post> getLengthyPosts(){
		Session session = util.getSession();
		try {
			Query q = session.getNamedQuery("getLongPosts");
			return q.list();	
		}
		finally {
			session.close();
		}
	}
	
	public Post save(Post p) {
		Session session = util.getSession();
		try {
			Transaction tx = session.beginTransaction();
			int id = (int) session.save(p);
			tx.commit();
			p.setId(id);
		}finally {
			session.close();
		}
		return p;
	}
	
	public List<Post> getByAuthor(User auth){
		
		List<Post> posts = new ArrayList<Post>();
		//get all posts by author
		Session session = util.getSession();
		try {
			Query q = session.createQuery
					("from Post where author = :u");
			q.setParameter("u", auth);
			posts = q.list();
		}
		finally {
			session.close();
		}
		return posts;
	}

}
