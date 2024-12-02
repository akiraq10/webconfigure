package local.sesweb.loginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.management.LockInfo;

public class LoginElements {
    private LoginElements(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public static LoginElements getLoginElement(WebDriver driver){
        return new LoginElements(driver);
    }

    @FindBy(id = "UserName")
    WebElement userName;
    @FindBy(css = "input[type='password']:nth-of-type(1)")
    WebElement password;
    @FindBy(id = "ses-submit-btn")
    WebElement loginBtn;
    @FindBy(id = "breadcrumb_Folder_ViewFolder_0")
    WebElement logoWMGBtn;
    @FindBy(className = "loginValidationErrors")
    WebElement unsuccessfulError;

}
