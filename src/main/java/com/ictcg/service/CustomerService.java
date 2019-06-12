package com.ictcg.service;

import java.util.Collection;

import com.ictcg.model.Customer;

public interface CustomerService {

	Collection<Customer> findAll();

	Customer findById(Integer id);

	void delete(Customer customer);

	void update(Customer customer);

	void save(Customer customer);

}
