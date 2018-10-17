package com.sid.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sid.spring.bean.CustomerDTO;
import com.sid.spring.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerservice;

	@GetMapping("/get/all")
	public List<CustomerDTO> getAllCustomer() {
		return customerservice.getAllCustomer();
	}

	@GetMapping("/get/{id}")
	public List<CustomerDTO> getByIdCustomer(@PathVariable(value = "id") String customerSk) {
		return customerservice.getByIdCustomer(customerSk);
	}

	@PostMapping("/add")
	public ResponseEntity<?> addCustomer(@RequestBody CustomerDTO customer) {

		customerservice.addCustomer(customer);

		return ResponseEntity.status(HttpStatus.CREATED).body("Created "+customer);
	}

}