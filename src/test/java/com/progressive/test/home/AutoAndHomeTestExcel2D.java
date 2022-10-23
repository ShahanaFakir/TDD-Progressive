package com.progressive.test.home;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.progressive.base.BaseClass;
import com.progressive.utils.ExcelUtil;

public class AutoAndHomeTestExcel2D extends BaseClass {

	@DataProvider(name = "autoAndHomeData2DExcel")

	public Object[][] autoAndHomeData() {
		String pathString = configuration.get("excelPath");
		String sheetNameString = configuration.get("excelSheet");
		ExcelUtil excelUtil = new ExcelUtil(pathString, sheetNameString);
		return excelUtil.dataObjects();
	}

	@Test(enabled = true, dataProvider = "autoAndHomeData2DExcel")
	public void getAutoAndHomeQuote(String firstName, String miName, String lastName, String dob, String address,
			String aptNo, String cityName, String zipCode) throws InterruptedException {
		homePage.homePageAutoAndHomeSteps();
		aboutAutoAndHomePage.aboutAutoAndHomeSteps(zipCode);
		birthdatePage.autoAndHomebirthdatePageStep(firstName, miName, lastName, dob, address, aptNo, cityName, zipCode);

	}

}
