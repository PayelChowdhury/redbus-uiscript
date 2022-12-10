package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class DriverManager {
private static WebDriver driver;
static BaseUtility baseUtility;

    static {
        try {
            baseUtility = new BaseUtility();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Step("create driver")
    private static WebDriver createDriver() throws IOException {
    String browserName = baseUtility.getBrowserName();
    if(browserName.equalsIgnoreCase("chrome")){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    return driver;
}
    @Step("get driver")
   public static WebDriver getDriver() throws IOException {
    driver= createDriver();
    return driver;
   }
    @Step("close driver")
   public void closeBrowser(){
        driver.close();
        driver.quit();
   }

}
