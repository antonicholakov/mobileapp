package core;

import io.appium.java_client.AppiumDriver;
import pages.Android.LoginPage_Android;
import pages.iOS.LoginPage_iOS;

public class App {
    private final AppiumDriver driver;

    public App(AppiumDriver driver) {
        this.driver = driver;
    }

    private LoginPage_Android loginPage_android;
    private LoginPage_iOS loginPage_iOS;

    public LoginPage_Android loginPage_android() {
        if (loginPage_android == null) {
            loginPage_android = new LoginPage_Android(driver);
        }
        return loginPage_android;
    }

    public LoginPage_iOS loginPage_iOS() {
        if (loginPage_iOS == null) {
            loginPage_iOS = new LoginPage_iOS(driver);
        }
        return loginPage_iOS;
    }
}