package com.sid.spring.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private JdbcTemplate jdbctemplate;

	public List<CustomerDTO> findAll() {
		return jdbctemplate.query("select * from sid_cn_eal", new RowMapper<CustomerDTO>() {

			public CustomerDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				CustomerDTO cust = new CustomerDTO();

				cust.setCustomerDimKey(rs.getInt(1));
				cust.setCustomerSk(rs.getString(2));
				cust.setCustomerGender(rs.getString(3));
				cust.setCustomerPostal(rs.getString(4));
				cust.setCustomerCardRK(rs.getString(5));

				return cust;
			}

		});

	}

	public CustomerDTO findByCustomerSk(String customerSk) {
		return jdbctemplate.queryForObject("select * from sid_cn_eal WHERE customer_sk = ?",new RowMapper<CustomerDTO>() {

			public CustomerDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				CustomerDTO cust = new CustomerDTO();

				cust.setCustomerDimKey(rs.getInt(1));
				cust.setCustomerSk(rs.getString(2));
				cust.setCustomerGender(rs.getString(3));
				cust.setCustomerPostal(rs.getString(4));
				cust.setCustomerCardRK(rs.getString(5));

				return cust;
			}

		}, customerSk);
	}
}
