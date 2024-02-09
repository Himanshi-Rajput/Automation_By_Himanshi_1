package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class RemoteTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp() throws IOException {

//        String hubCommand = "java -jar selenium-server-standalone-3.141.59.jar -role hub";
//        Runtime.getRuntime().exec(hubCommand);
//        String nodeCommand = "java -jar selenium-server-standalone-3.141.59.jar -role node -hub http://localhost:4444/grid/register";
//        Runtime.getRuntime().exec(nodeCommand);
        // Set the desired capabilities for the remote WebDriver
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.WIN11);
        capabilities.setBrowserName("MicrosoftEdge");// Set the platform of the remote machine


        // Provide the URL of the Selenium Grid hub
        URL gridUrl = new URL("http://localhost:4444/wd/hub");

        // Create the RemoteWebDriver instance
        driver = new RemoteWebDriver(gridUrl, capabilities);
    }

    @Test
    public void testRemoteExecution() throws InterruptedException {
        // Your test case logic goes here
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(3000);

    }

    @AfterTest
    public void tearDown() {
        // Close the WebDriver session
        if (driver != null) {
            driver.quit();
        }
    }
}

