package pages.Android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.BasePageAndroid;


public class LoginPage_Android extends BasePageAndroid {
    private WebDriverWait wait;

    // The driver instance for the app
    public LoginPage_Android(AppiumDriver driver, WebDriverWait wait) {
        super(driver);
        this.wait = wait;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginPage_Android.class);

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

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]")
    private WebElement homeIcon;

    @AndroidFindBy(accessibility = "Home")
    private WebElement home;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]")
    private WebElement personIcon;

    @AndroidFindBy(accessibility = "Log out")
    private WebElement logout;

    @AndroidFindBy(accessibility = "Forgot your password?")
    private WebElement forgotYourPassword;

    @AndroidFindBy(accessibility = "Forgot your password")
    private WebElement forgotYourPasswordMessage;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[1]")
    private WebElement backButtonToLoginScreen;

    @AndroidFindBy(accessibility = "Error")
    private WebElement error;
    @AndroidFindBy(accessibility = "Invalid Login Credentials")
    private WebElement invalidLoginCredentials;

    @AndroidFindBy(accessibility = "Close")
    private WebElement errorMessageCloseButton;


    public void enterCompany(String companyValue) {
        loginToContinue.click();
        company.click();
        LOGGER.info("Entering Company: " + companyValue);
        company.sendKeys(companyValue);
    }

    public void enterEmail(String emailValue) {
        email.click();
        LOGGER.info("Entering Email address: " + emailValue);
        email.sendKeys(emailValue);
    }
    public void enterPassword(String passwordValue) {
        password.click();
        LOGGER.info("Entering password: " + "*******");
        password.sendKeys(passwordValue);
    }

    public void clickLogin() {
        LOGGER.info("Pressing Login button");
        login.click();
    }

    public void clickLoginToContinue() {
        LOGGER.info("Tapping on the info message 'Login to Continue' to hide keyboard");
        loginToContinue.click();
    }

    public boolean clickHomeIconAndVerifyHomeScreen() {
        LOGGER.info("Pressing Home icon");
        wait.until(ExpectedConditions.visibilityOf(homeIcon)).click();
        return home.isDisplayed();
    }

    public boolean clickPersonIconAndVerifyPersonScreen() {
        LOGGER.info("Pressing Person icon");
        wait.until(ExpectedConditions.visibilityOf(personIcon)).click();
        return logout.isDisplayed();
    }

    public void clickLogout() {
        LOGGER.info("Pressing Log out button");
        logout.click();
    }

    public boolean  verifyLoginScreenMessage() {
        return loginToContinue.isDisplayed();
    }

    public void clickForgotYourPassword() {
        LOGGER.info("Pressing Forgot your Password? at the Login Screen");
        forgotYourPassword.click();
    }

    public boolean verifyForgotYourPasswordScreen() {
        wait.until(ExpectedConditions.visibilityOf(forgotYourPasswordMessage));
        return forgotYourPasswordMessage.isDisplayed();
    }

    public void clickBackButtonAtForgotYourPasswordScreen() {
        LOGGER.info("Pressing Back button at the Forgot Your Password Screen");
        backButtonToLoginScreen.click();
    }

    public boolean verifyInvalidCredentialsErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(error));
        wait.until(ExpectedConditions.visibilityOf(invalidLoginCredentials));
        return error.isDisplayed() && invalidLoginCredentials.isDisplayed();
    }

    public void clickErrorMessageCloseButton() {
        LOGGER.info("Pressing Close button from the Error popup message");
        errorMessageCloseButton.click();
    }
}