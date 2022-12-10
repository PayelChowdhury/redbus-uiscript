package Listeners;


import Utils.BaseUtility;
import Utils.DriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

import java.io.IOException;

public class TestListeners implements ITestListener {

    public void onTestSuccess(ITestResult result) {
        System.out.println("Pass");
    }

    public void onStart(ITestContext context) {
        System.out.println("Execution starts");
    }

    public void onFinish(ITestContext context) {
        System.out.println("Execution ends");
    }

    @Attachment(value = "Screenshot of {0}", type = "image/png")
    public byte[] saveScreenshot(String name, WebDriver driver) {
        return (byte[]) ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            saveScreenshot(result.getName(), DriverManager.getDriver());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}