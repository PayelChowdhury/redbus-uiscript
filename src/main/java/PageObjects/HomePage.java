package PageObjects;

import Utils.BaseUtility;
import Utils.DriverManager;
import io.qameta.allure.Step;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class HomePage {
   WebDriver driver;
   BaseUtility baseUtility ;
   Duration duration;
   JavascriptExecutor executor;

    private static final String TOP_MENU = "//li[@class='menu_Hotels']/div";
    private static final String CITY = "//label//input[@id='cit']";
    private static final String CITY_NAME= "//div[@role='listbox']//div[1]//ul[@role='listbox']//li[1]";

    public HomePage(WebDriver driver) throws IOException {
        this.driver = driver;
        baseUtility = new BaseUtility();
        duration = baseUtility.duration();
        executor = (JavascriptExecutor)driver;
    }
    @Step("Launch the application")
    public void launchApplication(){
        driver.get(baseUtility.invokeUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(duration);
    }
    @Step("Click on menu hotel")
    public void clickOnMenu() throws InterruptedException {
        WebElement element = baseUtility.Wait(driver, By.xpath(TOP_MENU), duration);
        baseUtility.clickJavaScript(driver, element);
    }
    @Step("Enter city")
    public void enterCity() throws InterruptedException, IOException {
        WebElement elementCity = baseUtility.Wait(driver, By.xpath(CITY),duration);
        baseUtility.clickJavaScript(driver,elementCity);
        String string = baseUtility.readYamlObject("city");
        System.out.println(string);
        elementCity.sendKeys(string);
//        Thread.sleep(10000);
        WebElement element = baseUtility.Wait(driver, By.xpath(CITY_NAME), duration);
        baseUtility.clickJavaScript(driver, element);
    }

}