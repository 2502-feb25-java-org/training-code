package com.revature.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
	
	public List<Account> findByCustomerid(int id);

}
