package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MyAccount {

	public WebDriver driver;
	public MyAccount(WebDriver d)
	{
		driver=d;
	}
	
	By editShippingAddress_link = By.xpath("//div[@class='box box-shipping-address']//span[contains(text(),'Edit Address')]");
	By streetName_textbox=By.xpath("//input[@id='street_1']");
	By streetNumber_textbox=By.xpath("//input[@id='street_2']");
	By city_textbox=By.xpath("//input[@id='city']");
	By phoneNumber_textbox=By.xpath("//input[@id='telephone']");
	By state_field=By.xpath("//span[normalize-space()='State/Province']/..//following-sibling::div/*[@style='display: inline-block;']");
	By zipCode_textbox=By.xpath("//input[@id='zip']");
	By country_dropdown=By.xpath("//select[@id='country']");
	By saveAddress_button=By.xpath("//span[normalize-space()='Save Address']");
	public void click_Edit_Shipping_Address_link()
	{
		driver.findElement(editShippingAddress_link).click();
	}
	
	public void enter_Shipping_Address_streetNumber(String streetNumber)
	{
		driver.findElement(streetNumber_textbox).sendKeys(streetNumber);
	}
	
	public void enter_Shipping_Address_streetName(String streetName)
	{
		driver.findElement(streetName_textbox).sendKeys(streetName);
	}
	
	public void enter_City(String city)
	{
		driver.findElement(city_textbox).sendKeys(city);
	}
	
	public void enter_PhoneNumber(String phone)
	{
		driver.findElement(phoneNumber_textbox).sendKeys(phone);
	}
	
	public void enter_State(String state) throws InterruptedException
	{
		String tagname=driver.findElement(state_field).getTagName();
		if(tagname.equals("input"))
			{
				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(state_field));	
				driver.findElement(state_field).click();
				Thread.sleep(10000);
				driver.findElement(state_field).sendKeys(state);	
			}
		else
			{
				boolean flag=false;
				Select select=new Select(driver.findElement(state_field));
				List<WebElement> listOfStates=driver.findElements(By.xpath("//*[@id='region_id']/option"));
				for(int i=0; i<listOfStates.size(); i++)
					{
						String currentname=listOfStates.get(i).getText();
						if(currentname.equalsIgnoreCase(state))
						{
							select.selectByVisibleText(currentname);
							flag=true;
							break;
						}
					}	
				if(flag==false)
				{
					for(int i=0; i<listOfStates.size(); i++)
					{
						String currentname=listOfStates.get(i).getText();
						if(currentname.contains(state) || state.contains(currentname))
						{
							select.selectByVisibleText(currentname);
							flag=true;
							break;
						}
					}	
					if(flag==false)
						select.selectByIndex(2);
				}
			}
	}
	
	public void enter_ZipCode(String zipcode)
	{
		driver.findElement(zipCode_textbox).sendKeys(zipcode);
	}
	
	public void selectCountry(String country) throws InterruptedException
	{
		Select select=new Select(driver.findElement(country_dropdown));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(country_dropdown));
		//driver.findElement(country_dropdown).click();
		//Thread.sleep(20000);
		select.selectByVisibleText(country);
		Thread.sleep(20000);
	}
	
	public void click_saveAddress()
	{
		driver.findElement(saveAddress_button).click();
	}
	
}
