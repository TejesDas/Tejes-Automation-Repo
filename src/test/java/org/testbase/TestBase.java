package org.testbase;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports report=new ExtentReports(System.getProperty("user.dir") + "\\ExtentReports\\Results.html",true);	
    public static ExtentTest Logger;
    	public static void browserOpen()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public static void configReader() throws IOException
	{
		prop = new Properties();
		try
		{
			FileInputStream fi = new FileInputStream("C:\\Users\\Tejes Das\\eclipse-workspace\\CucumberFramework\\Config\\config.properties");
			prop.load(fi);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static void GetScreenShot(String filename) throws IOException
	{
		try {
		File scrfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotpath=System.getProperty("user.dir") +  "\\ExtentReports\\Screenshots\\";
		FileUtils.copyFile(scrfile,new File (screenshotpath  + filename.trim() + ".png"));
		String imghtmlpath=Logger.addScreenCapture(screenshotpath + filename.trim() + ".png" );
		Logger.log(LogStatus.INFO,"Screenshot :" + imghtmlpath);
		}catch(Exception e)
		{
			
			System.out.println(e.getMessage());
		}
		
		
		
	}
	public static void StartTest(String TestName)
	{
		Logger=report.startTest(TestName);
		
	}
	public static void EndTest()
	{
		report.endTest(Logger);
		report.flush();
		
	}
	public static void highlightElement(WebElement element) 
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		try
		{
			jse.executeScript("arguments[0].setAttribute('style',arguments[1]);",element,"color:brown;border:5px solid green;");
			
			
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
	}
	
	public static void click(String xpath,String actionInfo) throws IOException
	{
		try
		{
			WebElement element = driver.findElement(By.xpath(xpath));
			element.click();
			highlightElement(element);
			GetScreenShot(actionInfo);
			System.out.println("Sucessfully : "  + actionInfo);
			Logger.log(LogStatus.INFO,"Successfully : "  + actionInfo);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println("RUNTIME ERORR  : : Not able to : "  + actionInfo);
			Logger.log(LogStatus.FAIL, "RUNTIME ERORR  : : Not able to : "  + actionInfo);
			GetScreenShot(actionInfo);
			report.flush();
			throw new java.lang.RuntimeException("RUNTIME ERROR :: Not able to : " +actionInfo);
			
		}
	}
	
	public static void inputText(String xpath, String value,String actionInfo) throws IOException
	{
		try
		{
			WebElement element = driver.findElement(By.xpath(xpath));
			element.sendKeys(value);
			highlightElement(element);
			GetScreenShot(actionInfo);
			System.out.println("Sucessfully : "  + actionInfo);
			Logger.log(LogStatus.INFO,"Successfully : "  + actionInfo);
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println("RUNTIME ERORR  : : Not able to : "  + actionInfo);
			Logger.log(LogStatus.FAIL, "RUNTIME ERORR  : : Not able to : "  + actionInfo);
			GetScreenShot(actionInfo);
			report.flush();
			//throw new java.lang.RuntimeException("RUNTIME ERROR :: Not able to : " +actionInfo);

		}
	}

}
