package pages.iOS;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import util.BasePageiOS;

public class LoginPage_iOS extends BasePageiOS {

        // The driver instance for the app
        public LoginPage_iOS(AppiumDriver driver) {
                super(driver);
                PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        }

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


        // The method that enters the Company
        public void enterCompany(String companyValue) {
                company.sendKeys(companyValue);
        }

        // The method that enters the Email
        public void enterEmail(String emailValue) {
                email.sendKeys(emailValue);
        }

        // The method that enters the password
        public void enterPassword(String passwordValue) {
                password.sendKeys(passwordValue);
        }

        // The method that clicks the login button
        public void clickLogin() throws InterruptedException {
                Thread.sleep(2000);
                login.click();
        }

        public void clickHomeIcon() throws InterruptedException {
                Thread.sleep(5000);
                homeIcon.click();
        }

        public boolean verifyHomeScreen() throws InterruptedException {
                Thread.sleep(5000);
                home.isDisplayed();
                return true;
        }

        public void clickPersonIcon() throws InterruptedException {
                Thread.sleep(5000);
                personIcon.click();
        }

        public boolean verifyPersonScreen() throws InterruptedException {
                Thread.sleep(5000);
                logout.isDisplayed();
                return true;
        }

        public void clickLogout() throws InterruptedException {
                Thread.sleep(5000);
                logout.click();
        }

        public boolean verifyLoginScreen() throws InterruptedException {
                Thread.sleep(5000);
                loginToContinue.isDisplayed();
                return true;
        }
}