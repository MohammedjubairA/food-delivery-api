package com.example.demowithswiggy.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demowithswiggy.entity.*;
public interface RestuarantRepo extends JpaRepository<Restuarant,Integer> {

}
