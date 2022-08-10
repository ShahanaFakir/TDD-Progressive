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
	
	//@FindBy(xpath = "//input[@id='VehiclesNew_embedded_questions_list_AntilockBrakes_Y']")
	//WebElement euippedWithAntiLongBrakesElement;
	
	private void getTitle(String expected) {
		assertEquals(commons.getText(titElement), expected);
	}
	
	
	private void selectYear(String value) {
		commons.selectDropdownByValue(yearElement, value);
	}
	
	private void selectMake(String value1) {
		commons.selectDropdownByValue(makElement, value1);
	}
	
	private void selectModel(String value2) {
		commons.selectDropdownByValue(modelElement, value2);
	}
	
	private void selectPrimaryUse(String value3) {
		commons.selectDropdownByValue(primaryUsElement, value3);
	}
	
	private void selectOwnOrLease(String value4) {
		commons.selectDropdownByValue(ownOrLeasElement, value4);
	}
	
	private void selectHowLonghaveYouHadThisVehicle(String value5) {
		commons.selectDropdownByValue(howLongHaveYouHadThisVehiclElement, value5);
	}
	
	private void selectTypeOfSecurityAlarm(String value6) {
		commons.selectDropdownByValue(typeOfSecurityElement, value6);
	}
	
	private void clickDone() {
		commons.clickElement(doneElement);
	}
	
	

	public void aboutVehiclePageSteps(String expected,  String value, String value1,String value2, String value3,String value4, String value5,String value6
			) {
		getTitle(expected);
		selectYear(value);
		selectMake(value1);
		selectModel(value2);
		selectPrimaryUse(value3);
		selectOwnOrLease(value4);
		selectOwnOrLease(value4);
		selectHowLonghaveYouHadThisVehicle(value5);
		selectHowLonghaveYouHadThisVehicle(value5);
		selectHowLonghaveYouHadThisVehicle(value5);
		selectTypeOfSecurityAlarm(value6);
		clickDone();
		
		
	}
	
	
}
