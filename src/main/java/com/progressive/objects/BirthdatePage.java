package com.progressive.objects;

import static com.progressive.utils.DataMap.*;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.progressive.common.CommonFunctions;
import com.progressive.utils.AutoData;

public class BirthdatePage {
	WebDriver driver;
	CommonFunctions commons;

	public BirthdatePage(WebDriver driver, CommonFunctions commons) {
		PageFactory.initElements(driver, this);
		this.commons = commons;

	}

	@FindBy(id = "NameAndAddressEdit_embedded_questions_list_FirstName")
	WebElement firstNameElement;
	@FindBy(id = "NameAndAddressEdit_embedded_questions_list_MiddleInitial")
	WebElement miElement;
	@FindBy(id = "NameAndAddressEdit_embedded_questions_list_LastName")
	WebElement lastNameElement;
	@FindBy(id = "NameAndAddressEdit_embedded_questions_list_DateOfBirth")
	WebElement dobElement;
	@FindBy(id = "NameAndAddressEdit_embedded_questions_list_MailingAddress")
	WebElement addressElement;
	@FindBy(id = "NameAndAddressEdit_embedded_questions_list_ApartmentUnit")
	WebElement aptNoElement;
	@FindBy(id = "NameAndAddressEdit_embedded_questions_list_City")
	WebElement cityNameElement;
	@FindBy(id = "NameAndAddressEdit_embedded_questions_list_ZipCode")
	WebElement zipCodeElement;
	@FindBy(xpath = "//button[text()='Okay, start my quote.']")
	WebElement startMyQuoteElement;

	private void inputFirstName(String firstName) {
		commons.inputValues(firstNameElement, firstName);
	}

	private void inputMi(String miName) {
		commons.inputValues(miElement, miName);

	}

	private void inputLastName(String lastName) {
		commons.inputValues(lastNameElement, lastName);

	}

	private void inputDob(String dob) {
		commons.inputValues(dobElement, dob);

	}

	private void inputAddress(String address) {
		commons.inputValues(addressElement, address);

	}

	private void inputAptNo(String apt) {
		commons.inputValues(aptNoElement, apt);
	}

	private void inputCityName(String cityName) {
		commons.inputValues(cityNameElement, cityName);
	}

	private void inputZipCode(String zipCode) {
		commons.clear(zipCodeElement);
		commons.inputValues(zipCodeElement, zipCode);
	}

	private void clickOkayMyQuote() {
		commons.clickElement(startMyQuoteElement);
	}

	public void autoBirthdatePageStep(String firstName, String miName, String lastName, String dob, String address,
			String aptNo, String cityName, String zipCode) {
		inputFirstName(firstName);
		inputMi(miName);
		inputLastName(lastName);
		inputDob(dob);
		inputAddress(address);
		inputAptNo(aptNo);
		inputCityName(cityName);
		inputZipCode(zipCode);
		clickOkayMyQuote();
		inputAddress(address);
		inputAptNo(aptNo);
		inputCityName(cityName);
		clickOkayMyQuote();

	}
	
	
	public void autoAndHomebirthdatePageStep(Map<String, String> map) {
		inputFirstName(map.get(FirstName.getValue()));
		inputMi(map.get(MiName.getValue()));
		inputLastName(map.get(LastName.getValue()));
		inputDob(map.get(DOB.getValue()));
		inputAddress(map.get(Address.getValue()));
		inputAptNo(map.get(AptNo.getValue()));
		inputCityName(map.get(City.getValue()));
		inputZipCode(map.get(ZipCode.getValue()));
		clickOkayMyQuote();
		inputAddress(map.get(Address.getValue()));
		inputAptNo(map.get(AptNo.getValue()));
		inputCityName(map.get(City.getValue()));
		clickOkayMyQuote();

	}
	
	public void autoAndHomebirthdatePageStep(String firstName, String miName, String lastName, String dob, String address,
			String aptNo, String cityName, String zipCode) {
		inputFirstName(firstName);
		inputMi(miName);
		inputLastName(lastName);
		inputDob(dob);
		inputAddress(address);
		inputAptNo(aptNo);
		inputCityName(cityName);
		inputZipCode(zipCode);
		clickOkayMyQuote();
		inputAddress(address);
		inputAptNo(aptNo);
		inputCityName(cityName);
		clickOkayMyQuote();
		
	}
	
	public void autoAndHomebirthdatePageStep(AutoData autoData) {
		inputFirstName(autoData.getFirstName());
		inputMi(autoData.getMiName());
		inputLastName(autoData.getLastName());
		inputDob(autoData.getDob());
		inputAddress(autoData.getAddress());
		inputAptNo(autoData.getAptNo());
		inputCityName(autoData.getCityName());
		inputZipCode(autoData.getZipCode());
		clickOkayMyQuote();
		inputAddress(autoData.getAddress());
		inputAptNo(autoData.getAptNo());
		inputCityName(autoData.getCityName());
		clickOkayMyQuote();
		
	}


}
