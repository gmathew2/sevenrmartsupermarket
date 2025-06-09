package com.sevenrmartsupermarket.utilities;
import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility 
{
	WebDriver driver;
	Actions actions;
	JavascriptExecutor js;
	
	public PageUtility(WebDriver driver)
	{
		this.driver=driver;
		actions=new Actions(driver);
		js= (JavascriptExecutor) driver;
	}
	
	public void scrollAndClick(WebElement element)
	{
		js.executeScript("arguments[0].scrollIntoView();", element);
		js.executeScript("arguments[0].click();",element);
	}
	
	public void selectByVisibleText(WebElement element, String text)
	{
		Select select=new Select(element);
		select.selectByVisibleText(text);//byindex,byvalue, actions also
	}

	public void selectByIndex(WebElement element,int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	public void selectByValue(WebElement element,String value)
	{
		Select select=new Select(element);
		select.selectByValue(value);
	}
}
