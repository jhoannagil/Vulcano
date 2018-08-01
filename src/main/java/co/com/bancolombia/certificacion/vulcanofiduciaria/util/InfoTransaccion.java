package co.com.bancolombia.certificacion.vulcanofiduciaria.util;

import co.com.bancolombia.certificacion.vulcanofiduciaria.model.Encabezado;

public enum InfoTransaccion {
	SOLICITUD (new Encabezado("BLE","N","0004","S"));
	
	
	private Encabezado encabezado;
	
	InfoTransaccion (Encabezado encabezado){
		this.encabezado = encabezado;
		
	}
	
	public Encabezado getEncabezado() {
		
		return encabezado;
		
	}

}
