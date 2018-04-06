package buisness.core.dashboard.Practice.practiceMeasureGrid;

import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.dashboard.practice.practiceMeasureGrid.DefaultMeasureGrid;
import configuration.Setup;

/**
 * Verifies Favorites Measure View present on Dashboard > Practice For
 * NOnRolling Extends DefaultMeasureGridComp
 * <p>
 * This class Query Keyword to Extended PracticeFavoritesMeasureViewNR class
 * Returns boolean true if grid from UI and Database match Returns boolean false
 * if grid from UI and Database do not match Return data to validate count.
 * @author Rakesh.kulkarni Created Date: 15/03/2016
 * @author probeer.roy Updated Date: 07/12/2017
 */

public class PracticeFavoritesMeasureViewNR extends DefaultMeasureGridComp {

	/**
	 * This method is used to compare UI Grid data with Database grid data For
	 * NonRolling and Favorites Measure
	 * <p>
	 * Passes locator : To Find the element Passes Parameters elementmethod and
	 * locator to verify() of PqrsAdvancedStatusView class This method verify
	 * Count Method to compare object of DatabaseGrid and WebGrid. It check
	 * value present on UI with Database
	 * 
	 * @param locator
	 *            : To Find the element Name of locator in object repository
	 *            <p>
	 * @param elementmethod
	 *            : To Find the element by the type of Element Example xpath,
	 *            id,
	 * @Param data : quarter or month
	 * @return result of Test case "Pass" or "Fail" Return data to validate
	 *         count.
	 */

	public boolean verifyPFMViewNR(String locator, String elementmethod, String data, String data1) {
		ConfigurationManager config = new ConfigurationManager();
		DatabaseManger.SQLserverConnection();
		String query = config.getQuery("PFMViewNR");
		query = query.replace("@loginuser", getLoggedInUser());
		query = query.replace("@quartermonth", data);

		if (isQuarter(data)) {
			query = query.replace("@flag", data1);
		} else {
			query = query.replace("@flag", data1);
		}
		DefaultMeasureGrid databaseGrid = getDBgrid(query);
		DefaultMeasureGrid webGrid = getWebgrid(locator, elementmethod);
		if (webGrid != null) {

			if (databaseGrid != null) {
				if (webGrid.compareTo(databaseGrid) == 0) {
					Setup.log.info("Data on UI and Database are matched.");
					Setup.log.trace("Data on UI and Database are matched.");
					Setup.testcase.assertTrue(true);
					return true;
				} else {
					Setup.log.trace("Data on UI and Database does not match.");
					Setup.testcase.fail();
					return false;
				}
			}

			else {
				Setup.log.error("Result in Database is null");
			}
		} else {
			Setup.log.error("UI grid is null");
		}
		Setup.testcase.fail();
		return false;
	}

}