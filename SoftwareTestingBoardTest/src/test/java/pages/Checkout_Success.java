package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkout_Success {

	public WebDriver driver;
	public Checkout_Success(WebDriver d)
	{
		driver=d;
	}
	
	By Print_Receipt_link=By.xpath("//*[@id=\"maincontent\"]/div[1]/a");
	
	public void click_print_receipt_link() throws InterruptedException
	{
		try {
			Thread.sleep(20000);
			WebElement we=driver.findElement(Print_Receipt_link);
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
