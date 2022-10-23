package com.progressive.test.auto;

import org.testng.annotations.Test;

import com.progressive.base.BaseClass;

public class AutoClassNormalization extends BaseClass {

	@Test(enabled = true, priority = 1)
	public void getAutoQuote() throws InterruptedException {
		homePage.homePageAutoSteps();
		aboutP.aboutPSteps("AUTO", "https://www.progressive.com/#l", "11377");

	}

	@Test(enabled = true, priority = 2)
	public void getAutoQuote01() throws InterruptedException {
		homePage.homePageAutoSteps();
		aboutP.aboutCondoSteps("AUTO", "https://www.progressive.com/#l", "11375");

	}

}
