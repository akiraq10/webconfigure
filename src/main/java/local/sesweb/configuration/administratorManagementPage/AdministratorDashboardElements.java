package local.sesweb.configuration.administratorManagementPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdministratorDashboardElements {
    @FindBy(id = "breadcrumb_Configuration_ViewConfigAdminUsers_3")
    WebElement administratorManagementBreadcrumb;
    @FindBy(id = "Actions_Type_Admin_Basic")
    WebElement administratorMenu;
    @FindBy(id = "Actions_Configuration_ManageRbacRoles")
    WebElement manageRoleOpt;
    @FindBy(id = "Actions_Configuration_AddAdmin")
    WebElement addNewAdminOpt;
    @FindBy(id = "Actions_Configuration_DeleteAdminConfirmed")
    WebElement deleteAdminOpt;
    @FindBy(id = "Actions_Configuration_ViewAdminGeneral")
    WebElement viewPropertiesOpt;
    @FindBy(id = "Actions_Configuration_ChangePassword")
    WebElement changeAdminPwdOpt;
    @FindBy(xpath = "//tbody")
    WebElement adminUserTable;
    @FindBy(xpath = "//input[@placeholder='Search...']")
    WebElement searchTxt;
    @FindBy(xpath = "//span[@class='k-icon k-i-search']")
    WebElement searchIcon;
    @FindBy(id="tabs_Admin_1")
    WebElement administratorGroupTab;
    @FindBy(id="Actions_Configuration_AddAdminGroup")
    WebElement addAdministratorGroupOpt;


    private AdministratorDashboardElements(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    static AdministratorDashboardElements getElen(WebDriver driver){
        return new AdministratorDashboardElements(driver);
    }
}
