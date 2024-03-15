package core;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Android.LoginPage_Android;
import pages.iOS.LoginPage_iOS;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class App {
    private final AppiumDriver driver;
    private final WebDriverWait wait;
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public App(AppiumDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    private LoginPage_Android loginPage_android;
    private LoginPage_iOS loginPage_iOS;

    public LoginPage_Android loginPage_android() {
        if (loginPage_android == null) {
            loginPage_android = new LoginPage_Android(driver, wait);
        }
        return loginPage_android;
    }

    public LoginPage_iOS loginPage_iOS() {
        if (loginPage_iOS == null) {
            loginPage_iOS = new LoginPage_iOS(driver, wait);
        }
        return loginPage_iOS;
    }

    public void screenshot(String path_screenshot) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String filename = UUID.randomUUID().toString();
        File targetFile = new File(path_screenshot + filename + ".jpg");
        FileUtils.copyFile(srcFile, targetFile);
    }
}
