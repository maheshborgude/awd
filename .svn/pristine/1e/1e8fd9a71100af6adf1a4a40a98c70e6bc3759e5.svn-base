package buisness.core.dashboard.Practice.practiceMeasureGrid;

import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import configuration.Setup;

/**
 * Verifies  Measure count with lower scores on Dashboard > Practice > Measure computation summary<p>
 * Extends PracticeMeasureCount
 * Returns boolean true if count from UI and Database match<p>
 * Returns boolean false if count from UI and Database does not match<p>
 * @author probeer.roy
 * Created Date: 07/12/2017
 * 
 */
public class MeasureCountWithLowerScores extends PracticeMeasureCount {


	public boolean verifyMeasureCountwithLS(String elementmethod, String locator, String data, String data1) {
		ConfigurationManager config = new ConfigurationManager();
		DefaultMeasureGridComp getUiCount = new DefaultMeasureGridComp();
		DatabaseManger.SQLserverConnection();
		String query = config.getQuery("PracticeMeasureCountWithHighLowScores");
		query = query.replace("@quartermonth", data);
		query = query.replace("@loginuser", getLoggedInUser());
		query = query.replace("@score", "1");
		System.out.println(data1);
		if (isQuarter(data)) {
			query = query.replace("@flag", data1);
		} else {
			query = query.replace("@flag", data1);
		}

		String dbCount = getCountFromDB(query);
		getUiCount.getMeasurewithLS(elementmethod, locator);
		int uiCount = getUiCount.getLowerScoresMeasuresCount();

		Setup.log.info("Ui_Count" + uiCount);
		Setup.log.info("Db_Count" + dbCount);
		if (String.valueOf(uiCount).equals(dbCount)) {
				System.out.println("Total records and total number of rows are equal.");
				Setup.log.trace("\nCount from Database and UI are equal.");
				Setup.testcase.assertTrue(true);
				return true;
			} else {
				Setup.log.info("\nCount from Database and UI are not equal");
				Setup.log.trace("\nCount from Database and UI are not equal");
				Setup.testcase.fail();
				return false;
			}
		} 

	}
