package buisness.core.gprosubmission;

import java.sql.ResultSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import buisness.core.DashboardUI;
import buisness.core.ElementMethod;
import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.gprosubmission.GproMeasureGrid;
import configuration.Setup;

/**
 * Provider class<p>
 * Extends DashboardUI
 * Provides getDBList, getUIlist
 * @author Sachin.Gawade
 * 11 Feb 2016
 */

public class GPROReportingMeasures  extends DashboardUI {
	public String pqrsno;
	public String measuretitle;
	public String qualitydomain;
	public String crosscutting;
	public ConfigurationManager config;
	public ElementMethod em;
	public String locator; 
	
	
	//ProviderTable constructor
	public GPROReportingMeasures() 
	{
		em  = new ElementMethod();
	
	}
	
	/**
	 * getDBList method<p>
	 * Returns GPRO Measure Grid object<p>
	 * @author Sachin.Gawade
	 * 11 Feb 2016
	 */

	public GproMeasureGrid  getDBList(String query) 
	{
	 DatabaseManger.SQLserverConnection();
    ResultSet rs = DatabaseManger.exeQuery(query);
    GproMeasureGrid dbgrid = new GproMeasureGrid();

    Setup.log.trace(query);
    Setup.log.trace(rs);
    //System.out.println("my query "+query);
	
		try {
			while(rs.next())
{
				try {
					pqrsno = rs.getString("pqrsno");
					measuretitle= rs.getString("measuretitle");
					qualitydomain= rs.getString("qualitydomain");
					crosscutting= rs.getString("crosscutting");
					
				}
					
				catch (Exception e) {
			
					Setup.log.error("Please verify the coulumn names in queries");
				}
				dbgrid.GproMeasureGridCountRow(pqrsno, measuretitle, qualitydomain , crosscutting);
				
}
		} catch (Exception e) {
		
			Setup.log.error("No providers found for the logged in user in the database");
		}	
	
		return dbgrid;
}

	/**
	 * getUIlist method<p>
	 * Returns GproMeasureGrid object containing all providers and their details available<p>
	 * @param locator (of the table in the UI)
	 * @author Sachin.Gawade
	 * 11 Feb 2016
	 */
	public GproMeasureGrid getUIlist(String locator)
	{
		GproMeasureGrid uigrid = new GproMeasureGrid();
		//TODO: try using invalid xpath function does not indicate wrong xpath
		List<WebElement> rows = em.getWebElements("xpath", locator);
	
		
		for(WebElement we : rows)
		{
			try
			{
			pqrsno= we.findElement(By.xpath("./td[2]")).getText();
			measuretitle = we.findElement(By.xpath("./td[3]")).getText();
			qualitydomain = we.findElement(By.xpath("./td[4]")).getText();
			crosscutting= we.findElement(By.xpath("./td[5]")).getText();
			
			}
			catch (Exception e)
			{
				Setup.log.error("Error while fetching data from the UI.");
				Setup.testcase.assertTrue(false);
			}
			uigrid.GproMeasureGridCountRow(pqrsno, measuretitle, qualitydomain, crosscutting);
					}
		//System.out.println("Reached here");
		return uigrid;
		
	}
	
	
}
