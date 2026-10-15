package com.example.demowithswiggy.dao;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demowithswiggy.entity.*;
public interface UserRepo extends JpaRepository<User,Integer>{
	
	Optional<User> findByName(String name);
}
