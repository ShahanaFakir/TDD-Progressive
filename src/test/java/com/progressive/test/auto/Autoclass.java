package com.progressive.test.auto;

import org.testng.annotations.Test;
import com.progressive.base.BaseClass;

public class AutoClass extends BaseClass {

	@Test
	public void getAutoQuote() throws InterruptedException {
		homePage.homePageAutoSteps();
		aboutP.aboutPSteps("AUTO", "https://www.progressive.com/#l", "11377");
		birthdatePage.autoBirthdatePageStep("Alex", "D", "Rodriguez", "01/05/1984", "59-16 Woodside Avenue", "3B", "Queens",
				"11377");
		aboutVehiclePage.aboutVehiclePageSteps("Tell us about your vehicle(s)...", "2012", "TOYOTA","COROLLA", "4TNC", "3",
				"C","N");

	}
	

}
