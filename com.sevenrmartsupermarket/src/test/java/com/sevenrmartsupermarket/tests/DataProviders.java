package com.sevenrmartsupermarket.tests;
import org.testng.annotations.DataProvider;

import com.sevenrmartsupermarket.utilities.ExcelReader;

public class DataProviders 
{
	ExcelReader excelreader = new ExcelReader();
	@DataProvider(name = "LoginData")
	public Object[][] getBrand() 
	{
        excelreader.setExcelFile("DataProviderLoginDetails");
        return excelreader.getMultidimentionalData(3, 2);
    }
   /* public Object[][] getBrand() 
	{
        return new Object[][] 
        {
        	{"admin","WrongPassword"},
            {"WrongUsername","admin"},
            {"WrongUsername","WrongPassword"}
        };
    }*/
}
