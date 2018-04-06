package buisness.core.dashboard.Practice.practiceMeasureGrid;

import buisness.core.dashboard.Practice.practiceMeasureGrid.PracticeMeasureCount;
import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import configuration.Setup;

/**
 * Verifies Favorites Measure Count present on Dashboard > Practice For Rolling
 * Extends PracticeMeasureCount 
 * This class Query Keyword to Extended
 * PracticeFavoritesMeasureCountNR class Returns boolean true if grid from UI
 * and Database match Returns boolean false if grid from UI and Database do not
 * match Return data to validate count.
 * @author Rakesh.Kulkani Created Date: 21/03/2016
 * @author probeer.roy Updated Date: 04/12/2017
 * 
 */

public class PracticeFavoritesMeasureCountR extends PracticeMeasureCount {

	/**
	 * Passes locator : To Find the element Passes Parameters elementmethod and
	 * locator to verify() Favorites Measure Count This method verify Count
	 * Method to compare object of DatabaseGrid and WebGrid. It check value
	 * present on UI with Database
	 * 
	 * @param locator
	 *            : To Find the element Name of locator in object repository
	 *            <p>
	 * @param elementmethod
	 *            : To Find the element by the type of Element Example xpath,
	 *            id,
	 * @Param data : quarter or month
	 * @return result of Test case "Pass" or "Fail"
	 */

	public boolean verifyCount(String elementmethod, String locator, String data, String data1) {
		ConfigurationManager config = new ConfigurationManager();
		DatabaseManger.SQLserverConnection();
		System.out.println(elementmethod + "" + locator + "" + data);

		String query = config.getQuery("PFMCountR");
		query = query.replace("@quartermonth", data);
		query = query.replace("@loginuser", getLoggedInUser());

		if (isQuarter(data)) {
			query = query.replace("@flag", data1);
		} else {
			query = query.replace("@flag", data1);
		}

		String dbCount = getCountFromDB(query);
		String uiCount = getTotalRecFromUI(elementmethod, locator);
		String elementmethod1 = "xpath";
		String locator1 = "//table[@id='sample-table-1']/tbody/tr[@style]";
		String uiRowCount = getCountOfRowsfromUI(elementmethod1, locator1);

		Setup.log.info("Ui_Count" + uiCount);
		Setup.log.info("Db_Count" + dbCount);
		Setup.log.info("uiRowCount" + uiRowCount);

		if (uiCount.equals(uiRowCount)) {
			//System.out.println("Total records and total number of rows are equal.");
			if (uiCount.equals(dbCount)) {
				Setup.log.info("\n Count from Database and UI are equal.");
				Setup.log.trace("\n Count from Database and UI are equal.");
				Setup.testcase.assertTrue(true);
				return true;
			} else {
				Setup.log.trace("\n Count from Database and UI are not equal");
				Setup.testcase.fail();
				return false;
			}
		} else {
			Setup.log.trace("\n Count of total records and UI are not equal");
			Setup.testcase.fail();
			return false;
		}

	}
}