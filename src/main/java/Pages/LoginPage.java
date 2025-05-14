package Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    AndroidDriver driver;
    WebDriverWait wait;

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // unified wait
    }

//    this is may change
    public void navigateToLoginScreen() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.saucelabs.mydemoapp.android:id/menuIV"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/itemTV' and @text='Log In']"))).click();

        // Ensure login screen is fully loaded before interaction
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.saucelabs.mydemoapp.android:id/nameET")));
    }

    public void login(String username, String password) {
        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.saucelabs.mydemoapp.android:id/nameET")));
        usernameField.clear();
        usernameField.sendKeys(username);

        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.saucelabs.mydemoapp.android:id/passwordET")));
        passwordField.clear();
        passwordField.sendKeys(password);

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.saucelabs.mydemoapp.android:id/loginBtn")));
        loginButton.click();
    }

    public boolean isLoginSuccessful() {
        try {
            WebElement successElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("com.saucelabs.mydemoapp.android:id/productTV")));
            return successElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLoginRejected() {
        try {
            return wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(By.id("com.saucelabs.mydemoapp.android:id/loginBtn")),
                    ExpectedConditions.visibilityOfElementLocated(By.id("com.saucelabs.mydemoapp.android:id/nameErrorTV")),
                    ExpectedConditions.visibilityOfElementLocated(By.id("com.saucelabs.mydemoapp.android:id/passwordErrorTV"))
            )) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isUsernameRequiredMessageDisplayed() {
        try {
            WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("com.saucelabs.mydemoapp.android:id/nameErrorTV")));
            return errorMsg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPasswordRequiredMessageDisplayed() {
        try {
            WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("com.saucelabs.mydemoapp.android:id/passwordErrorTV")));
            return errorMsg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
