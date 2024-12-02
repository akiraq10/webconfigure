package local.sesweb.userDashboardPage.groupPage;

import local.sesweb.userDashboardPage.UserDashboardElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GroupDashboardElements {
    @FindBy(id = "Actions_Type_Group_Basic")
    WebElement groupMenu;
    @FindBy(id = "Actions_Group_AddUser")
    WebElement addUserToGroupOpt;
    private GroupDashboardElements(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }

    static GroupDashboardElements getEle(WebDriver driver) {
        return new GroupDashboardElements(driver);
    }
}
