package co.com.bancolombia.certificacion.vulcanofiduciaria.interations;


import static org.junit.Assert.assertThat;

import co.com.bancolombia.certificacion.vulcanofiduciaria.myextra.MyExtra_init;
import co.com.bancolombia.certificacion.vulcanofiduciaria.myextra.Screen;
import co.com.bancolombia.certificacion.vulcanofiduciaria.myextra._Session;
import co.com.bancolombia.certificacion.vulcanofiduciaria.myextra._System;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class Cargar implements Interaction {

	static _System sSystem = null;
	static Screen Screen = null;
	static _Session Sess0 = null;
	static int g_HostSettleTime = 3000;

	


	@Override
	public <T extends Actor> void performAs(T actor) {
		
		
		String libreria="stilibrp";
		String opcion = "1";
		String Enter="<Enter>";
		
		sSystem = MyExtra_init.crearSistema();
		Sess0 = MyExtra_init.crearSesion(sSystem);
		Screen = MyExtra_init.crearPantalla(Sess0);

		try {

			String TextoPantalla = "";
			Screen.putString(opcion, 8, 10, null);
			Screen.sendKeys(Enter);
			Screen.waitHostQuiet(g_HostSettleTime);
			Thread.sleep(2000);

			

			while (true) {

				

				TextoPantalla = Screen.getString(14, 32, 12, Screen);

				
				if (TextoPantalla.equals("Ventana Menú")) {
					Screen.putString(opcion, 18, 8, null);
					Screen.sendKeys(Enter);
					Screen.waitHostQuiet(g_HostSettleTime);
					Thread.sleep(2000);

					Screen.putString(opcion, 11, 9, null);
					Screen.sendKeys(Enter);
					Screen.sendKeys(Enter);
					Screen.waitHostQuiet(g_HostSettleTime);
					Thread.sleep(2000);
					Screen.putString(libreria, 16, 67, null);
					Screen.sendKeys(Enter);
					Screen.waitHostQuiet(g_HostSettleTime);
									

					

				} else {
					break;
				}


			}

			 

		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}

	}



	public static Cargar librerias() {

		return Tasks.instrumented(Cargar.class);
	}

}
