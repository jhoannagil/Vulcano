package co.com.bancolombia.certificacion.vulcanofiduciaria.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.bancolombia.certificacion.vulcanofiduciaria.interations.Abrir;
import co.com.bancolombia.certificacion.vulcanofiduciaria.interations.IngresarDatosUsuario;
import co.com.bancolombia.certificacion.vulcanofiduciaria.interations.Ir;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class RealizarLogin implements Task {

	private String rolusuario;

	public RealizarLogin(String rolusuario) {
		this.rolusuario = rolusuario;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(IngresarDatosUsuario.ingresarDatos(rolusuario),EditarLibrerias.conCargaLibrerias());

	}

	public static RealizarLogin ingresarDatos(String rolusuario) {

		return instrumented(RealizarLogin.class, rolusuario);
	}

}
