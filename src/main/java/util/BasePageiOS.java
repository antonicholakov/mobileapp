package util;

import io.appium.java_client.AppiumDriver;

public class BasePageiOS {
    protected AppiumDriver driver;

    public BasePageiOS (AppiumDriver driver) {
        this.driver = driver;
    }
}
