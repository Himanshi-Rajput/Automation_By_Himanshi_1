package TestCases;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class QRcode {
    public static void main(String[] args) throws InterruptedException, IOException, NotFoundException {

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sproutqr.com/blog/qr-code-test");

        WebElement  element = driver.findElement(By.xpath("//*[@alt=\"QR code sample for testing: a qr code test image \"]"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].scrollIntoView(true)", element);

        String QRCode = driver.findElement(By.xpath("//*[@alt=\"QR code sample for testing: a qr code test image \"]")).getAttribute("src");

        System.out.println(QRCode);

        URL url = new URL(QRCode);

        BufferedImage bufferedImage = ImageIO.read(url);

        LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
        HybridBinarizer hybridBinarizer = new HybridBinarizer(luminanceSource);
        BinaryBitmap binaryBitmap = new BinaryBitmap(hybridBinarizer);
        Result result = new MultiFormatReader().decode(binaryBitmap);

        String text = result.getText();

        System.out.println(text);

        Thread.sleep(3000);

        driver.quit();

    }
}
