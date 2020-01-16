package org.studyeasy.spring.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.studyeasy.spring.DAO.AppDAOImpl;

@Configuration
public class AppConfig {

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/project");
		dataSource.setUsername("root");
		dataSource.setPassword("root");

		return dataSource;
	}
	
	public AppDAOImpl AppDAO(){
		return new AppDAOImpl(getDataSource());
	}


}








