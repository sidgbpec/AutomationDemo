package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import config.ReadConfig;

public class Homepage {
	WebDriver driver;
	ReadConfig readConfig=new ReadConfig();

    public Homepage(WebDriver d)
    {
        driver=d;
    }

    By createAnAccount_link=By.xpath("//div[@class='panel header']//a[normalize-space()='Create an Account']");

    public void click_Create_An_Account_link()
    {
        driver.findElement(createAnAccount_link).click();
    }
    
    

}
