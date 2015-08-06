package com.bgmagar.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.bgmagar.dao.ProductDao;
import com.bgmagar.dao.impl.ProductDaoImpl;
import com.bgmagar.service.ProductService;
import com.bgmagar.service.impl.ProductServiceImpl;

@PropertySource(value = { "classpath:/database.properties" })
@Configuration
@ComponentScan("com.bgmagar")
@EnableWebMvc
public class AppConfig {
	
	@Value("${database.mysql.url}")
	private String databaseUrl;
	
	@Value("${database.mysql.driver}")
	private String databaseDriver;
	
	@Value("${database.mysql.username}")
	private String databaseUsername;
	
	@Value("${database.mysql.password}")
	private String databasePassword;
	
	//Required for the @propertysource to get the property resolution mechanism working
	   @Bean
	   public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
	      return new PropertySourcesPlaceholderConfigurer();
	   }

/*	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(databaseDriver);
		dataSource.setUrl(databaseUrl);
		dataSource.setUsername(databaseUsername);
		dataSource.setPassword(databasePassword);
		return dataSource;
	}*/
	
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(databaseDriver);
		dataSource.setUrl(databaseUrl);
		dataSource.setUsername(databaseUsername);
		dataSource.setPassword(databasePassword);
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
