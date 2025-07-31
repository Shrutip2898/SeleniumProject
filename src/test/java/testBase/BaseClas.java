package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClas {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties p;

	@BeforeClass(groups = {"Regression", "Master" ,"Sanity", "DataDriven"})
	@Parameters({"os", "browser"})
	public void setup(String os, String br) throws IOException
	{
		FileReader file = new FileReader("./src//test//resources//config.property");
		p = new Properties();
		p.load(file);
		logger = LogManager.getLogger(this.getClass());
		switch(br.toLowerCase())
		{
		case "chrome": driver=new ChromeDriver(); break;
		case "edge": driver=new EdgeDriver(); break;
		default: System.out.println("No matching browser..");
					return;
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.automationexercise.com/");
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups = {"Regression", "Master" ,"Sanity", "DataDriven"})
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomString()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	public String randomString1()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	
	public String randomNumber()
	{
		String generatednumber = RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}
	
	public String randomNumber1()
	{
		String generatednumber = RandomStringUtils.randomNumeric(6);
		return generatednumber;
	}
	
	public String randomAlphaNumberic()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(6);
		String generatednumber = RandomStringUtils.randomNumeric(6);
		return (generatedstring + generatednumber);
	}
	

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}


}
