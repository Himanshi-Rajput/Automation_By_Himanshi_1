package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;

public class HashMapCode {

    static HashMap <Integer, String> LoginInfo()
    {
        HashMap<Integer , String> hs = new HashMap<Integer, String>();
        hs.put(1,"Admin@admin123");
        hs.put(2,"Admin@admin123");
        hs.put(3,"Admin@admin123");
        return hs;
    }
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Thread.sleep(3000);

        int i=1, size = LoginInfo().size();
        System.out.println("size of Hashmap is: "+size);

        while (LoginInfo().containsKey(i))
        {
            String Data = LoginInfo().get(i);
            String data[] = Data.split("@");
            driver.findElement(By.name("username")).sendKeys(data[0]);
            driver.findElement(By.name("password")).sendKeys(data[1]);
            driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();

            Thread.sleep(3000);
            String title = driver.getTitle();

            if (title.equals("OrangeHRM"))
            {
                System.out.println("Test Case is Passed.");
            }
            else
            {
                System.out.println("TestCase is failed");
            }

            driver.findElement(By.xpath("//*[@class=\"oxd-icon bi-caret-down-fill oxd-userdropdown-icon\"]")).click();

            Thread.sleep(2000);

            driver.findElement(By.linkText("Logout")).click();

            Thread.sleep(5000);

            i++;
        }

        System.out.println("Code run successfully..");

        driver.quit();

    }
}
