package co.com.bancolombia.certificacion.vulcanofiduciaria.tasks;

import java.util.List;
import co.com.bancolombia.certificacion.vulcanofiduciaria.interations.IngresarTrama;
import co.com.bancolombia.certificacion.vulcanofiduciaria.model.CargaUtilTrama;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CargarTrama implements Task {

	private List<CargaUtilTrama> infoTramas;

	public CargarTrama(List<CargaUtilTrama> infoTramas) {
		this.infoTramas = infoTramas;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(IngresarTrama.cargaUtil(infoTramas));

	}

	public static CargarTrama coninfo(List<CargaUtilTrama> infoTramas) {
		return instrumented(CargarTrama.class, infoTramas);
	}

}
