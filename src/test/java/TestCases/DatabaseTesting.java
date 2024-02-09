package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.*;

public class DatabaseTesting {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        //create Connection
        //Create statement query
        //execute statement
        //closed connection

        //WebDriver driver = new ChromeDriver();
        //Class.forName("com.mysql.jdbc.Driver"); ---it will work automatically
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mypractice","root", "root");

        Statement st = con.createStatement();

        //String query = "insert into mypractice.persons values (65 , \"Rajput\" , \"Himanshi\" , \"RajNagar\", \"Indore\")";
        //String query = "CREATE TABLE employees_information (first_name VARCHAR(50) , position VARCHAR(50))";
        //String query  = "UPDATE  persons set LastName='Rajput' where LastName='Soni' AND PersonID='65'";
        //String query = "DELETE FROM persons WHERE PersonID=64";
        //st.executeUpdate(query);

        String query = "Select FirstName,LastName from mypractice.persons";

        ResultSet rs = st.executeQuery(query);

        while (rs.next())
        {
            String FN = rs.getString("FirstName");
            String LN = rs.getString("LastName");

            System.out.println(FN +" "+ LN);
        }

        con.close();

        System.out.println("Code Compiled successfully");


    }
}
