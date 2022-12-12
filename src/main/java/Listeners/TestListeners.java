package Listeners;


import Utils.BaseUtility;
import Utils.DriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

import java.io.ByteArrayInputStream;
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


    @Override
    @Attachment(value = "Screenshot", type = "image/png")
    public void onTestFailure(ITestResult result) {
        try {
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}