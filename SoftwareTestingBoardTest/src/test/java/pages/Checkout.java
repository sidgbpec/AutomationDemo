package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkout 
{
	WebDriver driver;
	public Checkout(WebDriver d)
    {
        driver=d;
    }
	By proceedToCheckout=By.xpath("//ul[@class='checkout methods items checkout-methods-items']//button[@class='action primary checkout']");
	By item_text_in_cart=By.xpath("//td[@class='col item']//a[normalize-space()='Didi Sport Watch']");
	
	public void click_ProceedToCheckoutButton() throws InterruptedException
	{
		Thread.sleep(20000);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element=driver.findElement(proceedToCheckout);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
		wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckout));
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", element);
	}
	
	public String get_text_item_in_cart()
	{
		String text_of_item_in_cart=driver.findElement(item_text_in_cart).getText();
		return text_of_item_in_cart;
	}
	
}
