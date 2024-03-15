package util;

import io.appium.java_client.AppiumDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePageAndroid {
    protected AppiumDriver driver;

    public BasePageAndroid (AppiumDriver driver) {
        this.driver = driver;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(BasePageAndroid.class);
}
