package common;

import core.BaseTestiOS;
import org.junit.jupiter.api.Test;

public class LoginPageTestiOS extends BaseTestiOS {
    @Test
    public void testLogin() throws InterruptedException {
        // Enter the company name
        app.loginPage_iOS().enterCompany("Pragmatic DOM");
        // Enter the email address
        app.loginPage_iOS().enterEmail("anthonycholakov@icloud.com");
        // Enter the password
        app.loginPage_iOS().enterPassword("Test05!!!");
        // Click the login button
        app.loginPage_iOS().clickLogin();
        // Verify that the login was successful
        app.loginPage_iOS().clickHomeIcon();
        app.loginPage_iOS().verifyHomeScreen();
        app.loginPage_iOS().clickPersonIcon();
        app.loginPage_iOS().verifyPersonScreen();
        app.loginPage_iOS().clickLogout();
        app.loginPage_iOS().verifyLoginScreen();
    }
}