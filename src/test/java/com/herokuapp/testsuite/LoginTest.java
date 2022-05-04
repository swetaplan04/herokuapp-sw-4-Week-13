package com.herokuapp.testsuite;

import com.herokuapp.pages.LoginPage;
import com.herokuapp.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    LoginPage loginPage = new LoginPage();

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        loginPage.enterUserName("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLoginButton();
        String actualMessage = loginPage.getWelcomeMessage();
        // Assert.assertEquals(expectedMessage, actualMessage, "Login page not displayed");
        Assert.assertEquals(actualMessage,"Secure Area","error");

    }
    @Test
    public void verifyTheUsernameErrorMessage(){
        loginPage.enterUserName("tomsmith1");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLoginButton();
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualMessage,"Your username is invalid!\n" +
                "×", "error");


    }
    @Test
    public void verifyThePasswordErrorMessage(){
        loginPage.enterUserName("tomsmith");
        loginPage.enterPassword("SuperSecretPassword");
        loginPage.clickOnLoginButton();
        String actualMessage = loginPage.getInValidPassword();
        Assert.assertEquals(actualMessage,"Your password is invalid!\n" +
                "×", "error");


    }
}

