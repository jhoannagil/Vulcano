package co.com.bancolombia.certificacion.vulcanofiduciaria.tasks;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.bancolombia.certificacion.vulcanofiduciaria.interations.Ir;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;


public class IngresarAlSimulador implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Ir.aSimulador());		
				
		
	}

	public static IngresarAlSimulador iraSimulador() {
		
		return instrumented(IngresarAlSimulador.class);
	}
	
	


}
