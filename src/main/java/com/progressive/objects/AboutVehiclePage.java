package com.progressive.objects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.progressive.common.CommonFunctions;

public class AboutVehiclePage {
	WebDriver driver;
	CommonFunctions commons;

	public AboutVehiclePage(WebDriver driver, CommonFunctions commons) {
		PageFactory.initElements(driver, this);
		this.commons = commons;

	}

	@FindBy(xpath = "//h1[text()='Tell us about your vehicle(s)...']")
	WebElement titElement;

	@FindBy(xpath = "//select[@id='VehiclesNew_embedded_questions_list_Year']")
	WebElement yearElement;

	@FindBy(xpath = "//select[@id='VehiclesNew_embedded_questions_list_Make']")
	WebElement makElement;

	@FindBy(xpath = "//select[@id='VehiclesNew_embedded_questions_list_Model']")
	WebElement modelElement;

	@FindBy(xpath = "//select[@id='VehiclesNew_embedded_questions_list_VehicleUse']")
	WebElement primaryUsElement;

	@FindBy(xpath = "//select[@id='VehiclesNew_embedded_questions_list_OwnOrLease']")
	WebElement ownOrLeasElement;

	@FindBy(xpath = "//select[@id='VehiclesNew_embedded_questions_list_LengthOfOwnership']")
	WebElement howLongHaveYouHadThisVehiclElement;

	@FindBy(xpath = "//select[@id='VehiclesNew_embedded_questions_list_AntitheftDevice']")
	WebElement typeOfSecurityElement;

	@FindBy(xpath = "//button[text()='Done']")
	WebElement doneElement;

	// @FindBy(xpath =
	// "//input[@id='VehiclesNew_embedded_questions_list_AntilockBrakes_Y']")
	// WebElement euippedWithAntiLongBrakesElement;

	private void getTitle(String expectedTitle) {
		assertEquals(commons.getText(titElement), expectedTitle);
	}

	private void selectYear(String year) {
		commons.selectDropdownByValue(yearElement, year);
	}

	private void selectMake(String make) {
		commons.selectDropdownByValue(makElement, make);
	}

	private void selectModel(String model) {
		commons.selectDropdownByValue(modelElement, model);
	}

	private void selectPrimaryUse(String primaryUser) {
		commons.selectDropdownByValue(primaryUsElement, primaryUser);
	}

	private void selectOwnOrLease(String ownOrLease) {
		commons.selectDropdownByValue(ownOrLeasElement, ownOrLease);
	}

	private void selectHowLonghaveYouHadThisVehicle(String value) {
		commons.selectDropdownByValue(howLongHaveYouHadThisVehiclElement, value);
	}

	private void selectTypeOfSecurityAlarm(String securityAlarm) {
		commons.selectDropdownByValue(typeOfSecurityElement, securityAlarm);
	}

	private void clickDone() {
		commons.clickElement(doneElement);
	}

	public void aboutVehiclePageSteps(String expectedTitle, String year, String make, String model, String primaryUser,
			String ownOrLease, String value, String securityAlarm) {
		getTitle(expectedTitle);
		selectYear(year);
		selectMake(make);
		selectModel(model);
		selectPrimaryUse(primaryUser);
		selectOwnOrLease(ownOrLease);
		selectOwnOrLease(ownOrLease);
		selectHowLonghaveYouHadThisVehicle(value);
		selectHowLonghaveYouHadThisVehicle(value);
		selectHowLonghaveYouHadThisVehicle(value);
		selectTypeOfSecurityAlarm(securityAlarm);
		clickDone();

	}

}
