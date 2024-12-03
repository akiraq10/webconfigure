package local.sesweb.userDashboardPage.groupPage.addUserToGroupPage;

import io.qameta.allure.Step;
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
        hover(driver,getEle(driver).selectSizeDropdownList);
        click(driver,getEle(driver).selectSizeDropdownList);



        return this;
    }
    @Step("select page size = 40")
    public AddUserToGroupController clickPageSize40() throws InterruptedException {
        click(driver,getEle(driver).pageSize40);
        Thread.sleep(1000);
        return this;
    }
    @Step("Click on select All users checkbox")
    public AddUserToGroupController clickOnSelectAllUsersChk(){
        click(driver,getEle(driver).selectAllUsersChk);
        return this;
    }
}
