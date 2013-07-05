package com.crispico.model;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.crispico.dao.EntityManagerHolder;
import com.crispico.dao.impl.ClientJPADao;
import com.crispico.dao.impl.CompanyJPADao;
import com.crispico.model.Company;

public class TestHibernate {

//	private static EntityManagerFactory emf;
	private static EntityManager em;

	@BeforeClass
	public static void initEntityManager() {
//		emf = Persistence
//				.createEntityManagerFactory("company_persistance_unit");
		em = EntityManagerHolder.getInstance().getEntityManager();
	}

	@Test
	public void testClientUsage(){
		ClientJPADao clientHandler = new ClientJPADao(em);
		for(int i=1;i<=10;i++){
			Client client = new Client();
			client.setName("Client"+i);
			clientHandler.saveOrUpdate(client);
		}
		List<Client> clients = clientHandler.loadAll();
		for(Client c : clients)
			System.out.println(c.getName());
	}
	
	@Test
	public void testDirectHibernateCompanyUsage() {
		Company company = new Company();
		
		company.setName("One");
		company.setCui("RandomCui");
		company.setAddress("randomAddress");
		
		CompanyJPADao companyHandler = new CompanyJPADao(em);
		companyHandler.saveOrUpdate(company);
		
//		System.out.println(companyHandler.loadById(240).getName());
		
		List<Company> companies = companyHandler.loadAll();
		for(Company c : companies)
			System.out.println(c.getName());
	}
		
		
	
	public void loadById(){
		Company company = em.find(Company.class,40);
		em.getTransaction().begin();
		company.setName("Razvan");
		em.merge(company);
		em.getTransaction().commit();
	}
	
	
	public void removeById(){
		em.remove(em.find(Company.class,20));
	}

	@AfterClass
	public static void closeEMFactory() {
		em.close();
//		emf.close();
	}

}
