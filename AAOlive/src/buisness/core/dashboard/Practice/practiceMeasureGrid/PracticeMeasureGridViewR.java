package buisness.core.dashboard.Practice.practiceMeasureGrid;

import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.dashboard.practice.practiceMeasureGrid.DefaultMeasureGrid;
import configuration.Setup;
/**
 * Verifies Practice Measure Grid present on Dashboard > Practice > Measure computation summary For Rolling<p>
 * Extends DefaultMeasureGridComp
 * Returns boolean true if grid from UI and Database match<p>
 * Returns boolean false if grid from UI and Database does not match<p>
 * @author probeer.roy
 * Created Date: 07/12/2017
 * 
 */
public class PracticeMeasureGridViewR extends DefaultMeasureGridComp {
	ConfigurationManager config;

	public PracticeMeasureGridViewR() {
		config = new ConfigurationManager();
	}

	public DefaultMeasureGrid getdatabaseGrid(String query) {
		DatabaseManger.SQLserverConnection();
		System.out.println("Actual Query called:" + query);
		return super.getDBgrid(query);
	}

	/* This method will compare each row from UI and DB */
	public boolean verifyPracticeMeasureGridR(String elementmethod, String locator, String data, String data1) {
		System.out.println("verifyPracticeMeasureGrid method Invoked.");
		String query = config.getQuery("PracticeMeasureGridR");
		query = query.replace("@quartermonth", data);
		query = query.replace("@loginuser", getLoggedInUser());
		if (isQuarter(data)) {
			query = query.replace("@flag", data1);
		} else {
			query = query.replace("@flag", data1);
		}
		DefaultMeasureGrid dbGrid = getdatabaseGrid(query);
		System.out.println(dbGrid);
		DefaultMeasureGrid uiGrid = getWebgrid(elementmethod, locator);
		if (uiGrid.compareTo(dbGrid) == 0) {
			Setup.log.trace("Data present on patient visits grid on UI matched with data in database");
			Setup.testcase.assertTrue(true);
			return true;
		} else {
			Setup.log.trace("Data present on patient visits grid on UI does not matched with data in database");
			Setup.testcase.fail();
			return false;
		}
	}

}
