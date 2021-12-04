package com.andoresudev.javaEE.mod2.sesion4;



import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;


public class EjemploLog4J {
	//org.apache.logging.log4j.spi.LoggerContext
	public static void main(String[] args) 
	{
		Logger logger = LogManager.getLogger("EjemploLog4j");
		
		PatternLayout patron = new PatternLayout("%m %n");
		ConsoleAppender consola = new ConsoleAppender();
		consola.setLayout(patron);
		 
		logger.addAppender(consola);
		logger.setLevel(Level.INFO); //SETEARLE UN NIVEL ES COMO PONER EL MINIMO, SOLO MUESTRA DE ESE HACIA ARRIBA
		
		//ESTE ES EL ORDER DE JERARQUIA DE NIVEL
		logger.fatal("Error Fatal");
		logger.error("Error Error");
		logger.warn("Error Warn");
		logger.info("Warn Info");
		logger.debug("Error Debug");
		
		
		
	}

}
