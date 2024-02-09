package TestCases;

import org.testng.annotations.Test;
import org.testng.xml.dom.Tag;

public class BTFile1 {

    @Test (priority = 0)
    void loginbyFB()
    {
        System.out.println("This is the Facebook Login Method");
    }

    @Test (priority = 2)
    void loginbyTW()
    {
        System.out.println("This is the Twitter Login method");
    }

    @Test(priority = 1)
    void LoginbyEM()
    {
        System.out.println("This is the email login method");
    }
}
