package no.hvl.dat152;

import java.util.List;

import java.sql.*;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

@Entity
public class Product {
	
	@Id
	int pno;
	String pName;
	double priceInEuro;
	String imageFile;
	
	public Product(int pno, String pName, double priceInEuro, String imageFile) {
		this.pno = pno;
		this.pName = pName;
		this.priceInEuro = priceInEuro;
		this.imageFile = imageFile;
	}
	
	
	public Product() {
		
	}
	
public static void main(String [] args) throws Exception {
		
		
		
		
	}

public static void skrivUtAlleFilmer() {
	
	String jpql = "SELECT p FROM Product p";
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProductPU");
	EntityManager em = emf.createEntityManager();
	
	TypedQuery<Product> query = em.createQuery(jpql, Product.class);
	List<Product> list = query.getResultList();
	list.forEach(System.out::println);
	
}
	

public int getPno() {
	return pno;
}

public void setPno(int pno) {
	this.pno = pno;
}
	

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public double getPriceInEuro() {
		return priceInEuro;
	}

	public void setPriceInEuro(int priceInEuro) {
		this.priceInEuro = priceInEuro;
	}

	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}

	@Override
	public String toString() {
		return "Product [pName=" + pName + ", priceInEuro=" + priceInEuro + ", imageFile=" + imageFile
				+ "]";
	}
	
	

}
