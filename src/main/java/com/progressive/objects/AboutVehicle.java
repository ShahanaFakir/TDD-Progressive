package com.progressive.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.progressive.common.CommonFunctions;

public class AboutVehicle {
	WebDriver driver;
	CommonFunctions commons;

	public void aboutVehiclePage(WebDriver driver, CommonFunctions commons) {
		PageFactory.initElements(driver, this);
		this.commons = commons;

	}

}
