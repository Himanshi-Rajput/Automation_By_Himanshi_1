package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class AutoIT2 {

    public static void main(String[] args) throws InterruptedException, IOException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        Thread.sleep(1000);

        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@href=\"/web/index.php/pim/viewPimModule\"]")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@class=\"oxd-icon bi-chevron-left\"]")).click();

        Thread.sleep(1000);

        driver.findElement(By.linkText("Add Employee")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@class=\"oxd-icon bi-chevron-left\"]")).click();

        driver.findElement(By.xpath("//*[@class=\"oxd-icon-button oxd-icon-button--solid-main employee-image-action\"]")).click();

        Runtime.getRuntime().exec("C://Users//HimanshiRajput//Desktop//AutoIT//Test2"+" "+"C:\\Users\\HimanshiRajput\\Desktop\\AutoIT\\sampleFile");

        Thread.sleep(8000);

        driver.quit();

    }
}
