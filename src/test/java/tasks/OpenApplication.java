package tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import ui.TourLoginPage;

public class OpenApplication {

    public static Task onTheToursLoginPage() {
        return Task.where("Opens tours login page",
                Open.browserOn().the(TourLoginPage.class)
        );

    }
}
