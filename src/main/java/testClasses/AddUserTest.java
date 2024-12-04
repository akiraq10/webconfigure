package testClasses;

import dataprovider.ReadDataFromJSon;
import dataprovider.getdata.GroupInfoData;
import dataprovider.getdata.UserInfoData;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static local.sesweb.configuration.ConfigurationPage.configurationPage;
import static local.sesweb.configuration.administratorManagementPage.AdministratorDashboardPage.administratorDashboardPage;
import static local.sesweb.configuration.administratorManagementPage.addAdminGroupPage.AddAdminGroupPage.addAdminGroupPage;
import static local.sesweb.loginPage.LoginPage.loginPage;
import static local.sesweb.userDashboardPage.UserDashboardPage.userDashboardPage;
import static local.sesweb.userDashboardPage.groupPage.GroupDashboardPage.groupDashboardPage;
import static local.sesweb.userDashboardPage.groupPage.addGroupPage.AddGroupPage.addGroupPage;
import static local.sesweb.userDashboardPage.groupPage.addUserToGroupPage.AddUserToGroupPage.addUserToGroupPage;
import static local.sesweb.userDashboardPage.userPage.addUserPage.AddUserPage.addUserPage;

public class AddUserTest extends BaseTest{

    @Description("Add new user")
    @Test(description = "Test case SDTC....: Verify can add new user success",
            dataProvider = "UserInfo",
            dataProviderClass = ReadDataFromJSon.class )
    public void CreateUser(UserInfoData data) throws MalformedURLException {
        WebDriver driver=getDriver();
        driver.get(url);
        loginPage(driver).act().loginSESWEB(adminUser,pwd);
        userDashboardPage(driver).act()
                .hoverOnFolderMenu()
                .clickOnAddUser();

        addUserPage(driver).act()
                .fillUserID(data.getUsername())
                .fillPWD(data.getPwd())
                .unCheckFinalPassword()
                .clickOnSaveBtn();

    }

    @Description("Add new Group on SES.WEB success")
    @Test(description = "Test case SDTC....: Verify can add new Group success",
            dataProvider = "GroupInfo",
            dataProviderClass = ReadDataFromJSon.class )
    public void CreateGroup(GroupInfoData data) throws MalformedURLException, InterruptedException {
        WebDriver driver=getDriver();
        driver.get(url);
        loginPage(driver).act()
                        .loginSESWEB(adminUser,pwd);
        userDashboardPage(driver).act()
                .hoverOnFolderMenu()
                .clickOnAddGroup();
        addGroupPage(driver).act()
                .fillGroupName(data.getGroupName())
                .fillDescription(data.getGroupDescription())
                .clickOnSaveButton();
    }
    @Description("Add User to Group on SES.WEB success")
    @Test(description = "Test case SDTC....: Verify can add new Group success",
            dataProvider = "GroupInfo",
            dependsOnMethods = {"CreateGroup","CreateUser"},
            dataProviderClass = ReadDataFromJSon.class )
    public void AddUserToGroup(GroupInfoData data) throws MalformedURLException, InterruptedException {
        WebDriver driver=getDriver();
        driver.get(url);
        loginPage(driver).act()
                        .loginSESWEB(adminUser,pwd);
        userDashboardPage(driver).act()
                .selectGroupOnFolderTree(data.getGroupName());
        groupDashboardPage(driver).act()
                .hoverOnFolderMenu()
                .clickOnAddUserToGroupOpt();
        addUserToGroupPage(driver).act()
                .clickOnPageSizeDropdownList()
                .clickPageSize40()
                .clickOnSelectAllUsersChk()
                .clickOnSaveBtn();
    }

    @Description("Add group to administrator group success")
    @Test(description = "Test case SDTC....: Verify can add  Group administrator group success",
            dataProvider = "GroupInfo",
            dependsOnMethods = "AddUserToGroup",
            dataProviderClass = ReadDataFromJSon.class )
    public void AddGroupToAdministratorGroupPage(GroupInfoData data) throws MalformedURLException, InterruptedException {
        WebDriver driver=getDriver();
        driver.get(url);
        loginPage(driver).act()
                .loginSESWEB(adminUser,pwd);
        configurationPage(driver).act()
                .clickConfiguration()
                .clickAdministratorManage();
        administratorDashboardPage(driver).act()
                .clickOnAdministratorGroupTab()
                .hoverOnAdministratorMenu()
                .clickOnAddAdminGroupOpt();
        addAdminGroupPage(driver).act()
                .fillGroupNameToSearchBox(data.getGroupName())
                .selectGroup(data.getGroupName())
                .selectRoleForGroup("Administrator")
                .clickOnSaveBtn();
    }


}
