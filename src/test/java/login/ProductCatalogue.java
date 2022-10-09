package login;

import org.openqa.selenium.support.PageFactory;

import com.qa.Base.TestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCatalogue extends TestBase {
	private AppiumDriver driver;
	
	public ProductCatalogue(AppiumDriver driver) {
		super();
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

}
