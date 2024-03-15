package core;

import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class IOSFailureScreenshotExtension implements TestWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(IOSFailureScreenshotExtension.class);

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        takeScreenshot(context);
    }

    private void takeScreenshot(ExtensionContext context) {
        Optional<Object> testInstance = context.getTestInstance();
        if (testInstance.isPresent() && testInstance.get() instanceof BaseTestiOS) {
            BaseTestiOS test = (BaseTestiOS) testInstance.get();
            AppiumDriver driver = test.getDriver();
            if (driver != null) {
                try {
                    File localScreenshots = new File(new File("target"), "screenshots");
                    if (!localScreenshots.exists() || !localScreenshots.isDirectory()) {
                        localScreenshots.mkdirs();
                    }
                    LocalDateTime now = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH.mm.ss");
                    String timestamp = now.format(formatter);
                    File screenshot = new File(localScreenshots, test.getClass().getSimpleName() + "_" + context.getTestMethod().get().getName() + "_" + timestamp + ".png");
                    Files.copy(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE).toPath(), Paths.get(screenshot.getAbsolutePath()));
                    LOGGER.info("Screenshot for class={} method={} saved in: {}", test.getClass().getSimpleName(), context.getTestMethod().get().getName(), screenshot.getAbsolutePath());
                } catch (IOException e) {
                    LOGGER.error("Unable to take screenshot", e);
                }
            } else {
                LOGGER.error("Driver does not support taking screenshots");
            }
        }
    }
}
