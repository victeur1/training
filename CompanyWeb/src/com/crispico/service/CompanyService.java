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
		return new CompanyJPADao(EntityManagerHolder.getInstance()
				.getEntityManager()).loadAll();
	}

	public List<Company> addOrModifyCompany(Company company) {
		CompanyJPADao comp = new CompanyJPADao(EntityManagerHolder
				.getInstance().getEntityManager());
		comp.saveOrUpdate(company);
		return comp.loadAll();
	}

	public List<Company> removeCompany(Integer id) {
		CompanyJPADao comp = new CompanyJPADao(EntityManagerHolder
				.getInstance().getEntityManager());
		System.out.println(comp.loadById(id).getName());
		System.out.println(comp.loadById(id).getId());
		comp.remove(comp.loadById(id));
		return comp.loadAll();
	}


}
