package buisness.core.dashboard.location;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import buisness.util.datastructures.dashboard.location.LocationGrid;
import buisness.util.datastructures.dashboard.practice.PracticeLocationPopUpGrid;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import buisness.core.DashboardUI;
import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import configuration.Setup;

abstract public class Location extends DashboardUI   {
	
	 ConfigurationManager config;
		
		public Location() 
		{
			config = new ConfigurationManager();
		
		}	 
		/**
		 * getDBLocationListit()<p>
		 * Returns AdministrationLocationGrid object containing all locations and their details available<p>
		 * for logged in user in the database<p>
		 *  @return dbgrid which contains all database rows 
		 * @author nilesh.patil
	     *Created date 3 FEB 2016
		 */
		
		public buisness.util.datastructures.dashboard.location.LocationGrid getDatabaseGrid(String query) 
		{
			DatabaseManger.SQLserverConnection();
			ResultSet resultSet= DatabaseManger.exeQuery(query);
			LocationGrid dbGrid=new LocationGrid();
			Setup.log.trace(query);
			System.err.println(query);
			try {
				while(resultSet.next())
	{
					try {
						String locationName = resultSet.getString("locationName");
						String Exceeding= resultSet.getString("Exceeding");
						String below= resultSet.getString("below");
				        Setup.log.info(locationName+Exceeding+below);
						dbGrid.addPopupLocationGridcountRow1(locationName, Exceeding, below);
					  
					} catch (SQLException e)
					{
						Setup.log.error("Please verify the coulumn  LocationEnlisted query in   Queries.properties file");
						Setup.log.debug(e.getMessage());
					}
	       
	}
			} catch (SQLException e) 
			{
				Setup.log.error("Please verify LocationEnlisted query in Queries.properties file");
				e.printStackTrace();
			}	

		
			return dbGrid;
	}
		/**
		 * getUILocationlist(String locator)<p>
		 * Returns AdministrationLocationGrid object containing all locations and their details available<p>
		 * for logged in user in the database<p>
		 * @param locator<p>
		 * @return uigrid which contains all the UI Data 
		 * 
		 * @author nilesh.patil
	     *Created date 12 Jan 2016
		 */
		public buisness.util.datastructures.dashboard.location.LocationGrid getWebGrid(String elementMethod ,String locator)
		{
			System.out.println("xyz");
			System.out.println("1"+locator);

			buisness.util.datastructures.dashboard.location.LocationGrid uigrid = new buisness.util.datastructures.dashboard.location.LocationGrid();
			List<WebElement> rows = getWebElements(elementMethod, locator);
			
		/*	try {
				
				Setup.log.debug(locator);
			} catch (InvalidSelectorException e1)
			{
				Setup.log.error("Please verify xpath in Object repository file");
				e1.printStackTrace();
			}*/
			System.out.println("2"+locator);
			try {
				for(WebElement we : rows)
				{
					String locationName = we.findElement(By.xpath("./td[1]/a")).getText();
				    String Exceeding = we.findElement(By.xpath("./td[2]/a")).getText();
					String below = we.findElement(By.xpath("./td[3]/a")).getText();
					Setup.log.info(locationName+Exceeding+below);
					uigrid.addPopupLocationGridcountRow1(locationName, Exceeding, below);
				}
			} catch (Exception e) 
			{
				Setup.log.error("Error while fetching the data from the UI");
			}
			
			return uigrid;
			
		}
		


	

}
