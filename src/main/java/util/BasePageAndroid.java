package util;

import io.appium.java_client.AppiumDriver;

public class BasePageAndroid {
    protected AppiumDriver driver;

    public BasePageAndroid (AppiumDriver driver) {
        this.driver = driver;
    }
}
