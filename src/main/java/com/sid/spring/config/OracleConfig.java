package com.sid.spring.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import oracle.jdbc.pool.OracleDataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class OracleConfig {

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;

	@Value("${spring.datasource.url}")
	private String url;

	/*public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUrl(String url) {
		this.url = url;
	}*/

	@Autowired
	public DataSource datasource() throws SQLException {

		OracleDataSource ods = new OracleDataSource();

		ods.setUser(username);
		ods.setPassword(password);
		ods.setURL(url);
		//ods.setImplicitCachingEnabled(true);
		//ods.setFastConnectionFailoverEnabled(true);

		return ods;
	}
}
