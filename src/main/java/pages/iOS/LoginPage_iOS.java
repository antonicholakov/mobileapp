package pages.iOS;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.BasePageiOS;

public class LoginPage_iOS extends BasePageiOS {
        private WebDriverWait wait;


        // The driver instance for the app
        public LoginPage_iOS(AppiumDriver driver, WebDriverWait wait) {
                super(driver);
                this.wait = wait;
                PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        }

        private static final Logger LOGGER = LoggerFactory.getLogger(LoginPage_iOS.class);
        @iOSXCUITFindBy(accessibility = "Company")
        private WebElement company;
        @iOSXCUITFindBy(accessibility = "Email Address")
        private WebElement email;
        @iOSXCUITFindBy(accessibility = "Password")
        private WebElement password;
        @iOSXCUITFindBy(accessibility = "Login")
        private WebElement login;
        @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name='EasySecure']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeButton[1]")
        private WebElement homeIcon;
        @iOSXCUITFindBy(accessibility = "Home")
        private WebElement home;
        @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name='EasySecure']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeButton[2]")
        private WebElement personIcon;
        @iOSXCUITFindBy(accessibility = "Log out")
        private WebElement logout;
        @iOSXCUITFindBy(accessibility = "Login to Continue")
        private WebElement loginToContinue;
        @iOSXCUITFindBy(accessibility = "Forgot your password?")
        private WebElement forgotYourPassword;
        @iOSXCUITFindBy(accessibility = "Forgot your password")
        private WebElement forgotYourPasswordMessage;
        @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"EasySecure\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeImage[1]")
        private WebElement backButtonToLoginScreen;
        @iOSXCUITFindBy(accessibility = "Error")
        private WebElement error;
        @iOSXCUITFindBy(accessibility = "Invalid Login Credentials")
        private WebElement invalidLoginCredentials;
        @iOSXCUITFindBy(accessibility = "Close")
        private WebElement errorMessageCloseButton;


        public void enterCompany(String companyValue) {
                LOGGER.info("Entering Company: " + companyValue);
                company.sendKeys(companyValue);
        }

        public void enterEmail(String emailValue) {
                LOGGER.info("Entering Email address: " + emailValue);
                email.sendKeys(emailValue);
        }

        public void enterPassword(String passwordValue) {
                LOGGER.info("Entering password: " + "*******");
                password.sendKeys(passwordValue);
        }

        public void clickLogin() {
                LOGGER.info("Pressing Login button");
                login.click();
        }

        public void clickHomeIcon() {
                LOGGER.info("Pressing Home icon");
                wait.until(ExpectedConditions.visibilityOf(homeIcon)).click();
        }

        public String verifyHomeScreen() {
                wait.until(ExpectedConditions.visibilityOf(home));
                return home.getText();
        }

        public void clickPersonIcon() {
                LOGGER.info("Pressing Person icon");
                wait.until(ExpectedConditions.visibilityOf(personIcon)).click();
        }

        public boolean verifyPersonScreen() {
                logout.isDisplayed();
                return true;
        }

        public void clickLogout() {
                LOGGER.info("Pressing Log out button");
                logout.click();
        }

        public String verifyLoginScreen() {
                wait.until(ExpectedConditions.visibilityOf(loginToContinue));
                return loginToContinue.getText();
        }

        public void clickForgotYourPassword() {
                LOGGER.info("Pressing Forgot your Password? at the Login Screen");
                forgotYourPassword.click();
        }

        public String verifyForgotYourPasswordScreen() {
                wait.until(ExpectedConditions.visibilityOf(forgotYourPasswordMessage));
                return forgotYourPasswordMessage.getText();
        }

        public void clickBackButtonAtForgotYourPasswordScreen() {
                LOGGER.info("Pressing Back button at the Forgot Your Password Screen");
                backButtonToLoginScreen.click();
        }
        public String verifyError() {
                wait.until(ExpectedConditions.visibilityOf(error));
                return error.getText();
        }

        public String verifyErrorMessageForInvalidCredentials() {
                wait.until(ExpectedConditions.visibilityOf(invalidLoginCredentials));
                return invalidLoginCredentials.getText();
        }

        public void clickErrorMessageCloseButton() {
                LOGGER.info("Pressing Close button from the Error popup message");
                errorMessageCloseButton.click();
        }
}