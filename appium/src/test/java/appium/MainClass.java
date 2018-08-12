package appium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MainClass {

	@Test
	public void mainTest() throws Exception {

		String apkPath = "./src/main/resources/apk/ApiDemos-debug.apk";
		File apkFile = new File(apkPath);

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		// desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
		// "Nexus_S_API_23");
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
				"Nexus_4_API_27");
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
				apkFile.getAbsolutePath());

		AndroidDriver androidDriver = new AndroidDriver(new URL(
				"http://127.0.0.1:4723/wd/hub/"), desiredCapabilities);
		androidDriver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);

		// find element using xpath and click on it
		androidDriver.findElement(
				By.xpath(".//android.widget.TextView[@text='Preference']"))
				.click();

		androidDriver
				.findElement(
						By.xpath(".//android.widget.TextView[contains(@content-desc,'3. Preference dependencies')]"))
				.click();

		androidDriver.findElement(By.id("android:id/checkbox")).click();

		androidDriver.findElement(
				By.xpath(".//android.widget.TextView[@text='WiFi settings']"))
				.click();

		androidDriver.findElement(By.className("android.widget.EditText"))
				.sendKeys("Boob");

		// androidDriver.findElement(
		// By.xpath(".//*[@resource-id='android:id/button1']")).click();

		androidDriver.findElement(MobileBy.AndroidUIAutomator("text(\"OK\")"))
				.click();
	}
}
