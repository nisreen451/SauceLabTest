package Tests;
 
 
import org.testng.Assert;
import org.testng.annotations.Test;
 
import Base.BaseTest;
import Pages.LoginPage;
import Pages.ProductsPage;
 
public class TestProduct extends BaseTest{

 
 
	@Test(priority = 1)
    public void Login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginScreen();
        loginPage.login("bod@example.com", "10203040");
    }
    @Test(priority = 2)
    public void TC_add_001_testaddtocart() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.SelectItem();
        productsPage.addToCart();
        productsPage.CheckCart();
       Assert.assertTrue(productsPage.IsProductAdded(), "Item added to cart ");

    }
 
  
	@Test(priority = 3)
    public void TC_remove_001_testremovetocart() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.DeleteFromCart();
        Assert.assertTrue(productsPage.IsProductDeleted(), "Item removed from  cart ");

    }
}