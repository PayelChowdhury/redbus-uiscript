package StepDefinitions;


import Utils.BaseUtility;
import Utils.DataService;
import Utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Hook {
    DriverManager driverManager = new DriverManager();
    String username ;
    Properties properties;
    WebDriver driver;

    public Hook() throws IOException {
        FileInputStream read = new FileInputStream("properties/config.properties");
        properties = new Properties();
        properties.load(read);
    }

    @Before
    public void beforeScenario(){
        System.out.println("The execution Start Now");
    }

    @After(order = 1)
    public void executeDbQuery() throws SQLException, ClassNotFoundException {
        username = properties.getProperty("username");
        String query = "select * from suite.users where name = '"+username+"' ";
        ResultSet rs = BaseUtility.getResultSet(query);
        rs.next();
        int userId=rs.getInt("id");
        String name =rs.getString("name");
        System.out.println("username-" +name+ " and id-" +userId);
    }

    @After(order =0)
    public void afterSteps(Scenario sc) throws IOException {
        if(sc.isFailed()){
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES)));
        }
        driverManager.closeBrowser();
        System.out.println("The execution End");
    }

}
