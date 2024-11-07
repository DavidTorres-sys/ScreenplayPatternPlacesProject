package co.com.calidad.automation.moduloAutomation.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

/**
 * Connects the Actor to the specified API service.
 * By default, it reads the base URL from the 'webdriver.base.url' environment variable.
 */
public class ConnectTo implements Task {

    private final String urlString;

    public ConnectTo() {
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
        urlString = environmentVariables.getProperty("webdriver.base.url");
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        SerenityRest.reset();
        t.whoCan(CallAnApi.at(urlString));
    }

    public static ConnectTo theService() {
        return Tasks.instrumented(ConnectTo.class);
    }
}
