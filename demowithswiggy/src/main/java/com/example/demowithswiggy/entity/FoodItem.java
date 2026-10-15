package com.example.demowithswiggy.entity;
import jakarta.persistence.*;


@Entity

public class FoodItem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String name;
	int price;
	
	@ManyToOne
	Restuarant rest;

	public FoodItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FoodItem(String name, int price, Restuarant rest) {
		super();
		this.name = name;
		this.price = price;
		this.rest = rest;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Restuarant getRest() {
		return rest;
	}

	public void setRest(Restuarant rest) {
		this.rest = rest;
	}
	
}
