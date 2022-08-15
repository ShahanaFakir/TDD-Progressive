package com.progressive.test.home;

import org.testng.annotations.Test;
import com.progressive.base.BaseClass;

public class AutoAndHomeClass extends BaseClass {
	
	@Test(enabled = true)
	public void getAutoAndHomeQuote() throws InterruptedException {
		homePage.homePageAutoAndHomeSteps();
		aboutAutoAndHomePage.aboutAutoAndHomeSteps("11377");
		birthdatePage.autoAndHomebirthdatePageStep("Samantha", "A", "Rosario", "02/02/1988", "61-20 Woodside Avenue",
				"5C", "Queens", "11377");

	}

}
