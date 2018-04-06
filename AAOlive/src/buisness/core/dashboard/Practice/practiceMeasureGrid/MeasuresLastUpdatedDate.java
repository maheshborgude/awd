package buisness.core.dashboard.Practice.practiceMeasureGrid;

import java.sql.ResultSet;
import buisness.core.DashboardUI;
import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import configuration.Setup;
/**
 * Verifies  the last updated date on Dashboard > Practice <p>
 * Extends DashboardUI
 * Returns boolean true if count from UI and Database match<p>
 * Returns boolean false if count from UI and Database does not match<p>
 * @author probeer.roy
 * Created Date: 07/12/2017
 * 
 */
public class MeasuresLastUpdatedDate extends DashboardUI {
	ConfigurationManager config;

	public MeasuresLastUpdatedDate() {
		config = new ConfigurationManager();
	}
	
	public boolean verifyMeasuresLastUpdatedDate(String elementmethod, String locator, String data, String data1) {
		System.out.println("verifyMeasuresLastUpdatedDate method Invoked.");
		String getDateFromDb = null;
		DatabaseManger.SQLserverConnection();

		String query = config.getQuery("LastUpdatedDate");
		query = query.replace("@quartermonth", data);
		query = query.replace("@loginuser", getLoggedInUser());
		if (isQuarter(data)) {
			query = query.replace("@flag", data1);
		} else {
			query = query.replace("@flag", data1);
		}
		System.out.println("Query passed: " + query);
		ResultSet resultSet = DatabaseManger.exeQuery(query);

		if (resultSet != null) {
			try {
				while (resultSet.next()) {
					getDateFromDb = resultSet.getString("Date");
					System.out.println(getDateFromDb);
				}
			} catch (Exception e) {
				Setup.log.error("Exception while fetching the data from Database.");
				Setup.testcase.fail();
			}
		}
		String getDateFromUi = getWebElement(elementmethod, locator).getText();
		System.out.println(getDateFromUi);

		if (getDateFromDb.equals(getDateFromUi)) {
			Setup.log.trace("Last Updated Date present on UI and database is same.");
			Setup.testcase.assertTrue(true);
			return true;
		} else {
			Setup.log.trace("Last Updated Date present on UI and database is not same.");
			Setup.testcase.fail();
			return false;
		}
	}

}
