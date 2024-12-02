package local.sesweb.userDashboardPage.userPage.addUserPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUserElements {
    @FindBy(id = "User_Name")
    WebElement userIDTXT;
    @FindBy(id = "password-input")
    WebElement passwordTXT;
    @FindBy(id = "FirstName")
    WebElement firstNameTXT;
    @FindBy(id = "LastName")
    WebElement lastNameTXT;
    @FindBy(id = "Phone")
    WebElement phoneTXT;
    @FindBy(id = "Email")
    WebElement emailTXT;
    @FindBy(id = "IsAdminSetPassword")
    WebElement finalPWDCheckBox;
    @FindBy(id = "Description")
    WebElement descriptionTXT;
    @FindBy(name = "UserType")
    WebElement userTypeOpt;
    @FindBy(id = "uniform-UserType")
    WebElement userTypeListBox;
    @FindBy(id = "new-user-submit")
    WebElement saveBtn;

    @FindBy(css = "[class='alert success']")
    WebElement successAlert;


    private AddUserElements(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    static AddUserElements getEle(WebDriver driver) {
        return new AddUserElements(driver);
    }

}
