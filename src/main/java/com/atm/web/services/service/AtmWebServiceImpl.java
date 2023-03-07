package com.atm.web.services.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atm.web.services.model.Product;
import com.atm.web.services.dto.ProductInfo;

@Service
public class AtmWebServiceImpl implements AtmWebService{
	
private static final Log log = LogFactory.getLog(AtmWebServiceImpl.class);
    
    @Autowired
    private ProductService productService;
    
	@Override
	public List<ProductInfo> getProducts() {
		List<ProductInfo> listProducts = new ArrayList<>();
		for (Product product : productService.list()) {
			ProductInfo item = new ProductInfo();
			item.setId(product.getId());
			item.setName(product.getName());
			item.setImage(product.getImage());
			listProducts.add(item);
		}
		return listProducts;
	}
	
}
