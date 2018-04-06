	
package buisness.core.Submission;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import buisness.core.DashboardUI;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.Submission.AdvancedStatusGrid;
import configuration.Setup;
/**
 * This is used to fetch Advanced Status grid from UI and Database 
 * This class has the following methods trimMultiSpace(),getWebGrid() and getDatabaseGrid()
 * @author Sachin.Gawade
 * date 16 Feb 2016
 */
abstract public class AdvancedStatus extends DashboardUI {

	/**
	 * This method is used to get data from the UI of Advanced Status grid
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * Returns AdvancedStatusGrid object
	 */
	public AdvancedStatusGrid getWebGrid(String elementmethod,String locator)
	{
		if(locator!=null)
		{
			AdvancedStatusGrid pqrsAdvancedStatusGrid=new AdvancedStatusGrid();
			try
			{
				List<WebElement> rows = getWebElements(elementmethod, locator);			
				Setup.log.trace(locator);
				for(WebElement table : rows)
				{					
					String measure = table.findElement(By.xpath("./td[1]")).getText();
					Setup.log.info(measure);
					String eligible = table.findElement(By.xpath("./td[2]")).getText();
					Setup.log.info(eligible);
					String met = table.findElement(By.xpath("./td[3]")).getText();	
					Setup.log.info(met);
					String notMet = table.findElement(By.xpath("./td[4]")).getText();
					Setup.log.info(notMet);
					String notApplicable = table.findElement(By.xpath("./td[5]")).getText();
					Setup.log.info(notApplicable);
					String exclusion = table.findElement(By.xpath("./td[6]/a")).getText();
					Setup.log.info(exclusion);
					pqrsAdvancedStatusGrid.add(measure, eligible, met, notMet, notApplicable, exclusion);
				}
			}
			catch(NoSuchElementException e)
			{
				Setup.log.error(e);
				Setup.log.error("Element not found on the UI. Please check xpath of column in webtable. ");
			}
			
			catch(Exception e)
			{
				Setup.log.error(e);
				Setup.log.error("Exception faced while fetching data from UI.");
			}
			return pqrsAdvancedStatusGrid;	
		}
		else
		{
			Setup.log.error("Locator not found in object repository "+locator);
			return null;
		}

	}

	/**
	 * This method is used to get data from the database for PQRS Advanced Status grid
	 * Returns PqrsAdvancedStatusGrid object
	 * @param query Query to be run on database<p>
	 */
	public AdvancedStatusGrid getDatabaseGrid(String query)
	{
		String userName =getLoggedInUser();
		query=query.replace( "@loginuser",userName);	
		DatabaseManger.SQLserverConnection(); 
		ResultSet resultSet= DatabaseManger.exeQuery(query);
		AdvancedStatusGrid pqrsAdvancedStatusGridDB=new AdvancedStatusGrid();
		Setup.log.trace(query);
		if(resultSet != null)
		{
			try {
				while(resultSet.next())
				{
					String measure = resultSet.getString("measure");	
					String measureT=trimMultiSpace(measure).trim();		
					String eligible = resultSet.getString("eligible");	
					String eligibleT=trimMultiSpace(eligible).trim();	
					String met = resultSet.getString("met");	
					String metT=trimMultiSpace(met).trim();	
					String notMet = resultSet.getString("notMet");	
					String notMetT=trimMultiSpace(notMet).trim();
					String notApplicable = resultSet.getString("notApplicable");	
					String notApplicableT=trimMultiSpace(notApplicable).trim();
					String exclusion = resultSet.getString("exclusion");	
					String exclusionT=trimMultiSpace(exclusion).trim();				
					pqrsAdvancedStatusGridDB.add(measureT, eligibleT, metT, notMetT,notApplicableT,exclusionT);
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
			return pqrsAdvancedStatusGridDB;
		}

		else
		{
			Setup.log.error("Result set obtained after running given query is NULL");
			return null;
		}
	}
}
