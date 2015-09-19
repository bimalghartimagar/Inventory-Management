package com.bgmagar.dao.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bgmagar.dao.ProductDao;
import com.bgmagar.domain.Category;
import com.bgmagar.domain.Product;
import com.bgmagar.mapper.CategoryMapper;
import com.bgmagar.mapper.ProductMapper;

public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Product> getProductList() {
		return jdbcTemplate.query("SELECT ID, NAME, RATE, QUANTITY, COMPANY, DESCRIPTION, UPDATE_DATE FROM product ", new ProductMapper());
	}

	@Override
	public Product getProduct(int id) {
		return jdbcTemplate.queryForObject("SELECT ID, NAME, RATE, QUANTITY, COMPANY, DESCRIPTION, UPDATE_DATE FROM product WHERE ID=?", new Object[]{id},new ProductMapper());
	}

	@Override
	public void addProduct(Product product) {
		jdbcTemplate.update("INSERT INTO product(ID, NAME, RATE, QUANTITY, COMPANY, DESCRIPTION, UPDATE_DATE) values (NULL,?,?,?,?,?,?)", new Object[]{product.getName(), product.getRate(), product.getQuantity(), product.getCompany(), product.getDescription(), new Date(new java.util.Date().getTime())});
		
	}

	@Override
	public void updateProduct(int id, Product product) {
		jdbcTemplate.update("UPDATE product SET NAME=?, RATE=?, QUANTITY=?, COMPANY=?, DESCRIPTION=?, UPDATE_DATE=? WHERE ID=?", new Object[]{product.getName(), product.getRate(), product.getQuantity(), product.getCompany(), product.getDescription(), new Date(new java.util.Date().getTime()), id});
		
	}

	@Override
	public List<Category> getCategoryList() {
		return jdbcTemplate.query("Select * from category", new CategoryMapper());
	}

}
