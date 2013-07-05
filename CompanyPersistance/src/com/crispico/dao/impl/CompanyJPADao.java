package com.crispico.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.crispico.dao.CompanyDao;
import com.crispico.model.Company;

public class CompanyJPADao implements CompanyDao {

	private EntityManager entityManager ;
	
	public CompanyJPADao(EntityManager em){
		this.entityManager  = em;
	}
	
	@Override
	public void saveOrUpdate(Company company) {
		entityManager.getTransaction().begin();
		if (company.getId() != null) {
			entityManager.merge(company);			
		} else {			
			entityManager.persist(company);			
		}
		entityManager.getTransaction().commit();
	}

	@Override
	public Company loadById(Integer id) {
		return entityManager.find(Company.class,id);
	}

	@Override
	public List<Company> loadAll() {
		//List<Company> companies = ;
		return entityManager.createQuery("Select c from Company c").getResultList();
	}

	@Override
	public void remove(Company company) {
		entityManager.remove(company);
	}
	
}
