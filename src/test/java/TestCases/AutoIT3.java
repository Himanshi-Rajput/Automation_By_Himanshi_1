package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;

public class AutoIT3 {
    public static void main(String[] args) throws IOException, InterruptedException {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-notifications");
//        WebDriver driver = new ChromeDriver(options);

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--disable-notifications");
        FirefoxDriver driver = new FirefoxDriver(options);

        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Register.html");

        Thread.sleep(5000);

        //driver.findElement(By.xpath("//input[@id=\"imagesrc\"]")).click();

         WebElement element = driver.findElement(By.xpath("//*[@onchange='uploadimg()']"));

        JavascriptExecutor jse = (JavascriptExecutor)driver;

        jse.executeScript("arguments[0].click();", element);

        Thread.sleep(8000);

        Runtime.getRuntime().exec("C://Users//HimanshiRajput//Desktop//AutoIT//Test1"+" "+"C:\\Users\\HimanshiRajput\\Desktop\\AutoIT\\sampleFile");

        Thread.sleep(10000);

        driver.quit();

    }
}
