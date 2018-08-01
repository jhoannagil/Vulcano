package co.com.bancolombia.certificacion.vulcanofiduciaria.interations;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import java.util.List;
import co.com.bancolombia.certificacion.vulcanofiduciaria.model.CargaUtilTrama;
import co.com.bancolombia.certificacion.vulcanofiduciaria.myextra.MyExtra_init;
import co.com.bancolombia.certificacion.vulcanofiduciaria.myextra.Screen;
import co.com.bancolombia.certificacion.vulcanofiduciaria.myextra._Session;
import co.com.bancolombia.certificacion.vulcanofiduciaria.myextra._System;
import co.com.bancolombia.certificacion.vulcanofiduciaria.util.StringUtilidades;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class IngresarTrama implements Interaction {

	public _System sSystem = null;
	public Screen screen = null;
	public _Session Sess0 = null;
	public int g_HostSettleTime = 3000;

	private List<CargaUtilTrama> infoTramas;
	String trama;

	public IngresarTrama(List<CargaUtilTrama> infoTramas) {
		this.infoTramas = infoTramas;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		for (CargaUtilTrama cargaUtilTrama : infoTramas) {
			trama = StringUtilidades.generarTrama(cargaUtilTrama);
			//System.out.println("Trama: " + trama);

		}

		sSystem = MyExtra_init.crearSistema();
		Sess0 = MyExtra_init.crearSesion(sSystem);
		screen = MyExtra_init.crearPantalla(Sess0);

		try {

			String TextoPantalla = "";

			screen.putString(trama, 16, 2, null);
			screen.sendKeys("<Enter>");
			
			screen.waitHostQuiet(g_HostSettleTime);
			Thread.sleep(2000);
			TextoPantalla = screen.getString(8, 23, 3, screen);
						
			assertThat(TextoPantalla, is("000"));

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

	public static IngresarTrama cargaUtil(List<CargaUtilTrama> infoTramas) {

		return instrumented(IngresarTrama.class, infoTramas);
	}

}
