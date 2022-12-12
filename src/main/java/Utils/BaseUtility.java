package Utils;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.sql.DriverManager;
import java.time.Duration;
import java.util.Map;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.yaml.snakeyaml.Yaml;

public class BaseUtility {
    static Properties properties ;
    WebDriver driver;
    JSONParser jsonParser;
    static Map<?,?> property;
    private static Connection con;

public BaseUtility() throws IOException {
    try{
    FileInputStream read = new FileInputStream("properties/config.properties");
    properties = new Properties();
    properties.load(read);
     }catch (IOException e) {
        e.printStackTrace();
    }
}
    public String readJsonObject(String string) throws IOException{
        try{
            jsonParser = new JSONParser();
            FileReader reader = new FileReader("properties/data.json");
            Object obj = jsonParser.parse(reader);
            JSONObject jsonObject =(JSONObject) obj;
            String String = (String) jsonObject.get(string);
            System.out.println("String "+String);
            return String;
        }catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    public String readYamlObject(String string) throws IOException {
      FileReader reader = new FileReader("properties/data.yaml");
      Yaml yml = new Yaml();
      property = yml.load(reader);
      String String = (String) property.get(string);
      return String;
    }
    public String getBrowserName() throws IOException {
        String browserName=properties.getProperty("browser");
        return browserName;
    }
    public String invokeUrl() {
        String url = properties.getProperty("url");
        return url;
    }
 public Duration duration(){
     Duration duration = Duration.ofSeconds(Long.parseLong(properties.getProperty("duration")));
     return duration;
 }
    public static WebElement Wait(WebDriver driver, By by, Duration duration){
        WebDriverWait webDriverWait = new WebDriverWait(driver, duration);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElement(by);
    }
    public void clickJavaScript(WebDriver driver, WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }
    public static Connection loadAndConnectDatabase() throws ClassNotFoundException, SQLException {

        final String driver = properties.getProperty("driver");
        final String HOST = properties.getProperty("host");
        final String DB_NAME = properties.getProperty("dbname");
        final String USER = properties.getProperty("user");
        final String PASSWORD = properties.getProperty("password");
        final String PORT = properties.getProperty("port");


        //load driver to establish database connection
        Class.forName(driver);
        // Create the connection object and connect to the DB
        con = DriverManager
                .getConnection(
                        "jdbc:postgresql://"+HOST+":"+PORT+"/"+DB_NAME+"",
                        USER,
                        PASSWORD
                );
        System.out.println("connect to the database successfully");
        return con;
    }
    /**
     * get a result of query
     */
    public static ResultSet getResultSet(String query) throws SQLException, ClassNotFoundException {
        Connection con = loadAndConnectDatabase();
        ResultSet rs;
        PreparedStatement st = con.prepareStatement(query);
        rs = st.executeQuery();
        return rs;
    }

}
