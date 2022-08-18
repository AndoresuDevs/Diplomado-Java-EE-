package dao;

import java.io.IOException;
import java.util.Properties;

public class DAOAbstractFactory 
{
	
	public static DAOFactory getInstance() 
	{
		Properties propiedades= new Properties();
		DAOFactory dao = null;
		try 
		{
			propiedades.load(DAOAbstractFactory.class.getResourceAsStream("libreria.properties"));
			String tipo = propiedades.getProperty("tipo");
			
			if(tipo.equals("JDBC")) 
			{
				System.out.println("ENTRO JDBC FACTORY");
				dao =  new DAOJDBCFactory();
			}
			else if(tipo.equals("JPA")) 
			{
				System.out.println("ENTRO JPA FACTORY");
				dao =  new DAOJPAFactory();
			} 
			else 
			{
				System.out.println("ENTRO HIBERNATE FACTORY");
				dao = new DAOHibernateFactory();
			} 
			
		}
		catch(IOException e) 
		{
			System.out.println("ERROR EN DAO ABSTRACT FACTORY: "+e.getMessage());
		}
		return dao;
		
		
	}
}
 