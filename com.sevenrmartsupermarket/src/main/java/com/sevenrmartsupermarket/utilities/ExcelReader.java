package com.sevenrmartsupermarket.utilities;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sevenrmartsupermarket.constants.Constants;

public class ExcelReader 
{
	XSSFSheet sheet;
	XSSFWorkbook workbook;
	XSSFRow row;
	XSSFCell cell;
	
	public void setExcelFile(String sheetName)
	{
		try
		{
			File src = new File(Constants.EXCEL_FILEPATH);
			FileInputStream fi = new FileInputStream(src);
			workbook = new XSSFWorkbook(fi);
			sheet = workbook.getSheet(sheetName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public String getCellData(int rowNo, int columnNo)
	{
		row = sheet.getRow(rowNo);
		cell = row.getCell(columnNo);
		switch (cell.getCellType()) {
		case STRING: 
		{
			String data;
			data = cell.getStringCellValue();
			return data;
		}
		case NUMERIC: 
		{
			long d = (long) cell.getNumericCellValue();
			return String.valueOf(d);
		}

		default:
			return null;

		}
	}
	
	public Object[][] getMultidimentionalData(int row, int column) 
	{
		Object data[][] = new Object[row][column];
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<column;j++)
			{
				data[i][j]=getCellData(i,j);
			}
		}
		return data;
	}

}

