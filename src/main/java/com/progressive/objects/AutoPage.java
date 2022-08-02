package com.progressive.objects;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.progressive.common.CommonFunctions;

public class AutoPage {
	WebDriver driver;
	CommonFunctions commons;

	public AutoPage(WebDriver driver, CommonFunctions commons) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.commons = commons;

	}

	@FindBy(id = "quote-title")
	WebElement titlElement;

	@FindBy(xpath = "//input[@id='zipCode_overlay']")
	WebElement zipCodElement;

	@FindBy(xpath = "(//button[@data-action='AU+H'])[1]")
	WebElement homeButtonElement;

	@FindBy(xpath = "//input[@id='qsButton_overlay']")
	WebElement getAQuotElement;

	private void getTitle(String expected) {
		assertEquals(commons.getText(titlElement), expected);

	}

	private void getCurrentUrl(String expectedUrl) {
		assertEquals(expectedUrl, commons.getCurrentUrl(driver));

	}

	private void inputZipCode(String value) {
		commons.inputValues(zipCodElement, value);
	}

	private void clickHomeButton() {
		commons.clickElement(homeButtonElement);
	}

	private void clickGetAQuote() {
		commons.clickElement(getAQuotElement);

	}

	public void aboutPSteps(String expected, String expectedUrl, String value) {
		getTitle(expected);
		getCurrentUrl(expectedUrl);
		inputZipCode(value);
		clickHomeButton();
		clickGetAQuote();

	}

}
