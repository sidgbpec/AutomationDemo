package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Watches {

	public WebDriver driver;
	public Watches(WebDriver d)
	{
		driver=d;
	}
	
	By DidiSportWatch =By.xpath("//div[@class='product-item-info']//img[@alt='Didi Sport Watch']");
	//By AddToCart_DidiSportWatch =By.xpath("//button[@id='product-addtocart-button']");
	By AddToCart_DidiSportWatch=By.xpath("//button[@title='Add to Cart']");
	By item_to_be_added_in_cart =By.xpath("//span[@class='base']");
	By shoppingcart=By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']//a[@href='https://magento.softwaretestingboard.com/checkout/cart/']");
	
	public void click_Over_DidiSportWatch() throws InterruptedException
	{
		WebElement DidiSportWatch_Element=driver.findElement(DidiSportWatch);
		DidiSportWatch_Element.click();
		/*Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(DidiSportWatch));
		Thread.sleep(20000)*/;
	}
	
	public void click_AddToCart_DidiSportWatch()
	
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(AddToCart_DidiSportWatch)).click();

		/*WebElement AddToCartElement=driver.findElement(AddToCart_DidiSportWatch);
		((JavascriptExecutor)driver).executeScript("arguments[0].click;", AddToCartElement);*/
	}
	
	public String get_item_name_before_adding_in_cart()
	{
		return driver.findElement(item_to_be_added_in_cart).getText();
	}
	
	public void click_shopping_cart()
	{
		driver.findElement(shoppingcart).click();
	}
}
