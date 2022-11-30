package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrintReceipt {
	public WebDriver driver;
	public PrintReceipt(WebDriver d)
	{
		driver=d;
	}
	
	By item_name_in_receipt=By.xpath("//*[contains(@id, \"order-item-row-\")]/td/strong");

	public String get_item_name_in_receipt() throws InterruptedException
	{
		String output="";
		try
		{
			Thread.sleep(10000);
			WebElement we=driver.findElement(item_name_in_receipt);
			//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", we);
			output=we.getText();			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			WebElement we=driver.findElement(item_name_in_receipt);
			//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", we);
			output=we.getText();
		}
		return output;
	}
}
