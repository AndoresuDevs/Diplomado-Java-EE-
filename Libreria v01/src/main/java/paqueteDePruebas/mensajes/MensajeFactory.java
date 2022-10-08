package paqueteDePruebas.mensajes;

public class MensajeFactory 
{
	public static Mensaje getMensaje() 
	{
		
		return new MensajeProxy();
	}
}
