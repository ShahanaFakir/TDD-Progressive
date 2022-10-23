package com.progressive.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.google.common.io.Files;
import com.progressive.reporting.Loggers;

public class CommonFunctions {
	WebDriver driver;
	CommonWaits waits;

	public CommonFunctions(WebDriver driver, CommonWaits waits) {
		this.driver = driver;
		this.waits = waits;
	}

	public void clickElement(WebElement element) {
		try {
			waits.waitUntilClickable(element);
			element.click();
			Loggers.getLog(element + " : This element has been clicked");

		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.getLog(element + " : This element is not found");
			Assert.fail();

		}

	}

	public String getText(WebElement element) {
		String valueString = null;
		try {
			valueString = element.getText();
			Loggers.getLog(element + " :has value --->" + valueString);

		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.getLog(element + " : This element is not found");
			Assert.fail();

		}
		return valueString;

	}

	public String getCurrentUrl(WebDriver driver) {
		Loggers.getLog("Current URL is: " + driver.getCurrentUrl());
		return driver.getCurrentUrl();
	}

	public void inputValues(WebElement element, String value) {
		try {
			element.sendKeys(value);
			Loggers.getLog(value + " : This value has beed passed into--->" + element);

		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.getLog(element + " : This element is not found");
			Assert.fail();
		}
	}

	public void clear(WebElement element) {
		try {
			element.clear();
			Loggers.getLog("Value has been cleared from this element ---> " + element);
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.getLog(element + " : This element is not found");
			Assert.fail();
		}
	}

	public void selectDropdownByValue(WebElement element, String value) {
		try {
			Select select = new Select(element);
			Thread.sleep(500);
			select.selectByValue(value);
			Loggers.getLog(value + " : This value has been passed into this element ---> " + element);
		} catch (NullPointerException | NoSuchElementException | InterruptedException e) {
			e.printStackTrace();
			Loggers.getLog(element + " : This element is not found");
			Assert.fail();
		}

	}

	public String getScreenshot(String testName) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("MMddyyyy_hh.mm.ss");
		String extension = format.format(date);
		File file = new File("screenShots/" + testName + "_" + extension + ".png");
		TakesScreenshot ss = (TakesScreenshot) driver;
		File outPutFile = ss.getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(outPutFile, file.getAbsoluteFile());
			Loggers.getLog("Test has been failed \nScreenshot taken here ---> " + file.getAbsolutePath());
		} catch (Exception e) {
			e.printStackTrace();
			Loggers.getLog("Error while taking screenshot");
		}
		return file.getAbsolutePath();
	}

}
