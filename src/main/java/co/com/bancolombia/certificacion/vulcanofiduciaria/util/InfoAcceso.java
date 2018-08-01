package co.com.bancolombia.certificacion.vulcanofiduciaria.util;

import co.com.bancolombia.certificacion.vulcanofiduciaria.model.Credenciales;

public enum InfoAcceso {
	USUARIO (new Credenciales("CJHEGIL", "CAL201803"));
	
	private Credenciales credenciales;
	
	InfoAcceso (Credenciales credenciales){
		this.credenciales = credenciales;
	}
	
	public Credenciales getCredenciales() {
		return credenciales;
	}

}
