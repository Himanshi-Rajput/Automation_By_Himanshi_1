package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scrolling1 {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://flagpedia.net/index");

        JavascriptExecutor jse = (JavascriptExecutor)driver;

        jse.executeScript("window.scrollBy(0,500)","");

        Thread.sleep(3000);

        WebElement India = driver.findElement(By.linkText("India"));

        jse.executeScript("arguments[0].scrollIntoView();", India);

        Thread.sleep(3000);

        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        Thread.sleep(3000);

        driver.quit();

    }
}
