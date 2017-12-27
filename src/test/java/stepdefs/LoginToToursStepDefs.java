package stepdefs;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import tasks.Login;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class LoginToToursStepDefs {

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^that (.*) is mercury tours user$")
    public void that_Amar_is_mercury_tours_user(String commuterName) {
        theActorCalled(commuterName);
    }

    @When("^(.*) type username (.*) and password (.*) and submit$")
    public void type_username_and_password_and_submit(String actor, String username, String password) {
        theActorCalled(actor).attemptsTo(
                Login.withUserName(username).andPassword(password).submit()
        );
    }
}
