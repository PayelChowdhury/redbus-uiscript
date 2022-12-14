package StepDefinitions;

import Listeners.TestListeners;
import PageObjects.HomePage;
import Utils.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;


@Epic("Web Application Regression Testing")
@Feature("Home Page Tests")
@Listeners(TestListeners.class)

public class HomePageSteps {
    WebDriver driver;
    HomePage homePage ;

    private static Logger log = LogManager.getLogger(HomePageSteps.class);

    public HomePageSteps() throws IOException {
      driver =DriverManager.getDriver();
      homePage = new HomePage(driver);
    }
    @Test(description = "homepage of applicatio")
    @Description("homepage of application")
    @Given("user in the homepage")
    public void userInTheHomepage() {
        homePage.launchApplication();
        log.info("Application launched");
    }

    @Test(description = "user clicks on the hotel menu")
    @Description("user clicks on the hotel menu")
    @And("user clicks on the hotel menu")
    public void userClicksOnTheHotelMenu() throws InterruptedException {
      homePage.clickOnMenu();
      log.info("Hotel menu is selected");
    }

    @Test(description = "user enter the city or location")
    @Description("user enter the city or location")
    @When("user enter the city or location")
    public void userEnterTheCityOrLocation() throws InterruptedException, IOException {
        homePage.enterCity();
        log.info("Enter the city");
    }

    @Test(description = "user enter checkin and checkout date")
    @Description("user enter checkin and checkout date")
    @And("user enter checkin and checkout date")
    public void userEnterCheckinAndCheckoutDate() {
    homePage.selectDate();
        log.info("Select the checkin and checkout date");
    }
    @Test(description = "user enter room and guest details")
    @Description("user enter room and guest details")
    @And("user enter room and guest details")
    public void userEnterRoomAndGuestDetails() throws IOException {
        homePage.enterGuests();
        log.info("Enter guest number details");
    }
    @Test(description = "user click on the search button")
    @Description("user click on the search button")
    @And("user click on the search button")
    public void userClickOnTheSearchButton() {
        homePage.clickOnSearchButton();
        log.info("Click on search button");
    }


}
