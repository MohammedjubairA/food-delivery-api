package com.exxample.demowithswiggy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demowithswiggy.entity.*;
import com.example.demowithswiggy.dao.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
		@Autowired
		RestuarantRepo rr1;
		@Autowired
		FoodItemRepo fi1;
		@Autowired 
		FoodOrderRepo fo1;
		@Autowired
		UserRepo ur2;
		
		@PostMapping("/addrestuarant")
		public Restuarant get1(@RequestBody Restuarant r)
		{
			return rr1.save(r);
		}
		@PostMapping("/addfooditems")
		public FoodItem get2(@RequestBody FoodItem fi)
		{
			return fi1.save(fi);
		}
		@PutMapping("/assign/{orderid}/{partnerid}")
		public FoodOrder get3(@PathVariable int orderid,@PathVariable  int partnerid)
		{
			FoodOrder order = fo1.findById(orderid).get();
			User u = ur2.findById(partnerid).get();
			
			order.setDeliverypartner(u);
			order.setStatus(OrderStatus.OUT_FOR_DELIVERY);
			return fo1.save(order);
		}
		
}
