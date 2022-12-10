package StepDefinitions;

import Listeners.TestListeners;
import PageObjects.HomePage;
import Utils.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
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

    public HomePageSteps() throws IOException {
      driver =DriverManager.getDriver();
      homePage = new HomePage(driver);
    }
    @Test(description = "homepage of applicatio")
    @Description("homepage of application")
    @Given("user in the homepage")
    public void userInTheHomepage() {
        homePage.launchApplication();
    }

    @Test(description = "user clicks on the hotel menu")
    @Description("user clicks on the hotel menu")
    @And("user clicks on the hotel menu")
    public void userClicksOnTheHotelMenu() throws InterruptedException {
      homePage.clickOnMenu();
    }

    @Test(description = "user enter the city or location")
    @Description("user enter the city or location")
    @When("user enter the city or location")
    public void userEnterTheCityOrLocation() throws InterruptedException, IOException {
        homePage.enterCity();
    }

//    @And("user enter checkin and checkout date")
//    public void userEnterCheckinAndCheckoutDate() {
//
//    }
//    @And("user enter room and guest details")
//    public void userEnterRoomAndGuestDetails() {
//    }
//    @And("user select the price range and click on the search button")
//    public void userSelectThePriceRangeAndClickOnTheSearchButton() {
//    }
//    @And("user sort the result")
//    public void userSortTheResult() {
//    }
//
//    @Then("user click on hotel and click book the hotel")
//    public void userClickOnHotelAndClickBookTheHotel() {
//    }
}
