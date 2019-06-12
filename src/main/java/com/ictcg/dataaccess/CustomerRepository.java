package com.ictcg.dataaccess;

import java.util.Collection;

public interface CustomerRepository {

	Collection<CustomerEntity> findAll();
	
	CustomerEntity findById(Integer id);
	
	void save(CustomerEntity customer);
	
	void delete(CustomerEntity customer);
}
