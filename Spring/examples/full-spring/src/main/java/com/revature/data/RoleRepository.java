package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
