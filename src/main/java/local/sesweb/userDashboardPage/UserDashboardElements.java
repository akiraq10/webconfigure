package local.sesweb.userDashboardPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserDashboardElements {
    @FindBy(linkText = "Users")
    WebElement usersPage;
    @FindBy(id = "Actions_Type_User_Basic")
    WebElement userMenu;
    @FindBy(id = "Actions_Type_User_Advanced")
    WebElement userAdvancedMenu;
    @FindBy(id = "Actions_User_ViewUserGeneral")
    WebElement viewPropertiesOpt;
    @FindBy(id = "Actions_Type_Folder_Basic")
    WebElement folderMenu;
    @FindBy(id = "Actions_Folder_AddFolder")
    WebElement addFolderOpt;
    @FindBy(id = "Actions_Folder_AddUserGeneral")
    WebElement addUserOpt;
    @FindBy(id = "Actions_Group_AddGroup")
    WebElement addGroupOpt;
    @FindBy(id = "Actions_User_ChallengeResponseGen")
    WebElement challengeResponseRMCEOpt;
    @FindBy(id = "Actions_Folder_ViewFolderGeneral")
    WebElement folderProperties;

    @FindBy(css = "[id='UF_0_Rm9sZGVycw=='][class='jstree-closed']>ins")
    WebElement expandFolderIcon;
    @FindBy(css ="[id='UF_0_Rm9sZGVycw==']>ul")
    WebElement folderTree;

    @FindBy(css = "tbody")
    WebElement userListTbl;
    @FindBy(id = "breadcrumb_Folder_ViewFolder_2")
    WebElement usersBreadcrumb;
    @FindBy(id = "Actions_User_AssignGroups")
    WebElement addUserToGroupOpt;
    @FindBy(css ="input[placeholder='Search...']")
    WebElement searchText;
    @FindBy(css =".alert.success")
    WebElement successAlert;
    @FindBy(id = "header_logoffbutton")
    WebElement logOffOpt;
    @FindBy(id = "Actions_User_DeleteUserConfirmed")
    WebElement deleteUserOptInUserMenu;
    @FindBy(xpath = "//button[text()='Yes']")
    WebElement yesBtnOnConfirmationDialog;
    @FindBy(linkText = "Folders")
    WebElement rootFolders;
    private UserDashboardElements(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }

    static UserDashboardElements getUserDashboardElement(WebDriver driver) {
        return new UserDashboardElements(driver);
    }


}
