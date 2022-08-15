package com.progressive.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.progressive.common.CommonFunctions;
import com.progressive.utils.AutoData;

public class AutoAndHomePage {
	WebDriver driver;
	CommonFunctions commons;

	public AutoAndHomePage(WebDriver driver, CommonFunctions commons) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.commons = commons;
	}

	@FindBy(xpath = "//input[@id='zipCode_overlay']")
	WebElement zipCodElement;

	@FindBy(xpath = "//input[@id='qsButton_overlay']")
	WebElement getAQuotElement;

	private void inputZipCode(String value) {
		commons.inputValues(zipCodElement, value);
	}

	private void clickGetAQuote() {
		commons.clickElement(getAQuotElement);

	}

	public void aboutAutoAndHomeSteps(String value) {
		inputZipCode(value);
		clickGetAQuote();

	}
	
	public void aboutAutoAndHomeSteps(AutoData autoData) {
		inputZipCode(autoData.getZipCode());
		clickGetAQuote();

	}

}
