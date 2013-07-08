package com.crispico.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.crispico.model.*;

public class ContactJPADao {
	
	private EntityManager entityManager ;
	
	public ContactJPADao(EntityManager em){
		this.entityManager  = em;
	}
	

	public void saveOrUpdate(Contact contact) {
		entityManager.getTransaction().begin();
		if (contact.getId() != null) {
			entityManager.merge(contact);			
		} else {			
			entityManager.persist(contact);			
		}
		entityManager.getTransaction().commit();
	}


	public Contact loadById(Integer id) {
		return entityManager.find(Contact.class,id);
	}


	public List<Contact> loadAll() {
		return entityManager.createQuery("Select c from Company c").getResultList();
	}


	public void remove(Contact contact) {
		entityManager.remove(contact);
	}
	

}
