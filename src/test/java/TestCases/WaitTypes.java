package TestCases;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class WaitTypes {

    public static void main(String[] args) throws InterruptedException {

       implicitwait();

       Explicitwait();

        FluentWait();

    }

    public static void implicitwait()
    {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);

        System.out.println(driver.getPageSource());

        System.out.println("Implicit functionality done.");

        driver.close();

    }

    public static void  Explicitwait() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com/");

        driver.findElement(By.xpath("//*[@role=\"combobox\"]")).sendKeys("Manual Testing" + Keys.ENTER);


        Thread.sleep(1000);
        JavascriptExecutor jse = (JavascriptExecutor)driver;

        jse.executeScript("window.scrollBy(0, 500)", "");


        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));


        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"rso\"]/div[2]/div/div/div[1]/div/div/span/a/div/div/div/cite")));

        System.out.println(ele.getText());

        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        ele =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

        System.out.println(ele.getAttribute("placeholder"));

        System.out.println("Explicit Wait Test is Done.");

    }

    public static  void FluentWait()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        org.openqa.selenium.support.ui.Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5)).ignoring(Exception.class);
        driver.get("https://demo.guru99.com/test/guru99home/");

        WebElement ele = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(By.xpath("//*[@href=\"https://www.guru99.com/selenium-tutorial.html\"]"));
            }
        });

        ele.click();
        System.out.println("Fluent Wait is tested");

    }
}
