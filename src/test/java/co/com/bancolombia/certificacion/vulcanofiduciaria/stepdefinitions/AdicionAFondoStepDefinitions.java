package co.com.bancolombia.certificacion.vulcanofiduciaria.stepdefinitions;

import static org.hamcrest.Matchers.greaterThan;
import java.util.List;
import co.com.bancolombia.certificacion.vulcanofiduciaria.model.CargaUtilTrama;
import co.com.bancolombia.certificacion.vulcanofiduciaria.model.Encabezado;
import co.com.bancolombia.certificacion.vulcanofiduciaria.questions.Verificar;
import co.com.bancolombia.certificacion.vulcanofiduciaria.tasks.AbrirMyExtra;
import co.com.bancolombia.certificacion.vulcanofiduciaria.tasks.CargarEncabezado;
import co.com.bancolombia.certificacion.vulcanofiduciaria.tasks.CargarTrama;
import co.com.bancolombia.certificacion.vulcanofiduciaria.tasks.EditarLibrerias;
import co.com.bancolombia.certificacion.vulcanofiduciaria.tasks.IngresarAlSimulador;
import co.com.bancolombia.certificacion.vulcanofiduciaria.tasks.RealizarLogin;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import static net.serenitybdd.screenplay.GivenWhenThen.*;


public class AdicionAFondoStepDefinitions {

	private Actor jhoanna = Actor.named("Jhoanna");

	@Given("^que el (.*) necesita adicionar a un fondo de inversión desde una cuenta de depositos$")
	public void queElUsuarioNecesitaAdicionarAUnFondoDeInversiNDesdeUnaCuentaDeDepositos(String rolusuario)
			throws Exception {
		jhoanna.wasAbleTo(AbrirMyExtra.abrir(), RealizarLogin.ingresarDatos(rolusuario));
		jhoanna.wasAbleTo(EditarLibrerias.conCargaLibrerias(),IngresarAlSimulador.iraSimulador());
	}

	@When("^realiza una (.*) de adición desde el canal$")
	public void realizaUnaSolicitudDeAdicionDesdeElCanal(String infoencabezado) throws Exception {
		jhoanna.attemptsTo(CargarEncabezado.conInfo(infoencabezado));
		
	}
	
	@When("^Ingresa los datos necesarios$")
	public void ingresaLosDatosNecesarios(List<CargaUtilTrama> infoTramas) throws Exception {
		jhoanna.attemptsTo(CargarTrama.coninfo(infoTramas));
	    
	}

	@Then("^verifica el aumento del (.*) en el fondo de inversión$")
	public void verificaElAumentoDelSaldoEnElFondoDeInversiN(String saldo) throws Exception {
		jhoanna.should(seeThat(Verificar.aumentodeSaldo(), greaterThan(1200)));
	}

	@Then("^que el saldo de la cuenta de depositos disminuya$")
	public void queElSaldoDeLaCuentaDeDepositosDisminuya() throws Exception {
	}

}
