package common;

import core.BaseTestAndroid;
import org.junit.jupiter.api.Test;

public class LoginPageTestAndroid extends BaseTestAndroid {

    @Test
    public void testLogin() throws InterruptedException {
        // Enter the company name
        app.loginPage_android().clickLoginToContinue();
        app.loginPage_android().enterCompany("Pragmatic DOM");
        // Enter the email address
        app.loginPage_android().enterEmail("anthonycholakov@icloud.com");
        // Enter the password
        app.loginPage_android().enterPassword("Test05!!!");
        app.loginPage_android().clickLoginToContinue();
        // Click the login button
        app.loginPage_android().clickLogin();
        // Verify that the login was successful
        app.loginPage_android().clickHomeIconAndVerifyHomeScreen();
        app.loginPage_android().clickPersonIconAndVerifyPersonScreen();
        app.loginPage_android().clickLogout();
        app.loginPage_android().verifyLoginScreenMessage();
        //assertTrue(loginPage.isLoginSuccessful());
    }
}