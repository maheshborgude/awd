package buisness.core.dashboard.Practice.practiceMeasureGrid;

import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.dashboard.practice.practiceMeasureGrid.DefaultMeasureGrid;
import configuration.Setup;
/**
 * Verifies  the Measures with lower scores on Dashboard > Practice <p>
 * Extends DefaultMeasureGridComp
 * Returns boolean true if grid from UI and Database match<p>
 * Returns boolean false if grid from UI and Database does not match<p>
 * @author probeer.roy
 * Created Date: 07/12/2017
 * 
 */
public class MeasuresWithLowScores extends DefaultMeasureGridComp {
	ConfigurationManager config;

	public MeasuresWithLowScores() {
		config = new ConfigurationManager();
	}

	public DefaultMeasureGrid getdatabaseGrid(String query) {
		DatabaseManger.SQLserverConnection();
		System.out.println("Query Passed: " + query);
		return super.getDBgrid(query);
	}

	/* This method will compare each row from UI and DB */
	public boolean VerifyMeasureLS(String elementmethod, String locator, String data, String data1) {
		System.out.println("VerifyMeasureHS method Invoked.");
		String query = config.getQuery("PracticeMeasureHighLowScore");
		query = query.replace("@quartermonth", data);
		query = query.replace("@loginuser", getLoggedInUser());
		query = query.replace("@score", "1");
		if (isQuarter(data)) {
			query = query.replace("@flag", data1);
		} else {
			query = query.replace("@flag", data1);
		}
		DefaultMeasureGrid dbGrid = getdatabaseGrid(query);
	//	System.out.println(dbGrid);
		DefaultMeasureGrid uiGrid = getMeasurewithLS(elementmethod, locator);
		if (uiGrid.compareTo(dbGrid) == 0) {
			Setup.log.trace("Measure with lower scores on UI matched with data in database.");
			Setup.testcase.assertTrue(true);
			return true;
		} else {
			Setup.log.trace("Measure with lower scores on UI does not matched with data in database.");
			Setup.testcase.fail();
			return false;
		}
	}

}
