package buisness.core.dashboard.Practice.practiceMeasureGrid;

import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import configuration.Setup;

/**
 * Verifies  Measure count with high scores on Dashboard > Practice > Measure computation summary<p>
 * Extends PracticeMeasureCount
 * Returns boolean true if count from UI and Database match<p>
 * Returns boolean false if count from UI and Database does not match<p>
 * @author probeer.roy
 * Created Date: 07/12/2017
 * 
 */
public class MeasureCountWithHigherScores extends PracticeMeasureCount {


	public boolean verifyMeasureCountwithHS(String elementmethod, String locator, String data, String data1) {
		ConfigurationManager config = new ConfigurationManager();
		DefaultMeasureGridComp getUiCount = new DefaultMeasureGridComp();
		DatabaseManger.SQLserverConnection();
		String query = config.getQuery("PracticeMeasureCountWithHighLowScores");
		query = query.replace("@quartermonth", data);
		query = query.replace("@loginuser", getLoggedInUser());
		query = query.replace("@score", "0");
		System.out.println(data1);
		if (isQuarter(data)) {
			query = query.replace("@flag", data1);
		} else {
			query = query.replace("@flag", data1);
		}

		String dbCount = getCountFromDB(query);
		getUiCount.getMeasurewithHS(elementmethod, locator);		
		int uiCount = getUiCount.getHigherScoresMeasuresCount();
		Setup.log.info("Ui_Count" + uiCount);
		Setup.log.info("Db_Count" + dbCount);
	
			
			if (String.valueOf(uiCount).equals(dbCount)) {
				Setup.log.info("\n Count from Database and UI are equal.");
				Setup.log.trace("\n Count from Database and UI are equal.");
				Setup.testcase.assertTrue(true);
				return true;
			} else {
				Setup.log.info("\n Count from Database and UI are not equal");
				Setup.log.trace("\n Count from Database and UI are not equal");
				Setup.testcase.fail();
				return false;
			}
		} 

	}
