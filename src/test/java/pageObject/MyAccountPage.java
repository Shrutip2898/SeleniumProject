package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
@FindBy(xpath = "//i[@class =  'fa fa-home']")
WebElement Home;	

@FindBy(xpath = "//a[@href = '/logout']")
WebElement lnkLogout;

public boolean isHomePageExit() {
	try {
		return (Home.isDisplayed());
		}
		catch(Exception e)
		{
			return (false);
		}
}
	
public void clickLogout() {
	
		lnkLogout.click();
	}
	
}



