package com.bgmagar.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.bgmagar.dao.ProductDao;
import com.bgmagar.dao.impl.ProductDaoImpl;
import com.bgmagar.service.ProductService;
import com.bgmagar.service.impl.ProductServiceImpl;

@Configuration
@ComponentScan("com.bgmagar")
@EnableWebMvc
public class AppConfig {

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/product_db");
		dataSource.setUsername("root");
		dataSource.setPassword("nepal@123");
		return dataSource;
	}

	@Autowired
	@Bean(name = "jdbcTemplate")
	public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Autowired
	@Bean(name = "productDao")
	public ProductDao getProductDao() {
		return new ProductDaoImpl();
	}

	@Autowired
	@Bean(name = "productService")
	public ProductService getProductService() {
		return new ProductServiceImpl();
	}



}
