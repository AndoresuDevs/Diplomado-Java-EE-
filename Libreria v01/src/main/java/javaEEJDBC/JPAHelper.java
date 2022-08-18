package javaEEJDBC;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAHelper {
	private static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("JavaEE");
	
	public static EntityManager createEntityManager()
	{
		return emf.createEntityManager();
	}
}    
