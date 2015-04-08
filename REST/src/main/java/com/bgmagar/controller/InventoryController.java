package com.bgmagar.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
@RequestMapping("/")
public class InventoryController {

	@Autowired
	private ProductService productService;

	List<Product> pList = new ArrayList<Product>();

	@RequestMapping(value = { "/", "/api" })
	private String welcome() throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				getClass().getResourceAsStream("/help.html")));

		StringBuilder helpString = new StringBuilder();

		String part = "";
		while ((part = reader.readLine()) != null) {
			helpString.append(part);
		}

		return helpString.toString();
	}

	/**
	 * @return list of product
	 */
	@RequestMapping(value = "/api/product", method = RequestMethod.GET)
	private List<Product> getProductList() {

		return productService.getProductList();
	}

	/**
	 * @param id
	 * @return product associated with @param id
	 */
	@RequestMapping(value = "/api/product/{id}", method = RequestMethod.GET)
	private Product getProduct(@PathVariable int id) {
		return productService.getProduct(id);

	}
	
	/**
	 * Add person to the list
	 * 
	 * @return HttpStatus.OK
	 */
	@RequestMapping(value = "/api/product", method = RequestMethod.PUT)
	private ResponseEntity<Product> addProduct(@RequestBody Product product) {
		
		productService.addProduct(product);


		return new ResponseEntity<Product>(HttpStatus.OK);

	}

	/**
	 * @param id
	 *            Update detail of person associated with @param id
	 * @return HttpStatus.OK
	 */
	@RequestMapping(value = "/api/product/{id}", method = RequestMethod.PUT)
	private ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product) {
		
		productService.updateProduct(id, product);

		return new ResponseEntity<Product>(HttpStatus.OK);

	}

}
