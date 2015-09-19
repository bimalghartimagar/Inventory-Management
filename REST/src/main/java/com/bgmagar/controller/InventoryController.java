package com.bgmagar.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bgmagar.domain.Product;
import com.bgmagar.service.ProductService;

@RestController
public class InventoryController {

	@Autowired
	private ProductService productService;

	@Autowired
	private HttpServletRequest request;

	static private Map<String, Integer> requestMap = new HashMap<String, Integer>();

	List<Product> pList = new ArrayList<Product>();

	@RequestMapping(value = { "/", "/api" })
	private ModelAndView welcome() throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				getClass().getResourceAsStream("/help.html")));

		StringBuilder helpString = new StringBuilder();

		String part = "";

		while ((part = reader.readLine()) != null) {

			helpString.append(part);
		}
		System.out.println(request.getRemoteAddr());
		;

		return new ModelAndView("index");
	}

	/**
	 * @return list of product
	 */
	@RequestMapping(value = "/api/product", method = RequestMethod.GET)
	private Map<String, Object> getProductList() {

		addRequest(request.getRemoteAddr());

		Map<String, Object> map = new HashMap<String, Object>();

		Map<Object, Object> metaMap = new HashMap<Object, Object>();

		map.put("products", productService.getProductList());

		metaMap.put("totalRecords", productService.getProductList().size());

		metaMap.put("page", 0);

		map.put("meta", metaMap);

		return map;
	}

	/**
	 * @param id
	 * @return product associated with @param id
	 */
	@RequestMapping(value = "/api/product/{id}", method = RequestMethod.GET)
	private Object getProduct(@PathVariable int id) {

		addRequest(request.getLocalAddr());

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
	private ResponseEntity<Product> updateProduct(@PathVariable int id,
			@RequestBody Product product) {

		productService.updateProduct(id, product);

		return new ResponseEntity<Product>(HttpStatus.OK);

	}

	@RequestMapping(value = "/api/category", method = RequestMethod.GET)
	private Map<String, Object> getCategory() {

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("categories", productService.getCategoryList());

		return map;

	}

	private void addRequest(String ip) {

		if (requestMap.containsKey(ip)) {

			Integer requestCount = requestMap.get(ip);

			requestCount++;

			requestMap.put(ip, requestCount);

			System.out.println("IP " + ip + " has sent request " + requestCount
					+ " times");
		} else {

			requestMap.put(ip, 1);

			System.out.println("IP " + ip + " has sent request first time");
		}

	}

}
