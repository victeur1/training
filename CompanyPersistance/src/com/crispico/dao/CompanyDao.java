package com.crispico.dao;

import java.util.List;

import com.crispico.model.Company;

public interface CompanyDao {

	public void saveOrUpdate(Company company);

	public Company loadById(Integer id);

	public List<Company> loadAll();

	public void remove(Company company);

}
