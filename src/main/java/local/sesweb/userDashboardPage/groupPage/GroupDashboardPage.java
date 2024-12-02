package local.sesweb.userDashboardPage.groupPage;

import org.openqa.selenium.WebDriver;

public class GroupDashboardPage {
    GroupDashboardController groupDashboardController;
    GroupDashboardVerifier groupDashboardVerifier;

    private GroupDashboardPage(GroupDashboardController groupDashboardController,GroupDashboardVerifier groupDashboardVerifier){
        this.groupDashboardController=groupDashboardController;
        this.groupDashboardVerifier=groupDashboardVerifier;
    }

    public static GroupDashboardPage groupDashboardPage(WebDriver driver){
        return new GroupDashboardPage(new GroupDashboardController(driver),new GroupDashboardVerifier(driver));
    }
    public GroupDashboardController act(){
        return groupDashboardController;
    }
    public GroupDashboardVerifier verifier(){
        return groupDashboardVerifier;
    }

}
