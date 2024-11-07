package co.com.calidad.automation.moduloAutomation.stepdefinitions;

import co.com.calidad.automation.moduloAutomation.tasks.ConnectTo;
import co.com.calidad.automation.moduloAutomation.tasks.CreatePerson;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.equalTo;

public class PersonCreationStepDefinition {

    Actor user = Actor.named("user");

    @Before
    @Given("I am connected to the system to register a new person")
    public void iAmConnectedToTheSystemToRegisterANewPerson() {
        user.attemptsTo(ConnectTo.theService());
    }

    @When("I send the person's data to the system")
    public void iSendThePersonsDataToTheSystem() {
        user.attemptsTo(CreatePerson.service());
    }

    @Then("the system should return a 201 status code")
    public void theSystemShouldReturnA201CreatedStatusCode() {
        user.should(seeThatResponse(response -> response.statusCode(201)));
    }

    @And("the response should include the newly created person information")
    public void theResponseShouldIncludeTheNewlyCreatedPersonInformation() {
        user.should(seeThatResponse(response -> response
                .body("firstName", equalTo("Paula Andrea Laverde"))
                .body("age", equalTo(23))
                .body("occupation", equalTo("Delineante de Ingeniería"))
        ));
    }
}
