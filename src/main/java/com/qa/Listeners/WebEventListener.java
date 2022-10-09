package com.qa.Listeners;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.support.events.WebDriverListener;

public class WebEventListener implements WebDriverListener  {
	
	@Override
	public void afterClick(WebElement element) {
		System.out.println("Clicked on "+element);
	}
	
	@Override
	public void afterClear(WebElement element) {
		System.out.println("Cleared on "+element);
	}
	
	@Override
	public void afterBack(Navigation navigation) {
		System.out.println("Navigating back to "+navigation);
	}
	
	@Override
	public void afterForward(Navigation navigation) {
		System.out.println("Navigating forward to "+navigation);
	}

}
