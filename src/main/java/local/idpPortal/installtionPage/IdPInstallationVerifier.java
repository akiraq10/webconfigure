package local.idpPortal.installtionPage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;


import static local.idpPortal.installtionPage.IdPInstallationElement.getElement;
import static org.testng.Assert.assertTrue;


public class IdPInstallationVerifier {
    private WebDriver driver ;


    public IdPInstallationVerifier(WebDriver driver) {
        this.driver=driver;

    }

    @Step("Expected: IdP is configured success")
    public IdPInstallationVerifier verifyConfigSuccess() throws InterruptedException {
        Thread.sleep(500);
        assertTrue(getElement(driver).signInBtn.isDisplayed());
        return this;
    }


}
