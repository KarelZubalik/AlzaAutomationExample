package tests;

import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import utils.ScreenshotUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public  class TestsClass {
    WebDriver driver;

    @BeforeClass
    protected void  beforeClass(){

    }
    @AfterClass
    protected void afterClass(){
        driver.close();
        driver.quit();
    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            saveScreenshotOnFailure(driver);
        }
    }

    @Attachment(value = "Screenshot on Failure", type = "image/png")
    public byte[] saveScreenshotOnFailure(WebDriver driver) {
        String screenshotPath = ScreenshotUtil.takeScreenshot(driver);
        File screenshot = new File(screenshotPath);
        byte[] screenshotBytes = new byte[0];
        try {
            screenshotBytes = Files.readAllBytes(screenshot.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotBytes;
    }
}
