package com.watsapp;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WatsappClass extends AbstractBaseClass{
	
	protected AndroidDriver<WebElement> driver;
	
  @Test
  public void launchingWatsapp() throws MalformedURLException {
	  	  
	  //startAppiumServer();
	  driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilitiesMethod());
	  stopServer();
  }
  
}