package testCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClas;
import utilities.DataProviders;

public class TC003_DataDriven extends BaseClas{
	
	@Test(dataProvider = "LoginData", dataProviderClass=DataProviders.class, groups = "DataDriven")//if we get data provider from different class so we need to to give dataProviderClass
	
	public void verifyloginDDT(String email, String Pwd, String exp) {
		logger.info("***TC003_DataDriven Testcase started *****");
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickSignup();
		
		LoginPage lp = new LoginPage(driver);
		lp.loginPassword(Pwd);
		lp.loginEmail(email);
		lp.loginButton();
		
		MyAccountPage map = new MyAccountPage(driver);
		boolean targetpage = map.isHomePageExit();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetpage == true)
			{	
				map.clickLogout();
			   Assert.assertTrue(true);
			}
			else 
			{
				Assert.assertTrue(false );
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetpage == false)
			{	
				map.clickLogout();
			   Assert.assertTrue(false);
			}
			else 
			{
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***TC003_DataDriven Testcase Ended *****");
	}
		

}
