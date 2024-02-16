package pages.Android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import util.BasePageAndroid;


public class LoginPage_Android extends BasePageAndroid {

    // The driver instance for the app
    public LoginPage_Android(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /**
     * Android
     */

    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Company']")
    private WebElement company;

    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Email Address']")
    private WebElement email;

    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Password']")
    private WebElement password;

    @AndroidFindBy(accessibility = "Login")
    private WebElement login;

    @AndroidFindBy(accessibility = "Login to Continue")
    private WebElement loginToContinue;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]")
    private WebElement homeIcon;

    @AndroidFindBy(accessibility = "Home")
    private WebElement home;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]")
    private WebElement personIcon;

    @AndroidFindBy(accessibility = "Log out")
    private WebElement logout;


    public void enterCompany(String companyValue) {
        company.click();
        company.sendKeys(companyValue);
    }

    // The method that enters the Email
    public void enterEmail(String emailValue) {
        email.click();
        email.sendKeys(emailValue);
    }

    // The method that enters the password
    public void enterPassword(String passwordValue) {
        password.click();
        password.sendKeys(passwordValue);
    }

    // The method that clicks the login button
    public void clickLogin() {
        login.click();
    }

    public void clickLoginToContinue() throws InterruptedException {
        loginToContinue.click();
        Thread.sleep(2000);
    }

    public boolean clickHomeIconAndVerifyHomeScreen() throws InterruptedException {
        Thread.sleep(5000);
        homeIcon.click();
        Thread.sleep(5000);
        return home.isDisplayed();
    }

    public boolean clickPersonIconAndVerifyPersonScreen() throws InterruptedException {
        Thread.sleep(5000);
        personIcon.click();
        Thread.sleep(2000);
        return logout.isDisplayed();
    }

    public void clickLogout() {
        logout.click();
    }

    public boolean verifyLoginScreenMessage() throws InterruptedException {
        Thread.sleep(5000);
        return loginToContinue.isDisplayed();
    }
}
