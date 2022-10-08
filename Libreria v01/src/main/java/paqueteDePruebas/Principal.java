package paqueteDePruebas;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import paqueteDePruebas.mensajes.Mensaje;

public class Principal {

	public static void main(String[] args) {
		ApplicationContext factoria = new FileSystemXmlApplicationContext("classpath*:/contextoAplicacion.xml");
		Mensaje miMensaje = (Mensaje) factoria.getBean("MensajeHTML");
		miMensaje.hola();
		
		Mensaje miMensaje2 = (Mensaje) factoria.getBean("MensajePlano");
		miMensaje2.hola();
//		MensajeFactory mf = new MensajeFactory();
//		mf.getMensaje().hola();
	}

}
