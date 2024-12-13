package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String sheetname,int row,int cellno) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstants.excelpath);
		  Workbook wb = WorkbookFactory.create(fis);
		 Cell cell = wb.getSheet(sheetname).getRow(row).getCell(cellno);
		 DataFormatter d = new DataFormatter();
			String data = d.formatCellValue(cell);
		 wb.close();
		return data;
		
	}
	public int getRowcount(String sheetname) throws Throwable, Throwable {
		FileInputStream fis = new FileInputStream(IPathConstants.excelpath);
		  Workbook wb = WorkbookFactory.create(fis);
		 int rowcount = wb.getSheet(sheetname).getLastRowNum();
		 wb.close();
		 return rowcount;
	}
	public void setDataIntoExcel(String sheetname,int row,int cell, String data   ) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstants.excelpath);
		  Workbook wb = WorkbookFactory.create(fis);
		 wb.getSheet(sheetname).getRow(row).createCell(cell);
		 FileOutputStream fos = new FileOutputStream(IPathConstants.excelpath);
		 wb.write(fos);
		 wb.close();
	}
	/*public String DataFormat() {
		DataFormatter d = new DataFormatter();
		String data = d.formatCellValue
		
	}*/

}
