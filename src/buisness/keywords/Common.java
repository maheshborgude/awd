package buisness.keywords;

import buisness.core.ElementMethod;
import buisness.core.login.AfterLoginUtility;
import configuration.Setup;
import org.apache.xpath.SourceTree;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;

public abstract class Common {

	protected String result;
	protected ElementMethod element=new ElementMethod();

	/**
	 * Method Call the appropriate method which is required to perform the logic of
	 * action keyword that is passed as parameter
	 * 
	 * @param elementmethod: ElementMethod that is to be used, i.e ID, XPath etc 
	 * @param action: Keywords are passed
	 * @param locator: Value of locator which would be required to identify elements on UI
	 * @param data: The data that need to passed along with action keyword
	 * @return Pass if the element was successfully passed
	 */
	public String meth(String elementmethod,String action,String locator,String...data)
	{
		initilizeResult();
		if(action.isEmpty())
		{
			Setup.log.warn("Blank action is added in Excel");
			result ="Fail";
		}
        else if(action.equalsIgnoreCase("type"))
		{   Setup.log.debug("Action: Type element\tLocator Value: " + locator);
			result=element.type_element(elementmethod,locator,data[0]);
		}
		else if(action.equalsIgnoreCase("click"))
		{		
			Setup.log.debug("Action: Click element\tLocator Value: " + locator);
			try
			{
				result=element.click_element(elementmethod,locator);
			}
			catch (WebDriverException we)
			{
				Setup.log.debug("Element not Clickble exception occur and hence Click F5 key");
				Keyboard keyboard = ((HasInputDevices) Setup.driver).getKeyboard();
				keyboard.pressKey(Keys.F5);
				result ="Fail";
			}
		}
		else if(action.equalsIgnoreCase("calculatestarttime"))
		{   Setup.log.debug("Action:   " + action);
		    result=element.calculateStartTime();
		}
		else if(action.equalsIgnoreCase("calculatestoptime"))
		{   Setup.log.debug("Action:   " + action);
			result=element.calculateStopTime(data[0]);
		}

		else if(action.equalsIgnoreCase("enter"))
		{		
			result=element.press_enter(elementmethod,locator);
		}
		else if(action.equalsIgnoreCase("verifyelement"))
		{
			result=element.verify_element(elementmethod,locator);
		}
		else if(action.equalsIgnoreCase("linktext"))
		{
			result=element.linktext(elementmethod,locator);
		}
		else if(action.equalsIgnoreCase("radioselect"))
		{
			result=element.radioselect_element(elementmethod,locator);
		}
		else if(action.equalsIgnoreCase("select"))
		{
			result=element.selectDropDownByVisibltext(elementmethod,locator,data[0]);
		}
		else if(action.equalsIgnoreCase("press_backspace"))
		{
			result=element.press_backspace(elementmethod,locator);
		}
		else if(action.equalsIgnoreCase("check_label"))
		{
			result=element.check_label(elementmethod, locator, data[0]);
		}
		else if (action.equalsIgnoreCase("wait_page_load"))
		{
			element.wait_page_load();
		}else if (action.equalsIgnoreCase("wait_implicit"))
		{
			element.wait_implicit();
		}
		else if(action.equalsIgnoreCase("defaultSelect"))
		{
			AfterLoginUtility.CurrentSelected = element.getSelectValue(elementmethod,locator);
		}	 
		else if(action.equalsIgnoreCase("uploadfile"))
		{
			result=element.uploadfile(data[0]);
		}	 
		else if(action.equalsIgnoreCase("mousehover"))
		{
			result=element.mouseHover(elementmethod, locator);
		}  
		else if(action.equalsIgnoreCase("clickRandom"))
		{
			result=element.clickRandomElement(elementmethod, locator) ? "Pass" : "Fail";
		}else if(action.equalsIgnoreCase("clickRandomProvider"))
		{
			result=element.clickRandomProvider(elementmethod, locator) ? "Pass" : "Fail";
		}
		else if(action.equalsIgnoreCase("wait click"))
		{
			result=element.wait_click(elementmethod, locator);
		}
		else if(action.equalsIgnoreCase("switch frame"))
		{
			result=element.switchtoframe(elementmethod, locator);
		}
		else if(action.equalsIgnoreCase("switch defaultframe"))
		{
			result=element.switchtodefaultframe();
		}
		else if(action.equalsIgnoreCase("verifyisvisible"))
		{
			result=element.waitForElementToBeVisible(elementmethod, locator);
		}
		else if(action.equalsIgnoreCase("scrolltotop"))
		{
			result=element.scrollToTop();
		}
		else if(action.equalsIgnoreCase("ClickHome"))
		{
			result=element.clickHome();
		}
		else if(action.equalsIgnoreCase("ClickF5"))
		{
			result=element.clickF5();
		}
		else if(action.equalsIgnoreCase("SelectRolling"))
		{
			result=element.SelectRolling();
		}
		else if(action.equalsIgnoreCase("SelectNonRolling"))
		{
			result=element.SelectNonRolling();
		}
		else if(action.equalsIgnoreCase("typeDate"))
		{
			result=element.typeDate(elementmethod,locator);
		}
		else if(action.equalsIgnoreCase("typeTime"))
		{
			result=element.typeTime(elementmethod,locator);
		}
		else if(action.equalsIgnoreCase("typeDateTime"))
		{
			result=element.typeDateTime(elementmethod,locator);
		}
		else if(action.equalsIgnoreCase("typeDay"))
		{
			result=element.typeDay(elementmethod,locator);
		}
		else if(action.equalsIgnoreCase("typeMonth"))
		{
			result=element.typeMonth(elementmethod,locator);
		}
		else if(action.equalsIgnoreCase("SelectQuarter"))
		{
			result=element.SelectQuarter(elementmethod,locator);
		}
		else if(action.equalsIgnoreCase("ClickPageDown"))
		{
			result=element.ClickPageDown();
		}
		else if(action.equalsIgnoreCase("SelectPQRSProvider"))
		{
			result=element.SelectPQRSProvider(data[0]);
		}
		else if(action.equalsIgnoreCase("getSelectedMeasureSet"))
		{
			result=element.getSelectedMeasureSet(elementmethod,locator);
		}
		else if(action.equalsIgnoreCase("getSelectedbutton"))
		{
			result=element.getSelectedbutton(elementmethod,locator);

		}else if(action.equalsIgnoreCase("selectQuarter1"))
		{
			result=element.selectQuarter1(elementmethod,locator,data[0],data[1])?"Pass":"Fail";
		}//selectMonth
		else if(action.equalsIgnoreCase("selectMonth"))
		{
			result=element.selectMonth(elementmethod,locator,data[0],data[1])?"Pass":"Fail";
	
		}
		else if(action.equalsIgnoreCase("RefreshPage"))
		{
			result=element.refreshPage()?"Pass":"Fail";
		
		}else if(action.equalsIgnoreCase("PerformSorting"))
		{
			result=element.performSorting(elementmethod, locator, data[0])?"Pass":"Fail";
			
		}
		return result;
	}	
	private void initilizeResult()
	{
		result=null;
	}
}
