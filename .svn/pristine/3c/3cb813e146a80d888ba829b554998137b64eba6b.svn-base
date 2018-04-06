package buisness.core.dashboard.Practice.practiceProvider.rolling;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import buisness.core.DashboardUI;
import buisness.core.ElementMethod;
import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.dashboard.practice.practiceProvider.PracticeProviderPT_TableGrid;
import configuration.Setup;

public class PracticeProviderPopUpTabBasicR extends DashboardUI {

	public String Quarter;
	public String All;
	public String Met;
	public String NotMet;
	public String Percentage;
	public ConfigurationManager config;
	public ElementMethod em;
	public String locator;

	// ProviderTable constructor
	public PracticeProviderPopUpTabBasicR() 
	{
		em = new ElementMethod();

	}


	/** Gets Dashboard>>Practice>>Provider count from database<p>
	 *@param query: Name of query in query repository<p>
	 */

	public String getdatabasePracticeProvidercount(String query)
	{
		DatabaseManger.SQLserverConnection();
		try {
			ResultSet resultSet = DatabaseManger.exeQuery(query);
			
			if (resultSet.next()) 
			{
	                return resultSet.getString("TotalPracticeProviderCount");
			}
			else
			{
				Setup.log.error("No Provider Record found in the Database.");
			}
			
		}

		 catch(SQLException e)
		{
			Setup.log.error("SQL Exception. Please check query in query repository");
			Setup.testcase.fail();
		}
		catch(Exception e)
		{
			Setup.log.error("Exception faced while fetching data from Database.");
			Setup.testcase.fail();
		}
		Setup.testcase.fail();
		return "0";
	}
	

	/** Gets Provider\Location grid count from UI<p>
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator of Provider\Location record count in the UI is passed<p>
	 */
	public String getuiPracticeProvidercount(String elementmethod,String locator)
	{
		ElementMethod em=new ElementMethod();
		try
		{
		return trimuicount(em.gettext(elementmethod, locator));
		}
		catch(NoSuchElementException e)
		{
			Setup.log.error(e);
			Setup.log.error("Provider record Element is not found on the UI. Please check locator of the object passed. ");
		}
		
		catch(Exception e)
		{
			Setup.log.error(e);
			Setup.log.error("Exception faced while fetching Provider Count Record data from UI. ");
		}
		Setup.testcase.fail();
		return "0";
	}
	

    /*Returns query as string  */
	public String getQuery(String queryName,String data) 
	{
		config = new ConfigurationManager();
		String query = config.getQuery(queryName);
		query = query.replace("@loginuser", getLoggedInUser());
		//query = query.replace("@flag", getFlag());
		query=query.replace("@QuarterOrMonth",data);
		return query;
	}
	/**
	 * getDBPracticeProviderPTTable method
	 * Returns Performance Trend table details from Dashboard>>Practice Provider tab
	 * Returns PracticeProviderPT_TableGrid object containing respective providers and their details available
	 * including Quarter,All, Met, NotMet and Percentage
	 * for logged in user in the database.
	 * 
	 * @author Ashwini.Gore 1 Dec 2017
	 */
	public PracticeProviderPT_TableGrid getDBPracticeProviderPTTable(String query) {
		DatabaseManger.SQLserverConnection();
		ResultSet rs = DatabaseManger.exeQuery(query);
		Setup.log.info("Result Set:" + rs);
		PracticeProviderPT_TableGrid dbgrid = new PracticeProviderPT_TableGrid();
		Setup.log.trace(query);
		Setup.log.info(rs);
		try {
			while (rs.next()) {
				try {
					Quarter = rs.getString("Quarter");
					//System.out.print(" DB: "+Quarter);
					All = rs.getString("All");
					//System.out.print(" DB: "+All);
					Met = rs.getString("Met");
					//System.out.print(" DB: "+Met);
					NotMet = rs.getString("NotMet");
					//System.out.print(" DB: "+NotMet);
					Percentage = rs.getString("Percentage");
					//System.out.println(" DB: "+Percentage);
				} catch (Exception e) {
					Setup.log.error("Please verify the coulumn names in queries");
				}
				dbgrid.addRowToTable(Quarter, All, Met, NotMet, Percentage);

			}
		} catch (Exception e) {
			Setup.log.error("No record in table of the database");
		}

		return dbgrid;
	}

	/**
	 * getUIPracticeProviderPTTable method
	 * Returns Performance Trend table details from Dashboard>>Practice Provider tab
	 * Returns PracticeProviderPT_TableGrid object containing respective providers and their details available
	 * including Quarter,All, Met, NotMet and Percentage
	 * for logged in user in the UI.
	 * @author Ashwini Gore 1 Dec 2017
	 */
	public PracticeProviderPT_TableGrid getUIPracticeProviderPTTable(String locator) {
		PracticeProviderPT_TableGrid uigrid = new PracticeProviderPT_TableGrid();
		List<WebElement> rows = em.getWebElements("xpath", locator);
		
		for (WebElement we : rows) {
			try {
				Quarter = we.findElement(By.xpath("./td[1]")).getText();
				//System.out.print(" UI Quarter: "+Quarter);
				All = we.findElement(By.xpath("./td[2]")).getText();
				//System.out.print(" UI All: "+All);
				Met = we.findElement(By.xpath("./td[3]")).getText();
				//System.out.print(" UI Met: "+Met);
				NotMet = we.findElement(By.xpath("./td[4]")).getText();
				//System.out.print(" UI NotMet: "+NotMet);
				Percentage = we.findElement(By.xpath("./td[5]")).getText();
				//System.out.println(" UI Percentage: "+Percentage);
			} catch (Exception e) {
				Setup.log.error("Error while fetching data from the UI.");
				Setup.testcase.assertTrue(false);
			}
			uigrid.addRowToTable(Quarter, All, Met, NotMet, Percentage);
		}
		return uigrid;

	}

}
