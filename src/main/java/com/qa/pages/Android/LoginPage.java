package com.qa.pages.Android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.Base.TestBase;
import com.qa.Utils.AndroidActions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;


public class LoginPage extends TestBase {
	private AppiumDriver driver;
	
	public LoginPage(AppiumDriver driver) {
		super();
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	@iOSXCUITFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	WebElement dropdown;
	
	@AndroidFindBy(id="android:id/text1")
	WebElement selectCountry;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	WebElement nameField;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
	private WebElement femaleOption;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
	private WebElement maleOption;
	
	@AndroidBy(id="com.androidsample.generalstore:id/btnLetsShop")
	WebElement shopBtn;
	
	@AndroidBy(xpath="(//android.widget.Toast)[1]")
	WebElement toast;
	
	
	public void selectCountry(String country) {
		dropdown.click();
		AndroidActions.scrollToText(country);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+country+"']")).click();
	}
	

	public void setNameField(String name)
	{
		nameField.sendKeys(name);
		((HidesKeyboard)driver).hideKeyboard();
		
	}
	
	public void setGender(String gender)
	{
		if (gender.contains("female"))
			femaleOption.click();
		else
			maleOption.click();
			
	}
	
	public void submitForm()
	{
		shopBtn.click();
//		return	new ProductCatalogue(driver);
		
	}
	
	public String toastMessage() {
		return toast.getAttribute("name");
	}
	
	

}
