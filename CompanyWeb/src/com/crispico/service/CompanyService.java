package com.crispico.service;

import java.util.ArrayList;
import java.util.List;

import com.crispico.dao.EntityManagerHolder;
import com.crispico.dao.impl.CompanyJPADao;
import com.crispico.dao.impl.ContactJPADao;
import com.crispico.model.Company;
import com.crispico.model.Contact;

public class CompanyService {

	public String sayHello(String name) {
		return "Hello " + name;
	}

	public List<Company> getAllCompanies() {
		return new CompanyJPADao(EntityManagerHolder.getInstance()
				.getEntityManager()).loadAll();
	}
	
	
	public List<String> getAllCompaniesNames() {
		List<Company> companies= new CompanyJPADao(EntityManagerHolder.getInstance()
				.getEntityManager()).loadAll();
		List<String> names = new ArrayList<String>();
		for(Company i : companies){
			names.add(i.getName());			
		}
		
		return names;
	}
	

	public List<Company> addOrModifyCompany(Company company) {
		CompanyJPADao comp = new CompanyJPADao(EntityManagerHolder
				.getInstance().getEntityManager());
		comp.saveOrUpdate(company);
		return comp.loadAll();
	}
	
	
	public List<Contact> addOrModifyContact (Contact contact) {
		ContactJPADao comp = new ContactJPADao(EntityManagerHolder
				.getInstance().getEntityManager());
		comp.saveOrUpdate(contact);
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

	public List<Contact> getAllContacts() {
		return new ContactJPADao(EntityManagerHolder.getInstance()
				.getEntityManager()).loadAll();
	}
	
	

}
