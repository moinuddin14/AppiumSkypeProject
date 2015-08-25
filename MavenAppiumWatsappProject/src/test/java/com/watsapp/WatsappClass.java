package com.watsapp;

import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WatsappClass extends AbstractBaseClass{
	
	protected AndroidDriver<WebElement> driver;
	
  @Test
  public void launchingWatsapp() throws MalformedURLException {
	  	  
	  startAppiumServer();
	  desiredCapabilitiesMethod("chrome", driver);
	  stopServer();
  }
  
}