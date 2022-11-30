package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PurchasePage {
	
		WebDriver driver;
	    public PurchasePage(WebDriver d)
	    {
	        driver=d;
	    }

	    By hamburger_menu_All =By.xpath("//i[@class='hm-icon nav-sprite']");

	    public void click_hamburder_menu_all()
	    {
	        driver.findElement(hamburger_menu_All).click();
	    }
}
