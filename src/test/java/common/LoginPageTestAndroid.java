package common;

import core.AndroidFailureScreenshotExtension;
import core.BaseTestAndroid;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(AndroidFailureScreenshotExtension.class)

public class LoginPageTestAndroid extends BaseTestAndroid {
    @Test
    @Tag("login")
    @Tag("android")
    @DisplayName("Can perform login and logout")
    public void testLogin() {
        app.loginPage_android().enterCompany("Pragmatic DOM");
        app.loginPage_android().enterEmail("anthonycholakov@icloud.com");
        app.loginPage_android().enterPassword("Test05!!!");
        app.loginPage_android().clickLoginToContinue();
        app.loginPage_android().clickLogin();
        //assert navigation to home screen
        Assertions.assertTrue(app.loginPage_android().clickHomeIconAndVerifyHomeScreen());
        //assert navigation to person screen
        Assertions.assertTrue(app.loginPage_android().clickPersonIconAndVerifyPersonScreen());
        app.loginPage_android().clickLogout();
        //asserting that logging out the login screen is visible with 'Login to Continue' message
        Assertions.assertTrue( app.loginPage_android().verifyLoginScreenMessage());
    }

    @Test
    @Tag("login")
    @Tag("android")
    @DisplayName("Can go to Forgot Password page and navigate back to Login screen")
    public void navigateFromForgotPasswordToLoginScreen() {
        app.loginPage_android().clickForgotYourPassword();
        //assert navigation to Forgot Your Password Screen
        Assertions.assertTrue(app.loginPage_android().verifyForgotYourPasswordScreen());
        app.loginPage_android().clickBackButtonAtForgotYourPasswordScreen();
        //assert navigation back to the Login Screen
        Assertions.assertTrue( app.loginPage_android().verifyLoginScreenMessage());
    }

    @Test
    @Tag("login")
    @Tag("android")
    @DisplayName("Can't login with blank credentials")
    public void cantLoginWithBlankCredentials() {
        app.loginPage_android().clickLogin();
        //assert that Error popup & Message are present at the Login Screen
        Assertions.assertTrue(app.loginPage_android().verifyInvalidCredentialsErrorMessage());
        app.loginPage_android().clickErrorMessageCloseButton();
        //assert that you are still at Login screen
        Assertions.assertTrue( app.loginPage_android().verifyLoginScreenMessage());
    }
}