package login;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.Base.TestBase;
import com.qa.pages.Android.LoginPage;

public class Login extends TestBase {
	LoginPage login;
	
/*	@BeforeMethod
	public void setup() {
		AppiumUtils.preSetup("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
	}
*/	
	@Test
	public void FillForm_PositiveFlow() {
		login = new LoginPage(driver);
		login.selectCountry("Australia");
		login.setNameField("nikkil");
		login.setGender("male");
		login.submitForm();
	}
	
	@Test
	public void FillForm_ErrorValidation() {
		login = new LoginPage(driver);
		login.selectCountry("Australia");
		login.setGender("male");
		login.submitForm();
		String message = login.toastMessage();
		Assert.assertEquals(message, "Please enter your name");
	}

}
