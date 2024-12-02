package local.sesweb.userDashboardPage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static java.lang.Thread.sleep;
import static local.sesweb.userDashboardPage.UserDashboardElements.getUserDashboardElement;
import static ults.ElementController.*;

public class UserDashboardController {
    private WebDriver driver ;

    public UserDashboardController(WebDriver driver) {
        this.driver=driver;

    }
    @Step("Hover mouse on the Folder menu")
    public UserDashboardController hoverOnFolderMenu() {

        hover(driver, getUserDashboardElement(driver).folderMenu);
        return this;
    }
    @Step("Hover mouse on the User menu")
    public UserDashboardController hoverOnUserMenu() {

        hover(driver, getUserDashboardElement(driver).userMenu);
        return this;
    }
    @Step("Click on the Add Folder option")
    public UserDashboardController clickOnAddFolder() {
        click(driver, getUserDashboardElement(driver).addFolderOpt);
        return this;
    }
    @Step("Click on the View Properties option")
    public UserDashboardController clickOnViewPropertiesOpt() {
        click(driver, getUserDashboardElement(driver).viewPropertiesOpt);
        return this;
    }
    @Step("Click on the Add User option")
    public UserDashboardController clickOnAddUser() {
        click(driver, getUserDashboardElement(driver).addUserOpt);
        return this;
    }
    @Step("Click on the Add Group option")
    public UserDashboardController clickOnAddGroup() {
        click(driver, getUserDashboardElement(driver).addGroupOpt);
        return this;
    }
    @Step("Click on the Add User(s) to Group option")
    public UserDashboardController clickOnAddUserToGroup() {
        click(driver, getUserDashboardElement(driver).addUserToGroupOpt);
        return this;
    }



    private UserDashboardController clickOnExpandIcon() throws InterruptedException {
        click(driver, getUserDashboardElement(driver).expandFolderIcon);
        sleep(1000);
        return this;
    }
    @Step("Select User as {username}")
    public UserDashboardController selectExistingUser(String username) throws InterruptedException {
        selectElementHasLinkInTable(driver,getUserDashboardElement(driver).userListTbl,username);
        return this;
    }
    @Step("Enter user: {userName} at Search textbox ")
    public UserDashboardController searchUser(String userName){
        fill(driver,getUserDashboardElement(driver).searchText,userName);
        return this;
    }

    @Step("Select the folder as {folderName}")
    public UserDashboardController selectFolderOnFolderTree(String folderName) throws InterruptedException {
        clickOnExpandIcon();
        selectElementInList(driver,getUserDashboardElement(driver).folderTree,folderName);
        sleep(2000);
        return this;

    }
    @Step("Click on Folder properties option")
    public UserDashboardController clickOnFolderPropertiesOpt(){
        click(driver,getUserDashboardElement(driver).folderProperties);
        return this;
    }

    @Step("Select the folder as {groupName}")
    public UserDashboardController selectGroupOnFolderTree(String groupName) throws InterruptedException {
        clickOnExpandIcon();
        selectElementInList(driver,getUserDashboardElement(driver).folderTree,groupName);
        sleep(2000);
        return this;

    }
    @Step("Select the folder as {groupName}")
    public UserDashboardController selectGroupOnFolderTreeNotClickExpandIcon(String groupName) throws InterruptedException {
        selectElementInList(driver,getUserDashboardElement(driver).folderTree,groupName);
        sleep(2000);
        return this;

    }
    @Step("Click on the Log off Option at top right corner")
    public UserDashboardController clickOnLogOff()  {
        click(driver,getUserDashboardElement(driver).logOffOpt);
        return this;
    }
    @Step("Click on the User -> Delete user option")
    public UserDashboardController clickOnDeleteUserOpt() {
        click(driver,getUserDashboardElement(driver).deleteUserOptInUserMenu);
        return this;
    }
    @Step("Click on the Yes button on the Confirmation dialog")
    public UserDashboardController clickOnYesBtnOnConfirmationDialog() {
        click(driver,getUserDashboardElement(driver).yesBtnOnConfirmationDialog);
        return this;
    }
    @Step("Click on the root Folder")
    public UserDashboardController clickOnTheRootFolder() {
        click(driver,getUserDashboardElement(driver).rootFolders);
        return this;
    }

}
