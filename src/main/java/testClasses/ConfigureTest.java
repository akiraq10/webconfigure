package testClasses;

import dataprovider.ReadDataFromJSon;
import dataprovider.getdata.ConfigureInfoData;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.net.MalformedURLException;

import static local.idpPortal.installtionPage.IdPInstallationPage.idPInstallationPage;
import static local.sesweb.installationPage.WebInstallationPage.webInstallationPage;


public class ConfigureTest extends BaseTest {


    @Description("Make sure admin can configure SES.WEB success")
    @Test(description = "Test case SDTC....: Verify can config SES.WEB success",
            dataProvider = "ConfigureServer",
            dataProviderClass = ReadDataFromJSon.class )
    public void config_SESWEB(ConfigureInfoData data) throws InterruptedException, MalformedURLException {
        WebDriver driver=getDriver();
        driver.get(data.getScheme()+data.getDomain()+":"+data.getSesWebPort()+data.getSubDirectoryInstall());
        webInstallationPage(driver).act().fillKF(data.getKfPath())
                .fillKFPwd(data.getKfPWD())
                .fillServerName(data.getServerName())
                .fillDatabase(data.getDbName())
                .fillSqlUserName(data.getSqlUserName())
                .fillSQLPWD(data.getSqlPWD())
                .fillServerPublickUrL(data.getSesWebPublicServerURL())
                .enableDebugLog()
                .clickOnConfigureBtn();
        webInstallationPage(driver).verify().verifyAfterConfigSuccess();


    }

    @Description("Make sure admin can configure SES.IdP success")
    @Test(description = "Test case SDTC....: Verify can config IdP portal success",
            dataProvider = "ConfigureServer",
            dataProviderClass = ReadDataFromJSon.class)
    public void config_IdP(ConfigureInfoData data) throws InterruptedException, AWTException, MalformedURLException {

        WebDriver driver=getDriver();
        driver.get(data.getScheme()+data.getDomain()+":"+data.getIdpWebPort()+data.getSubDirectoryInstall());
        idPInstallationPage(driver).act()
                .fillKF(data.getKfPath())
                .fillKFPWD(data.getKfPWD())
                .fillServerName(data.getServerName())
                .fillDatabase(data.getDbName())
                .fillSQLUserName(data.getSqlUserName())
                .fillSQLPWD(data.getSqlPWD())
                .fillIdPServerUrl(data.getIdpPublicServerURL())
                .enableDebug()
                .clickSaveBtn();
        idPInstallationPage(driver).verify().verifyConfigSuccess();


    }
}
