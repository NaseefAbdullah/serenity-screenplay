package tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.TourLogin;

public class Login {

    public static AndPassword withUserName(String userName) {
        return new LoginBuilder(userName);

    }

    public interface AndPassword {
        Submit andPassword(String password);
    }

    public interface Submit {
        Task submit();
    }

    public static class LoginBuilder implements AndPassword, Submit {

        private String userName;
        private String password;

        LoginBuilder(String userName) {
            this.userName = userName;
        }

        @Override
        public Submit andPassword(String password) {
            this.password = password;
            return this;
        }

        @Override
        public Task submit() {
            return Task.where("Enters username and password",
                    OpenApplication.onTheToursLoginPage(),
                    Enter.theValue(userName).into(TourLogin.USERNAME),
                    WaitUntil.angularRequestsHaveFinished(),
                    Enter.theValue(password).into(TourLogin.PASSWORD),
                    Click.on(TourLogin.LOGINBUTTON))
                    .with("userName").of(userName)
                    .with("Password").of(password);
        }
    }
}
