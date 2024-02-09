package TestCases;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

import static TestCases.JSE2.*;


public class JSE1 {
    public static void main(String[] args) throws InterruptedException, IOException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        //Flashing element

        driver.get("https://flagpedia.net/index");
        WebElement India_flag = driver.findElement(By.xpath("//*[@href=\"/india\"]"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", India_flag);
        FlashbyJS(India_flag , driver);

        //Draw a border around the element

        borderbyJS(India_flag , driver);

        //Capture SS

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File target = new File("C://Users//HimanshiRajput//Desktop//Automation Testing//Saving SS in SeleniumWebdriver//1SS.png");
        FileHandler.copy(src , target);

        // Get title of the page

        //System.out.println(driver.getTitle());
        String title = getTitleByJS(driver);
        System.out.println(title);

        //Clicking on Web element

        WebElement IndiaFlag = driver.findElement(By.xpath("//*[@href=\"/india\"]"));
        clickElementByJS(IndiaFlag , driver);

        //Generate alert info

        String message = "Hi India";
        generateAlertByJS(driver , message);

        //Refreshing the browser

        //driver.navigate().refresh();
        refreshPageBYJS(driver);

        //Scrolling1

        driver.navigate().back();
        WebElement Greece_Flag = driver.findElement(By.xpath("//*[@href=\"/greece\"]"));
        scrollIntoViewByJS( Greece_Flag , driver);

        //scrolling2

        scrollPageDownByJS(driver);

        System.out.println("This is last line of code.");
        driver.quit();

    }
}
