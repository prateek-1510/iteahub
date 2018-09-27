package com.iteahub.config;

import java.beans.PropertyVetoException;
import java.util.MissingResourceException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;
//@PropertySource("classpath:log4jconfig.properties")
@PropertySource("classpath:db_config.properties")

@Configuration
@EnableWebMvc
@ComponentScan("com.iteahub")
public class AppConfig {
	@Autowired
	private Environment env;
	Logger logger=Logger.getLogger(this.getClass().getName());
	@Bean
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/Views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
	public DataSource postgresSqlDataSource()
	{
		ComboPooledDataSource dataSource=new ComboPooledDataSource();
		 
		try {
			dataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
	
			throw new MissingResourceException("jdbc.driver", "org.postgresql.Driver","jdbc.driver");
		}
		logger.info("#########################");
		logger.info(""+env.getProperty("jdbc.connection-url"));
		dataSource.setJdbcUrl(env.getProperty("jdbc.connection-url"));
		logger.info(""+env.getProperty("jdbc.user"));
		dataSource.setUser(env.getProperty("jdbc.user"));
		logger.info(""+env.getProperty("jdbc.password"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		logger.info(""+env.getProperty("connection.pool.initialPoolSize"));
		dataSource.setInitialPoolSize(getProperty(env.getProperty("connection.pool.initialPoolSize")));
		logger.info(""+env.getProperty("connection.pool.maxIdleTime"));
		dataSource.setMaxIdleTime(getProperty(env.getProperty("connection.pool.maxIdleTime")));
		logger.info(""+env.getProperty("connection.pool.maxPoolSize"));
		dataSource.setMaxPoolSize(getProperty(env.getProperty("connection.pool.maxPoolSize")));
		logger.info(""+env.getProperty("connection.pool.minPoolSize"));
		dataSource.setMinPoolSize(getProperty(env.getProperty("connection.pool.minPoolSize")));
		
		
		return dataSource;
	}
	
	private int getProperty(String propertyName)
	{
		return Integer.parseInt(propertyName);
	}
	

}
