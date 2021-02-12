package no.hvl.dat152;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

@Stateless
public class ProductEAO {
	
	public ProductEAO() {
		
	}
	
	 
	
	// Sjekker om varen finnes fra før
	
	public static boolean finnesFraFor(Product product) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProductPU");
		EntityManager em = emf.createEntityManager();
		
		boolean found = false;
		String f = "";
		
		String products = "SELECT p FROM Product p";
		
		em.getTransaction().begin();
		
		TypedQuery<Product> query = em.createQuery(products, Product.class);
		
		List<Product> productList = query.getResultList();
		
		int count = 0;
		
		for(Product p : productList) {
			count = p.getPno();
			em.find(Product.class, count);
			
			if(count == product.getPno()) {
				f = "It's already a product!";
				found = true;
			}
			
		}
		
		em.getTransaction().commit();
		em.close();

		System.out.println(f);
		return found;
		
		
	}
	
	public static List<Product> hentAlleVarer(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProductPU");
		EntityManager em = emf.createEntityManager();
		String varer = "SELECT p FROM Product p";
		
		// henter alle varer fra databasen og lagrer dem i en query
				TypedQuery<Product> query = em.createQuery(varer, Product.class);

		// lagrer alle funnene fra query i en ny vareliste
				List<Product> vareliste = query.getResultList();
				
				return vareliste;
	}

	
	
		
	}
	
	


