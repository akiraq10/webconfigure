package local.sesweb.userDashboardPage.groupPage.addGroupPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddGroupElements {
    @FindBy(id = "GroupName")
    WebElement groupName;
    @FindBy(id = "Description")
    WebElement description;
    @FindBy(name = "save")
    WebElement saveBtn;
    @FindBy(id = "GroupName-error")
    WebElement groupNameError;


    @FindBy(css = "[class='alert success']")
    WebElement alertCreateGroupSuccess;
    @FindBy(xpath = "alert i_access_denied red")
    WebElement alertCreateGroupExisting;

    private AddGroupElements(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    static AddGroupElements getElement(WebDriver driver) {
        return new AddGroupElements(driver);
    }
}
