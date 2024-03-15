package core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTestiOS {

    protected App app;
    private AppiumDriver driver;
    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseTestiOS.class);
    protected WebDriverWait wait;

    public AppiumDriver getDriver() {
        return this.driver;
    }

    @BeforeAll
    public void setup() throws MalformedURLException {
        if (driver == null) {

            //capabilities

            XCUITestOptions options = new XCUITestOptions();
            options.setDeviceName("iPhone 15")
                    .setPlatformVersion("17.0")
                    .setBundleId("com.easysecure")
                    .setNoReset(true);

            // Initialize driver
            driver = new AppiumDriver(new URL("http://127.0.0.1:4723"), options);

            // Add an implicit wait
            wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Adjust the wait time as needed

            // Initialize app with the driver
            app = new App(driver, wait);
        }
    }


    @AfterAll
    public void tearDown() {
        // Quit driver
        if (driver != null) {
            driver.quit();
        }
    }
}
