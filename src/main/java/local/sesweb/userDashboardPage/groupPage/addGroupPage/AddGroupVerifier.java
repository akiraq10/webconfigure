package local.sesweb.userDashboardPage.groupPage.addGroupPage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static local.sesweb.userDashboardPage.groupPage.addGroupPage.AddGroupElements.getElement;
import static ults.ElementController.verify;

public class AddGroupVerifier {
    private WebDriver driver;

    public AddGroupVerifier(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Verify the new group is created success and the success alert {expected} is displayed ")
    public AddGroupVerifier isCheckAddGroupSuccess(String expected){
        verify(driver,getElement(driver).alertCreateGroupSuccess,expected);
        return this;
    }
}
