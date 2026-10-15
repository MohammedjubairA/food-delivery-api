package com.exxample.demowithswiggy.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demowithswiggy.entity.*;
import com.example.demowithswiggy.dao.*;
import java.util.*;

@RestController
@RequestMapping("/customer")
public class UserController {
	
	@Autowired
	FoodItemRepo fi2;
	@Autowired 
	FoodOrderRepo fo2;
	@Autowired
	UserRepo ur3;
	
	@GetMapping("/foods")
	public List<FoodItem> get5()
	{
		return fi2.findAll();
	}
	@PostMapping("/order/{customerid}")
	public FoodOrder get6(@PathVariable int customerid,@RequestBody List<Integer> foodids)
	{
		FoodOrder order1 = new FoodOrder();
		order1.setCustomer(ur3.findById(customerid).get());
		order1.setItems(fi2.findAllById(foodids));
		order1.setStatus(OrderStatus.PLACED);
		return fo2.save(order1);
	}
		
}
