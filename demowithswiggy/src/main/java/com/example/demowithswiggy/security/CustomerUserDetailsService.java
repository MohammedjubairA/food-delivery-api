package com.example.demowithswiggy.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.demowithswiggy.entity.*;
import com.example.demowithswiggy.dao.*;
@Service
public class CustomerUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserRepo xyz;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			
		User u = xyz.findByName(username).orElseThrow(()-> new UsernameNotFoundException("usernot found"));
		UserBuilder builder = org.springframework.security.core.userdetails.User.builder();
		
		builder.username(u.getName());
		builder.password(u.getPassword());
		builder.roles(u.getRole().name());
		return builder.build();
	}

}