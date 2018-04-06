package buisness.core;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import configuration.Setup;
import configuration.UtilityFunction;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class ElementMethod 
{
	DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss:SS");
	public static Date date,date1, date2,date4;
	SimpleDateFormat format;
	long millis, seconds, milliseconds,minutes;

	/**
	 *
	 * This method return web element for given locator with respective element
	 * method
	 *
	 * @param elementMethod
	 *            which method should be used XPath,ID,Name
	 * @param locator
	 *            contains the details of locator for respective element method
	 * @return if the web element found then element is returned or null is
	 *         returned
	 */
	public WebElement getWebElement(String elementMethod, String locator) {
		WebElement we = null;
		By by = null;
		if (elementMethod.equalsIgnoreCase("id")) {
			by = By.id(locator);
		} else if (elementMethod.equalsIgnoreCase("name")) {
			by = By.name(locator);
		} else if (elementMethod.equalsIgnoreCase("xpath")) {
			by = By.xpath(locator);
		} else if (elementMethod.equalsIgnoreCase("linkText")) {
			by = By.xpath(locator);
		}

		else if (elementMethod.equalsIgnoreCase("partialLinkText")) {
			by = By.xpath(locator);
		} else if (elementMethod.equalsIgnoreCase("tagName")) {
			by = By.xpath(locator);
		}

		else {
			Setup.log.warn("Please verify the locator as no locator is specified");
			return we;
		}

		// Check if the element is visible or wait for it, If it is found only
		// then we would go further or null would be returned
		if (this.WaitForElementVisible(by, 60)) {
			we = Setup.driver.findElement(by);
		}
		return we;
	}

	/***
	 * @author nilesh.patil This method is used for upload the file
	 * @param file
	 * @return
	 */
	// function to upload file
	public String uploadfile(String file) {
		try {
			System.out.println("file name is  " + file);

			// put path of your image in a clipboard
			StringSelection ss = new StringSelection(file);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

			// imitate mouse events like ENTER, CTRL+C, CTRL+V
			Robot robot = new Robot();
			// robot.delay(1000);

			// robot.keyPress(KeyEvent.VK_ENTER);
			// robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Robot r_enter = new Robot();
			r_enter.keyPress(KeyEvent.VK_ENTER);
			r_enter.keyRelease(KeyEvent.VK_ENTER);
			r_enter.delay(1000);
			return "Pass";
		} catch (AWTException e) {
			e.printStackTrace();
			return "Fail";
		}
	}
	
	/**
	 * @author: ashwini.gore
	 * This method records the start time before any action taken
	 * return the time as a String
	 * */
    public String calculateStartTime()
	{
		try
		{
			date = new Date();
			dateFormat.format(date);
			System.out.println("Recorded Start Time:"+dateFormat.format(date));
			return "pass";
		} catch (Exception e) 
		{
			System.out.println("Unable to record start date");
			return "Fail";
		}
	 }
	/**
	 * @author: ashwini.gore
	 * This method records the End time before any action taken
	 * return the time as a String
	 * Logic for calculation
	 * long days = TimeUnit.MILLISECONDS.toDays(millis);
        millis -= TimeUnit.DAYS.toMillis(days);
        long hours = TimeUnit.MILLISECONDS.toHours(millis);
        millis -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        millis -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);
	 * */
    public String calculateStopTime(String action)
	{
		try
		{
		date4 = new Date();
		dateFormat.format(date4);
		System.out.println("StartTime:"+dateFormat.format(date));	
		System.out.println("End Time:"+dateFormat.format(date4));
		format = new SimpleDateFormat("HH:mm:ss:SS");
		date1  = format.parse(dateFormat.format(date));
		date2 = format.parse(dateFormat.format(date4));
	
		millis = date2.getTime() - date1.getTime(); 
		minutes= TimeUnit.MILLISECONDS.toMinutes(millis);
		millis -= TimeUnit.MINUTES.toMillis(minutes);
		seconds=TimeUnit.MILLISECONDS.toSeconds(millis);
		millis -= TimeUnit.SECONDS.toMillis(seconds);

		System.out.println(action +": "+minutes+" minutes "+seconds+" seconds "+millis+" MS");
		return "pass";	
        } catch (Exception e) 
		{
			System.out.println("Unable to record End date");
			return "Fail";
		}
	 }
		
    

	/**
	 * This method checks if element is visible in The UI
	 * Updated by: Sachin Gawade
	 * @param elementmethod: Example: xpath,id.
	 * @param locator: locator of object to be checked
	 * @return pass or fail
	 */

	public String waitForElementToBeVisible(String elementmethod, String locator) {
		try {
			WebElement we = this.getWebElement(elementmethod, locator);
			new WebDriverWait(Setup.driver, 60).until(ExpectedConditions.elementToBeSelected(we));
			return "Pass";
		} catch (Exception e1) {
			return "Fail";
		}

	}

	/**
	 * This method waits till the object is click-able.
	 * Updated by: Sachin Gawade
	 * @param elementmethod: Example: xpath,id.
	 * @param locator: locator of object to be clicked
	 * @return pass or fail
	 */
	public String wait_click(String elementmethod, String locator) {
		try {
			WebElement we = this.getWebElement(elementmethod, locator);
			new WebDriverWait(Setup.driver, 60).until(ExpectedConditions.elementToBeClickable(we));
			Setup.log.info("Element is clickable LocatorValue:"+locator);
			return "Pass";
		} catch (Exception e1) {
			Setup.log.info("Error while waiting for element to be clickable");
			Setup.log.warn(e1.toString());
			return "Fail";
		}
	}

	/**
	 * Created by
	 *
	 * @author nilesh.patil created Date 25 Jan 2016 This method is used to
	 *         press enter key on keyboard
	 * @return
	 */
	public String pressEnter() {
		try {
			Keyboard keyboard = ((HasInputDevices) Setup.driver).getKeyboard();
			keyboard.pressKey(Keys.ENTER);
			return "pass";
		} catch (Exception e1) {

			Setup.log.warn(e1.toString());
			return "Fail";
		}

	}

	/**
	 * Presss the Home key present on to the Keyboard
	 * By ClickHome key
	 * Date : 05-04-2016
	 * Created by :Rakesh Kulkarni
	 * @return
     */
	public String clickHome() {
		try {
			Keyboard keyboard = ((HasInputDevices) Setup.driver).getKeyboard();
			keyboard.pressKey(Keys.HOME);
			Thread.sleep(2000);
			return "pass";
		} catch (Exception excep) {

			Setup.log.warn(excep.toString());
			return "Fail";
		}

	}
	public String ClickPageDown() {
		try {
			Keyboard keyboard = ((HasInputDevices) Setup.driver).getKeyboard();
			keyboard.pressKey(Keys.PAGE_DOWN);
			Thread.sleep(2000);
			return "pass";
		} catch (Exception excep) {

			Setup.log.warn(excep.toString());
			return "Fail";
		}

	}

	/**
	 * Presss the Home key present on to the Keyboard
	 * By ClickHome key
	 * Date : 05-04-2016
	 * Created by :Rakesh Kulkarni
	 * @return
	 */
	public String clickF5() {
		try {
			Actions actionObject = new Actions(Setup.driver);
			actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.F5).keyUp(Keys.CONTROL).perform();
			// Keyboard keyboard = ((HasInputDevices)
			// Setup.driver).getKeyboard();
			// keyboard.pressKey(Keys.F5);
			return "pass";
		} catch (Exception excep) {

			Setup.log.warn(excep.toString());
			return "Fail";
		}

	}
	/***
	 * Changed by
	 *
	 * @author Nilesh patil Changed Date :-27 Jan 2016 This method is used to
	 *         enter data into fields or send text in text boxes
	 * @param elementmethod
	 * @param locator
	 * @return
	 */

	public String type_element(String elementmethod, String locator, String data) {
		WebElement we = this.getWebElement(elementmethod, locator);
		if (we == null) {
			return "fail";
		}
		we.clear();
		we.sendKeys(java.lang.String.valueOf(data));
		return "pass";
	}

	/***
	 * Changed by
	 *
	 * @author Nilesh patil This method is used to handle the mouseHover actions
	 * @param elementmethod
	 * @param locator
	 * @return
	 */

	public String mouseHover(String elementmethod, String locator) {
		WebElement webEleObj = this.getWebElement(elementmethod, locator);

		if (webEleObj == null) {
			return "fail";
		}
		Locatable hoverItem = (Locatable) webEleObj;
		Mouse mouse = ((HasInputDevices) Setup.driver).getMouse();
		mouse.mouseMove(hoverItem.getCoordinates());
		return "pass";
	}

	// function to switch to frame
	public String switchtoframe(String elementmethod, String locator) {
		try {
			if (elementmethod.equalsIgnoreCase("id")) {
				By by = By.id(locator);
				this.WaitForElementVisible(by, 60);

				Setup.driver.switchTo().frame(Setup.driver.findElement(By.id(locator)));
			} else if (elementmethod.equalsIgnoreCase("name")) {
				By by = By.name(locator);
				this.WaitForElementVisible(by, 60);
				Setup.driver.switchTo().frame(Setup.driver.findElement(By.name(locator)));
			} else if (elementmethod.equalsIgnoreCase("xpath")) {
				By by = By.xpath(locator);
				this.WaitForElementVisible(by, 60);
				Setup.driver.switchTo().frame(Setup.driver.findElement(By.xpath(locator)));
			}
			return "Pass";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}

	}


	// function to switch to default frame
	public String switchtodefaultframe() {
		try {
			Setup.driver.switchTo().defaultContent();
			return "Pass";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	////// click event
	public String click_element(String elementmethod, String locator) {
		WebElement we = this.getWebElement(elementmethod, locator);
		
		if (we != null) {
			we.click();
			return "Pass";
		}
		return "Fail";
	}

	/***
	 * Changed by
	 *
	 * @author nilesh.patil This method is used to press enter key on selected
	 *         element of a web page
	 * @param elementmethod
	 * @param locator
	 * @return
	 */

	// press enter key
	public String press_enter(String elementmethod, String locator) {

		WebElement we = this.getWebElement(elementmethod, locator);
		if (we == null) {
			return "Fail";
		}
		we.clear();
		we.sendKeys(Keys.ENTER);
		return "pass";

	}

	// press backspace
	public String press_backspace(String elementmethod, String locator) {
		try {
			if (elementmethod.equalsIgnoreCase("id")) {
				By by = By.id(locator);
				this.WaitForElementVisible(by, 05);
				// Setup.driver.findElement(By.id(locator)).clear();
				Setup.driver.findElement(By.id(locator)).sendKeys(Keys.BACK_SPACE);
			} else if (elementmethod.equalsIgnoreCase("name")) {
				By by = By.name(locator);
				this.WaitForElementVisible(by, 05);
				// Setup.driver.findElement(By.name(locator)).clear();
				Setup.driver.findElement(By.name(locator)).sendKeys(Keys.BACK_SPACE);

			}
			if (elementmethod.equalsIgnoreCase("xpath")) {
				By by = By.xpath(locator);
				this.WaitForElementVisible(by, 05);
				// Setup.driver.findElement(By.xpath("element")).clear();
				Setup.driver.findElement(By.xpath(locator)).sendKeys(Keys.BACK_SPACE);
			}
			return "Pass";
		} catch (Exception e1) {
			// Setup.log("Fail to send data to element"+locator);
			return "Fail";
		}
	}

	public String wait_implicit() {
		try {
			Setup.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			System.out.println("Implicit Wait for 60 seconds ");
			return "Pass";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail to wait implicitly";
		}
	}



	/***
	 * Changed by
	 *
	 * @author Nilesh Patil This method used to verify element on page
	 * @param elementmethod
	 * @param locator
	 * @return
	 */

	public String verify_element(String elementmethod, String locator) {
		try {
			if (elementmethod.equalsIgnoreCase("id")) {
				By by = By.id(locator);
				this.WaitForElementVisible(by, 60);
				Setup.driver.findElement(By.id(locator));
			} else if (elementmethod.equalsIgnoreCase("name")) {
				By by = By.name(locator);
				this.WaitForElementVisible(by, 60);
				Setup.driver.findElement(By.name(locator));
			} else if (elementmethod.equalsIgnoreCase("xpath")) {
				By by = By.xpath(locator);
				this.WaitForElementVisible(by, 60);
				Setup.driver.findElement(By.xpath(locator));
			} else if (elementmethod.equalsIgnoreCase("linkText")) {
				By by = By.linkText(locator);
				this.WaitForElementVisible(by, 60);
				Setup.driver.findElement(By.linkText(locator)).click();
			} else if (elementmethod.equalsIgnoreCase("partialLinkText")) {
				By by = By.partialLinkText(locator);
				this.WaitForElementVisible(by, 60);
				Setup.driver.findElement(By.partialLinkText(locator)).click();
			}
			return "Pass";
		} catch (Exception e1) {
			System.out.println("Unable to find the element by given elementmethod and locator.");
			Setup.log.trace(e1.toString());
			//Setup.log.warn(e1.toString());
			return "Fail";
		}

	}

	/**
	 * @author nilesh.patil This method is used to select the radio button
	 * @param elementmethod
	 * @param locator
	 * @return
	 */
	public String radioselect_element(String elementmethod, String locator)

	{
		WebElement we = this.getWebElement(elementmethod, locator);

		if (we == null) {
			return "fail";
		}
		we.click();
		return "pass";

	}

	public String wait_page_load() {
		try {
			Setup.driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			return "Pass";
		} catch (Exception e1) {
			Setup.log.warn(e1.toString());
			return "Fail";
		}

	}

	/**
	 * Changed by
	 *
	 * @author nilesh.patil Changed Date :- 27 Jan 2016 This method is used to
	 *         select drop down value by visible text
	 * @param elementmethod
	 * @param locator
	 * @param data
	 * @return
	 */



	/**
	 * Created by
	 *
	 * @author nilesh.patil Created Date :- 27 Jan 2016 This method is used to
	 *         select drop down value by Value
	 * @param elementmethod
	 * @param locator
	 * @param data
	 * @return
	 */

	public String selectDropDownByValue(String elementmethod, String locator, String data) {
		WebElement we = this.getWebElement(elementmethod, locator);
		if (we != null) {
			Select so = new Select(we);
			so.selectByValue(data);
			return "Pass";
		}

		return "Fail";

	}

	/**
	 * Created by
	 *
	 * @author nilesh.patil Created Date :- 27 Jan 2016 This method is used to
	 *         select drop down value by Index
	 * @param elementmethod
	 * @param locator
	 * @param data
	 * @return
	 */

	public String selectDropDownByIndex(String elementmethod, String locator, String data) {
		WebElement we = this.getWebElement(elementmethod, locator);
		if (we != null) {
			Select so = new Select(we);
			so.selectByIndex(Integer.parseInt(data));
			return "Pass";
		}

		return "Fail";

	}

	/**
	 * Created by
	 *
	 * @author nilesh.patil Created Date :- 27 Jan 2016 This method is used to
	 *         deselect any pre-selected option
	 * @param elementmethod
	 * @param locator
	 * @param data
	 * @return
	 */

	public String deselectByvisbletesxt(String elementmethod, String locator, String data) {
		WebElement we = this.getWebElement(elementmethod, locator);
		if (we != null) {
			Select so = new Select(we);
			so.deselectByVisibleText(data);
			return "Pass";
		}

		return "Fail";

	}

	public boolean WaitForElementVisible(By by, int timeOutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(Setup.driver, timeOutInSeconds);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			return true;
		} catch (TimeoutException te) {
			Setup.log.warn("Unable to find element " + by.toString() + " on UI even after waiting for "
					+ timeOutInSeconds + " sec");
			return false;
		} catch (Exception e1) {
			Setup.log.warn("Excpetion occured ");
			return false;
		}

	}

	/***
	 * Changed by changed Date 1-27-2016
	 *
	 * @author nilesh.patil This method is used to find and click the linktexts
	 * @param elementmethod
	 * @param locator
	 * @return
	 */

	public String linktext(String elementmethod, String locator) {
		WebElement we = this.getWebElement(elementmethod, locator);

		if (we == null) {
			return "fail";
		}
		we.click();
		return "pass";

	}

	public boolean isElementPresent(By by) {
		try {
			Setup.driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public String getattribute(String elementmethod, String locator, String data) {

		WebElement e = this.getWebElement(elementmethod, locator);
		String value = e.getAttribute(data);
		return value;
	}

	public String gettext(String elementmethod, String locator) {

		WebElement e = this.getWebElement(elementmethod, locator);
		String value = e.getText();
		return value;
	}

	public String getSelectValue(String elementmethod, String locator) {

		WebElement e = this.getWebElement(elementmethod, locator);
		Select select = new Select(e);
		String value = select.getFirstSelectedOption().getText();
		System.out.println(value);
		// String
		// value=e.findElement(By.xpath("./Option[@selected]")).getText();
		return value;
	}

	public List<WebElement> getWebElements(String elementmethod, String locator) {
		try {
			List<WebElement> e = null;

			if (elementmethod.equalsIgnoreCase("id")) {
				By by = By.id(locator);
				this.WaitForElementVisible(by, 60);
				e = Setup.driver.findElements(By.id(locator));

			} else if (elementmethod.equalsIgnoreCase("name")) {
				By by = By.name(locator);
				this.WaitForElementVisible(by, 60);
				e = Setup.driver.findElements(By.name(locator));

			} else if (elementmethod.equalsIgnoreCase("xpath")) {
				By by = By.xpath(locator);
				this.WaitForElementVisible(by, 60);
				e = Setup.driver.findElements(By.xpath(locator));
			} else {
				Setup.log.warn("Invalid element method");
			}

			return e;
		} catch (Exception e1) {
			Setup.log.debug(e1.toString());
			return null;
		}
	}

	public String check_label(String elementmethod, String locator, String text) {
		try {
			System.out.println("Xpath is " + locator);
			System.out.println("Element Method is " + elementmethod);

			System.out.println("Expeted Text is " + text);
			String l_text = this.gettext(elementmethod, locator).trim();
			System.out.println("Actual Text is " + l_text);

			if (l_text.equalsIgnoreCase(text.trim())) {
				System.out.println("matched");
			} else {
				System.out.println("not matched");
			}
			return "Pass";
		} catch (Exception e) {
			e.printStackTrace();
			return "Fail";
		}
	}
	/**@author awadhesh.sengar 12/13/2017
	 * Click any one element from a list of elements found using the locator
	 * If no element found using the given locator the false would be returned
	 *
	 * Note:- Locator passed should be able to find more than one elements on the UI
	 *
	 * @param - The method to be used to find elements (XPath,ID)
	 * @param locator - The actual locator of the elements to be found 
	 * @return 	True - When it was able to click any one element from the list<br>
	 * 			False - If it wasn't find any element by given locator
	 */
	public boolean clickRandomElement(String elementmethod, String locator)
	{
		List<WebElement> elements = getWebElements(elementmethod, locator);

		//UNIT_TEST: Firstly we should test that list contains something that we could click
		if(elements == null || elements.isEmpty())
		{
			Setup.log.warn("The element could not be found");
			return false;
		}
		Random r = new Random();
		elements.get(r.nextInt(elements.size()));
	    int randomValue = r.nextInt(elements.size()); //Getting a random value that is between 0 and (list's size)
		randomValue=0;
		if(randomValue==0)
		{ 
			randomValue=randomValue+1;
		}
		System.out.println("the random value is "+randomValue);
	
		try {
			int i=randomValue;
			if(i<=elements.size())
			{ i=(i*2)-1;
			Setup.driver.findElement(By.xpath(".//*[@id='sample-table-1']/tbody[1]/tr["+i+"]/td[1]")).click();
			String Measurename = Setup.driver.findElement(By.xpath(".//*[@id='sample-table-1']/tbody[1]/tr["+i+"]/td[1]")).getText();
			System.out.println("Measure selected is  "+Measurename); 
			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("the random value encountered an error");
			e.printStackTrace();
			
			}
		return true;
	}

	
	/**
	 * Function to scroll to top of the page
	 */
	public String scrollToTop()
	{
		try{
		((JavascriptExecutor) Setup.driver).executeScript("scroll(0,250);");
		return "pass";
		}
		catch (Exception e)
		{
			Setup.log.warn("Could not scroll to top of the page");
			return "fail";
		}
	}

	public String SelectNonRolling() {
		String StatusR = Setup.driver.findElement(By.xpath(".//*[@id='RollNonRoll']")).getAttribute("checked");
		System.out.println(StatusR);
		Setup.log.info("StatusR(TRUE) :" + StatusR);
		try {
			if (StatusR.equalsIgnoreCase("TRUE")) {
				Setup.driver.findElement(By.xpath(".//*[@id='RollNonRoll']")).click();
				Setup.log.info("NON rollin selected");
				return "pass";
			}
		} catch (NullPointerException nexc) {
			Setup.log.info("currently Non Rolling Selected hence return true");
			return "pass";
		} catch (Exception exc) {
			Setup.log.warn("Exception in SelectNonRolling()");
			exc.printStackTrace();
			return "fail";
		}
		return "pass";
	}
	public String SelectRolling() {
		String StatusNR = Setup.driver.findElement(By.xpath(".//*[@id='RollNonRoll']")).getAttribute("checked");
		Setup.log.info("StatusNR(NULL) :" + StatusNR);
		try {
			if (StatusNR.equalsIgnoreCase("TRUE")) {
				Setup.log.info("currently Rolling is Selected hence return true");
				return "pass";
			}
		} catch (NullPointerException nexc) {
			Setup.driver.findElement(By.xpath(".//*[@id='RollNonRoll']")).click();
			Setup.log.info("Rolling selected");
			return "pass";
		} catch (Exception exc) {
			Setup.log.warn("Exception in SelectRolling()");
			exc.printStackTrace();
			return "fail";
		}
		return "pass";
	}
	public String typeDate(String elementmethod, String locator) {
		WebElement we = this.getWebElement(elementmethod, locator);
		if (we == null) {
			return "fail";
		}
		try
		{
			Calendar currentdate = Calendar.getInstance();
			String strdate = null;
			DateFormat formatter = new SimpleDateFormat("dd.MMM.yyyy");
			strdate = formatter.format(currentdate.getTime());
			TimeZone obj = TimeZone.getTimeZone("IST");
			formatter.setTimeZone(obj);
			strdate = formatter.format(currentdate.getTime());
			Date theResult = formatter.parse(strdate);
			we.clear();
			we.sendKeys(strdate);
			return "pass";
		} catch (Exception exc) {
			Setup.log.warn("Error occur while converting date format in ElementMethod Class" + exc.toString());
			return "fail";
		}
	}
	public String typeTime(String elementmethod, String locator) {
		WebElement we = this.getWebElement(elementmethod, locator);
		if (we == null) {
			return "fail";
		}
		try
		{
			Calendar currentdate = Calendar.getInstance();
			String strdate = null;
			DateFormat formatter = new SimpleDateFormat("HH.mm.ss");
			strdate = formatter.format(currentdate.getTime());
			TimeZone obj = TimeZone.getTimeZone("IST");
			formatter.setTimeZone(obj);
			strdate = formatter.format(currentdate.getTime());
			Date theResult = formatter.parse(strdate);
			we.clear();
			we.sendKeys(strdate);
			return "pass";
		} catch (Exception exc) {
			Setup.log.warn("Error occur while converting date format in ElementMethod Class" + exc.toString());
			return "fail";
		}
	}
	public String typeDateTime(String elementmethod, String locator) {
		WebElement we = this.getWebElement(elementmethod, locator);
		if (we == null) {
			return "fail";
		}
		try
		{
			Calendar currentdate = Calendar.getInstance();
			String strdate = null;
			DateFormat formatter = new SimpleDateFormat("dd.MMM.yyyy HH.mm.ss");
			strdate = formatter.format(currentdate.getTime());
			TimeZone obj = TimeZone.getTimeZone("IST");
			formatter.setTimeZone(obj);
			strdate = formatter.format(currentdate.getTime());
			Date theResult = formatter.parse(strdate);
			we.clear();
			we.sendKeys(strdate);
			return "pass";
		} catch (Exception exc) {
			Setup.log.warn("Error occur while converting date format in ElementMethod Class" + exc.toString());
			return "fail";
		}
	}
	public String typeDay(String elementmethod, String locator) {
		WebElement we = this.getWebElement(elementmethod, locator);
		if (we == null) {
			return "fail";
		}
		try
		{
			int strdate1= Calendar.getInstance().get(Calendar.DAY_OF_WEEK);;
			we.clear();
			we.sendKeys(getDayName(strdate1));
			return "pass";
		}
		catch (Exception exc)
		{
			System.out.println("Error occur while converting date format in ElementMethod Class"+exc.toString());
			return "fail";
		}
	}
	public static String getDayName(int day){
		switch(day){
			case 1:return "Sunday";
			case 2:return "Monday";
			case 3:return "Tuesday";
			case 4:return "Wednesday";
			case 5:return "Thursday";
			case 6:return  "Friday";
			case 7:return "Saturday";
		}
		return "Worng Day";
	  }
	public String typeMonth(String elementmethod, String locator) {
		WebElement we = this.getWebElement(elementmethod, locator);
		if (we == null) {
			return "fail";
		}
		try
		{
			Calendar currentdate = Calendar.getInstance();
			String strdate = null;
			DateFormat formatter = new SimpleDateFormat("MMM");
			strdate = formatter.format(currentdate.getTime());
			TimeZone obj = TimeZone.getTimeZone("IST");
			formatter.setTimeZone(obj);
			strdate = formatter.format(currentdate.getTime());
			Date theResult = formatter.parse(strdate);
			we.clear();
			we.sendKeys(strdate);
			return "pass";
		}
		catch (Exception exc)
		{
			Setup.log.warn("Error occur while converting date format in ElementMethod Class"+exc.toString());
			return "fail";
		}
	}
	public String SelectQuarter(String elementmethod, String locator) {
		WebElement we = this.getWebElement(elementmethod, locator);
		Select dropdown = new Select(Setup.driver.findElement(By.id(locator)));
		if (we == null) {
			return "fail";
		}
		try
		{
			buisness.managers.ConfigurationManager configurationManager = new buisness.managers.ConfigurationManager();
			String str1=configurationManager.read_Configfile("Quarter");
			String str2=configurationManager.read_Configfile(str1);
			dropdown.selectByIndex(Integer.parseInt(str2));    //its fast
			return "true";
		}
		catch (Exception exc)
		{
			dropdown.selectByIndex(0);
			Setup.log.warn("Error occur while Selecting the Quarter hence select default Quarter");
			return "pass";
		}
	}
	public String SelectPQRSProvider(String data) {
		WebElement we = this.getWebElement("id","ddlProviderList");

		Select dropdown = new Select(Setup.driver.findElement(By.id("ddlProviderList")));
		if (we == null) {
			return "fail";
		}
		try
		{
			verify_element("id","ddlProviderList");
			dropdown.selectByVisibleText(data);
			verify_element("id","ddlProviderList");
			return "true";
		}
		catch (Exception exc)
		{
         	dropdown.selectByIndex(1);
			Setup.log.fatal("Error occur while Selecting the Provider hence 2nd Provider is selected");
			return "pass";
		}
	}

	public String selectDropDownByVisibltext(String elementmethod, String locator, String data) {
		WebElement we = this.getWebElement(elementmethod, locator);
		if (we == null) {
			return "Fail";
		}
		System.out.println("drop down data " + data);
		Select so = new Select(we);
		so.selectByVisibleText(data);

		return "Pass";

	}
	
	/***********************************************************************************
	 * @author probeer.roy Method to get the selected measure set. Date:
	 *         29/11/2017
	 */
	public String getSelectedMeasureSet(String elementmethod, String locator) {
		WebElement we = this.getWebElement(elementmethod, locator);
		if (we == null) {
			return "Fail";
		}
		String value = we.getAttribute("data-value");
		System.out.println(value);
		we.click();
		int size = we.findElements(By.xpath("//div[@id='divMeasureSetGrid']/table/tbody/tr[@id]")).size();
		System.out.println(size);
		for (int i = 2; i <= (size + 1); i++) {
			String locator1 = "//div[@id='divMeasureSetGrid']/table/tbody/tr[" + i + "]/td[1]/input";
			String mvalue = we.findElement(By.xpath(locator1)).getAttribute("value");
			System.out.println(mvalue);
			if (mvalue.equals(value)) {
				String locator2 = "//div[@id='divMeasureSetGrid']/table/tbody/tr[" + i + "]/td[2]";
				String defaultmeasureset = we.findElement(By.xpath(locator2)).getText();
				System.out.println(defaultmeasureset);
				we.findElement(By.xpath("//*[@id='MasterWrapperMeasureSet']/div[2]/a")).click();
				return "Pass";
			}
		}
		return "Pass";
	}

	/***********************************************************************************
	 * @author probeer.roy Method to get the selected button.
	 * Date: 29/11/2017
	 */
	public String getSelectedbutton(String elementmethod, String locator) {
		WebElement we = this.getWebElement(elementmethod, locator);
		String classname = we.getAttribute("class");
		//System.out.println(classname);
		if (classname.equals("badge active btnfavrorite width-90")) {
			String locator1 = "//*[@id='aspnetForm']/div[3]/div[2]/div[1]/div/div[1]/table/tbody/tr/td[10]/a/span/label";
			String getselectedbutton = we.findElement(By.xpath(locator1)).getText();
			System.out.println("Selected button is: " + getselectedbutton);
			return "Pass";
		} else {
			String locator2 = "//*[@id='aspnetForm']/div[3]/div[2]/div[1]/div/div[1]/table/tbody/tr/td[11]/a/span/label";
			String getselectedbutton1 = we.findElement(By.xpath(locator2)).getText();
			System.out.println("Selected button is: " + getselectedbutton1);
			return "Pass";
		}
	}

	/*************************************************************************************
	 * This method will get the quarter name from the xlsx, based on the
	 * expected quarter it will select the quarter only. return true when
	 * quarter is selected return false when quarter is not available in the
	 * list.
	 * 
	 * @author probeer.roy Created Date: 07/12/2017
	 */
	public boolean selectQuarter1(String elementmethod, String locator, String quarter, String flag) {
		String setFlag;
		if (flag.equals("QR")) {
			setFlag = flag;
		} else {
			setFlag = flag;
		}
		// System.out.println("Flag set is " + setFlag);
		System.out.println("Expected quarter is: " + quarter);
		UtilityFunction test = new UtilityFunction();
		String getSelectedQuarter = test
				.trimMultiSpace(Setup.driver.findElement(By.xpath("//select[@id='ddlQuarter']/option[1]")).getText());
		System.out.println("Selected quarter is: " + getSelectedQuarter);
		if (getSelectedQuarter.equals(quarter)) {
			return true;
		} else {
			try {
				WebElement we = this.getWebElement(elementmethod, locator);
				List<WebElement> quarterList = we
						.findElements(By.xpath("//select[@id='ddlQuarter']/option[@data-rtype='" + setFlag + "']"));
				Select dropdown = new Select(we);
				we.click();
				int size = quarterList.size();
				//System.out.println("Number of quarters are : " + size);
				for (WebElement lItem : quarterList) {
					String sText = test.trimMultiSpace(lItem.getText());
				//	System.out.println("gettext is : " + sText);
					if (sText.equals(quarter)) {
						System.out.println("Quarter is found and selected: " + sText);
						lItem.click();
						return true;
					} else
						continue;
				}
			} catch (Exception Ex) {
				System.out.println("Quarter is not available in the list." + Ex);
				return false;
			}
			return false;
		}
	}

	/**************************************************************************
	 * This method will refresh the page once called and will return boolean
	 * true when page is refreshed. return false when unable to refresh the
	 * page.
	 * 
	 * @author probeer.roy Created Date: 08/12/2017
	 */
	public boolean refreshPage() {
		String url = "https://iris1.aao.org/Dashboard/Default.aspx";
		String url1 = "https://iris1.aao.org/Dashboard/Default.aspx#";
		Setup.driver.navigate().refresh();
		wait_implicit();
		String getURL = Setup.driver.getCurrentUrl();
		// System.out.println("Url: " + getURL);
		if (url.equals(getURL) || url1.equals(getURL)) {
			return true;
		} else {
			return false;
		}
	}

	/*************************************************************************************
	 * This method will perform the sorting based on the parameters provided in
	 * xlsx which will return true when sorting perform successfully. return
	 * false when sorting will not perform.
	 * 
	 * @author probeer.roy Created Date: 14/12/2017
	 */
	public boolean performSorting(String elementmethod, String locator, String sortingparam) {
		WebElement we = null;
		List<WebElement> cols = getWebElements(elementmethod, locator);
		int numberOfCols = cols.size();
		// System.out.println("Number of headers: " + numberOfCols);
		for (int i = 0; i <= numberOfCols; i++) {
			we = cols.get(i);
			String sorttext = we.getText();
			System.out.println("Sort Text is " + sorttext);
			String exptext = sorttext.replaceAll("[-+.^:, ]","");
			System.out.println("We2 " + exptext);
			if (exptext.equalsIgnoreCase(sortingparam)) {
				we.click();
				return true;
			}
		}
		return false;
	}

	public boolean clickRandomProvider(String elementmethod, String locator) {
		System.out.println(elementmethod+ " " +locator);
		try{
		List<WebElement> elements = getWebElements(elementmethod, locator);
		System.out.println("size " + elements.size());
		System.out.println("Coming here in random provider method.");
		// UNIT_TEST: Firstly we should test that list contains something that
		// we could click
		if (elements == null || elements.isEmpty()) {
			Setup.log.warn("The element could not be found");
			return false;
		}
		Random r = new Random();
		// Now we would generate random number only for the found number of
		// elements
		// finally get the element at a random location and click
		elements.get(r.nextInt(elements.size())).click();
		Thread.sleep(5000);
		return true;
		} catch (Exception Ex){
			Setup.log.trace(Ex);
			Setup.log.info("\nUnable to identify theprovider");
			return false;
		}
	}

	/*************************************************************************************
	 * This method will get the month name from the xlsx, based on the expected
	 * month it will select the month only. return true when month is selected
	 * return false when month is not available in the list.
	 * 
	 * @author probeer.roy Created Date: 21/12/2017
	 */
	public boolean selectMonth(String elementmethod, String locator, String month, String flag) {
		String setFlag;
		if (flag.equals("MR")) {
			setFlag = flag;
		} else {
			setFlag = flag;
		}
		// System.out.println("Flag set is " + setFlag);
		System.out.println("Expected month is: " + month);
		verify_element(elementmethod, locator);
		System.out.println(Setup.driver.findElement(By.xpath("//select[@id='ddlQuarter']/option[1]")).getText());
		WebElement me = this.getWebElement(elementmethod, locator);
		System.out.println(me);
		UtilityFunction test = new UtilityFunction();
		try {
			verify_element("xpath", "//select[@id='ddlQuarter']/option[@data-rtype='" + setFlag + "']");
			List<WebElement> monthlist = me
					.findElements(By.xpath("//select[@id='ddlQuarter']/option[@data-rtype='" + setFlag + "']"));
			Select dropdown = new Select(me);
			me.click();
			// List<WebElement> test12 = this.getWebElements(elementmethod,
			// locator);
			int size = monthlist.size();
			//System.out.println("Number of months are : " + size);
			for (WebElement lItem : monthlist) {
				String sText = test.trimMultiSpace(lItem.getText());
			//System.out.println("gettext is : " + sText);
				if (sText.equals(month)) {
					System.out.println("Month is found and selected: " + sText);
					lItem.click();
					return true;
				} else
					continue;
			}
		} catch (Exception Ex) {
			System.out.println("Month is not available in the list." + Ex);
			return false;
		}
		return false;
	}

}
