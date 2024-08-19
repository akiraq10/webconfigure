package local.sesweb.installationPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebInstallationElement {


    @FindBy(id = "Keyfile")
    WebElement keyfileTxt;
    @FindBy(id = "KeyfilePassword")
    WebElement keyfilePasswordTxt;
    @FindBy(id = "SqlServerName")
    WebElement sqlServerNameTxt;
    @FindBy(id = "SqlDatabaseName")
    WebElement sqlDatabaseNameTxt;
    @FindBy(id = "SqlUserName")
    WebElement sqlUserNameTxt;
    @FindBy(id = "SqlPassword")
    WebElement sqlPasswordTxt;
    @FindBy(xpath = "//span[@aria-labelledby='EnableLogging-form-label']")
    WebElement enableLoggingBtn;
    @FindBy(id = "config-button")
    WebElement configBtn;
    @FindBy(id = "ServerPublicUrl")
    WebElement serverPublicUrlTxt;
    @FindBy(id = "btn-reinstall-yes")
    WebElement reinstallYesBtn;
    @FindBy(id = "btn-reinstall-no")
    WebElement reinstallNoBtn;
    @FindBy(id = "IdpHost")
    WebElement providerUrLTxt;
    @FindBy(id = "IdpOAuthAppKey")
    WebElement OAuthClientIDTxt;
    @FindBy(id = "IdpOAuthAppSecret")
    WebElement OAuthClientSecretTxt;
    @FindBy(xpath = "//input[@name='EnableSESWebLogin']//parent::span")
    WebElement loginUsingIdPBtn ;

    private WebInstallationElement(WebDriver driver) {
//        this.driver= driver;
        PageFactory.initElements(driver,this);

    }

    public static WebInstallationElement getElement(WebDriver driver) {
        return new WebInstallationElement(driver);
 }


}
