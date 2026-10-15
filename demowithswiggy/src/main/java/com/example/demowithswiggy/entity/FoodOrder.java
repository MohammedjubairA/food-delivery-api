package com.example.demowithswiggy.entity;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class FoodOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@ManyToOne
	User customer;
	
	@ManyToOne
	User deliverypartner;
	
	@ManyToMany
	List<FoodItem> items;
	
	@Enumerated(EnumType.STRING)
	OrderStatus status;

	public FoodOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FoodOrder(User customer, User deliverypartner, List<FoodItem> items, OrderStatus status) {
		super();
		this.customer = customer;
		this.deliverypartner = deliverypartner;
		this.items = items;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public User getDeliverypartner() {
		return deliverypartner;
	}

	public void setDeliverypartner(User deliverypartner) {
		this.deliverypartner = deliverypartner;
	}

	public List<FoodItem> getItems() {
		return items;
	}

	public void setItems(List<FoodItem> items) {
		this.items = items;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	
}
