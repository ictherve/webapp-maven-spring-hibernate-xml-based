package com.ictcg.service;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ictcg.dataaccess.CustomerEntity;
import com.ictcg.dataaccess.CustomerRepository;
import com.ictcg.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;
	
	private ModelMapper modelMapper;

	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
		this.customerRepository = customerRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public Collection<Customer> findAll() {
		Collection<CustomerEntity> customerEntities = customerRepository.findAll();
		return Objects.isNull(customerEntities) ? null
				: customerEntities.stream().map(customerEntity -> modelMapper.map(customerEntity, Customer.class))
						.collect(Collectors.toList());
	}
	
	@Override
	public Customer findById(Integer id) {
		return modelMapper.map(customerRepository.findById(id), Customer.class);
	}

	@Override
	public void save(Customer customer) {

		CustomerEntity customerEntity = modelMapper.map(customer, CustomerEntity.class);
		customerRepository.save(customerEntity);
	}

	@Override
	public void update(Customer customer) {
		/*CustomerEntity customerEntity = customerRepository.findById(customer.getId());
		// customerEntity = modelMapper.map(customer, CustomerEntity.class);
		customerEntity.setFirstName(customer.getFirstName());
		customerEntity.setLastName(customer.getLastName());*/
		//customerRepository.update(modelMapper.map(customer, CustomerEntity.class));
	}

	@Override
	public void delete(Customer customer) {
		CustomerEntity customerEntity = modelMapper.map(customer, CustomerEntity.class);
		customerRepository.delete(customerEntity);
	}

}
