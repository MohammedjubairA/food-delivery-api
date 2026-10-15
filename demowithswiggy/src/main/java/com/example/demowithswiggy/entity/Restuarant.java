package com.example.demowithswiggy.entity;

import jakarta.persistence.*;

@Entity
public class Restuarant {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		int id;
		String name;
		String location;
		public Restuarant() {
			super();
			
		}
		public Restuarant(String name, String location) {
			super();
			this.name = name;
			this.location = location;
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
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		
		
}
