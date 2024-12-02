package local.sesweb.configuration.administratorManagementPage;

import io.qameta.allure.Step;

import org.openqa.selenium.WebDriver;

import static local.sesweb.configuration.administratorManagementPage.AdministratorDashboardElements.getElen;
import static ults.ElementController.*;


public class AdministratorDashboardController {
    private WebDriver driver;

    public AdministratorDashboardController(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Hover mouse on the Administrator menu")
    public AdministratorDashboardController hoverOnAdministratorMenu(){
        hover(driver,getElen(driver).administratorMenu);
        return this;
    }
    @Step("Click on the Add new Administrator option")
    public AdministratorDashboardController clickOnAddNewAdminOpt(){
        click(driver,getElen(driver).addNewAdminOpt);
        return this;
    }
    @Step("Click on the View Properties option")
    public AdministratorDashboardController clickOnViewPropertiesOpt(){
        click(driver,getElen(driver).viewPropertiesOpt);
        return this;
    }
    @Step("Select an admin user :{username}")
    public AdministratorDashboardController selectAdminUser(String username) throws InterruptedException {
        selectElementHasLinkInTable(driver,getElen(driver).adminUserTable,username);
        return this;
    }
    @Step("Click on Administrator Group tab")
    public AdministratorDashboardController clickOnAdministratorGroupTab() throws InterruptedException {
        click(driver,getElen(driver).administratorGroupTab);
        return this;
    }
    @Step("Click on add Administrator Group ")
    public AdministratorDashboardController clickOnAddAdminGroupOpt() throws InterruptedException {
        click(driver,getElen(driver).addAdministratorGroupOpt);
        return this;
    }
}
