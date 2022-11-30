package tests;
import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class BaseClass {
    
    public static Logger logger;
    public static ExtentSparkReporter spark;
    public static ExtentReports extent;
    public static ExtentTest test;
    
    public String captureScreenshot(WebDriver driver) throws IOException
	{
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destinationfilepath=new File("src/../Images/Screenshot_"+System.currentTimeMillis()+".png");
		
		String absolutepath=destinationfilepath.getAbsolutePath();
		FileHandler.copy(srcfile, destinationfilepath);
		return absolutepath;
	}
    
  public void setup() 
    {
    	logger= Logger.getLogger("Unlimint");
		logger.info("page is loaded");
		PropertyConfigurator.configure("log4j.properties");
		extent = new ExtentReports();
		spark=new ExtentSparkReporter("target/Spark/Spark.html");
		extent.attachReporter(spark);
		test=extent.createTest("PurchaseItem").assignAuthor("Siddharth Barthwal").assignCategory("Sanity").assignDevice("chrome");
	}
  public void teardown(WebDriver driver)
  {
	  
	  extent.flush();
	  driver.quit();
  }
    
}
