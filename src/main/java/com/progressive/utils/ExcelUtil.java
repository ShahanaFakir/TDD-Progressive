package com.progressive.utils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.progressive.reporting.Loggers;

public class ExcelUtil {
	Workbook workbook;
	Sheet sheet;

	FileInputStream fileInputStream;

	public ExcelUtil(String path, String sheetName) {
		try {
			fileInputStream = new FileInputStream(path);
		} catch (Exception e) {
			e.printStackTrace();

			Loggers.getLog("File not found in ---> " + path);
		}
		if (path.endsWith(".xls")) {
			try {
				workbook = new HSSFWorkbook(fileInputStream);
				fileInputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
				Loggers.getLog("File not found in ---> " + path);
			}

		} else if (path.endsWith(".xlsx")) {
			try {
				workbook = new XSSFWorkbook(fileInputStream);
				fileInputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
				Loggers.getLog("File not found in ---> " + path);
			}
		}
		sheet = workbook.getSheet(sheetName);
	}

	public String[][] dataObjects() {
		String[][] data = null;
		int yRowsNumber = 0;
		int totalCellNumber = sheet.getRow(0).getLastCellNum() - 2;

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			try {
				if (sheet.getRow(i).getCell(1).getStringCellValue().equalsIgnoreCase("Y")) {
					yRowsNumber++;

				}
			} catch (NullPointerException e) {
			}
		}
		data = new String[yRowsNumber][totalCellNumber];

		int row = 0;
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			try {
				if (sheet.getRow(i).getCell(1).getStringCellValue().equalsIgnoreCase("Y")) {
					for (int j = 2; j < sheet.getRow(i).getLastCellNum(); j++) {
						String value = sheet.getRow(i).getCell(j).getStringCellValue();
						data[row][j - 2] = value;
					}
					row++;

				}
			} catch (NullPointerException e) {

			}
		}
		return data;
	}

	public Map<Integer, Map<String, String>> dataMap() {
		Map<Integer, Map<String, String>> maps = new HashMap<Integer, Map<String, String>>();
		int yRows = 0;
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Map<String, String> map = new HashMap<String, String>();

			for (int j = 1; j < sheet.getRow(0).getLastCellNum(); j++) {
				try {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				} catch (NullPointerException | IllegalStateException e) {

				}
			}
			try {
				if (map.get("Execution").equalsIgnoreCase("Y")) {
					maps.put(yRows, map);
					yRows++;

				}
			} catch (NullPointerException e) {

			}
		}
		return maps;

	}

}
