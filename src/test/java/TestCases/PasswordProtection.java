package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Base64;

public class PasswordProtection {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Thread.sleep(5000);

        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys(decodepassword("YWRtaW4xMjM="));
        driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();

        Thread.sleep(3000);
        driver.quit();
    }
    public static String decodepassword (String pass)
    {
        byte[] decoded_pass =Base64.getDecoder().decode(pass);
        String DP = new String(decoded_pass);
        return DP;

    }
}