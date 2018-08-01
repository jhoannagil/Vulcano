package co.com.bancolombia.certificacion.vulcanofiduciaria.interations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import co.com.bancolombia.certificacion.vulcanofiduciaria.myextra.Screen;
import co.com.bancolombia.certificacion.vulcanofiduciaria.myextra._Session;
import co.com.bancolombia.certificacion.vulcanofiduciaria.myextra._System;
import co.com.bancolombia.certificacion.vulcanofiduciaria.util.InfoAcceso;
import co.com.bancolombia.certificacion.vulcanofiduciaria.model.Credenciales;
import co.com.bancolombia.certificacion.vulcanofiduciaria.myextra.MyExtra_init;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class IngresarDatosUsuario implements Interaction {

	public _System sSystem = null;
	public Screen screen = null;
	public _Session Sess0 = null;
	public int g_HostSettleTime = 3000;

	private String rolusuario;

	public IngresarDatosUsuario(String rolusuario) {
		this.rolusuario = rolusuario;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		
		sSystem = MyExtra_init.crearSistema();
		Sess0 = MyExtra_init.crearSesion(sSystem);
		screen = MyExtra_init.crearPantalla(Sess0);

		Credenciales credenciales = InfoAcceso.valueOf(rolusuario.toUpperCase()).getCredenciales();

		try {

			String TextoPantalla = "";
			
			screen.putString(credenciales.getusuario(), 6, 53, null);
			screen.putString(credenciales.getcontraseña(), 7, 53, null);
			screen.sendKeys("<Enter>");
			screen.waitHostQuiet(g_HostSettleTime);
			Thread.sleep(2000);

			TextoPantalla = screen.getString(24, 1, 49, screen);
			assertThat(TextoPantalla, is(not("La información de inicio de sesión no es correcta")));
			int i = 0;
			while (true) {
				i++;

				Thread.sleep(2000);
				TextoPantalla = screen.getString(5, 7, 9, screen);
				if (!TextoPantalla.equals("Ubicarse:")) {
					screen.sendKeys("<Enter>");
					screen.waitHostQuiet(g_HostSettleTime);
				} else {
					break;
				}
				if (i == 5) {
					break;
				}
			}
			assertThat(TextoPantalla, is("Ubicarse:"));

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}

	public static IngresarDatosUsuario ingresarDatos(String rolusuario) {

		return Tasks.instrumented(IngresarDatosUsuario.class, rolusuario);
	}

}
