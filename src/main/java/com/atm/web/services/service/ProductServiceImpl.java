package com.atm.web.services.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atm.web.services.model.Product;
import com.atm.web.services.repository.ProductDao;

@Service
public class ProductServiceImpl implements ProductService{
	
private static final Log log = LogFactory.getLog(ProductServiceImpl.class);
    
    @Autowired
    private ProductDao productDao; 
    
	@Override
	public List<Product> list() {
		return productDao.findAll(); 
	}

}
