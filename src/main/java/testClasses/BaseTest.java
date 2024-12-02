package testClasses;


import driver.Browser;
import driver.DriverFactory;
import io.qameta.allure.Allure;
import org.aeonbits.owner.ConfigFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

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
    private String browser;
    String url;
    String adminUser;
    String pwd;



    public WebDriver getDriver() throws MalformedURLException {
        return driverThread.get().getDriver(Browser.valueOf(browser));
    }

    @Parameters({"browser","url","adminUser","pwd"})
    @BeforeMethod(alwaysRun = true)
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



    @AfterMethod(alwaysRun = true)
    public void quitDriverSession(ITestResult result) {
      try {
          takeScreenShoot(result);

                  if (driverThread != null) {

                      driverThread.get().quitDriverSession();

                  }



      } catch (Exception e) {
          e.printStackTrace();
      }

  }

//   @AfterMethod(alwaysRun = true)
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
