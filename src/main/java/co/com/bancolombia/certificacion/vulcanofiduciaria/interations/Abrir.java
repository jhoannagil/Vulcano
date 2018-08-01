package co.com.bancolombia.certificacion.vulcanofiduciaria.interations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import java.io.IOException;

import co.com.bancolombia.certificacion.vulcanofiduciaria.myextra.Screen;
import co.com.bancolombia.certificacion.vulcanofiduciaria.myextra._Session;
import co.com.bancolombia.certificacion.vulcanofiduciaria.myextra._System;
import co.com.bancolombia.certificacion.vulcanofiduciaria.util.MyExtra;
import co.com.bancolombia.certificacion.vulcanofiduciaria.util.ProcessUtility;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class Abrir implements Interaction {
	

	static _System sSystem=null;
	static Screen Screen=null;
	static _Session Sess0=null;
	static int g_HostSettleTime = 3000; 

	@Override
	public   <T extends Actor> void performAs(T actor) {
		try
		{
			if(ProcessUtility.isProcessRunning("EXTRA.exe"))
				MyExtra.cerrarMyExtraAbierto();

			MyExtra.abrirArchivoDeMyExtra("D:\\Jhoanna Esmeralda Gi Tocora\\Bancolombia\\Proyectos\\Invesbot\\Proceso Certificación\\Ambientes\\CALIDAD2.EDP");
			Thread.sleep(5000);
			sSystem= MyExtra.crearSistema();
			Sess0=MyExtra.crearSesion(sSystem);
			Screen=MyExtra.crearPantalla(Sess0);
			sSystem.timeoutValue(g_HostSettleTime);
		}catch (IOException | InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	

	public static Abrir myExtra() {
		return Tasks.instrumented(Abrir.class);
	}
	
	
}
