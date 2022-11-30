package tests;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import config.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Checkout;
import pages.Checkout_Payment;
import pages.Checkout_Shipping;
import pages.Checkout_Success;
import pages.Common;
import pages.Homepage;
import pages.MyAccount;
import pages.PrintReceipt;
import pages.PurchasePage;
import pages.RegistrationPage;
import pages.SignInPage;
import pages.Watches;
import utilities.GenerateRandomSequence;
import utilities.NewUser;

public class VerifyPayment extends BaseClass{

	WebDriver driver;
	ReadConfig readconfig;
	SignInPage signinpage;
	NewUser newuser=new NewUser();
	BaseClass baseclass=new BaseClass();
	Checkout_Payment checkoutPayment;
	Checkout_Shipping checkoutShipping;
	Checkout_Success checkoutSuccess;
	Common common;
	Homepage homepage;
	MyAccount myAccount;
	PrintReceipt printReceipt;
	PurchasePage purchasePage;
	RegistrationPage registrationPage;
	Watches watches;
	Checkout checkout;
	GenerateRandomSequence generateRandomSequence;
	@Test
	public void verifyPayment()  throws InterruptedException, AWTException
	{
		baseclass.setup();
		
		
		newuser.registerNewUser();
		
		logger.info("new user is registered and signed in");
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		checkoutPayment=new Checkout_Payment(driver);
		checkoutShipping=new Checkout_Shipping(driver);
		checkoutSuccess=new Checkout_Success(driver);
		common=new Common(driver);
		homepage=new Homepage(driver);
		myAccount=new MyAccount(driver);
		printReceipt =new PrintReceipt(driver);
		purchasePage=new PurchasePage(driver);
		registrationPage=new RegistrationPage(driver);
		watches=new Watches(driver);
		signinpage=new SignInPage(driver);
		checkout=new Checkout(driver);
		readconfig=new ReadConfig();
		generateRandomSequence=new GenerateRandomSequence();
		String StreetName=newuser.get_StreetName();
		String StreetNumber=newuser.get_StreetNumber();
		String City=newuser.get_City();
		String Phone=newuser.get_Phone();
		String State=newuser.get_State();
		String ZipCode=newuser.get_ZipCode();
		String Country=newuser.get_Country();
		String EmailId=newuser.get_EmailId();
		String Password=newuser.get_Password();
		String item_name_before_payment;
		String item_name_after_adding_in_Cart;
		String item_name_before_adding_in_cart;
		String item_name_after_payment_in_receipt;
		
		driver.get(readconfig.getApplicationurl());
		
		driver.manage().window().maximize();
				
		signinpage.click_signin_link();
		signinpage.enter_email_id(EmailId);
		signinpage.enter_password(Password);
		signinpage.click_signin_button();
		Thread.sleep(20000);

		/*if(!driver.getTitle().contains("My Account"))
		{
			EmailId=EmailId.trim()+generateRandomSequence.appendEmail();
			signinpage.enter_email_id(EmailId);
			signinpage.enter_password(Password);
			signinpage.click_signin_button();
		}*/
		
		common.click_ProfileDropdown();
		Thread.sleep(10000);
		common.click_MyAccount_Option_under_MyProfile();
		Thread.sleep(10000);
		myAccount.click_Edit_Shipping_Address_link();
		logger.info("edit shipping address link is clicked");
		
		myAccount.enter_Shipping_Address_streetNumber(StreetNumber);
		logger.info("Street number is entered");
		myAccount.enter_Shipping_Address_streetName(StreetName);
		logger.info("Street Name is entered");
		myAccount.selectCountry(Country);
		logger.info("Country is selected");
		myAccount.enter_City(City);
		logger.info("city is entered");
		myAccount.enter_PhoneNumber(Phone);
		logger.info("Phone number is entered");
		
		
		myAccount.enter_State(State);
		logger.info("State is entered");
		myAccount.enter_ZipCode(ZipCode);
		logger.info("Zip code is entered");
		
		myAccount.click_saveAddress();
		logger.info("Address is saved");
		Thread.sleep(20000);
		common.hover_On_Gear_Option();
		logger.info("mouse is hovered over Gear menu");
		common.click_Watches_Option_Under_Gear_Menu();
		logger.info("Watches option is clicked");
		watches.click_Over_DidiSportWatch();
		logger.info("Didi sport watch is clicked");
		
		item_name_before_adding_in_cart=watches.get_item_name_before_adding_in_cart();
		System.out.println(item_name_before_adding_in_cart);
		
		watches.click_AddToCart_DidiSportWatch();
		logger.info("Add to cart button is clicked");
		Thread.sleep(10000);
		watches.click_shopping_cart();
		logger.info("Cart is opened");
		item_name_after_adding_in_Cart=checkout.get_text_item_in_cart();
		System.out.println(item_name_after_adding_in_Cart);
		checkout.click_ProceedToCheckoutButton();
		logger.info("Proceed to Checkout button is clicked");
		checkoutShipping.click_NextButtonOnCheckoutShippingPage();
		logger.info("Next button is clicked on chekcout shipping page");
		checkoutPayment.click_PlaceOrder_Button_OnCheckoutPaymentPage();
		logger.info("Place Order button is clicked on checkout payment page");
		String currentWindowHandle=driver.getWindowHandle();
		checkoutSuccess.click_print_receipt_link();
		logger.info("print receipt link is clicked");
		
		System.out.println(currentWindowHandle);
		Set<String> all_window_handles=driver.getWindowHandles();
		Iterator itr=all_window_handles.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		Thread.sleep(30000);
		
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
		driver.switchTo().defaultContent();
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		//driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
		
		/*driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement webElement = driver.findElement(By.tagName("body"));
		webElement.sendKeys(Keys.TAB);
		webElement.sendKeys(Keys.ENTER);
		*/
		logger.info("print dialogue is closed");
		//driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		System.out.println("window handle after closing print dialogue: "+driver.getWindowHandle());
		
		Thread.sleep(20000);
		
		item_name_after_payment_in_receipt=printReceipt.get_item_name_in_receipt();
		
		System.out.println("item name before adding in cart is: "+item_name_before_adding_in_cart);
		System.out.println("item name after adding in cart is: "+item_name_after_adding_in_Cart);
		System.out.println("item name after payment is: "+item_name_after_payment_in_receipt);
		
		//System.out.println(title);
		logger.info("test case is executed successfully");
		
		if (item_name_before_adding_in_cart.equalsIgnoreCase(item_name_after_adding_in_Cart) && item_name_after_adding_in_Cart.equalsIgnoreCase(item_name_after_payment_in_receipt))
        {
        	
        	test.log(Status.PASS,"test is passed");
        	try {
				test.addScreenCaptureFromPath(baseclass.captureScreenshot(driver));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
            Assert.assertTrue(true);
            logger.info("test case is passed");
        }
        else
        {
        	test.log(Status.FAIL, "test is failed");
        	try 
        	{
				test.addScreenCaptureFromPath(baseclass.captureScreenshot(driver));
			} 
			catch (IOException e) 
			{
				
				e.printStackTrace();
			}
        	Assert.assertTrue(false);
            logger.info("test case is failed");
         }
		baseclass.teardown(driver);
	}
}
