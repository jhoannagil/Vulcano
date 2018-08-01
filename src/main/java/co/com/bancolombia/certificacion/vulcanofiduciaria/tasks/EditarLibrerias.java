package co.com.bancolombia.certificacion.vulcanofiduciaria.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.bancolombia.certificacion.vulcanofiduciaria.interations.Cargar;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class EditarLibrerias implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Cargar.librerias());	
		
	}

	public static EditarLibrerias conCargaLibrerias() {
		
		return instrumented(EditarLibrerias.class);
		
	}
	

}
