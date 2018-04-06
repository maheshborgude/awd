package buisness.core.dashboard.Practice.practiceMeasureGrid;

import buisness.managers.ConfigurationManager;
import configuration.Setup;

/**
 * Verifies Practice Measure Computation Summary Count present on Practice >>
 * Select Measure For NOnRolling Extends PracticeMeasureCount This class get
 * Query Keyword to Extended MeasureComputationSummaryView class
 * Returns boolean true if grid from UI and Database match 
 * Returns boolean false if grid from UI and Database do not match Return data to validate count
 * @author Rakesh.kulkarni Created Date: 15/03/2016
 * @author probeer.roy Updated Date: 04/12/2017
 */

public class PracticeMeasureCountNR extends PracticeMeasureCount {

	/**
	 * This method is used to compare UI Grid data with Database grid data
	 * <p>
	 * 
	 * @param elementmethod
	 *            Example xpath, id, etc.
	 *            <p>
	 * @param locator
	 *            Name of locator in object repository
	 *            <p>
	 * @param data
	 *            quarter or month Returns boolean true if grid from UI and
	 *            Database match
	 *            <p>
	 *            Returns boolean false if grid from UI and Database do not
	 *            match
	 *            <p>
	 */
	public String verifyPMCountNR(String elementmethod, String locator, String data, String data1) {
		ConfigurationManager config = new ConfigurationManager();
		String query = config.getQuery("PracticeAllMeasureCountR");
		query = query.replace("@quartermonth", data);
		query = query.replace("@loginuser", getLoggedInUser());

		if (isQuarter(data)) {
			query = query.replace("@flag", data1);
		} else {
			query = query.replace("@flag", data1);
		}
        System.out.println("Query Passed: " +query);
		String dbCount = getCountFromDB(query);
		String uiCount = getTotalRecFromUI(elementmethod, locator);
		String elementmethod1 = "xpath";
		String locator1 = "//table[@id='sample-table-1']/tbody/tr[@style]";
		String uiRowCount = getCountOfRowsfromUI(elementmethod1, locator1);
		Setup.log.info("Ui_Count" + uiCount);
		Setup.log.info("Db_Count" + dbCount);
		Setup.log.info("Ui_Row_Count" + uiRowCount);

		if (uiCount.equals(uiRowCount)) {
			System.out.println("Total records and total number of rows are equal.");
			if (uiCount.equals(dbCount)) {
				Setup.log.trace("\n Count from Database and UI are equal.");
				Setup.testcase.assertTrue(true);
				return "Pass";
			} else {
				Setup.log.trace("\n Count from Database and UI are not equal");
				Setup.testcase.fail();
				return "Fail";
			}
		} else {
			Setup.log.trace("\n Count of total records and UI are not equal");
			Setup.testcase.fail();
			return "Fail";
		}
	}
}