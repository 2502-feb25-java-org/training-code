package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.PostRepository;
import com.revature.model.Post;
import com.revature.model.User;

@Service
public class PostService {

	@Autowired
	PostRepository repo;
	
	public Post save(Post p) {
		return repo.save(p);
	}
	
	
	public List<Post> getByAuthor(User u){
		return repo.getAllByAuthor(u);
	}
}
