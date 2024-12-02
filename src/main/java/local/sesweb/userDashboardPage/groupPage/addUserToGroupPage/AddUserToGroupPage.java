package local.sesweb.userDashboardPage.groupPage.addUserToGroupPage;

import org.openqa.selenium.WebDriver;

public class AddUserToGroupPage {
    public AddUserToGroupController act() {
        return addUserToGroupController;
    }

    public AddUserToGroupVerifier verify() {
        return addUserToGroupVerifier;
    }

    AddUserToGroupController addUserToGroupController;
    AddUserToGroupVerifier addUserToGroupVerifier;

    private AddUserToGroupPage(AddUserToGroupController addUserToGroupController, AddUserToGroupVerifier addUserToGroupVerifier) {
        this.addUserToGroupController = addUserToGroupController;
        this.addUserToGroupVerifier = addUserToGroupVerifier;
    }
    public static AddUserToGroupPage addUserToGroupPage(WebDriver driver){
        return new AddUserToGroupPage(new AddUserToGroupController(driver),new AddUserToGroupVerifier(driver));
    }
}
