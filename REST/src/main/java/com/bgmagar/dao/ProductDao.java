package com.bgmagar.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bgmagar.domain.Category;
import com.bgmagar.domain.Product;


@Repository
public interface ProductDao {

	public List<Product> getProductList();
	
	public Product getProduct(int i);
	
	public void addProduct(Product product);
	
	public void updateProduct(int id, Product product);

	public List<Category> getCategoryList();

}
