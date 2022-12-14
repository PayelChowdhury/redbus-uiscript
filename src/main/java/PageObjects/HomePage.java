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
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

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

    private static final String TOP_MENU = "//li[@class='menu_Hotels']//div//a";
    private static final String CITY = "//label//input[@id='city']";
    private static final String CITY_NAME = "//div[@role='listbox']//div[1]//ul[@role='listbox']//li[1]//p[text()='$value$']";
    private static final String CHECKIN_DATE = "//div[@class='DayPicker-Month'][2]//div[@class='DayPicker-Week'][3]//div[1]";
    private static final String CHECKOUT_DATE = "//div[@class='DayPicker-Month'][2]//div[@class='DayPicker-Week'][3]//div[2]";
    private static final String CLICK_PERSON_DROPDOWN = "//span[@data-testid='adult_count']";
    private static final String ENTER_PERSON = "//div[@class='gstSlctCont ']//ul//li[3]";
    private static final String APPLY_BUTTON = "//button[text()='Apply']";
    private static final String SEARCH_BUTTON = "//button[text()='Search']";

    public HomePage(WebDriver driver) throws IOException {
        this.driver = driver;
        baseUtility = new BaseUtility();
        duration = baseUtility.duration();
        executor = (JavascriptExecutor)driver;
    }
    /**
     * launch application
     */
    @Step("Launch the application")
    public void launchApplication(){
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        driver.get(baseUtility.invokeUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(duration);
        if((driver.getTitle()).contains("MakeMyTrip"));
        System.out.println("we are in homepage");
       }
    /**
     * click on the hotel menu
     */
    @Step("Click on menu hotel")
    public void clickOnMenu() throws InterruptedException {
        WebElement element = baseUtility.wait(driver, By.xpath(TOP_MENU), duration);
        baseUtility.clickJavaScript(driver, element);
        if(driver.findElement(By.xpath(TOP_MENU)).isEnabled())
            System.out.println("Hotel menu is selected");
    }
    /**
     * enter the city in text field
     */
    @Step("Enter city")
    public void enterCity() throws InterruptedException, IOException {
        WebElement elementCity = baseUtility.wait(driver, By.xpath(CITY),duration);
        baseUtility.clickJavaScript(driver,elementCity);
        String string = baseUtility.readYamlObject("city");
        elementCity.sendKeys(string);
        WebElement element = baseUtility.wait(driver, By.xpath(CITY_NAME.replace("$value$", baseUtility.readYamlObject("cityname"))) , duration);
        baseUtility.clickJavaScript(driver, element);
    }
    /**
     * enter check in and check out date
     */
    @Step("Enter check-in date and check-out date")
    public void selectDate(){
     WebElement elementCheckInDate = baseUtility.wait(driver, By.xpath(CHECKIN_DATE), duration);
     baseUtility.clickJavaScript(driver, elementCheckInDate);
     WebElement elementCheckOutDate = baseUtility.wait(driver, By.xpath(CHECKOUT_DATE), duration);
     baseUtility.clickJavaScript(driver, elementCheckOutDate);
    }
    /**
     * enter number of persons
     */
    @Step("Enter number of person details")
    public void enterGuests() throws IOException {
        WebElement elementDropdown = baseUtility.wait(driver, By.xpath(CLICK_PERSON_DROPDOWN), duration);
        baseUtility.clickJavaScript(driver, elementDropdown);
        WebElement elementNoOfPerson = baseUtility.wait(driver, By.xpath(ENTER_PERSON), duration);
        baseUtility.clickJavaScript(driver, elementNoOfPerson);
        WebElement elementApplyButton = baseUtility.wait(driver,By.xpath(APPLY_BUTTON), duration);
        baseUtility.clickJavaScript(driver, elementApplyButton);
    }
    /**
     * click on the search button
     */
    @Step("Click on the search button")
    public void clickOnSearchButton(){
        WebElement elementSearchButton = baseUtility.wait(driver, By.xpath(SEARCH_BUTTON), duration);
        baseUtility.clickJavaScript(driver, elementSearchButton);
    }


}