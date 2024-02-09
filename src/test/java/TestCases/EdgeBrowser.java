package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeBrowser {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Thread.sleep(5000);

        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();

        Thread.sleep(3000);

        String actual_title = driver.getTitle();
        String expected_title = "OrangeHRM";

        if(actual_title.equals(expected_title))
        {
            System.out.println("Titles are matched");
        }
        else
        {
            System.out.println("Titles are not matched");
        }

        Thread.sleep(3000);

        driver.quit();
    }
}
