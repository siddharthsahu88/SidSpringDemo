package com.sid.spring.bean;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface CustomerDAO {

	public List<CustomerDTO> findAll();

	public CustomerDTO findByCustomerSk(String customerSk);

}
