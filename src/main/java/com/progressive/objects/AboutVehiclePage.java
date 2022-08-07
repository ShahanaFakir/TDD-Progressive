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

	public void aboutVehiclePageSteps(String expected,  String value, String value1,String value2) {
		getTitle(expected);
		selectYear(value);
		selectMake(value1);
		selectModel(value2);
	}
}
