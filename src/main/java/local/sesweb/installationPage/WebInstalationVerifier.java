package local.sesweb.installationPage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static local.sesweb.installationPage.WebInstallationElement.getElement;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class WebInstalationVerifier {

    private WebDriver driver ;

    public WebInstalationVerifier(WebDriver driver) {
        this.driver=driver;

    }

    @Step("Expected: SES.WEB is configure success")
    public WebInstalationVerifier verifyAfterConfigSuccess() throws InterruptedException {
        Thread.sleep(5000);
        assertEquals(driver.getTitle(), "Log On");
        return this;
    }



}
