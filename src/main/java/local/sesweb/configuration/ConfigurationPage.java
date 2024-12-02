package local.sesweb.configuration;

import org.openqa.selenium.WebDriver;

public class ConfigurationPage {
    ConfigurationController configurationController;
    ConfigurationVerifier configurationVerifier;
    private ConfigurationPage(ConfigurationController configurationController,ConfigurationVerifier configurationVerifier){
        this.configurationController=configurationController;
        this.configurationVerifier=configurationVerifier;
    }
    public static ConfigurationPage configurationPage(WebDriver driver){
        return new ConfigurationPage(new ConfigurationController(driver),new ConfigurationVerifier(driver));
    }
    public ConfigurationController act(){
        return configurationController;
    }
    public ConfigurationVerifier verify(){
        return configurationVerifier;
    }
}
