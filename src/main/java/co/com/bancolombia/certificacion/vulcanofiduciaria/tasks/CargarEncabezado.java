package co.com.bancolombia.certificacion.vulcanofiduciaria.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import co.com.bancolombia.certificacion.vulcanofiduciaria.interations.IngresarEncabezado;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class CargarEncabezado implements Task{
	
	private String infoEncabezado;

	public CargarEncabezado(String infoEncabezado) {
		this.infoEncabezado = infoEncabezado;
		
		
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(IngresarEncabezado.cargaEncabezado(infoEncabezado));
		}
	
	public static CargarEncabezado conInfo(String infoEncabezado) {
		return instrumented(CargarEncabezado.class, infoEncabezado);
	}

}
