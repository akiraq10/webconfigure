package local.sesweb.configuration.administratorManagementPage.addAdminGroupPage;

import local.sesweb.userDashboardPage.groupPage.addUserToGroupPage.AddUserToGroupController;
import local.sesweb.userDashboardPage.groupPage.addUserToGroupPage.AddUserToGroupPage;
import local.sesweb.userDashboardPage.groupPage.addUserToGroupPage.AddUserToGroupVerifier;
import org.openqa.selenium.WebDriver;

public class AddAdminGroupPage {
    AddAdminGroupController addAdminGroupController;
    AddAdminGroupVerifier addAdminGroupVerifier;
    private AddAdminGroupPage(AddAdminGroupController addAdminGroupController,
                              AddAdminGroupVerifier addAdminGroupVerifier)
    {
        this.addAdminGroupController=addAdminGroupController;
        this.addAdminGroupVerifier=addAdminGroupVerifier;
    }
    public static AddAdminGroupPage addAdminGroupPage(WebDriver driver){
        return new AddAdminGroupPage(new AddAdminGroupController(driver),new AddAdminGroupVerifier(driver));
    }

    public AddAdminGroupController act() {
        return addAdminGroupController;
    }
    public AddAdminGroupVerifier verify(){
        return addAdminGroupVerifier;
    }
}
