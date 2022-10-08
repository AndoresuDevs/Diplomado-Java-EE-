package paqueteDePruebas.mensajes;

public class MensajeProxy implements Mensaje
{

	private Mensaje mensaje;
	
	public Mensaje getMensaje() {
		return mensaje;
	}
	
	@Override
	public void hola() {
		System.out.println("Funcionalidad Adicional Proxy");
		mensaje.hola();
		System.out.println("Funcionalidad Adicional Proxy");
	}
	
	public MensajeProxy() {
		this.mensaje= new MensajeHTML();
	}
	
	

}
