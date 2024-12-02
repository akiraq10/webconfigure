package local.sesweb.loginPage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static local.sesweb.loginPage.LoginElements.getLoginElement;
import static ults.ElementController.verify;

public class LoginVerifier {
    private WebDriver driver;

    public LoginVerifier(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Verify login to SES.WEB success. The SES.WED Dashboard page is displayed ")
    public LoginVerifier veirfyLoginSuccessfully() {


        verify(driver,getLoginElement(driver).logoWMGBtn);
        return this;
    }
    @Step("Verify fail to login to SES.WEB with invalid password. The Error is displayed")
    public LoginVerifier verifyLoginUnsuccessfully(){
        verify(driver,getLoginElement(driver).unsuccessfulError);
        return this;
    }

}
