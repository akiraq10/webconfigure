package local.sesweb.userDashboardPage.groupPage.addUserToGroupPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddUserToGroupElements {
    @FindBy(id = "breadcrumb_Folder_AssignGroup_4")
    WebElement assignGroupBreadcrumb;
    @FindBy(css ="input[placeholder='Search...']")
    WebElement searchTxt;
    @FindBy(css ="table[data-role]>tbody")
    WebElement selectUserTable;
    @FindBy(linkText = "Display all groups")
    WebElement displayAllGroupsChk;
    @FindBy(css ="button[name='save']")
    WebElement saveBtn;
    @FindBy(css =".alert.warning")
    WebElement redWarningAlert;
    @FindBy(css =".alert.success")
    WebElement successAlert;
    @FindBy(css="input[aria-label='Select all rows']")
    WebElement selectAllUsersChk;


    @FindBy(css="span[aria-label='Page sizes drop down']")
    WebElement pageSizeDrpList;
    @FindBy(xpath = "//div[@aria-label='Page sizes drop down']//li/span[text()=40]")
    WebElement pageSize30;

    private AddUserToGroupElements(WebDriver driver) {

        PageFactory.initElements(driver,this);
    }
    static AddUserToGroupElements getEle(WebDriver driver){
        return new AddUserToGroupElements(driver);
    }

}
