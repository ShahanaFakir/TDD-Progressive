package com.progressive.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.progressive.common.Commons;

public class HomePage {

	Commons commons;

	public HomePage(WebDriver driver, Commons commons) {
		PageFactory.initElements(driver, this);
		this.commons = commons;

	}

	// @FindBy(xpath = "//p[@class='txt' and normalize-space(text())='Auto']")
	@FindBy(xpath = "(//span[text()='Auto'])[1] | //p[@class='txt' and normalize-space(text())='Auto']")
	WebElement autoElement;

	private void AutoElement() throws InterruptedException {
		commons.clickElement(autoElement);
		Thread.sleep(5000);

	}

	public void homePageSteps() throws InterruptedException {
		AutoElement();

	}

}
