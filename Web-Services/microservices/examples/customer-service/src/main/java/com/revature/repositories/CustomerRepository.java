package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
