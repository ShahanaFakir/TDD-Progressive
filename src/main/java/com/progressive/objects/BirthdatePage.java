package com.progressive.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.progressive.common.Commons;

public class BirthdatePage {
	WebDriver driver;
	Commons commons;

	public BirthdatePage(WebDriver driver, Commons commons) {
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

	public void birthdatePageStep(String firstName, String miName, String lastName, String dob, String address) {
		inputFirstName(firstName);
		inputMi(miName);
		inputLastName(lastName);
		inputDob(dob);
		inputAddress(address);

	}

}
