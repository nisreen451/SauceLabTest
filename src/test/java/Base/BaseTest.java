package Base;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected AndroidDriver driver;

    @BeforeTest
    public void setUp() {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();

            // Basic capabilities
            caps.setCapability("platformName", "Android");
            caps.setCapability("deviceName", "emulator-5554");
            caps.setCapability("automationName", "UiAutomator2");
            caps.setCapability("appWaitActivity", "*");


            caps.setCapability("app", "C:/Users/user/AndroidStudioProjects/mda-2.0.2-23.apk");
            caps.setCapability("appPackage", "com.saucelabs.mydemoapp.android");
            caps.setCapability("appActivity", "com.saucelabs.mydemoapp.android.view.activities.SplashActivity");


            caps.setCapability("noReset", true);

            System.out.println("Starting Appium session...");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
            System.out.println("Appium session started successfully!");

        } catch (Exception e) {
            System.err.println("Failed to start Appium session: " + e.getMessage());
            e.printStackTrace(); // This will print the stack trace to console
        }
    }


    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
