package TestCases;

import org.testng.annotations.Test;

public class BTFile2 {

    @Test(priority = 0)
    void SignupbyFB()
    {
        System.out.println("This is the Facebook Signup Method");
    }

    @Test (priority = 1)
    void SignupbyTW()
    {
        System.out.println("This is the Twitter Signup method");
    }

    @Test(priority = 2)
    void SignupbyEM()
    {
        System.out.println("This is the email Signup method");
    }
}
