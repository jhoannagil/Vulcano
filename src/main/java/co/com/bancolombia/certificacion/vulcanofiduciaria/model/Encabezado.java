package co.com.bancolombia.certificacion.vulcanofiduciaria.model;

public class Encabezado {

	private String canal;
	private String reverso;
	private String transaccion;
	private String respuesta;

	public Encabezado(String canal, String reverso, String transaccion, String respuesta) {
		this.canal = canal;
		this.reverso = reverso;
		this.transaccion = transaccion;
		this.respuesta = respuesta;

	}

	public String getcanal() {

		return canal;
	}

	public String getreverso() {

		return reverso;
	}

	public String gettransaccion() {

		return transaccion;
	}

	public String getrespuesta() {

		return respuesta;
	}

}
