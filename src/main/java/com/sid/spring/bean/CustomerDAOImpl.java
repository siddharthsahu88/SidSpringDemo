package com.sid.spring.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
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

	public List<CustomerDTO> findByCustomerSk(String customerSk) {
		return jdbctemplate.query("select * from sid_cn_eal WHERE customer_sk = ?", new RowMapper<CustomerDTO>() {

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

	public void insertCustomer(final CustomerDTO customer) {
		final String INSERT_SQL = "insert into sid_cn_eal(CN_DIM_KEY, CUSTOMER_SK, GENDER_CD, POSTAL_CD, CUSTOMER_CARD_RK) values (?,?,?,?,?)";

		jdbctemplate.update(new PreparedStatementCreator() {

			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(INSERT_SQL);

				ps.setInt(1, customer.getCustomerDimKey());
				ps.setString(2, customer.getCustomerSk());
				ps.setString(3, customer.getCustomerGender());
				ps.setString(4, customer.getCustomerPostal());
				ps.setString(5, customer.getCustomerCardRK());

				return ps;
			}
		});
	}
}
