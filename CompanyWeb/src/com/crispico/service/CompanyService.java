package com.crispico.service;

import java.util.List;

import com.crispico.dao.EntityManagerHolder;
import com.crispico.dao.impl.CompanyJPADao;
import com.crispico.model.Company;

public class CompanyService {

	public String sayHello(String name) {
		return "Hello " + name;
	}
	
	public List<Company> getAllCompanies() {
		return new CompanyJPADao(EntityManagerHolder.getInstance().getEntityManager()).loadAll();
	}
}
