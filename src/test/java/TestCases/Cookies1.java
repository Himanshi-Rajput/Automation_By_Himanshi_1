package TestCases;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Set;

public class Cookies1 {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");

        Set<Cookie> diff_coo = driver.manage().getCookies();

        int cookies_size = diff_coo.size();

        System.out.println("Total num of cookies are: "+ cookies_size);

        for (Cookie cook : diff_coo)
        {
            System.out.println("The Name of Cookie is: "+cook.getName()+"  And the value of the cookie is: "+cook.getValue());
        }

        System.out.println("The value of the cookie -"+ driver.manage().getCookieNamed("session-id-time"));

        //Adding cookies

        Cookie coo_obj = new Cookie("Mine_Special_Cookie","Himanshi");

        driver.manage().addCookie(coo_obj);

        diff_coo = driver.manage().getCookies();
        cookies_size = diff_coo.size();

        System.out.println("The new cookies count is: "+cookies_size);

        for (Cookie cook : diff_coo)
        {
            System.out.println("The name of cookie is: "+cook.getName()+" The Value of cookie is: "+cook.getValue());
        }

        driver.manage().deleteCookie(coo_obj);

        driver.manage().deleteCookieNamed("session-id-time");

        diff_coo = driver.manage().getCookies();
        cookies_size = diff_coo.size();

        System.out.println("After deleting 2 cookies the new size is"+cookies_size);

        for (Cookie cook: diff_coo)
        {
            System.out.println("The name of cookie is: "+ cook.getName()+" The value of the cookie is: "+cook.getValue());
        }

        driver.manage().deleteAllCookies();

        diff_coo = driver.manage().getCookies();
        cookies_size = diff_coo.size();

        System.out.println("After deleting all cookies the new count is: "+cookies_size);

        driver.quit();

    }

}
