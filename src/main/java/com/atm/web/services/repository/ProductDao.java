package com.atm.web.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atm.web.services.model.*;


public interface ProductDao extends JpaRepository<Product, Long>{
	List<Product> findAll();
}
