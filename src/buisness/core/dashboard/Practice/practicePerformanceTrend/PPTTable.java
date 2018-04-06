package buisness.core.dashboard.Practice.practicePerformanceTrend;

import java.sql.ResultSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import buisness.core.DashboardUI;
import buisness.core.ElementMethod;
import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.dashboard.practice.practicePerformanceTrend.PPTTableGrid;
import configuration.Setup;

public class PPTTable extends DashboardUI {
	public String Quarter;
	public String All;
	public String Met;
	public String NotMet;
	public String Percentage;
	public ConfigurationManager config;
	public ElementMethod em;
	public String locator;

	// ProviderTable constructor
	public PPTTable() {
		em = new ElementMethod();

	}

	/**
	 * getDBProviderList method
	 * <p>
	 * Returns PopupProviderGrid object containing all providers and their
	 * details available
	 * <p>
	 * for logged in user in the database.
	 * 
	 * @author Sachin.Gawade 12 Jan 2016
	 */
	
	public String getQuery(String queryName)
	{
		config = new ConfigurationManager();
		String query = config.getQuery(queryName);
		query=query.replace("@loginuser",getLoggedInUser());
		return query;
	}	

	public PPTTableGrid getDBPPTTable(String query) {
		DatabaseManger.SQLserverConnection();
		ResultSet rs = DatabaseManger.exeQuery(query);
		Setup.log.info("Result Set:"+rs);
		PPTTableGrid dbgrid = new PPTTableGrid();
		Setup.log.trace(query);
		Setup.log.info(rs);
		try {
			while (rs.next()) {
				try {
					Quarter = rs.getString("Quarter");
					Setup.log.info(Quarter);
					All = rs.getString("All");
					Setup.log.info(All);
					Met = rs.getString("Met");
					Setup.log.info(Met);
					NotMet = rs.getString("NotMet");
					Setup.log.info(NotMet);
                    Percentage = rs.getString("Percentage");
					Setup.log.info(Percentage);
				} catch (Exception e) {
					Setup.log.error("Please verify the coulumn names in queries");
				}
				dbgrid.addRowToTable(Quarter,All,Met,NotMet,Percentage);

			}
		} catch (Exception e) {
			Setup.log.error("No record in table of the database");
		}

		return dbgrid;
	}

	/**
	 * getUIProviderlist method
	 * <p>
	 * Returns DashboardLocationProviderGrid object containing all providers and
	 * their details available
	 * <p>
	 * for logged in user in the UI.
	 * 
	 * @param locator
	 *            (of the table in the UI)
	 * @author Sachin.Gawade 12 Jan 2016
	 */
	public PPTTableGrid getUIPPTTable(String locator) {
		PPTTableGrid uigrid = new PPTTableGrid();
		List<WebElement> rows = em.getWebElements("xpath", locator);

		for (WebElement we : rows) {
			try {
				Quarter = we.findElement(By.xpath("./td[2]")).getText();
				Setup.log.info(Quarter);
				All = we.findElement(By.xpath("./td[3]")).getText();
				Setup.log.info(All);
				Met = we.findElement(By.xpath("./td[4]")).getText();
				Setup.log.info(Met);
				NotMet = we.findElement(By.xpath("./td[5]")).getText();
				Setup.log.info(NotMet);
				Percentage = we.findElement(By.xpath("./td[8]")).getText();
				Setup.log.info(Percentage);
			} catch (Exception e) {
				Setup.log.error("Error while fetching data from the UI.");
				Setup.testcase.assertTrue(false);
			}
			uigrid.addRowToTable(Quarter, All, Met, NotMet,Percentage);
		}
		return uigrid;

	}

}
