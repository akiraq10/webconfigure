package local.sesweb.userDashboardPage.groupPage;

import io.qameta.allure.Step;
import local.sesweb.userDashboardPage.UserDashboardController;
import org.openqa.selenium.WebDriver;


import static local.sesweb.userDashboardPage.groupPage.GroupDashboardElements.getEle;
import static ults.ElementController.click;
import static ults.ElementController.hover;

public class GroupDashboardController {
    private WebDriver driver ;

    public GroupDashboardController(WebDriver driver) {
        this.driver=driver;

    }
    @Step("Hover mouse on the Group menu")
    public GroupDashboardController hoverOnFolderMenu() {

        hover(driver, getEle(driver).groupMenu);
        return this;
    }
    @Step("Click on Add user to group opt")
    public GroupDashboardController clickOnAddUserToGroupOpt() {

        click(driver, getEle(driver).addUserToGroupOpt);
        return this;
    }



}
