package TestCases;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

public class AutoIT1 {

    public static void main(String[] args) throws InterruptedException, IOException {

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-notifications");
//        WebDriver driver = new ChromeDriver(options);

        FirefoxDriver driver = new FirefoxDriver();

        driver.get("https://demoqa.com/upload-download");
        driver.manage().window().maximize();

        JavascriptExecutor jse = (JavascriptExecutor)driver;

        jse.executeScript("window.scrollBy(0,200)");

        //driver.findElement(By.xpath("//*[@id=\"uploadFile\"]")).click();

        WebElement ele = driver.findElement(By.xpath("//*[@id='uploadFile']"));

        //Thread.sleep(500);
        jse.executeScript("arguments[0].click()", ele);
        //jse.executeScript("arguments[0].click();", ele);

        Runtime.getRuntime().exec("C://Users//HimanshiRajput//Desktop//AutoIT//Test1"+"  "+"C:\\Users\\HimanshiRajput\\Desktop\\AutoIT\\sampleFile");

        System.out.println("Done");

        driver.close();






    }
}
