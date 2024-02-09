package TestCases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSE2 {



    /*
    JavaScriptExecutor is an interface that is used to execute JavaScript
    through selenium webdriver. JavaScript is a programming language that
    interacts with HTML in a browser, and to use this function in Selenium,
    JavascriptExecutor is required.
     */

    //Flashing the element

    public  static void FlashbyJS(WebElement element , WebDriver driver)
    {
        String bgcolor = element.getCssValue("background-color");

        for (int i=0 ; i<=50 ; i++)
        {
            colorchange("#000000", element , driver);
            colorchange(bgcolor , element , driver);
        }
    }

    public static void colorchange (String color , WebElement element , WebDriver driver)
    {
        JavascriptExecutor jse = (JavascriptExecutor)driver;

        jse.executeScript("arguments[0].style.background='"+color+"'", element);
    }


    public static void borderbyJS(WebElement element , WebDriver driver) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].style.border='3px solid red'", element);
        Thread.sleep(3000);
    }

    public static String getTitleByJS(WebDriver driver)
    {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        String title = jse.executeScript("return document.title").toString();
        return title;
    }

    public static void clickElementByJS (WebElement element , WebDriver driver) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", element);
        Thread.sleep(3000);
    }

    public static void generateAlertByJS(WebDriver driver , String message) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("alert('"+message+"')");
        Thread.sleep(5000);
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);
    }

    public static void refreshPageBYJS(WebDriver driver) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("history.go(0)");
        Thread.sleep(3000);
    }

    public static void scrollIntoViewByJS(WebElement element,WebDriver driver) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",element);
        Thread.sleep(3000);
    }

    public static void scrollPageDownByJS(WebDriver driver) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, document.body.offsetHeight)");
        Thread.sleep(3000);
    }




}
