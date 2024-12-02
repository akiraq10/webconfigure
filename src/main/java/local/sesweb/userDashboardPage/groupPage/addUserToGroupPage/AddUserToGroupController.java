package local.sesweb.userDashboardPage.groupPage.addUserToGroupPage;

import io.qameta.allure.Step;
import local.sesweb.userDashboardPage.groupPage.addGroupPage.AddGroupController;
import org.openqa.selenium.WebDriver;


import static local.sesweb.userDashboardPage.groupPage.addUserToGroupPage.AddUserToGroupElements.getEle;
import static ults.ElementController.*;

public class AddUserToGroupController {

    WebDriver driver;

    public AddUserToGroupController(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Select the Group: {groupName}")
    public AddUserToGroupController selectTheGroupToAssign(String groupName) throws InterruptedException {
        selectElementInTable(driver,getEle(driver).selectUserTable,groupName);
        return this;
    }
    @Step("Click on the Save button")
    public AddUserToGroupController clickOnSaveBtn(){
        click(driver,getEle(driver).saveBtn);
        return this;
    }

    @Step("Click on Page size dropdown List")
    public AddUserToGroupController clickOnPageSizeDropdownList(){
        click(driver,getEle(driver).pageSizeDrpList);
        return this;
    }
    @Step("select page size =30")
    public AddUserToGroupController clickPageSize30(){
        click(driver,getEle(driver).pageSize30);
        return this;
    }
    @Step("Click on select All users checkbox")
    public AddUserToGroupController clickOnSelectAllUsersChk(){
        click(driver,getEle(driver).selectAllUsersChk);
        return this;
    }
}
