package local.sesweb.userDashboardPage;

import org.openqa.selenium.WebDriver;

public class UserDashboardPage {
    UserDashboardController userDashboardController;
    UserDashboardVerifier userDashboardVerifier;

    private UserDashboardPage(UserDashboardController userDashboardController, UserDashboardVerifier userDashboardVerifier) {
        this.userDashboardController = userDashboardController;
        this.userDashboardVerifier = userDashboardVerifier;

    }

    public static UserDashboardPage userDashboardPage(WebDriver driver) {
        return new UserDashboardPage(new UserDashboardController(driver), new UserDashboardVerifier(driver));
    }

    public UserDashboardController act() {
        return userDashboardController;
    }

    public UserDashboardVerifier verify() {
        return userDashboardVerifier;
    }
}
