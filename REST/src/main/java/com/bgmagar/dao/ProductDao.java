package com.bgmagar.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bgmagar.domain.Product;


@Repository
public interface ProductDao {

	public List<Product> getProductList();
	
	public Product getProduct(int i);
}
