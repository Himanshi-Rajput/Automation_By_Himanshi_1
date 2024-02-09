package TestCases;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BarCode {
    public static void main(String[] args) throws InterruptedException, IOException, NotFoundException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://barcode.tec-it.com/en/?data=Himanshi+Rajput&multiplebarcodes=true&translate-esc=on");

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0, 300)");

        String barcode_ele = driver.findElement(By.xpath("//*[@alt=\"Barcode\"]")).getAttribute("src");

        System.out.println(barcode_ele);

        URL url = new URL(barcode_ele);

        BufferedImage barcode_img = ImageIO.read(url);

        LuminanceSource luminanceSource = new BufferedImageLuminanceSource(barcode_img);
        HybridBinarizer hybridBinarizer = new HybridBinarizer(luminanceSource);
        BinaryBitmap binaryBitmap = new BinaryBitmap(hybridBinarizer);
        Result result = new MultiFormatReader().decode(binaryBitmap);

        String final_value = result.getText();

        System.out.println(final_value);

        System.out.println("Good job Himanshi....This is the final line of the code");

        Thread.sleep(3000);
        driver.quit();
    }
}
