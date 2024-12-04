package testClasses;


import driver.Browser;
import driver.DriverFactory;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class BaseTest {
    private static final List<DriverFactory> driverThreadPool = Collections.synchronizedList((new ArrayList<>()));
    private static   ThreadLocal<DriverFactory> driverThread;
    public String browser;
    public String url;
    public String adminUser;
    public String pwd;



    public WebDriver getDriver() throws MalformedURLException {
        return driverThread.get().getDriver(Browser.valueOf(browser));
    }

    @Parameters({"browser","url","adminUser","pwd"})
    @BeforeTest()
    public void initWebDriverObject(String browser,String url,String adminUser, String pwd) {
        this.browser=browser;
        this.url=url;
        this.adminUser=adminUser;
        this.pwd=pwd;
        driverThread = ThreadLocal.withInitial(()->{
            DriverFactory driverThread = new DriverFactory();
            driverThreadPool.add(driverThread);
            return driverThread;
        });
    }



    @AfterSuite(alwaysRun = true)
    public void quitBrowser() {
        try {
            for (DriverFactory driver : driverThreadPool) {
                driver.quitDriverSession();
            }

        } catch (Exception e) {
            e.printStackTrace(); // Log any exceptions during cleanup
        }

  }

   @AfterMethod(description = "capture img if test is failed")
    public void takeScreenShoot(ITestResult result) throws MalformedURLException {
        getDriver().manage().deleteAllCookies();

        if(result.getStatus() == ITestResult.FAILURE){
            //1. get the test method name
            String testMethod = result.getName();

            //2. Declare File Location
            Calendar calendar =new GregorianCalendar();
            int y =calendar.get(Calendar.YEAR);
            int month =calendar.get(Calendar.MONTH);
            int day =calendar.get(Calendar.DATE);
            int hr =calendar.get(Calendar.HOUR_OF_DAY);
            int min =calendar.get(Calendar.MINUTE);
            int sec =calendar.get(Calendar.MILLISECOND);

            String takeTime =y + "-" + (month+1) + "-" + day + "-" + hr +"-" +min +"-"+sec;


            String folderTestDate="Failed Results IMGs Date " +month +"-" +day+"-"+y;
            String imageName=testMethod+"-"+takeTime+".png";
            String fileLocaltion = System.getProperty("user.dir") + "/screenshots/"+folderTestDate+"/"+imageName;


            //3. Save screenshot to the system
            File screenShot =((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenShot, new File(fileLocaltion));
                Path content = Paths.get(fileLocaltion);
                try (InputStream is = Files.newInputStream(content)){
                    Allure.addAttachment(testMethod,is);
                }


            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }


}
