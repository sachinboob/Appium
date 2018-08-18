package appium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MainClass {

	public AndroidDriver<AndroidElement> androidDriver = null;

	@Before
	public void setUp() throws Exception {
		String apkPath = "./src/main/resources/apk/ApiDemos-debug.apk";
		File apkFile = new File(apkPath);

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		// desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
		// "Nexus_S_API_23");
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
				"Nexus_4_API_27");
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
				apkFile.getAbsolutePath());

		androidDriver = new AndroidDriver<AndroidElement>(new URL(
				"http://127.0.0.1:4723/wd/hub/"), desiredCapabilities);
		androidDriver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
	}

	@Test
	public void mainTest() throws Exception {

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

		androidDriver.findElement(MobileBy.AndroidUIAutomator("text(\"OK\")"))
				.click();
	}

	@Test
	public void gestures_longPress() throws Exception {

		// find "Views" from list items and click on it

		// androidDriver
		// .findElement(
		// By.xpath(".//android.widget.TextView[contains(@text='Views')]"))
		// .click();

		TouchAction touchAction = new TouchAction(androidDriver);
		// touchAction.tap(androidDriver.findElementByXPath(".//android.widget.TextView[contains(@text='Views')]"));

		// Views
		touchAction
				.tap(TapOptions
						.tapOptions()
						.withElement(
								ElementOption.element(androidDriver
										.findElementByXPath(".//android.widget.TextView[@text='Views']"))))
				.perform();

		// Expandable Lists
		touchAction
				.tap(TapOptions
						.tapOptions()
						.withElement(
								ElementOption.element(androidDriver
										.findElementByXPath(".//android.widget.TextView[@text='Expandable Lists']"))))
				.perform();

		// Custom Adapter
		touchAction
				.tap(TapOptions
						.tapOptions()
						.withElement(
								ElementOption.element(androidDriver
										.findElementByXPath(".//android.widget.TextView[@text='1. Custom Adapter']"))))
				.perform();

		// People Names
		touchAction
				.longPress(
						LongPressOptions
								.longPressOptions()
								.withElement(
										ElementOption.element(androidDriver
												.findElementByXPath(".//android.widget.TextView[@text='People Names']"))))
				.perform();

	}

	@Test
	public void gestures_swipe() throws Exception {

		TouchAction touchAction = new TouchAction(androidDriver);

		// Views
		touchAction
				.tap(TapOptions
						.tapOptions()
						.withElement(
								ElementOption.element(androidDriver
										.findElementByXPath(".//android.widget.TextView[@text='Views']"))))
				.perform();

		// date widgets
		touchAction
				.tap(TapOptions
						.tapOptions()
						.withElement(
								ElementOption.element(androidDriver
										.findElementByXPath(".//android.widget.TextView[@text='Date Widgets']"))))
				.perform();

		// inline
		touchAction
				.tap(TapOptions
						.tapOptions()
						.withElement(
								ElementOption.element(androidDriver
										.findElementByXPath(".//android.widget.TextView[@text='2. Inline']"))))
				.perform();

		// tap on 3
		touchAction
				.tap(TapOptions
						.tapOptions()
						.withElement(
								ElementOption.element(androidDriver
										.findElementByXPath(".//*[@content-desc='3']"))))
				.perform();

		// swipet to left
		touchAction
				.press(PointOption
						.point(androidDriver
								.findElementByXPath(".//*[@content-desc='45']").getLocation().getX()
								,
								androidDriver
										.findElementByXPath(
												".//android.widget.TextView[@content-desc='45']")
								.getLocation().getY()))
				.perform();

	}

}
