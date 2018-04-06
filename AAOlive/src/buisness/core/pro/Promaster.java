package buisness.core.pro;

import java.sql.ResultSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import buisness.core.DashboardUI;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.administration.practice.PracticeGrid;
import configuration.Setup;

public class Promaster extends DashboardUI {

	
	public PracticeGrid getWebGrid(String elementmethod, String locator)
	{
		PracticeGrid practiceGridUI=new PracticeGrid();
		try
		{
			List<WebElement> rows = getWebElements("Xpath", locator);
			
			Setup.log.debug(locator);
			for(WebElement table : rows)
			{
				String externalID = table.findElement(By.xpath("./td[1]")).getText();
				String listName = table.findElement(By.xpath("./td[2]")).getText();			
				String npi = table.findElement(By.xpath("./td[3]")).getText();
				String inactive = table.findElement(By.xpath("./td[4]")).getText();
				practiceGridUI.add(externalID, listName, npi,inactive);

			}
		}
		catch(Exception error)
		{
			Setup.log.warn("Please check xpath in ObjectRepositary.Properties file ");
		}
		return practiceGridUI;
	}

	/**
	 * This method is used to get data from Database and return a object with Grid value<p>
	 * For logged in user in the database<p>
	 * @param locator
	 * @return Object of specified class
	 */
	public PracticeGrid getDbGrid(String query)
	{
		DatabaseManger.SQLserverConnection(); 
		String uname=getLoggedInUser();
		query=query.replace( "@loginuser",uname);	
		ResultSet resultSet= DatabaseManger.exeQuery(query);
		PracticeGrid practiceGridDB=new PracticeGrid();
		Setup.log.trace(query);
		if(resultSet != null)
		{
			
			try {
				while(resultSet.next())
				{
					String externalID = resultSet.getString("ExternalID");	
					String externalIDT=trimMultiSpace(externalID).trim();	
					String listName = resultSet.getString("ListName");	
					String listNameT=trimMultiSpace(listName).trim();		
					String npi = resultSet.getString("npi");
					String inactive = resultSet.getString("inactive");
					practiceGridDB.add(externalIDT, listNameT, npi , inactive);
				}

			}
			catch(Exception e)
			{
				Setup.log.error("Please check query in 'Queries.properties.ValidateTotalPracticeCount'or verify the logged in UserName");
				Setup.testcase.fail();
			}
			return practiceGridDB;
		 }
		
		else
		{
			return null;
		}
	}
}


