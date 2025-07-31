package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	

@FindBy(xpath = "//input[@id = 'id_gender2']")
WebElement gender;

@FindBy(xpath = "//input[@data-qa = 'password']")
WebElement password;

@FindBy(xpath = "//select[@data-qa = 'days']/option[@value = '10']")
WebElement selectDate;


@FindBy(xpath = "//select[@data-qa = 'months']/option[@value = '7']")
WebElement selectMonth;

@FindBy(xpath = "//select[@data-qa = 'years']/option[@value = '2002']")
WebElement selectYear;

@FindBy(xpath = "//input[@data-qa = 'first_name']")
WebElement firstName;

@FindBy(xpath = "//input[@data-qa = 'last_name']")
WebElement lastName;


@FindBy(xpath = "//input[@data-qa = 'address']")
WebElement address;


@FindBy(xpath = "//input[@data-qa = 'state']")
WebElement state;

@FindBy(xpath = "//input[@data-qa = 'city']")
WebElement city;

@FindBy(xpath = "//input[@data-qa = 'zipcode']")
WebElement zipcode;

@FindBy(xpath = "//input[@data-qa = 'mobile_number']")
WebElement mobilNo;

@FindBy(xpath = "//button[@type = 'submit']")
WebElement submitButton;

@FindBy(xpath = "//b[normalize-space() = 'Account Created!']")
WebElement msgConfirmation;

public void selectGender()
{
	gender.click();	
}

public void givePassword(String pwd)
{
	password.sendKeys(pwd);	
}

public void selectDOB()
{
	selectDate.click();
}

public void selectMonth()
{
	selectMonth.click();
}

public void selectYear()
{
	selectYear.click();
}

public void giveFirstName(String fname)
{
	firstName.sendKeys(fname);	
}

public void giveLastName(String lname)
{
	lastName.sendKeys(lname);	
}

public void giveAddress(String Uaddress)
{
	address.sendKeys(Uaddress);	
}

public void giveState(String Ustate)
{
	state.sendKeys(Ustate);	
}


public void giveCity(String Ucity)
{
	city.sendKeys(Ucity);	
}

public void giveZipcode(String Uzipcode)
{
	zipcode.sendKeys(Uzipcode);	
}

public void giveMobilNo(String UMobilNo)
{
	mobilNo.sendKeys(UMobilNo);	
}

public void clickSubmit()
{
	submitButton.click();	
}

public String getConfirmationMsg() {
	try {
		return (msgConfirmation.getText());
	} catch (Exception e) {
		return (e.getMessage());

	}
}

}
