package Pages;
 
 
import java.time.Duration;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
import io.appium.java_client.android.AndroidDriver;
 
public class ProductsPage {
	
	  AndroidDriver driver;
	    WebDriverWait wait;
	    
	    
	
	    public ProductsPage(AndroidDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // unified wait
	    }
	    
	    
	 public void SelectItem() {
	    	WebElement selectitem = wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//android.widget.ImageView[@content-desc=\"Sauce Labs Backpack\"]")));
	    	selectitem.click();
	    }
	
	 public void addToCart() {
		
			WebElement  addtocart = wait.until(ExpectedConditions.elementToBeClickable(
	                By.id("com.saucelabs.mydemoapp.android:id/cartBt")));
	    	addtocart.click();
	    	
	    	
	    }
	
	
	 public void CheckCart() {
		
			WebElement  checkcart = wait.until(ExpectedConditions.elementToBeClickable(
	                By.id("com.saucelabs.mydemoapp.android:id/cartIV")));
			checkcart.click();
			
		
		
	    }
	
	 public void DeleteFromCart() {
		
		 WebElement  deletefromcart = wait.until(ExpectedConditions.elementToBeClickable(
	                By.id("com.saucelabs.mydemoapp.android:id/removeBt")));
		  deletefromcart.click();
		  
		  
	  
	 }
	 public boolean IsProductAdded() {
		    try {
	            WebElement successElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                    By.id("com.saucelabs.mydemoapp.android:id/itemsTV")));
	            return successElement.isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    
	 }
	 public boolean IsProductDeleted() {
		    try {
	            WebElement successElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                    By.id("com.saucelabs.mydemoapp.android:id/noItemTitleTV")));
	            return successElement.isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    
	 }
 
}