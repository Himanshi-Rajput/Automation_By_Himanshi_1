package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CaptureImage {
    public static void main(String[] args) throws InterruptedException, IOException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Thread.sleep(5000);

        WebElement logo = driver.findElement(By.xpath("//*[@src=\"/web/images/ohrm_branding.png?v=1689053487449\"]"));

//        // Load jQuery
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        String jQueryScript = "var script = document.createElement('script'); " +
//                "script.src = 'https://code.jquery.com/jquery-3.6.4.min.js'; " +
//                "document.head.appendChild(script);";
//        jse.executeScript(jQueryScript);

        Screenshot logo_img = new AShot().coordsProvider(new WebDriverCoordsProvider()).shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver ,logo);

        BufferedImage actual_image = logo_img.getImage();

        File destination = new File("C://Users//HimanshiRajput//Desktop//Automation Testing//AShot API//actualimage3.png");

        ImageIO.write(actual_image, "png" , destination );

        File proof = new File("C://Users//HimanshiRajput//Desktop//Automation Testing//AShot API//actualimage3.png");

        if(proof.exists())
        {
            System.out.println("Logo Image saved successfully");
        }
        else
        {
            System.out.println("Logo Image not saved successfully");
        }

        System.out.println("this is last line of code");
        Thread.sleep(3000);
         driver.quit();

    }
}
