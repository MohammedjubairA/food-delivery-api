package com.example.demowithswiggy.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demowithswiggy.entity.*;
public interface FoodOrderRepo extends JpaRepository<FoodOrder,Integer>{
	List<FoodOrder> findByDeliverypartner_Id(int id);
}
