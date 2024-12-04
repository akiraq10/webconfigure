package driver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


public class DriverFactory {

    private  WebDriver driver;
    public WebDriver getDriver(Browser browser) throws MalformedURLException {
        if (driver==null){
            switch (browser){
                case chrome:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions=new ChromeOptions();
                    chromeOptions.setAcceptInsecureCerts(true);
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case firefox:
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions ffOpt=new FirefoxOptions();
                    ffOpt.setAcceptInsecureCerts(true);
                    driver=new FirefoxDriver(ffOpt);
                    break;
                case MicrosoftEdge:
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions edgeOpt=new EdgeOptions();
                    edgeOpt.setAcceptInsecureCerts(true);
                    driver=new EdgeDriver(edgeOpt);
                    break;
                default: throw new IllegalArgumentException("[ERR] the browser cannot null");
            }
            driver.manage().timeouts().implicitlyWait(2L, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }

        return driver;
    }

    public void quitDriverSession(){
        if (driver !=null){
            driver.quit();
            driver=null;
        }
    }




}
