package com.sndi.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sndi.admin.entities.User;

public interface UserRepository extends JpaRepository<User, String>{

}
