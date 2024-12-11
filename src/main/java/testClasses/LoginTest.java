package testClasses;


import dataprovider.ReadDataFromJSon;
import dataprovider.getdata.UserInfoData;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class LoginTest  extends BaseTest{

    @Description("Login SES.WEB success")
    @Test(description = "Test case SDTC....: Verify can login SES.WEB success",
            dataProvider = "UserInfo",
            dataProviderClass = ReadDataFromJSon.class )
    public void loginSES(UserInfoData data) throws MalformedURLException {
//        WebDriver driver=getDriver();
//        driver.get("https://magicendpoint-dev.com/");
//        loginSES(driver).act()
//                .fillUserName("qavndev")
//                .fillPWD("Qavn@123")
//                .clickOnLoginBtn();

    }

}
