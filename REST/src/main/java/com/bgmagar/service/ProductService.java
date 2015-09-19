package com.bgmagar.service;

import java.util.List;

import com.bgmagar.domain.Category;
import com.bgmagar.domain.Product;

public interface ProductService {

	public List<Product> getProductList();
	
	public Product getProduct(int id);
	
	public void addProduct(Product product);
	
	public void updateProduct(int id, Product product);

	public List<Category> getCategoryList();

}
