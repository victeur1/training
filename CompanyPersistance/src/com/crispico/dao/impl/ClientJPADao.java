package com.crispico.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.crispico.dao.ClientDao;
import com.crispico.model.Client;

public class ClientJPADao implements ClientDao{
	
	private EntityManager entityManager ;

	public ClientJPADao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void saveOrUpdate(Client client) {
		entityManager.getTransaction().begin();
		if (client.getId() != null) {
			entityManager.merge(client);			
		} else {			
			entityManager.persist(client);			
		}
		entityManager.getTransaction().commit();
	}

	@Override
	public Client loadById(Integer id) {
		return entityManager.find(Client.class,id);
	}

	@Override
	public List<Client> loadAll() {
		return entityManager.createQuery("Select c from Client c").getResultList();
	}

	@Override
	public void remove(Client client) {
		entityManager.remove(client);
	}

}
