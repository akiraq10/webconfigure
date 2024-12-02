package local.sesweb.configuration;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static local.sesweb.configuration.ConfigurationElements.getElen;
import static ults.ElementController.click;

public class ConfigurationController {
    WebDriver driver;
    public ConfigurationController(WebDriver driver) {
        this.driver = driver;

    }

    @Step("Click On Configuration in left nav")
    public ConfigurationController clickConfiguration(){
        click(driver,getElen(driver).configurationPage);
        return this;
    }
    @Step("Click On Administrator Management")
    public ConfigurationController clickAdministratorManage(){
        click(driver,getElen(driver).administratorPage);
        return this;
    }

}
