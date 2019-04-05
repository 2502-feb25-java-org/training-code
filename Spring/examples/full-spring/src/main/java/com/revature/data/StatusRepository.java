package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {

}
