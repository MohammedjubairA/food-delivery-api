package com.exxample.demowithswiggy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demowithswiggy.entity.*;
import com.example.demowithswiggy.dao.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	UserRepo ur1;
	
	PasswordEncoder a;
	
	@PostMapping("/register")
	public User register(@RequestBody User u)
	{
		u.setPassword(a.encode(u.getPassword()));
		return ur1.save(u);
	}

}
