package com.ictcg.dataaccess;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository{

	private SessionFactory sessionFactory;
	
	@Autowired
	public CustomerRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Collection<CustomerEntity> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from CustomerEntity", CustomerEntity.class).getResultList();
	}

	@Override
	public CustomerEntity findById(Integer id) {
		return sessionFactory.getCurrentSession().get(CustomerEntity.class, id);
	}

	@Override
	public void save(CustomerEntity customerEntity) {
		sessionFactory.getCurrentSession().saveOrUpdate(customerEntity);
	}

	@Override
	public void delete(CustomerEntity customerEntity) {
		sessionFactory.getCurrentSession().delete(customerEntity);
	}

}
