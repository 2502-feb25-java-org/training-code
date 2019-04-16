package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
