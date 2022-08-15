package com.progressive.test.home;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.progressive.base.BaseClass;
import com.progressive.utils.AutoData;

public class AutoAndHomeDataClass extends BaseClass {
	
	@DataProvider(name = "autoDataIterator")
	public Iterator<AutoData> autoDataIterator() {
		
		List<AutoData>list = new ArrayList<AutoData>();
		AutoData autoData1 = new AutoData("Samantha", "A", "Rosario", "02/02/1988", "61-20 Woodside Avenue",
				"5C", "Queens", "11377");
		AutoData autoData2 = new AutoData("Jose", "D", "Cruz", "03/01/1987", " 58-20 Roosevelt Avenue",
				"4A", "Queens", "11377");
		list.add(autoData1);
		list.add(autoData2);
		return list.iterator();
	}
	
	@DataProvider(name = "autoDataObject")
	public Object[][] autoDataObject() {
		
		AutoData autoData1 = new AutoData("Roma", "F", "Gurung", "03/03/1991", "61-15 Woodside Avenue",
				"3B", "Queens", "11377");
		AutoData autoData2 = new AutoData("Sarai", "D", "Cuamani", "04/05/1985", " 59-14 Roosevelt Avenue",
				"2A", "Queens", "11377");
		return new Object[][] {{autoData1}, {autoData2}};
	}
	
	
	
	@Test(enabled = true, dataProvider = "autoDataObject")
	public void getAutoAndHomeQuote(AutoData autoData) throws InterruptedException {
		homePage.homePageAutoAndHomeSteps();
		aboutAutoAndHomePage.aboutAutoAndHomeSteps(autoData);
		birthdatePage.autoAndHomebirthdatePageStep(autoData);

	}

}
