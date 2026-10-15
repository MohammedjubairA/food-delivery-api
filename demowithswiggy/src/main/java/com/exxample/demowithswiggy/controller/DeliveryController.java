package com.exxample.demowithswiggy.controller;
import com.example.demowithswiggy.entity.*;
import com.example.demowithswiggy.dao.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
	@Autowired 
	FoodOrderRepo fo3;
	@GetMapping("/orderdetails/{partnerid}")
	public List<FoodOrder> get7(@PathVariable int partnerid)
	{
		return fo3.findByDeliverypartner_Id(partnerid);
	}
	
	@PutMapping("/status/{orderid}")
	public FoodOrder get8(@PathVariable int orderid)
	{
	FoodOrder o=fo3.findById(orderid).get();
	o.setStatus(OrderStatus.DELIVERED);
	return fo3.save(o);
	}
}
