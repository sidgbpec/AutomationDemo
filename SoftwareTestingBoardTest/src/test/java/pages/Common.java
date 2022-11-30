package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class Common {
	WebDriver driver;
	public Common(WebDriver d)
    {
        driver=d;
    }
	By breadcrumb_option_Gear=By.xpath("//span[normalize-space()='Gear']");
	By Watches_Option_Under_Gear_menu=By.xpath("//span[normalize-space()='Watches']");
	//By Cart=By.xpath("//a[@class='action showcart']");
	By Cart=By.cssSelector(".action.showcart.active");
	By ProceedToCheckout_button=By.xpath("//button[@id='top-cart-btn-checkout']");
	By ProfileDropdown=By.cssSelector("div[class='panel header'] button[type='button']");
    By Signout=By.xpath("//div[@aria-hidden='false']//a[normalize-space()='Sign Out']");
    By MyAccount=By.cssSelector("div[class='panel wrapper'] li:nth-child(1) a:nth-child(1)");
    
	public void hover_On_Gear_Option() throws InterruptedException 
	{
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(breadcrumb_option_Gear)).perform();
		Thread.sleep(10000);
	}
	
	public void click_Watches_Option_Under_Gear_Menu() throws InterruptedException
	{
		driver.findElement(Watches_Option_Under_Gear_menu).click();
		Thread.sleep(10000);
	}
	
	public void click_Cart() throws InterruptedException
	{
		//driver.findElement(Cart).click();
		WebElement Cart_Element=driver.findElement(Cart);
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", Cart_Element);
		Thread.sleep(10000);
	}
	
	public void click_ProceedToCheckoutButton()
	{
		driver.findElement(ProceedToCheckout_button).click();
	}
	
	public void click_ProfileDropdown()
	{
		
		WebElement profile_dropdown=driver.findElement(ProfileDropdown);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", profile_dropdown);
	}
	
	public void click_Signout()
	{
		driver.findElement(Signout).click();
	}
	
	public void click_MyAccount_Option_under_MyProfile()
	{
		driver.findElement(MyAccount).click();
		/*WebElement myAccount_webelement=driver.findElement(MyAccount);
		((JavascriptExecutor)driver).executeScript("arguments[0].click", myAccount_webelement);*/
	}
	
}
