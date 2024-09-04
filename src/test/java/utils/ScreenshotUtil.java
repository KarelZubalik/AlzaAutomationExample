package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class ScreenshotUtil {
    public static String takeScreenshot(WebDriver driver) {
        // Pořízení screenshotu
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Název souboru
        String screenshotName = "screenshot-" + UUID.randomUUID().toString() + ".png";
        // Cesta, kam se uloží screenshot
        File destFile = new File(System.getProperty("user.dir") + "/target/allure-results/" + screenshotName);

        try {
            FileHandler.copy(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return destFile.getAbsolutePath();
    }
}
