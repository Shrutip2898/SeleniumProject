package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import pageObject.SignupPage;
import testBase.BaseClas;

public class TC001_AccountRegistrationPage extends BaseClas{
	

	
	@Test(groups = {"Regression", "Master"})
	public void Verify_account_registration()
	{
		
		logger.info("***** Starting TC001_AccountRegistrationTest  ****");
		logger.debug("This is a debug log message");
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickSignup();
		
		SignupPage sp = new SignupPage(driver);
		sp.sighupName(randomString().toUpperCase());
		sp.sighupEmail(randomString()+"@gmail.com");
		sp.sighupButton();
		
		AccountRegistrationPage ar = new AccountRegistrationPage(driver);
		ar.selectGender();
		ar.giveFirstName(randomString().toUpperCase());
		ar.giveLastName(randomString1().toUpperCase());
		ar.givePassword(randomAlphaNumberic());
		ar.selectDOB();
		ar.selectMonth();
		ar.selectYear();
		ar.giveAddress("PO Box-207  abc");
		ar.giveCity("Mumbai");
		ar.giveState("Maharastra");
		ar.giveZipcode(randomNumber1());
		ar.giveMobilNo(randomNumber());
		ar.clickSubmit();
			
	
	}
	catch (Exception e)
	{
		logger.error("Test failed: " + e.getMessage());
		Assert.fail("Test failed: " + e.getMessage());
	} 
	
	logger.info("***** Finished TC001_AccountRegistrationTest *****");
	
	}

}
