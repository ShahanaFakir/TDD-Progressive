package com.progressive.common;

import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.progressive.reporting.Loggers;

public class Commons {

	public void clickElement(WebElement element) {
		try {
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

}
