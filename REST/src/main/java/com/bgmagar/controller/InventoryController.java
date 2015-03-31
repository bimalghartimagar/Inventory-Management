package com.bgmagar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bgmagar.domain.Product;
import com.bgmagar.service.ProductService;

@RestController
@RequestMapping("/api")
public class InventoryController {
	
	@Autowired
	private ProductService productService;
	
	List<Product> pList = new ArrayList<Product>();
	
	/**
	 * @return list of person
	 */
	@RequestMapping(value="/product", method=RequestMethod.GET)
	private List<Product> getPerson() {
		
		return productService.getProductList();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Add person to the list
	 * @return HttpStatus.OK
	 */
	@RequestMapping(value="/product", method=RequestMethod.POST)
	private ResponseEntity<Product> setPerson(@RequestBody Product person) {
		

		
		return new ResponseEntity<Product>(HttpStatus.OK);
		
	}
	
	/**
	 * 
	 * @param id
	 * @return person associated with @param id
	 */
	@RequestMapping(value="/product/{id}", method=RequestMethod.GET)
	private Product getProduct(@PathVariable int id) {
		return productService.getProduct(id);
		
	}
	
	/**
	 * 
	 * @param id
	 * Update detail of person associated with @param id
	 * @return HttpStatus.OK
	 */
	@RequestMapping(value="/person/{id}", method=RequestMethod.POST)
	private ResponseEntity<Product> updatePerson(@PathVariable int id) {
		
		return new ResponseEntity<Product>(HttpStatus.OK);
		
	}

}
