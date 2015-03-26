package com.bgmagar.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bgmagar.domain.Product;

public class ProductMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

		Product product = new Product();
		product.setId(rs.getInt("ID"));
		product.setName(rs.getString("NAME"));
		product.setRate(rs.getInt("RATE"));
		product.setQuantity(rs.getInt("QUANTITY"));
		product.setCompany(rs.getString("COMPANY"));
		product.setDescription(rs.getString("DESCRIPTION"));
		product.setUpdateDate(rs.getDate("UPDATE_DATE"));

		return product;
	}

}
