package local.sesweb.userDashboardPage.userPage.addUserPage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static local.sesweb.userDashboardPage.userPage.addUserPage.AddUserElements.getEle;
import static ults.ElementController.verify;

public class AddUserVerifier {
    private WebDriver driver ;

    public AddUserVerifier(WebDriver driver) {
        this.driver=driver;

    }
    @Step("Verify the new user is created success and the alert {expected} is displayed")
    public AddUserVerifier verifyCreateUserSuccess(String expected){
        verify(driver, getEle(driver).successAlert, expected);
        return this;
    }
}
