package utilities;

import java.time.Duration;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import config.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pages.Common;
import pages.Homepage;
import pages.RegistrationPage;
import pages.SignInPage;


public class NewUser 
{
	ReadConfig readconfig=new ReadConfig();
	GenerateRandomSequence generateRandomSequence=new GenerateRandomSequence();
	JsonPath jsonPathEvaluator;
	RequestSpecification httpRequest;
	Response response; 
	WebDriver tempdriver;
	
	WebDriver driver;
	
	
	Boolean error_message_on_signin;
	String FirstName;
	String LastName;
	String EmailId;
	String Password;
	String StreetName;
	String StreetNumber;
	String City;
	String Phone;
	String State;
	String ZipCode;
	String Country;
	
	String jsonPath_of_FirstName="results[0].name.first";
	String jsonPath_of_LastName="results[0].name.last";
	String jsonPath_of_EmailId="results[0].email";
	String jsonPath_of_Password="results[0].login.password";
	String jsonPath_of_StreetName="results[0].location.street.name";
	String jsonPath_of_StreetNumber="results[0].location.street.number";
	String jsonPath_of_City="results[0].location.city";
	String jsonPath_of_Phone="results[0].phone";
	String jsonPath_of_State="results[0].location.state";
	String jsonPath_of_ZipCode="results[0].location.postcode";
	String jsonPath_of_Country="results[0].location.country";
	
	public void registerNewUser() throws InterruptedException
		{
			while(0==0)
				{
					generateUserData();
					WebDriverManager.chromedriver().setup();
					tempdriver=new ChromeDriver();
					tempdriver.manage().window().maximize();
					tempdriver.get(readconfig.getApplicationurl());
					SignInPage temp_signinpage=new SignInPage(tempdriver);
					temp_signinpage.click_signin_link();
					temp_signinpage.enter_email_id(EmailId);
					temp_signinpage.enter_password(Password);
					temp_signinpage.click_signin_button();
					if(!tempdriver.getTitle().contains("My Account"))
					{
						System.out.println("new user is found");
						break;
					}
					/*String error_message_text=temp_signinpage.get_error_message();
					
					if(error_message_text!=null)
						error_message_on_signin=true;
					else
						error_message_on_signin=false;
	
					if(error_message_on_signin)
					{
						System.out.println("new user found");
						break;
					}*/	
				}
			Thread.sleep(10000);
			tempdriver.quit();
			
			Password=Password.trim()+generateRandomSequence.appendPassword();
			System.out.println("updated password is: "+Password);
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			Common common=new Common(driver);
			Homepage homepage=new Homepage(driver);
			RegistrationPage registrationPage=new RegistrationPage(driver);
			//SignInPage signinpage=new SignInPage(driver);
			
			driver.get(readconfig.getApplicationurl());
			//Thread.sleep(10000);
			driver.manage().window().maximize();
			homepage.click_Create_An_Account_link();
			Thread.sleep(10000);
			registrationPage.enterFirstName(FirstName);
			registrationPage.enterLastName(LastName);
			registrationPage.signUpForNewsLetter();
			registrationPage.enterEmailID(EmailId);
			registrationPage.enterPassword(Password);
			registrationPage.enterConfirmPassword(Password);
			registrationPage.clickOnCreateAccount_button();
			Thread.sleep(20000);
			common.click_ProfileDropdown();
			Thread.sleep(10000);
			common.click_Signout();
			driver.quit();
		}

	public String get_StreetName()
		{
			return StreetName;
		}

	public String get_StreetNumber()
		{
			return StreetNumber;
		}

	public String get_City()
		{
			return City;
		}

	public String get_State()
		{
			return State;
		}

	public String get_Phone()
		{
			return Phone;
		}

	public String get_ZipCode()
		{
			return ZipCode;
		}

	public String get_Country()
		{
			return Country;
		}
	public String get_EmailId()
		{
			return EmailId;
		}
	public String get_Password()
		{
			return Password;
		}
	public String get_FirstName()
		{
			return FirstName;
		}
	public String get_LastName()
		{
			return LastName;
		}
	public void generateUserData()
		{
			System.out.println("generate user data method is called");
			RestAssured.baseURI = readconfig.getUserGeneratorURL();
			httpRequest = RestAssured.given();
			response = httpRequest.get("/api");
			System.out.println("response is: "+response.asString());
			jsonPathEvaluator = response.jsonPath();
			jsonPath_of_FirstName="results[0].name.first";
			jsonPath_of_LastName="results[0].name.last";
			jsonPath_of_EmailId="results[0].email";
			jsonPath_of_Password="results[0].login.password";
			jsonPath_of_StreetName="results[0].location.street.name";
			jsonPath_of_StreetNumber="results[0].location.street.number";
			jsonPath_of_City="results[0].location.city";
			jsonPath_of_Phone="results[0].phone";
			jsonPath_of_State="results[0].location.state";
			jsonPath_of_ZipCode="results[0].location.postcode";
			jsonPath_of_Country="results[0].location.country";
			FirstName=String.valueOf(jsonPathEvaluator.get(jsonPath_of_FirstName));
			System.out.println(FirstName);
			LastName=String.valueOf(jsonPathEvaluator.get(jsonPath_of_LastName));
			EmailId=String.valueOf(jsonPathEvaluator.get(jsonPath_of_EmailId));
			System.out.println("email id is: "+EmailId);
			System.out.println("type of email is: "+EmailId.getClass());
			Password=String.valueOf(jsonPathEvaluator.get(jsonPath_of_Password));
			StreetName=String.valueOf(jsonPathEvaluator.get(jsonPath_of_StreetName));
			StreetNumber=String.valueOf(jsonPathEvaluator.get(jsonPath_of_StreetNumber));
			City=String.valueOf(jsonPathEvaluator.get(jsonPath_of_City));
			Phone=String.valueOf(jsonPathEvaluator.get(jsonPath_of_Phone));
			State=String.valueOf(jsonPathEvaluator.get(jsonPath_of_State));
			ZipCode=String.valueOf(jsonPathEvaluator.get(jsonPath_of_ZipCode));
			Country=String.valueOf(jsonPathEvaluator.get(jsonPath_of_Country));
		}
}
