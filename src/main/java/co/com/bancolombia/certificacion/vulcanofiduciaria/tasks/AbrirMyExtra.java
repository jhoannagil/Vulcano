package co.com.bancolombia.certificacion.vulcanofiduciaria.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.bancolombia.certificacion.vulcanofiduciaria.interations.Abrir;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class AbrirMyExtra implements Task{

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Abrir.myExtra());
				
			
		
	}
	public static AbrirMyExtra  abrir() {
		
		return instrumented(AbrirMyExtra.class);
	}
	
	
	

}
