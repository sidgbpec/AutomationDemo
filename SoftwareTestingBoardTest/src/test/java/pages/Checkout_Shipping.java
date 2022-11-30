package pages;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
import org.apache.hc.core5.http.impl.DefaultContentLengthStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkout_Shipping {
	public WebDriver driver;
	public Checkout_Shipping(WebDriver d)
	{
		driver=d;
	}
	
	//By Next_Button_On_Checkout_Page=By.xpath("//button[contains(.,'Next')]");
	By Next_Button_On_Checkout_Page = By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button/span");
	//By shipping_method_checkbox=By.xpath("//input[@value='flatrate_flatrate']");

	By shipping_method_checkbox=By.xpath("(//*[@id=\"checkout-shipping-method-load\"]/table/tbody//td)[1]");
	
	public void click_NextButtonOnCheckoutShippingPage() throws InterruptedException
	{
		try {
			Thread.sleep(20000);
			
			WebElement we1=driver.findElement(shipping_method_checkbox);
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", we1);
			we1.click();
			
			WebElement we2=driver.findElement(Next_Button_On_Checkout_Page);
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", we2);
			we2.click();
			//driver.findElement(Next_Button_On_Checkout_Page).click();
			System.out.println("next button is clicked");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		/*WebElement table = driver.findElement(By.xpath("//span[normalize-space()='New Address']"));
		WebElement nextbutton = driver.findElement(with(Next_Button_On_Checkout_Page)
		                                          	.below(table));
		nextbutton.click();
		driver.navigate().refresh();
		driver.switchTo().defaultContent();
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(Next_Button_On_Checkout_Page));
		driver.findElement(Next_Button_On_Checkout_Page).click();*/
	}	
	
	
}
