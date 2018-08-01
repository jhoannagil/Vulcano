package co.com.bancolombia.certificacion.vulcanofiduciaria.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith (CucumberWithSerenity.class) 
@CucumberOptions (
		features ="src/test/resources/features/adicion_a_fondo.feature", 
		glue = "co.com.bancolombia.certificacion.vulcanofiduciaria.stepdefinitions",
		snippets = SnippetType.CAMELCASE
)
public class AdicionRunner {


}
