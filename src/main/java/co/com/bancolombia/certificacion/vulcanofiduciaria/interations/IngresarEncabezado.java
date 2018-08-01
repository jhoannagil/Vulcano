package co.com.bancolombia.certificacion.vulcanofiduciaria.interations;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import co.com.bancolombia.certificacion.vulcanofiduciaria.model.Encabezado;
import co.com.bancolombia.certificacion.vulcanofiduciaria.myextra.MyExtra_init;
import co.com.bancolombia.certificacion.vulcanofiduciaria.myextra.Screen;
import co.com.bancolombia.certificacion.vulcanofiduciaria.myextra._Session;
import co.com.bancolombia.certificacion.vulcanofiduciaria.myextra._System;
import co.com.bancolombia.certificacion.vulcanofiduciaria.util.InfoTransaccion;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class IngresarEncabezado implements Interaction {

	public _System sSystem = null;
	public Screen screen = null;
	public _Session Sess0 = null;
	public int g_HostSettleTime = 3000;

	private String infoEncabezado;

	public IngresarEncabezado(String infoEncabezado) {
		this.infoEncabezado = infoEncabezado;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		sSystem = MyExtra_init.crearSistema();
		Sess0 = MyExtra_init.crearSesion(sSystem);
		screen = MyExtra_init.crearPantalla(Sess0);
		
		

		Encabezado encabezado = InfoTransaccion.valueOf(infoEncabezado.toUpperCase()).getEncabezado();
		
		try {

			String TextoPantalla = "";
			Thread.sleep(2000);
			
		
	    	screen.putString(encabezado.getcanal(),5,23,null);
			screen.putString(encabezado.getreverso(), 5, 57, null);
			screen.putString(encabezado.gettransaccion(), 6, 23, null);
			screen.putString(encabezado.getrespuesta(), 6, 57, null);
			screen.waitHostQuiet(g_HostSettleTime);
			
			
			TextoPantalla = screen.getString(14, 2, 5, screen);
			
			assertThat(TextoPantalla, is("Carga"));
			
		
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}

	public static IngresarEncabezado cargaEncabezado(String infoEncabezado) {

		return instrumented(IngresarEncabezado.class, infoEncabezado);
	}

}
