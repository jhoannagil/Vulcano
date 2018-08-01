package co.com.bancolombia.certificacion.vulcanofiduciaria.interations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import co.com.bancolombia.certificacion.vulcanofiduciaria.myextra.MyExtra_init;
import co.com.bancolombia.certificacion.vulcanofiduciaria.myextra.Screen;
import co.com.bancolombia.certificacion.vulcanofiduciaria.myextra._Session;
import co.com.bancolombia.certificacion.vulcanofiduciaria.myextra._System;
import co.com.bancolombia.certificacion.vulcanofiduciaria.tasks.IngresarAlSimulador;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;

public class Ir implements Interaction {

	public _System sSystem = null;
	public Screen Screen = null;
	public _Session Sess0 = null;
	public int g_HostSettleTime = 3000;

	@Override
	public <T extends Actor> void performAs(T actor) {

		String opcion = "1";
		String programa = "FSFOSIMPS";
		String biblioteca = "FSFLIBRP";
		String simulador = "01";
		sSystem = MyExtra_init.crearSistema();
		Sess0 = MyExtra_init.crearSesion(sSystem);
		Screen = MyExtra_init.crearPantalla(Sess0);

		try {

			String TextoPantalla = "";
			Screen.putString(opcion, 12, 9, null);
			Screen.sendKeys("<Enter>");
			Screen.waitHostQuiet(g_HostSettleTime);
			Thread.sleep(2000);

//			int i = 0;
//
//			while (true) {
//
//				i++;
//
//				TextoPantalla = Screen.getString(14, 32, 12, Screen);
//
//				
//				if (TextoPantalla.equals("Ventana Menú")) {
//					Screen.putString(opcion, 18, 8, null);
//					Screen.sendKeys("<Enter>");
//					Screen.waitHostQuiet(g_HostSettleTime);
//					Thread.sleep(2000);
//
//					Screen.putString(opcion, 12, 9, null);
//					Screen.sendKeys("<Enter>");
//					Screen.waitHostQuiet(g_HostSettleTime);
//					Thread.sleep(2000);

					Screen.putString(programa, 5, 37, null);
					Screen.putString(biblioteca, 6, 39, null);
					Screen.sendKeys("<Enter>");
					Screen.waitHostQuiet(g_HostSettleTime);
					Thread.sleep(2000);

					Screen.putString(simulador, 24, 19, null);
					Screen.sendKeys("<Enter>");
					
					TextoPantalla = Screen.getString(5, 2, 5, Screen);
					
					

//				} else {
//					break;
//				}
//				if (i == 1) {
//					break;
//				}
//			}

			// assertThat(TextoPantalla,is("Simulador"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

	public static Ir aSimulador() {

		return Tasks.instrumented(Ir.class);
	}

}
