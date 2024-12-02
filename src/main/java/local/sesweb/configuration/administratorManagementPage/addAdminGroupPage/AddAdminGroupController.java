package local.sesweb.configuration.administratorManagementPage.addAdminGroupPage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static local.sesweb.configuration.administratorManagementPage.addAdminGroupPage.AddAdminGroupElements.getElen;
import static ults.ElementController.*;

public class AddAdminGroupController {
    WebDriver driver;
    public AddAdminGroupController(WebDriver driver){
        this.driver=driver;
    }
    @Step("Search Admin Group")
    public AddAdminGroupController fillGroupNameToSearchBox(String groupName){
        fill(driver, getElen(driver).searchBox,groupName);
        return this;
    }
    @Step("Select Admin Group: {groupName}")
    public AddAdminGroupController selectGroup(String groupName) throws InterruptedException {
        selectElementInTable(driver,getElen(driver).selectGroupTable,groupName);
        return this;
    }
    @Step("Select role: {role}")
    public AddAdminGroupController selectRoleForGroup(String role) throws InterruptedException {
        selectElementHasLinkInTable(driver,getElen(driver).selectRoleTable,role);
        return this;
    }
    @Step("Click on Save btn")
    public AddAdminGroupController clickOnSaveBtn() throws InterruptedException {
        click(driver,getElen(driver).saveBtn);
        return this;
    }

}
