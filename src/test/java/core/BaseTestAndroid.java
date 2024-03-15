package core;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTestAndroid {

    protected App app;
    private AppiumDriver driver;
    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseTestAndroid.class);

    public AppiumDriver getDriver() {
        return this.driver;
    }


    @BeforeAll
    public void setup() throws MalformedURLException {
        if (driver == null) {

            //capabilities

            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName("emulator-5554")
                    .setAppPackage("com.easysecure")
                    .setAppActivity("com.easysecure.MainActivity")
                    .setNoReset(true);

            // Initialize driver
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            // Add a wait for the app to load
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25)); // Adjust the wait time as needed
            wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Login to Continue")));

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
