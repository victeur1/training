package com.crispico.dao;

import java.util.List;

import com.crispico.model.*;



public interface ContactDao {
	
	public void saveOrUpdate(Contact contact);

	public Company loadById(Integer id);

	public List<Contact> loadAll();

	public void remove(Contact company);

}
