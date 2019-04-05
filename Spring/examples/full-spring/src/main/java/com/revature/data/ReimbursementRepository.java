package com.revature.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Reimbursement;
import com.revature.model.Status;
import com.revature.model.Type;
import com.revature.model.User;

@Repository
public interface ReimbursementRepository extends JpaRepository<Reimbursement, Integer>{

	List<Reimbursement> findByAuthor(User author);
	
	List<Reimbursement> findByType(Type type);
	
	List<Reimbursement> findByStatus(Status status);
}
