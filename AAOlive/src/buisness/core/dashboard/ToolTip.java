package buisness.core.dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import configuration.Setup;

public class ToolTip extends Basics{
	
	public boolean verifyToolTip(String locator,String PracticeId,String QuarterOrMonth)
	{
		String UITooltip = gettooltip(locator);
		String DBTooltip = getConstructedTooltip(locator,PracticeId,QuarterOrMonth);
		
		System.out.println("UI tooltip: " + UITooltip + "\tDB tooltip: " + DBTooltip);
		
		if(UITooltip.equals(DBTooltip))
			return true;
		return false;
	}
	/**
	 *  finds the tooltip displayed on UI
	 * @param locator
	 * @return
	 */
	public String gettooltip(String locator)
	{	
		WebElement we = Setup.driver.findElement(By.xpath(locator));
		
		//System.out.println(locator);
		String tooltip = we.getAttribute("title");
		return tooltip;
	}
	
	private String getConstructedTooltip(String locator,String PracticeId,String QuarterOrMonth)
	{
		//As TR contains measure id, Strip Xpath till TR
		locator = locator.replace("/td[3]//td[@title]", "");
		WebElement we = Setup.driver.findElement(By.xpath(locator));

		// As ID attribute contains tr as appended to measure id eg. <tr id="tr7d78288a-6776-402f-a84f-4ebbbabaff07" >
		String measureUID = we.getAttribute("id").substring(2);
		//System.out.println(measureUID);
		String numerator = getNumerator(measureUID,PracticeId,QuarterOrMonth);
		String denominator = getDenominator(measureUID,PracticeId,QuarterOrMonth);
		
		String constructedToolTip = numerator + "/" + denominator + " (N/D)";
		return constructedToolTip;
	}
}
