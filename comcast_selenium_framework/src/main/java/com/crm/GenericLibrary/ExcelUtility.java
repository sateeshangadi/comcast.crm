package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/**
	 * this method is to read the date from excel
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws Throwable
	 */
	
	public String getDataFromExcel(String sheetname,int rownum,int cellnum) throws Throwable{
		FileInputStream fis=new FileInputStream(Ipathconstants.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		Row row = sh.getRow(rownum);
		String data = row.getCell(cellnum).getStringCellValue();
		wb.close();
		return data;
	}
	/**
	 * this method is to get the last used row number from the specified sheet
	 * @param sheetname
	 * @return
	 * @throws Throwable
	 */
	
	public int getRowCount(String sheetname) throws Throwable{
		FileInputStream fis=new FileInputStream(Ipathconstants.excelpath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int count = sh.getLastRowNum();
		wb.close();
		return count;
	}
	/**
	 * this method is used to write the data into excel
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @param data
	 * @throws Throwable
	 */
	public void setDataExcel(String sheetname,int rownum,int cellnum,String data) throws Throwable
	{
		FileInputStream fis=new FileInputStream(Ipathconstants.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		Row row = sh.getRow(rownum);
		Cell cel = row.getCell(cellnum);
		cel.setCellValue(data);
		FileOutputStream fos=new FileOutputStream(Ipathconstants.excelpath);
		wb.write(fos);
		wb.close();
	}

}
