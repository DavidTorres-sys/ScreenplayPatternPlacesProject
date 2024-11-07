package co.com.calidad.automation.moduloAutomation.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.HashMap;
import java.util.Map;

public class CreatePerson implements Task {

    private static final String PERSON_ENDPOINT = "/v1/person/";

    @Override
    public <T extends Actor> void performAs(T t) {
        Map<String, Object> personData = new HashMap<>();
        personData.put("firstName", "Paula Andrea Laverde");
        personData.put("age", 23);
        personData.put("occupation", "Delineante de Ingeniería");
        t.attemptsTo(Post.to(PERSON_ENDPOINT).with(
                request -> request
                        .header("Content-Type", "application/json")
                        .body(personData)
        ));
    }
    public static CreatePerson service(){
        return Tasks.instrumented(CreatePerson.class);
    }
}
