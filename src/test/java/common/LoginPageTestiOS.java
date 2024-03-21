package common;

import core.BaseTestiOS;
import core.IOSFailureScreenshotExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(IOSFailureScreenshotExtension.class)

public class LoginPageTestiOS extends BaseTestiOS {
    @Test
    @Tag("login")
    @Tag("ios")
    @DisplayName("Can perform login and logout")
    public void testLogin() {
        app.loginPage_iOS().enterCompany("Pragmatic DOM");
        app.loginPage_iOS().enterEmail("anthonycholakov@icloud.com");
        app.loginPage_iOS().enterPassword("Test05!!!");
        app.loginPage_iOS().clickLogin();
        app.loginPage_iOS().clickPersonIcon();
        //assert navigation to person screen
        Assertions.assertTrue(app.loginPage_iOS().verifyPersonScreen());
        app.loginPage_iOS().clickLogout();
        //asserting that logging out the login screen is visible with 'Login to Continue' message
        Assertions.assertEquals("Login to Continue", app.loginPage_iOS().verifyLoginScreen());
    }

    @Test
    @Tag("login")
    @Tag("ios")
    @DisplayName("Can go to Forgot Password page and navigate back to Login screen")
    public void navigateFromForgotPasswordToLoginScreen() {
        app.loginPage_iOS().clickForgotYourPassword();
        //asserting that when clicking 'Forgot your password?' from Login Screen is navigating you to the Forgot Password Screen
        Assertions.assertEquals("Forgot your password", app.loginPage_iOS().verifyForgotYourPasswordScreen());
        app.loginPage_iOS().clickBackButtonAtForgotYourPasswordScreen();
        //asserting that when clicking < button is navigating you back to the Login Screen and 'Login to Continue' message is visible
        Assertions.assertEquals("Login to Continue", app.loginPage_iOS().verifyLoginScreen());
    }

    @Test
    @Tag("login")
    @Tag("ios")
    @DisplayName("Can't login with blank credentials")
    public void cantLoginWithBlankCredentials() {
        app.loginPage_iOS().clickLogin();
        //assert that Error popup & Message are present at the Login Screen
        Assertions.assertEquals("Error", app.loginPage_iOS().verifyError());
        Assertions.assertEquals("Invalid Login Credentials", app.loginPage_iOS().verifyErrorMessageForInvalidCredentials());
        app.loginPage_iOS().clickErrorMessageCloseButton();
        //assert that you are still at Login screen
        Assertions.assertEquals("Login to Continue", app.loginPage_iOS().verifyLoginScreen());
    }
}