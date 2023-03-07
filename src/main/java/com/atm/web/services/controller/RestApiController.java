package com.atm.web.services.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.atm.web.services.dto.ProductInfo;
import com.atm.web.services.service.AtmWebServiceImpl;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class RestApiController {
	
	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);
	
	@Autowired
    private AtmWebServiceImpl atmWebService;
	
	
	@RequestMapping("/")
    public String index() {
        return "Web Rest API";
    }
	
	@PostMapping("/listProduct")
    public @ResponseBody List<ProductInfo> listProduct() {
    	return atmWebService.getProducts();
    }
}

