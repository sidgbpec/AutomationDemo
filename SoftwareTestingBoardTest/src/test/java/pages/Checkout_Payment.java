package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Checkout_Payment 
{
	public WebDriver driver;
	public Checkout_Payment(WebDriver d)
	{
		driver=d;
	}
	
	By PlaceOrder_Button_On_Checkout_Payment_Page=By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button");
	By item_name_before_payment=By.xpath("//strong[@class='product-item-name']");
	
	public void click_PlaceOrder_Button_OnCheckoutPaymentPage() throws InterruptedException
	{
		try {
			Thread.sleep(20000);
			WebElement we=driver.findElement(PlaceOrder_Button_On_Checkout_Payment_Page);
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", we);
			we.click();
			//driver.findElement(Next_Button_On_Checkout_Page).click();
			System.out.println("button is clicked");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
