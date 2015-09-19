package com.bgmagar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bgmagar.dao.ProductDao;
import com.bgmagar.domain.Category;
import com.bgmagar.domain.Product;
import com.bgmagar.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> getProductList(){
		return productDao.getProductList();
	}

	@Override
	public Product getProduct(int id) {
		return productDao.getProduct(id);
	}

	@Override
	public void addProduct(Product product) {
		productDao.addProduct(product);
		
	}

	@Override
	public void updateProduct(int id, Product product) {
		productDao.updateProduct(id, product);
		
	}

	@Override
	public List<Category> getCategoryList() {
		return productDao.getCategoryList();
		
	}
	
	

}
