public class CheckoutTest {
    @Test
    public void testCheckoutWithAllFields() {
        driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"Sauce Labs Backpack\"]").click();

        driver.findElementById("com.saucelabs.mydemoapp.android:id/addToCartBtn").click();  // adjust ID if needed

        driver.findElementById("com.saucelabs.mydemoapp.android:id/cartIV").click();

        driver.findElementById("com.saucelabs.mydemoapp.android:id/checkoutBtn").click();  // adjust if needed

        driver.findElementById("com.saucelabs.mydemoapp.android:id/nameET").sendKeys("standard_user");
        driver.findElementById("com.saucelabs.mydemoapp.android:id/passwordET").sendKeys("secret_sauce");
        driver.findElementById("com.saucelabs.mydemoapp.android:id/loginBtn").click();

        driver.findElementById("com.saucelabs.mydemoapp.android:id/fullNameET").sendKeys("John Doe");
        driver.findElementById("com.saucelabs.mydemoapp.android:id/address1ET").sendKeys("123 Main St");
        driver.findElementById("com.saucelabs.mydemoapp.android:id/address2ET").sendKeys("Apt 5");
        driver.findElementById("com.saucelabs.mydemoapp.android:id/cityET").sendKeys("New York");
        driver.findElementById("com.saucelabs.mydemoapp.android:id/stateET").sendKeys("NY");
        driver.findElementById("com.saucelabs.mydemoapp.android:id/countryET").sendKeys("USA");

        driver.findElementById("com.saucelabs.mydemoapp.android:id/paymentBtn").click();

        MobileElement confirmation = driver.findElementById("com.saucelabs.mydemoapp.android:id/orderConfirmationMessage");
        Assert.assertTrue(confirmation.isDisplayed(), "Order confirmation should be shown.");
    }

    @Test
    public void testCheckoutMissing() {
        driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"Sauce Labs Backpack\"]").click();

        driver.findElementById("com.saucelabs.mydemoapp.android:id/addToCartBtn").click();

        driver.findElementById("com.saucelabs.mydemoapp.android:id/cartIV").click();

        driver.findElementById("com.saucelabs.mydemoapp.android:id/checkoutBtn").click();

        driver.findElementById("com.saucelabs.mydemoapp.android:id/nameET").sendKeys("standard_user");
        driver.findElementById("com.saucelabs.mydemoapp.android:id/passwordET").sendKeys("secret_sauce");
        driver.findElementById("com.saucelabs.mydemoapp.android:id/loginBtn").click();

        driver.findElementById("com.saucelabs.mydemoapp.android:id/fullNameET").sendKeys("");
        driver.findElementById("com.saucelabs.mydemoapp.android:id/address1ET").sendKeys("");
        driver.findElementById("com.saucelabs.mydemoapp.android:id/address2ET").sendKeys("Suite 100");
        driver.findElementById("com.saucelabs.mydemoapp.android:id/cityET").sendKeys("Los Angeles");
        driver.findElementById("com.saucelabs.mydemoapp.android:id/stateET").sendKeys("CA");
        driver.findElementById("com.saucelabs.mydemoapp.android:id/countryET").sendKeys("USA");

        driver.findElementById("com.saucelabs.mydemoapp.android:id/paymentBtn").click();

        MobileElement errorMessage = driver.findElementById("com.saucelabs.mydemoapp.android:id/errorTV");
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message should appear when full name is missing.");
}
    @Test
    public void testCheckoutFieldsEmpty() {
        driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"Sauce Labs Backpack\"]").click();
        driver.findElementById("com.saucelabs.mydemoapp.android:id/addToCartBtn").click();
        driver.findElementById("com.saucelabs.mydemoapp.android:id/cartIV").click();
        driver.findElementById("com.saucelabs.mydemoapp.android:id/checkoutBtn").click();

        driver.findElementById("com.saucelabs.mydemoapp.android:id/nameET").sendKeys("standard_user");
        driver.findElementById("com.saucelabs.mydemoapp.android:id/passwordET").sendKeys("secret_sauce");
        driver.findElementById("com.saucelabs.mydemoapp.android:id/loginBtn").click();


        driver.findElementById("com.saucelabs.mydemoapp.android:id/paymentBtn").click();

        MobileElement error = driver.findElementById("com.saucelabs.mydemoapp.android:id/errorTV");
        Assert.assertTrue(error.isDisplayed(), "Validation error should appear when all fields are empty.");
    }
