package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CompareImage {
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriver driver =  new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Thread.sleep(5000);

        File expected_img_location = new File("C://Users//HimanshiRajput//Desktop//Automation Testing//AShot API//actualimage1.png");

        BufferedImage expected_img = ImageIO.read(expected_img_location);

        WebElement logo = driver.findElement(By.xpath("//*[@class=\"orangehrm-login-branding\"]"));

        Screenshot logo_obj = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver , logo);

        BufferedImage actual_logo = logo_obj.getImage();

        ImageDiffer img_check = new ImageDiffer();

        ImageDiff diff = img_check.makeDiff(actual_logo , expected_img);

        if (diff.hasDiff()==true)
        {
            System.out.println("Images are different");
        }
        else
        {
            System.out.println("Images are same.");
        }

        System.out.println("This is last line of code...Well Done Himanshi");

        driver.quit();

    }
}
