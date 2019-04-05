package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {

}
