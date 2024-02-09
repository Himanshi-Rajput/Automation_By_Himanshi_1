package TestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestNGHardAssertion {
    public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Thread.sleep(3000);

        WebElement UN = driver.findElement(By.name("username"));
        WebElement PWD = driver.findElement(By.name("password"));

        Assert.assertTrue(UN.isDisplayed());
        UN.sendKeys("Admin");

        Assert.assertTrue(PWD.isEnabled());
        PWD.sendKeys("admin123");

//        Assert.assertFalse(UN.isDisplayed());
//        UN.sendKeys("Admin");
//
//        Assert.assertFalse(PWD.isEnabled());
//        PWD.sendKeys("admin123");

        driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();

        System.out.println("Testing is successfully done....");

        String title = driver.getTitle();

        Assert.assertEquals(title , "OrangeHRM");

        Thread.sleep(3000);
        driver.quit();
    }
}
