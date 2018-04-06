package buisness.core.dashboard.Practice.practiceMeasureGrid;

import java.sql.ResultSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import buisness.core.DashboardUI;
import buisness.core.ElementMethod;
import buisness.managers.DatabaseManger;
import configuration.Setup;

/**
 * Core logic to verify the count for Practice Measure Computation Summary for
 * selected practice as well as on DB.
 *  Extends DashboardUI
 * return count as String.
 * @author probeer.roy Created Date: 04/12/2017
 */

public class PracticeMeasureCount extends DashboardUI {
	private ResultSet resultSet = null;

	/*
	 * This method will get the count from DB for Practice Measure Computation
	 * Summary.
	 */
	public String getCountFromDB(String query) {
		DatabaseManger.SQLserverConnection();
		System.out.println("query passed is:" + query);
		try {
			resultSet = DatabaseManger.exeQuery(query);
			if (resultSet.next()) {
				System.out.println("Coming here in DB: " + resultSet.getString(1));
				return resultSet.getString(1);

			} else {
				Setup.log.trace("No Record found in the Database.");
			}
		} catch (Exception Ex) {
			Setup.log.error("Syntax of query may be wrong.");
		}
		Setup.testcase.fail();
		return "0";

	}

	/*
	 * This method will get the count from UI by calculating the rows from
	 * Practice Measure Computation Summary.
	 */
	public String getCountOfRowsfromUI(String elementmethod, String locator) {
		List<WebElement> rows = null;
		int Size;
		try {
			rows = getWebElements(elementmethod, locator);
			Size = rows.size();
			System.out.println("Number of IDs and measures in Practice Measure Grid: " + Size);
			return Integer.toString(Size);
		} catch (Exception Ex) {
			Setup.testcase.fail();
			Setup.log.error("Unable to find using the provided locator.");
			return "0";
		}

	}

	/*
	 * This method will get the count from label Total Records: from Practice
	 * Measure Computation Summary
	 */
	public String getTotalRecFromUI(String elementmethod, String locator) {
		ElementMethod Elm = new ElementMethod();
		try {
			return trimuicount(Elm.gettext(elementmethod, locator));
		} catch (Exception Ex) {

			Setup.testcase.fail();
			Setup.log.error("No Provider Record found in the UI");
			return "0";
		}

	}

	/*
	 * This method will trim the unnecessary characters and return the numeric value.
	 */
	public String trimuicount(String textcount) {
		int index = 0;
		char character = ' ';
		System.out.println("Count of text is: " + textcount.length());
		for (int i = 0; i < textcount.length(); i++) {
			if (textcount.charAt(i) == character) {
				index = i;
			}
		}
		System.out
				.println("Returning this to getTotalRecFromUI: " + textcount.substring(index + 1, textcount.length()));
		return textcount.substring(index + 1, textcount.length());
	}

	/*
	 * This method will give the count of measures with higher scores on
	 * dashboard for selected quarter
	 */
	public String getCountOfHSMeasures(String elementmethod, String locator) {
		List<WebElement> rows = null;
		int i = 0;
		try {
			rows = getWebElements(elementmethod, locator);
			for (WebElement Table : rows) {
				// System.out.println("Coming here in Foor loop");
				String tooltip = Table
						.findElement(By.xpath("./td[5]/i[@class='icon-info-sign bigger-150 light-grey tooltip-hide']"))
						.getAttribute("title");
				if (tooltip.contains("Higher")) {
					i = i + 1;
				} else
					continue;
			}
			return Integer.toString(i);

		} catch (Exception Ex) {
			Setup.testcase.fail();
			Setup.log.error("Unable to find using the provided locator.");
			return "0";
		}
	}

	/*
	 * This method will give the count of measures with lower scores on
	 * dashboard for selected quarter
	 */
	public String getCountOfLSMeasures(String elementmethod, String locator) {
		List<WebElement> rows = null;
		int i = 0;
		try {
			rows = getWebElements(elementmethod, locator);
			for (WebElement Table : rows) {
				// System.out.println("Coming here in Foor loop");
				String tooltip = Table
						.findElement(By.xpath("./td[5]/i[@class='icon-info-sign bigger-150 light-grey tooltip-hide']"))
						.getAttribute("title");
				if (tooltip.contains("Lower")) {
					i = i + 1;
				} else
					continue;
			}
			return Integer.toString(i);

		} catch (Exception Ex) {
			Setup.testcase.fail();
			Setup.log.error("Unable to find using the provided locator.");
			return "0";
		}
	}
	
}
