package local.sesweb.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfigurationElements {
    @FindBy(linkText = "Configuration")
    WebElement configurationPage;
    @FindBy(linkText = "Service Settings")
    WebElement serviceSettingPage;
    @FindBy(linkText = "Administrator Management")
    WebElement administratorPage;
    @FindBy(linkText = "Folder Encryption Policies")
    WebElement folderEncryptPoliciesPage;
    @FindBy(linkText = "Server's RSA Keys")
    WebElement serverRSAKeysPage;
    @FindBy(linkText = "Licenses")
    WebElement licensesPage;
    @FindBy(linkText = "Options")
    WebElement optionsPage;

    private ConfigurationElements(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    static ConfigurationElements getElen(WebDriver driver){
        return new ConfigurationElements(driver);
    }
}
