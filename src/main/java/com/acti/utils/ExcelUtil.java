package com.acti.utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	XSSFWorkbook wb;

	/*
	 * This constructor help us to load the excel file when this class is called
	 */

	public ExcelUtil(String excelpath) {
		try {
			File src = new File(excelpath);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("unable to load the excel sheet please check the path " + e.getMessage());
		}
	}

	// this method is used to get the active rows from the excel sheet
	public int getActiveRows(int sheetnum) {

		int rows = wb.getSheetAt(sheetnum).getLastRowNum()  +1;
		return rows;

	}

	// This method is used to get the data from excel cells
	public String getCellData(int sheetnum, int row, int col) {

		String data = wb.getSheetAt(sheetnum).getRow(row).getCell(col).toString();
		return data;
	}
}
