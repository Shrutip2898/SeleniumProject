package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends BasePage{

	public SignupPage(WebDriver driver) {
		super(driver);
		
	}
	
@FindBy(xpath = "//input[@data-qa = 'signup-name']")
WebElement giveName;

@FindBy(xpath = "//input[@data-qa = 'signup-email']")
WebElement giveEmail;

@FindBy(xpath = "//button[@data-qa = 'signup-button']")
WebElement clickButton;

public void sighupName(String fname)
{
	giveName.sendKeys(fname);	
}

public void sighupEmail(String email)
{
	giveEmail.sendKeys(email);	
}

public void sighupButton()
{
	clickButton.click();
}
}
