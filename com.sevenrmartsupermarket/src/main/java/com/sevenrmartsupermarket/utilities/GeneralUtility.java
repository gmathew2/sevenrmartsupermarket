package com.sevenrmartsupermarket.utilities;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class GeneralUtility //no constructor needed as there is no interaction with driver
{
	public String getAttribute(WebElement element, String attribute)
	{
		return element.getAttribute(attribute);
	}
	
	public String getCSSValue(WebElement element, String cssvalue)
	{
		return element.getAttribute(cssvalue);
	}
	
	public List<String> getTextofElements(List<WebElement> elements)
	{
		List<String> data=new ArrayList<String>();
		for(WebElement element:elements)
		{
			data.add(element.getText());
		}
		return data;
	}
	
	public static String get_RandomName() //generate random names and details
	{
		Faker faker=new Faker();
		return faker.name().firstName();
	}
	
	public static String get_TimeStamp()
	{
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		return timeStamp;
	}
}
