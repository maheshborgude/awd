package buisness.core.dashboard.Practice.practiceMeasureGrid;

import buisness.managers.ConfigurationManager;
import configuration.Setup;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Verifies Practice Measure Computation Summary Count present on Practice >>
 * Select Measure For Rolling
 * <p>
 * Extends PracticeMeasureCount
 * <p>
 * This class Query Keyword to Extended MeasureComputationSummaryView class
 * Returns boolean true if grid from UI and Database match
 * <p>
 * Returns boolean false if grid from UI and Database do not match
 * <p>
 * Return data to validate count.
 * 
 * @author Rakesh.Kulkani Created Date: 15/03/2016
 * @author probeer.roy Update Date: 04/12/2017
 * 
 */

public class PracticeMeasureCountR extends PracticeMeasureCount {

	/**
	 * Compares Practice\Measure Count for from UI and Database for Rolling This
	 * method is used to compare UI Grid data with Database grid data
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
	public String verifyPMCountR(String elementmethod, String locator, String data, String data1) {
		ConfigurationManager config = new ConfigurationManager();
		String query = config.getQuery("PracticeAllMeasureCountR");
		query = query.replace("@quartermonth", data);
		query = query.replace("@loginuser", getLoggedInUser());
		System.out.println(data1);
		if (isQuarter(data)) {
			query = query.replace("@flag", data1);
		} else {
			query = query.replace("@flag", data1);
		}

		String dbCount = getCountFromDB(query);
		String uiCount = getTotalRecFromUI(elementmethod, locator);
		String elementmethod1 = "xpath";
		String locator1 = "//table[@id='sample-table-1']/tbody/tr[@style]";
		String uiRowcount = getCountOfRowsfromUI(elementmethod1, locator1);

		Setup.log.info("Ui_Count" + uiCount);
		Setup.log.info("Db_Count" + dbCount);
		Setup.log.info("Ui_Row_Count" + uiRowcount);
		if (uiCount.equals(uiRowcount)) {
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