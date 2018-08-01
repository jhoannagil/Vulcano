package co.com.bancolombia.certificacion.vulcanofiduciaria.util;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;



import co.com.bancolombia.certificacion.vulcanofiduciaria.myextra.ClassFactory;
import co.com.bancolombia.certificacion.vulcanofiduciaria.myextra.Screen;
import co.com.bancolombia.certificacion.vulcanofiduciaria.myextra._Session;
import co.com.bancolombia.certificacion.vulcanofiduciaria.myextra._System;

public class MyExtra {
	
	public boolean seCreoElSistema(_System elSistema)
	{
		if(elSistema==null)
			return false;
		else
			return true;
	}
	
	public static void cerrarMyExtraAbierto() throws IOException
	{
		_System s=ClassFactory.createExtraSystem();
		_Session sesion= s.activeSession();
		if (sesion != null) {sesion.closeEx(1);}
		else { destroyProceso(); }
	}
	
	public static void destroyProceso() throws IOException
	{
		Runtime rt = Runtime.getRuntime();
		rt.exec("taskkill /IM EXTRA.exe");
	}
	
	public static void abrirArchivoDeMyExtra(String laRutaDelArchivo) throws IOException
	{
		Desktop  desk =Desktop.getDesktop();
		File file = new File(laRutaDelArchivo);
		desk.open(file);
	}
	
	public static _System crearSistema()
	{
		return ClassFactory.createExtraSystem();		
		
	}
	
	public static _Session crearSesion(_System elSistema)
	{
		return elSistema.activeSession();
	}
	
	public static Screen crearPantalla(_Session laSesion)
	{
		return laSesion.screen();
	}

}
