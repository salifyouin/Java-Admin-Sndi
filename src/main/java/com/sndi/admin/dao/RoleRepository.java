package com.sndi.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sndi.admin.entities.Role;

public interface RoleRepository extends JpaRepository<Role, String>{

}
