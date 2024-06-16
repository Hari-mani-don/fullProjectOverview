package com.fullProjectOverview.fullProjectOverview.configure;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@Profile("europe")
public class EuropeConfiguration {

	@Value("${europe.datasource.url}")
	private String url;

	@Value("${europe.datasource.username}")
	private String username;

	@Value("${europe.datasource.password}")
	private String password;

	@Value("${europe.datasource.driverClassName}")
	private String driverClassName;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName(driverClassName);
		datasource.setUrl(url);
		datasource.setPassword(password);
		datasource.setUsername(username);

		return datasource;
	}
}