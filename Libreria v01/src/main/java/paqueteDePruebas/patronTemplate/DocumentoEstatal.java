package paqueteDePruebas.patronTemplate;

public class DocumentoEstatal extends DocumentoOficial
{
	@Override
	protected void imprimirEncabezado() 
	{
		System.out.println("<oficial> Encabezado del Documento Estatal </oficial>");
	}

}
