package com.progressive.test.home;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.progressive.base.BaseClass;
import com.progressive.utils.AutoData;
import com.progressive.utils.ExcelUtil;

public class AutoTestExcelAutoData extends BaseClass {

	@DataProvider(name = "excelAutoData")
	public Iterator<AutoData> autoData() {
		String pathString = configuration.get("excelPath");
		String sheetNameString = configuration.get("excelSheet");
		ExcelUtil excelUtil = new ExcelUtil(pathString, sheetNameString);
		String[][] objects = excelUtil.dataObjects();
		List<AutoData> list = new ArrayList<AutoData>();
		for (int i = 0; i < objects.length; i++) {
			AutoData autoData = new AutoData(objects[i][0], objects[i][1], objects[i][2], objects[i][3], objects[i][4],
					objects[i][5], objects[i][6], objects[i][7]);
			list.add(autoData);
		}
		return list.iterator();
	}

	@Test(enabled = true, dataProvider = "excelAutoData")
	public void getAutoAndHomeQuote(AutoData autoData) throws InterruptedException {
		homePage.homePageAutoAndHomeSteps();
		aboutAutoAndHomePage.aboutAutoAndHomeSteps(autoData);
		birthdatePage.autoAndHomebirthdatePageStep(autoData);

	}

}
