	
package buisness.core.rpc.resetpracticekey;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import buisness.core.DashboardUI;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.rpc.resetpracticekey.ResetPracticeKeyGrid;
import configuration.Setup;
/**
 * This is used to fetch Advanced Status grid from UI and Database 
 * This class has the following methods trimMultiSpace(),getWebGrid() and getDatabaseGrid()
 * @author rakesh.kulkani
 * @Date 11/03/2016
 */
abstract public class ResetPracticeKey extends DashboardUI {

	/**
	 * This method is used to get data from the UI Reset practice key
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * Returns AdvancedStatusGrid object         
	 */
	public ResetPracticeKeyGrid getWebGrid(String elementmethod,String locator)
	{
		if(locator!=null)
		{
			ResetPracticeKeyGrid resetPracticeKeyGrid=new ResetPracticeKeyGrid();
			try
			{
				List<WebElement> rows = getWebElements(elementmethod, locator);			
				Setup.log.trace(locator);
				for(WebElement table : rows)
				{					
					String practiceID = table.findElement(By.xpath("./td[1]")).getText();
					Setup.log.info(practiceID);
					String practiceName = table.findElement(By.xpath("./td[2]")).getText();
					Setup.log.info(practiceName);
					String registrationKeyInUse = table.findElement(By.xpath("./td[3]")).getText();	
					Setup.log.info(registrationKeyInUse);
					String lastAccessTime = table.findElement(By.xpath("./td[4]")).getText();
					Setup.log.info(lastAccessTime);
					resetPracticeKeyGrid.add(practiceID, practiceName, registrationKeyInUse, lastAccessTime);
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
			return resetPracticeKeyGrid;	
		}
		else
		{
			Setup.log.error("Locator not found in object repository "+locator);
			return null;
		}

	}

	/**
	 * This method is used to get data from ui Reset practice key Grid
	 * @param query Query to be run on database<p>
	 * 
	 */
	public ResetPracticeKeyGrid getDatabaseGrid(String query)
	{
		String userName =getLoggedInUser();
		query=query.replace( "@loginuser",userName);	
		DatabaseManger.SQLserverConnection(); 
		ResultSet resultSet= DatabaseManger.exeQuery(query);
		ResetPracticeKeyGrid resetPracticeKeyGridDB=new ResetPracticeKeyGrid();
		Setup.log.trace(query);
		if(resultSet != null)
		{
			try {
				while(resultSet.next())
				{
					String practiceID = resultSet.getString("practiceID");	
					String practiceIDT=trimMultiSpace(practiceID).trim();	
					Setup.log.info(practiceIDT);
					
					String practiceName = resultSet.getString("practiceName");	
					String practiceNameT=trimMultiSpace(practiceName).trim();	
					Setup.log.info(practiceNameT);
					
					String registrationKeyInUse = resultSet.getString("registrationKeyInUse");	
					String registrationKeyInUseT=trimMultiSpace(registrationKeyInUse).trim();	
					Setup.log.info(registrationKeyInUseT);
					
					String lastAccessTime = resultSet.getString("lastAccessTime");	
					String lastAccessTimeT=trimMultiSpace(lastAccessTime).trim();		
					Setup.log.info(lastAccessTimeT);
					
					resetPracticeKeyGridDB.add(practiceIDT, practiceNameT, registrationKeyInUseT, lastAccessTimeT);
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
			return resetPracticeKeyGridDB;
		}

		else
		{
			Setup.log.error("Result set obtained after running given query is NULL");
			return null;
		}
	}
}
