package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath = "//input[@data-qa = 'login-password']")
	WebElement givePassword;

	@FindBy(xpath = "//input[@data-qa = 'login-email']")
	WebElement giveEmail;

	@FindBy(xpath = "//button[@data-qa = 'login-button']")
	WebElement clickButton;

	public void loginPassword(String fname)
	{
		givePassword.sendKeys(fname);	
	}

	public void loginEmail(String email)
	{
		giveEmail.sendKeys(email);	
	}

	public void loginButton()
	{
		clickButton.click();
	}
	}


