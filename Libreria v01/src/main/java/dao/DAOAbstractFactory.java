package dao;

public class DAOAbstractFactory 
{
	//AGREGAR EL JDBC PARA QUE SE HAGA EL SWITCHEO
	public static DAOFactory getInstance() 
	{
		String tipo = "JPA";
		if(tipo.equals("Hibernate")) {
			//new DAOHibernateFactory() 
			return null;
		}
		else
		{
			return new DAOJPAFactory();
		}
	}
}
