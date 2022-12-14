package PageObjects;

import Utils.BaseUtility;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.time.Duration;

public class SearchPage {

    WebDriver driver;
    BaseUtility baseUtility ;
    Duration duration;
    JavascriptExecutor executor;
    private static final String SORT_DROPDOWN = "//div[@class='customSelect']";
    private static final String SORT_VALUE ="//div[@class='customSelect']//ul//li[text()='Price - Low to High']";

    public SearchPage(WebDriver driver) throws IOException {
        this.driver = driver;
        baseUtility = new BaseUtility();
        duration = baseUtility.duration();
        executor = (JavascriptExecutor)driver;
    }

    /**
     * Sort the search result as price low to high
     */
    @Step("sort the search result as price low to high")
    public void sortTheSearchResult(){
        WebElement elementSortDropdown = baseUtility.wait(driver, By.xpath(SORT_DROPDOWN), duration);
        baseUtility.clickJavaScript(driver, elementSortDropdown);
        WebElement elementSortValue = baseUtility.wait(driver, By.xpath(SORT_VALUE), duration);
        baseUtility.clickJavaScript(driver, elementSortValue);
    }
}
