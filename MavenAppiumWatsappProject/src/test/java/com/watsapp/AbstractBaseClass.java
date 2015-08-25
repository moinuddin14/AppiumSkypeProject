package com.watsapp;

import io.appium.java_client.android.AndroidDriver;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AbstractBaseClass {

	protected String appPath = System.getProperty("user.dir")+"/appswhatsapp-2.12.176.apk";
	protected DesiredCapabilities capabilities;
	//protected AndroidDriver<WebElement> driver;

	public void startAppiumServer() {

		CommandLine command = new CommandLine("cmd");
		command.addArgument("/c");
		command.addArgument("C:\\Appium\\Appium\\node.exe");
		command.addArgument("C:\\Appium\\Appium\\node_modules\\appium\\bin\\appium.js");
		command.addArgument("--address");
		command.addArgument("127.0.0.1");
		command.addArgument("--port");
		command.addArgument("4724");
		command.addArgument("--no-reset");
		command.addArgument("--log");
		command.addArgument("D:/appiumLogs.txt");
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);

		try {
			executor.execute(command, resultHandler);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void stopServer() {
		CommandLine command = new CommandLine("cmd");
		command.addArgument("/c");
		command.addArgument("taskkill");
		command.addArgument("/F");
		command.addArgument("/IM");
		command.addArgument("node.exe");

		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);

		try {
			executor.execute(command, resultHandler);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	public void desiredCapabilitiesMethod(String browser, AndroidDriver<WebElement> driver) throws MalformedURLException {

		switch (browser) {

		case "chrome":
			capabilities = new DesiredCapabilities();
			capabilities.setCapability("automationName", "Appium");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("platformVersion", "4.4.4");
			capabilities.setCapability("deviceName",
					"Samsung Galaxy S5 - 4.4.4 - API 19 - 1080x1920");
			capabilities.setCapability("app", appPath);
			capabilities.setCapability("appPackage", "com.whatsapp");
			capabilities.setCapability("appActivity", "com.whatsapp.Main");

		default:
			capabilities = new DesiredCapabilities();
			capabilities.setCapability("automationName", "Appium");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("platformVersion", "");
			capabilities.setCapability("deviceName",
					"Samsung Galaxy S5 - 4.4.4 - API 19 - 1080x1920");
			capabilities.setCapability("app", appPath);
			capabilities.setCapability("appPackage", "");
			capabilities.setCapability("appActivity", "");
		}
		
		driver = new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
	}
}