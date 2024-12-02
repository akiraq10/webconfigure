package local.sesweb.configuration.administratorManagementPage;

import org.openqa.selenium.WebDriver;

import java.util.Stack;

public class AdministratorDashboardPage {
    AdministratorDashboardController administratorDashboardController;
    AdministratorDashboardVerifier administratorDashboardVerifier;
    private AdministratorDashboardPage(AdministratorDashboardController administratorDashboardController, AdministratorDashboardVerifier administratorDashboardVerifier)
    {
        this.administratorDashboardController=administratorDashboardController;
        this.administratorDashboardVerifier=administratorDashboardVerifier;
    }
    public static AdministratorDashboardPage administratorDashboardPage(WebDriver driver){
        return new AdministratorDashboardPage(new AdministratorDashboardController(driver),new AdministratorDashboardVerifier(driver));
    }

    public AdministratorDashboardController act() {
        return administratorDashboardController;
    }

    public AdministratorDashboardVerifier verifier() {
        return administratorDashboardVerifier;
    }
}
