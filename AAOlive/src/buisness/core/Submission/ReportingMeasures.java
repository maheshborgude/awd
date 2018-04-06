package buisness.core.Submission;

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
import buisness.util.datastructures.Submission.gprosubmission.milestonetwo.ReportingMeasureGrid;
import configuration.Setup;

/**
 * Provider class<p>
 * Extends DashboardUI
 * This class i sused to verify GPRO Reporting Measures grid.
 * Provides getDBList(), getUIlist()
 * @author Sachin.Gawade
 * 11 Feb 2016
 */

public class ReportingMeasures  extends DashboardUI {
	
	public ConfigurationManager config;
	public ElementMethod em;
	private boolean checkAllMeasures;
	
	//ProviderTable constructor
	public ReportingMeasures() 
	{
		em  = new ElementMethod();
		checkAllMeasures =true;
		//'checkAllMeasures' variable is used so that we can use the same code to check
		//Selected measures and all measures in GPRO Reporting measures milestone
		//By default it is set as True
		//When only selected measures need to be verified then checkAllMeasures must be set as false
	}
	
	/**
	 * Returns GPROMeasureGrid object<p>
	 * This class gets Db grid from passed query
	 * @author Sachin.Gawade
	 * 11 Feb 2016
	 */
	public ReportingMeasureGrid  getDatabaseGrid(String query) 
	{
		
	 DatabaseManger.SQLserverConnection();
    ResultSet rs = DatabaseManger.exeQuery(query);
    ReportingMeasureGrid dbgrid = new ReportingMeasureGrid();

    Setup.log.trace(query);
    Setup.log.trace(rs);
	
		try {
			while(rs.next())
{
				try {

					String pqrsno = rs.getString("pqrsno");
					String measuretitle= rs.getString("measuretitle");
					String qualitydomain= rs.getString("qualitydomain");
					String crosscutting= rs.getString("crosscutting");
					dbgrid.GproMeasureGridCountRow(pqrsno, measuretitle, qualitydomain , crosscutting);
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
				
}
		} catch (Exception e) {
		
			Setup.log.error("No providers found for the logged in user in the database");
		}	
	
		return dbgrid;
}

	/**
	 * Returns GproMeasureGrid object containing all measure details<p>
	 * This class is used to fetch grid from the UI.
	 * @param locator (of the table in the UI)
	 * @author Sachin.Gawade
	 * 11 Feb 2016
	 */

	public ReportingMeasureGrid getWebGrid(String elementmethod,String locator)

	{
		ReportingMeasureGrid uigrid = new ReportingMeasureGrid();
		List<WebElement> rows = em.getWebElements(elementmethod, locator);
	
		
		for(WebElement we : rows)
		{
			
			//FIX: Why am I hard coded
			if(checkAllMeasures==true || we.findElement(By.xpath("./td[1]/input[@type='checkbox']")).isSelected() )
			{	
			try
			{
				String pqrsno= we.findElement(By.xpath("./td[2]")).getText();
				String measuretitle = we.findElement(By.xpath("./td[3]")).getText();
				String qualitydomain = we.findElement(By.xpath("./td[4]")).getText();
				String crosscutting= we.findElement(By.xpath("./td[5]")).getText();
				uigrid.GproMeasureGridCountRow(pqrsno, measuretitle, qualitydomain, crosscutting);
			}
			catch(NoSuchElementException e)
			{
				Setup.log.error(e);
				Setup.log.error("Element not found on the UI. Please check xpath of column in webtable. ");
			}
			
			catch(Exception e)
			{
				Setup.log.error(e);
				Setup.log.error("Exception faced while fetching data from UI. ");
			}

			}
		}
		return uigrid;
		
	}
/**
 * Get boolean checkAllMeasures variable
 * @return
 */
	public boolean getCheckAllMeasures() {
		return checkAllMeasures;
	}
/**
 * Set checkAllMeasures variable
 * @param flag
 */
	public void setCheckAllMeasures(boolean setCheckAllMeasures) {
		this.checkAllMeasures = setCheckAllMeasures;
	}
	
	
}
