package co.com.bancolombia.certificacion.vulcanofiduciaria.model;

public class Credenciales {
	
	private String usuario;
	private String contraseña;
	
	public Credenciales(String usuario, String contraseña) {
		this.usuario = usuario;
		this.contraseña = contraseña; 
	}
	
		

	public String getusuario() {
		
		return usuario;
	}
	
   public String getcontraseña() {
		
		return contraseña;
	}

}
