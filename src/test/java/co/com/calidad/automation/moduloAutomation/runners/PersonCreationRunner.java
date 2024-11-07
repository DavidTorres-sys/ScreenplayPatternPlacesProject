package co.com.calidad.automation.moduloAutomation.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/post_person.feature",
        glue = "co.com.calidad.automation.moduloAutomation.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class PersonCreationRunner { }
