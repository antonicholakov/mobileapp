package core;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTestAndroid {

    protected App app;
    private AppiumDriver driver;


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
            driver = new AppiumDriver(new URL("http://127.0.0.1:4723"), options);

            // Add a wait for the app to load
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25)); // Adjust the wait time as needed
            wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Login to Continue")));

            // Initialize app with the driver
            app = new App(driver);
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
