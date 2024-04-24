package core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

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

            XCUITestOptions options = new XCUITestOptions();
            options.setDeviceName("iPhone 15")
                    .setPlatformVersion("17.0")
                    .setCommandTimeouts(Duration.ofSeconds(240))
                    .setWdaLaunchTimeout(Duration.ofSeconds(240))
                    .setBundleId("com.easysecure")
                    .setNoReset(true);
            try {
                driver = new IOSDriver(new URL("http://localhost:4723"), options);
            } catch (NoSuchSessionException e) {
                options.useNewWDA();
                driver = new IOSDriver(new URL("http://localhost:4723"), options);
            }

            // Add an implicit wait
            wait = new WebDriverWait(driver, Duration.ofSeconds(24)); // Adjust the wait time as needed

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
