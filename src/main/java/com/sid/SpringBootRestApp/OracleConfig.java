package com.sid.SpringBootRestApp;

import java.sql.SQLException;

import javax.sql.DataSource;
import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import oracle.jdbc.pool.OracleDataSource;

@Configuration
@ConfigurationProperties("oracle")
public class OracleConfig {

	@NotNull
	private String username;

	@NotNull
	private String password;

	@NotNull
	private String url;

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Bean
	public DataSource datasource() throws SQLException {

		OracleDataSource ods = new OracleDataSource();

		ods.setUser(username);
		ods.setPassword(password);
		ods.setURL(url);
		ods.setImplicitCachingEnabled(true);
		ods.setFastConnectionFailoverEnabled(true);

		return ods;
	}
}
