package TestCases;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class DataDrivenTestingUsingSQL {
    public static void main(String[] args) throws SQLException, InterruptedException, IOException {

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mypractice","root", "root");

        Statement st = con.createStatement();

        String s = "SELECT * FROM mypractice.orangehrm;";

        ResultSet rs = st.executeQuery(s);

        FileOutputStream file = new FileOutputStream("C:\\Users\\HimanshiRajput\\Desktop\\Automation Testing\\DatabaseDataDrivenTesting//LoginCredential.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Credential");

        int i = 0 ;

        while ( rs.next())
        {
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            Thread.sleep(3000);

            String UN = rs.getString("UserName");

            driver.findElement(By.name("username")).sendKeys(UN);

            String PWD = rs.getString("PassWord");

            driver.findElement(By.name("password")).sendKeys(PWD);

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

            XSSFRow row = sheet.createRow(i);

            int j = 0;

            row.createCell(j).setCellValue(UN);
            row.createCell(j+1).setCellValue(PWD);

            i= i+1;

        }

        workbook.write(file);
        file.close();

        driver.quit();


    }
}
