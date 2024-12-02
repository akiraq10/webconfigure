package local.sesweb.userDashboardPage.groupPage.addUserToGroupPage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static local.sesweb.userDashboardPage.groupPage.addUserToGroupPage.AddUserToGroupElements.getEle;
import static ults.ElementController.verify;

public class AddUserToGroupVerifier {
    WebDriver driver;

    public AddUserToGroupVerifier(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Verify the Assign group page is displayed")
    public AddUserToGroupVerifier isCheckAssignGroupPageDisplay(){
        verify(driver,getEle(driver).assignGroupBreadcrumb);
        return this;
    }
    @Step("Verify the 'Operation succeeded.' is displayed")
    public AddUserToGroupVerifier isCheckSuccessAlertDisplay(){
        verify(driver,getEle(driver).successAlert);
        return this;
    }
}
