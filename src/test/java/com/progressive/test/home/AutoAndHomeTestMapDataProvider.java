package com.progressive.test.home;

import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.progressive.base.BaseClass;
import com.progressive.utils.ExcelUtil;

public class AutoAndHomeTestMapDataProvider extends BaseClass {

	@DataProvider(name = "excelMap")
	public Object[][] mapData() {
		String pathString = configuration.getConfiguration("excelPath");
		String sheetNameString = configuration.getConfiguration("excelSheetMap");
		ExcelUtil excelUtil = new ExcelUtil(pathString, sheetNameString);
		int size = excelUtil.dataMap().size();
		Object[][] objects2D = new Object[size][1];
		for (int i = 0; i < size; i++) {
			objects2D[i][0] = excelUtil.dataMap().get(i);
		}
		return objects2D;
	}

	@Test(dataProvider = "excelMap")
	public void autoDataWithMapDataProvider(Map<String, String> map) throws InterruptedException {
		homePage.homePageAutoAndHomeSteps();
		aboutAutoAndHomePage.aboutAutoAndHomeSteps(map.get("Zip Code"));
		birthdatePage.autoAndHomebirthdatePageStep(map.get("First Name"), map.get("Mi Name"), map.get("Last Name"),
				map.get("DOB"), map.get("Address"), map.get("Apt No"), map.get("City"), map.get("Zip Code"));
	}

}
