package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.GenerateRandomSequence;

public class SignInPage {

	WebDriver driver;
	public SignInPage(WebDriver d)
	{
		driver=d;
	}
	
	By signin_link=By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]");
	By email_id_signin_page_textbox=By.xpath("//input[@id='email']");
    By password_signin_page_textbox=By.xpath("//fieldset[@class='fieldset login']//input[@id='pass']");
    By SignIn_button=By.xpath("//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]");
    By error_message=By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");
    
   
    
	
	public void click_signin_link()
	{
		driver.findElement(signin_link).click();
	}
	
	public void enter_email_id(String emailid)
	{
		driver.findElement(email_id_signin_page_textbox).sendKeys(emailid);
	}
	
	public void enter_password(String password)
	{
		driver.findElement(password_signin_page_textbox).sendKeys(password);
	}
	
	public void click_signin_button()
	{
		driver.findElement(SignIn_button).click();
	}
	
	public String get_error_message()
	{
		return driver.findElement(error_message).getText();
	}
	
	
}
