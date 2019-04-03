package com.revature.data;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Post;
import com.revature.model.User;

@Transactional
@Repository
public class PostRepository {
	
	@Autowired
	SessionFactory sf;
	
	public List<Post> getAllPosts(){
		Criteria c = sf.getCurrentSession().createCriteria(Post.class);
		return c.list();
	}
	
	public List<Post> getAllByAuthor(User author){
		Query q = sf.getCurrentSession().createQuery("FROM Post where author = :param");
		q.setEntity("param", author);
		return q.list();
	}
	
	public Post save(Post p) {
		int id = (int) sf.getCurrentSession().save(p);
		p.setId(id);
		return p;
	}

}
