package com.progressive.test.auto;

import org.testng.annotations.Test;
import com.progressive.base.BaseClass;

public class Autoclass extends BaseClass {

	@Test
	public void getAutoQuote() throws InterruptedException {
		homePage.homePageSteps();
		aboutP.aboutPSteps("AUTO", "https://www.progressive.com/#l", "11377");
		birthdatePage.birthdatePageStep("Alex", "D", "Rodriguez", "01/05/1984", "5920 Woodside Avenue");

	}

}
