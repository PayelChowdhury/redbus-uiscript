package StepDefinitions;

import PageObjects.HomePage;
import PageObjects.SearchPage;
import Utils.DriverManager;
import io.cucumber.java.en.And;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import org.testng.annotations.Listeners;

@Epic("Web Application Regression Testing")
@Feature("Search Page Tests")
public class SearchPageSteps {

    WebDriver driver;
    SearchPage searchPage ;

    public SearchPageSteps() throws IOException {
        driver = DriverManager.getDriver();
        searchPage = new SearchPage(driver);
    }

    @Test(description = "user click on the sort dropdown and select sort filter")
    @Description("user click on the sort dropdown and select sort filter")
    @And("user sort the result")
    public void userSortTheResult() {
        searchPage.sortTheSearchResult();
    }
}
