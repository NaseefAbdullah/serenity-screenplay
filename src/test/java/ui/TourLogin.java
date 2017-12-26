package ui;

import net.serenitybdd.screenplay.targets.Target;

public class TourLogin {

    public static final Target USERNAME = Target.the("Username field")
            .locatedBy("[name='userName']");

    public static final Target PASSWORD = Target.the("password field")
            .locatedBy("[name='password']");

    public static final Target LOGINBUTTON = Target.the("Login button")
            .locatedBy("[name='login']");
}
