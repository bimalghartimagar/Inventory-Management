package com.bgmagar.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bgmagar.dao.ProductDao;
import com.bgmagar.domain.Product;
import com.bgmagar.mapper.ProductMapper;

public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Product> getProductList() {
	
		return jdbcTemplate.query("SELECT ID, NAME, RATE, QUANTITY, COMPANY, DESCRIPTION, UPDATE_DATE FROM product", new ProductMapper());
	}

}
