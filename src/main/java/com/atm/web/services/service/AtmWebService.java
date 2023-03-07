package com.atm.web.services.service;

import java.util.List;

import com.atm.web.services.dto.ProductInfo;

public interface AtmWebService {
	
	List<ProductInfo> getProducts();
}
