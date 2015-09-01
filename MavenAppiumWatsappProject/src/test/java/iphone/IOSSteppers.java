package iphone;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import com.watsapp.AbstractBaseClass;

public class IOSSteppers extends AbstractBaseClass {

	protected IOSDriver<WebElement> driver;
	protected String appPath = System.getProperty("user.dir")
			+ "//apps//UICatalog.zip";
	protected DesiredCapabilities capabilities;
	protected final String UDID="f9e5efb721b2307100055d096a75fd7190a77e3a";

	@Test
	public void launchingWatsapp() throws IOException, InterruptedException {

		//stopAppiumServer();
		//startAppiumServer();

		capabilities = new DesiredCapabilities();
		capabilities.setCapability("automationName", "Appium");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "8.1");
		capabilities.setCapability("deviceName", "Khaja");
		capabilities.setCapability(MobileCapabilityType.APP, appPath);
		capabilities.setCapability("udid", UDID);
		capabilities.setCapability("bundleId", "apple-samplecode.UICatalog.test");
		capabilities.setCapability("autoAcceptAlerts", true);
		
		System.out.println("Trying to start the driver");
		driver = new IOSDriver<WebElement>(new URL(
				"http://127.0.0.1:4723/wd/hub"), capabilities);
		Thread.sleep(5000);
		System.out.println("Succesfully ");

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIANavigationBar[1]/UIAButton[1]")).click();
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")).click();
		
	}

}