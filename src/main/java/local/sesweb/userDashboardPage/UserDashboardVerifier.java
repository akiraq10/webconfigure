package local.sesweb.userDashboardPage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import static ults.ElementController.*;
import static local.sesweb.userDashboardPage.UserDashboardElements.getUserDashboardElement;

public class UserDashboardVerifier {
    private WebDriver driver ;


    public UserDashboardVerifier(WebDriver driver) {
        this.driver=driver;

    }
    @Step("Verify the Extend icon display on the Tree Folder")
    public UserDashboardVerifier isCheckExtendIconOnFolderTree(){
        verify(driver,getUserDashboardElement(driver).expandFolderIcon);
        return this;
    }
    @Step("Verify the Users breadcrumb is displayed")
    public UserDashboardVerifier isCheckUserBreadcrumbDisplay(){
        verify(driver,getUserDashboardElement(driver).usersBreadcrumb);
        return this;
    }
    @Step("Verify The Alert Success is displayed")
    public UserDashboardVerifier isCheckAlertSuccessDisplay(){
        verify(driver,getUserDashboardElement(driver).successAlert);
        return this;
    }
}
