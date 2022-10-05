package paqueteDePruebas.patronTemplate;

public class GestionDocumentos {

	public static void main(String[] args) 
	{
		Documento d = new DocumentoOficial();
		d.imprimir("Buenas Tardes Inge");
		
		System.out.println("\n");
		
		d = new DocumentoPlano();
		d.imprimir("Wenas");
		
		System.out.println("\n");
		
		d= new DocumentoEstatal();
		d.imprimir("SALUDOS DEL DOCUMENTO ESTATAL");
	}

}
