package com.bgmagar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bgmagar.dao.ProductDao;
import com.bgmagar.domain.Product;
import com.bgmagar.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;

	public List<Product> getProductList(){
		return productDao.getProductList();
	}

	@Override
	public Product getProduct(int id) {
		return productDao.getProduct(id);
	}

}
