package com.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.model.TravelModel;
import com.travel.model.admin;

public interface adminrepository extends JpaRepository<admin, Integer>{
	admin findByUsernameAndPassword(String username, String password);
}
