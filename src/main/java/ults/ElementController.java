package ults;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import static org.testng.Assert.*;

public class ElementController {

    private static void waitForElementVisibility(WebDriver driver, WebElement elementName){
        try {
            WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOf(elementName));
        }catch (Exception e){
            fail("ERR| " +elementName + " Not displayed. Please recheck the locator");
            e.printStackTrace();
        }


    }
    private static void waitForElementClickAble(WebDriver driver, WebElement elementName){
        try {
            WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(elementName));
        }catch (Exception e)
        {
            fail("ERR| " +elementName + " Not displayed. Please recheck the locator");
            e.printStackTrace();
        }

    }


    public static void click(WebDriver driver,WebElement element){
        waitForElementClickAble(driver,element);
        element.click();
    }
    public static void fill(WebDriver driver,WebElement element,String textDatabase){
        waitForElementVisibility(driver,element);
        element.clear();
        element.sendKeys(textDatabase);


    }


    public static void verify(WebDriver driver,WebElement element){
        waitForElementVisibility(driver,element);

        if (!element.isDisplayed())
        {
            fail("ERR| " + element + " Not Found");
        }
        else
        {

            assertTrue(element.isDisplayed(), "Test case is failed");
        }

    }

    public static void verifyElementNotDisplay(WebDriver driver,WebElement element){
        if (!element.isDisplayed())
        {
            assertFalse(element.isDisplayed(), "Test case is failed");
        }
        else fail("ERR| " + element + " is Found");

    }

    public static void verify(WebDriver driver, WebElement element, String expected) {
       waitForElementVisibility(driver,element);

        if (!element.isDisplayed())
        {
            fail("ERR| " + element + " Not Found");
        }
        else
        {

            assertEquals(element.getText(), expected,"Test case is failed");
        }
    }
    public static void verifyTextInElement(WebDriver driver, WebElement element, String expected) {
        waitForElementVisibility(driver,element);
        assertEquals(element.getAttribute("value"), expected);
    }

    public static void browseFile(String path) throws AWTException {
        StringSelection ss = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        System.out.println(ss);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_ENTER);

    }

    public static void hover(WebDriver driver, WebElement element) {
        waitForElementClickAble(driver,element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();

    }
    public static void uncheck(WebDriver driver,WebElement element){
        waitForElementClickAble(driver,element);
        try{
            if (element.isSelected()){
                element.click();
        }
            else System.out.println(element + "was uncheck");

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void check(WebDriver driver,WebElement element){
        waitForElementVisibility(driver,element);

        try{
            if(!element.isSelected())
            {
                element.click();
            }else System.out.println(element + " was checked below");
        }catch (Exception e){
            e.printStackTrace();
        }



    }
    public static void select(WebElement element,String optionName){

        Select select = new Select(element);
        select.selectByVisibleText(optionName);

    }
    public static void selectOption(WebDriver driver,WebElement comboList,String optionName){
        waitForElementVisibility(driver,comboList);
        Actions action =new Actions(driver);



        if (!comboList.getText().equals(optionName)) {
            click(driver,comboList);
            try{

                WebElement option=driver
                        .findElement
                                (By.xpath
                                        ("//div[@class='k-animation-container']/div/div[@class='k-list-scroller']/ul/li[text()='" +
                                                optionName +
                                                "']"));

                action.moveToElement(option).perform();
                if(!option.isDisplayed()){
                    throw new IllegalArgumentException("[ERR] "+ comboList + " Not found");
                }else{
                    waitForElementClickAble(driver,option);
                    click(driver,option);
                }

            }catch (Exception e){e.getStackTrace();}
        }

    }
    public static void selectElementInTable(WebDriver driver, WebElement  table,String value) throws InterruptedException {
        waitForElementVisibility(driver,table);
        Thread.sleep(500);
        hover(driver, table);
        if (table.getText().contains(value)) {
            List<WebElement> rows = table.findElements(By.xpath(".//td"));
            for(WebElement row : rows){
                highLightElement(driver,table);
                if (row.getText().equals(value))
                {
                    highLightElement(driver,row);
                    driver.findElement(
                            By.xpath(
                                    "//td[text()='"+row.getText()+"']/preceding-sibling::td/input[@type='checkbox']"

                    )).click();

                    break;
                }

            }
        }else  fail("[ERR] "+value + " does not existing");
    }

    public static void selectElementHasSpaceInTextInTable(WebDriver driver, WebElement  table, String value) throws InterruptedException {
        waitForElementVisibility(driver,table);
        Thread.sleep(500);
        hover(driver, table);
        if (table.getText().contains(value)) {
            List<WebElement> rows = table.findElements(By.xpath(".//td"));
            for(WebElement row : rows){
                highLightElement(driver,table);
                if (row.getText().equals(value))
                {
                    highLightElement(driver,row);
                    driver.findElement(
                            By.xpath(
                                    "//td[text()=' "+row.getText()+" ']/preceding-sibling::td/input[@type='checkbox']"
                            )).click();

                    break;
                }

            }
        }else fail("[ERR] "+value + " does not existing");
    }
    public static void selectElementHasLinkInTable(WebDriver driver, WebElement  table,String value) throws InterruptedException {
        waitForElementVisibility(driver,table);
        Thread.sleep(1000);
        hover(driver, table);
        if (table.getText().contains(value)) {
            List<WebElement> rows = table.findElements(By.xpath(".//td"));

            for(WebElement row : rows){
                waitForElementVisibility(driver,row);
                highLightElement(driver,table);
                if (row.getText().equals(value))
                {
                    highLightElement(driver,row);
                    driver.findElement(
                            By.xpath(
                                    "//td[.//a[text()='"+row.getText()+"']]/preceding-sibling::td/input[@type='checkbox']"
                            )).click();

                    break;
                }

            }
        }else fail("[ERR] "+value + " does not existing");
    }
    public static void selectElementInList(WebDriver driver, WebElement  list,String value) throws InterruptedException {
        waitForElementVisibility(driver,list);
        hover(driver,list);
        highLightElement(driver,list);

        if (list.getText().contains(value)) {
            List<WebElement> listElements = list.findElements(By.cssSelector("li>a"));
            for(WebElement liElement : listElements){
                    if (liElement.getText().contains(value)){
                        highLightElement(driver,liElement);
                        click(driver,liElement);
                        break;
                    }
            }
        }else fail("[ERR] "+value + " does not existing");
    }
    public static void verifyElementNotDisplayInTable(WebDriver driver, WebElement  table,String value) throws InterruptedException {
        waitForElementVisibility(driver,table);
        Thread.sleep(500);
        hover(driver, table);
        if (!table.getText().contains(value)){
            assertTrue(true);
        }else fail(value+ "still displayed");

    }
    public static void verifyElementDisplayInTable(WebDriver driver, WebElement  table,String value) throws InterruptedException {
        waitForElementVisibility(driver,table);
        Thread.sleep(500);
        hover(driver, table);
        assertTrue(table.getText().contains(value));


    }
    private static void highLightElement(WebDriver driver, WebElement element)
    {
        if (!element.isDisplayed()){
            throw new IllegalArgumentException("[ERR] Unable to highLight your element");
        }else
        {
            JavascriptExecutor js=(JavascriptExecutor)driver;

            js.executeScript("arguments[0].setAttribute('style', ' border: 2px solid red;');", element);

            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException e) {

                System.out.println(e.getMessage());
            }

            js.executeScript("arguments[0].setAttribute('style',' border: solid 2px green');", element);
        }

    }
    public static void verifyElementIsDisplayedInTable(WebDriver driver, WebElement  table,String value) throws InterruptedException {
        waitForElementVisibility(driver,table);
        Thread.sleep(500);
        hover(driver, table);
        System.out.println(table.getText());
        if (table.getText().contains(value)){
            assertTrue(true);
        }else fail("[ERR] "+value + " does not existing");



    }

    public static void selectAllCheckboxInTable(WebDriver driver,WebElement table) throws InterruptedException {
        waitForElementVisibility(driver,table);
        Thread.sleep(500);
        hover(driver, table);
        if (table.isDisplayed()){

            List<WebElement> checkBoxes=table.findElements(By.xpath("//input[@type='checkbox' and not(@disabled)]"));
            for (WebElement checkBox : checkBoxes) {
                checkBox.click();
            }
        }


    }
    public static void checkboxChecked(WebDriver driver, WebElement element)  {
        if (element.getAttribute("checked")==null){
           fail("[ERR] The "+ element +"is not check");
        }

    }





}
