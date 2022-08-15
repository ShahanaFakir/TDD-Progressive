package com.progressive.test.home;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.progressive.base.BaseClass;

public class AutoAndHomeTestParameter extends BaseClass{
	
	
	@Parameters("zip")
	@Test(enabled = true)
	public void getAutoAndHomeQuote(String zip) throws InterruptedException {
		homePage.homePageAutoAndHomeSteps();
		aboutAutoAndHomePage.aboutAutoAndHomeSteps(zip);
		birthdatePage.autoAndHomebirthdatePageStep("Samantha", "A", "Rosario", "02/02/1988", "61-20 Woodside Avenue",
				"5C", "Queens", "11377");

	}

}
