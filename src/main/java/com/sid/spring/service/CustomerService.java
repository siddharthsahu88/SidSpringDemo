package com.sid.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sid.spring.bean.CustomerDAO;
import com.sid.spring.bean.CustomerDTO;

@Service
public class CustomerService {

	@Autowired
	private CustomerDAO custdao;
	
	public List<CustomerDTO> getAllCustomer() {
		return custdao.findAll();
	}

	public CustomerDTO getByIdCustomer(String customerSk) {
		return custdao.findByCustomerSk(customerSk);
	}
	
}
