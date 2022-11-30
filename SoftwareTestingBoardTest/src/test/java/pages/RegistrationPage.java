package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import config.ReadConfig;

public class RegistrationPage{
	WebDriver driver;
	Homepage homePage=new Homepage(driver);
	SignInPage signinpage=new SignInPage(driver);
	ReadConfig readconfig=new ReadConfig();
    public RegistrationPage(WebDriver d)
    {
        driver=d;
    }

    By firstName_textbox =By.xpath("//input[@id='firstname']");
    By lastName_textbox =By.xpath("//input[@id='lastname']");
    By signUpForNewsLetter_checkbox =By.xpath("//input[@id='is_subscribed']");
    By emailid_textbox =By.xpath("//input[@id='email_address']");
    By password_textbox =By.xpath("//input[@id='password']");
    By confirmPassword_textbox=By.xpath("//input[@id='password-confirmation']");
    By createAccount_button =By.xpath("//button[@title='Create an Account']//span[contains(text(),'Create an Account')]");
    By error_for_password=By.xpath("//div[@id='password-error']");
    
    public void enterFirstName(String firstName)
    {
        driver.findElement(firstName_textbox).sendKeys(firstName);
    }
    
    public void enterLastName(String lastName)
    {
        driver.findElement(lastName_textbox).sendKeys(lastName);
    }
    
    public void signUpForNewsLetter()
    {
        driver.findElement(signUpForNewsLetter_checkbox).click();
    }
    
    public void enterEmailID(String emailid)
    {
        driver.findElement(emailid_textbox).sendKeys(emailid);
    }
    
    public void enterPassword(String password)
    {
        driver.findElement(password_textbox).sendKeys(password);
    }
    
    public void enterConfirmPassword(String password)
    {
        driver.findElement(confirmPassword_textbox).sendKeys(password);
    }
    
    public void clickOnCreateAccount_button()
    {
        driver.findElement(createAccount_button).click();
    }
    
    public boolean is_there_any_error_for_password()
    {
    	if(driver.findElement(error_for_password).getText()!=null)
    		return true;
    	else
    		return false;
    		
    }
}
