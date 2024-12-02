package local.sesweb.configuration.administratorManagementPage.addAdminGroupPage;

import local.sesweb.configuration.administratorManagementPage.AdministratorDashboardElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddAdminGroupElements {
  @FindBy(css="input[placeholder='Search...']")
    WebElement searchBox;
  @FindBy(css="table[data-role]>tbody")
    WebElement selectGroupTable;
  @FindBy(xpath = "//div[@id='kendogrid2']//table[@role='grid']")
    WebElement selectRoleTable;
  @FindBy(css = "button[name='save']")
  WebElement saveBtn;
    private AddAdminGroupElements(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    static AddAdminGroupElements getElen(WebDriver driver){
        return new AddAdminGroupElements(driver);
    }

}
