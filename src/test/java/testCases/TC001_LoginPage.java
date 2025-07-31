package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClas;

public class TC001_LoginPage extends BaseClas{
	
	
	@Test(groups = {"Sanity", "Master"})
	public void Verify_Login()
	{
		
		logger.info("***** Starting TC001_AccountRegistrationTest  ****");
		logger.debug("This is a debug log message");
		try
		{
			HomePage hp = new HomePage(driver);
			hp.clickSignup();
			
			LoginPage lp = new LoginPage(driver);
			lp.loginPassword(p.getProperty("password"));
			lp.loginEmail(p.getProperty("email"));
			lp.loginButton();
			
			MyAccountPage map = new MyAccountPage(driver);
			boolean targetpage = map.isHomePageExit();
			Assert.assertEquals(targetpage, true,"Login Failed" );
			map.clickLogout();		
		}
		catch (Exception e)
		{
			
			Assert.fail();
		} 
		
		logger.info("***** Finished TC001_AccountRegistrationTest *****");
	}

}
