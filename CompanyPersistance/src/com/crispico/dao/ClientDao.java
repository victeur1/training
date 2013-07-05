package com.crispico.dao;

import java.util.List;

import com.crispico.model.Client;

public interface ClientDao {
	
	public void saveOrUpdate(Client client);
	
	public Client loadById(Integer id);
	
	public List<Client> loadAll();

	public void remove(Client client);
}
