package Tests;

import Base.BaseTest;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin extends BaseTest {

    @Test(priority = 1)
    public void TC_Login_005_testInvalidUsernameAndPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginScreen();
        loginPage.login("wrong@example.com", "123");
        Assert.assertTrue(loginPage.isLoginRejected(), "Login should be rejected for invalid credentials.");
    }
    
    @Test(priority = 2)
    public void TC_Login_001_testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginScreen();
        loginPage.login("bod@example.com", "10203040");
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login should be success with valid credentials.");
        
    }
    
    @Test(priority = 3)
    public void TC_Login_008_testLockedUserLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginScreen();
        loginPage.login("alice@example.com", "10203040");
        Assert.assertTrue(loginPage.isLoginRejected(), "Login should be rejected for invalid credentials.");
        
    }
    
    @Test(priority = 4)
    public void TC_Login_002_testEmptyUsernameAndPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginScreen();
        loginPage.login("", "");
        Assert.assertTrue(loginPage.isUsernameRequiredMessageDisplayed(), "Expected 'Username is required' message not shown.");
    }
    
   
    
    @Test(priority = 5)
    public void TC_Login_006_testInvalidUsername() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginScreen();
        loginPage.login("wrong@example.com", "10203040");
        Assert.assertTrue(loginPage.isLoginRejected(), "Login should be rejected for invalid credentials.");
    }
    
    @Test(priority = 6)
    public void TC_Login_004_testEmptyPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginScreen();
        loginPage.login("bod@example.com", "");
        Assert.assertTrue(loginPage.isPasswordRequiredMessageDisplayed(), "Expected 'password is required' message not shown.");
    }
    
   
    
    @Test(priority = 7)
    public void TC_Login_007_testInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginScreen();
        loginPage.login("bod@example.com", "1234");
        Assert.assertTrue(loginPage.isLoginRejected(), "Login should be rejected for invalid credentials.");
    }
    
    @Test(priority = 8)
    public void TC_Login_003_testEmptyUsername() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginScreen();
        loginPage.login("", "10203040");
        Assert.assertTrue(loginPage.isUsernameRequiredMessageDisplayed(), "Expected 'Username is required' message not shown.");
    }

    
   
}
