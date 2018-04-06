package buisness.core.administration.location;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebElement;

import buisness.core.DashboardUI;
import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.administration.location.LocationGrid;
import configuration.Setup;

public abstract class Location extends DashboardUI   {
	
	 private static final boolean Webelement = false;
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
	     *Created date 12 Jan 2016
		 */
		
		public LocationGrid getDatabaseGrid(String query) 
		{
//		 DatabaseManger.SQLserverConnection();
//		String query = config.getQuery("LocationEnlisted");
         query=query.replace("@loginuser",getLoggedInUser());
		
	    ResultSet rs = DatabaseManger.exeQuery(query);
	    LocationGrid dbgrid = new LocationGrid();
	        Setup.log.trace(query);
	        System.err.println(query);
	        Setup.log.trace(rs);
		
			try {
				while(rs.next())
	{
					try {
						String locationname = rs.getString("locationname");
						String City= rs.getString("City");
						String State= rs.getString("State");
						String Postalcode= rs.getString("Postalcode");
						String Inactive= rs.getString("Inactive");
				        Setup.log.info(locationname+City+State+ Postalcode+Inactive);
				        
					   dbgrid.addPopupLocationGridcountRow1(locationname, City, State, Postalcode, Inactive);
					} catch (SQLException e)
					{
						Setup.log.error("Please verify the coulumn  LocationEnlisted query in   Queries.properties file");
						Setup.log.error(e.getMessage());
					}
					
	       
	}
			System.err.println("Db End");
			} catch (SQLException e) 
			{
				Setup.log.error("Please verify LocationEnlisted query in Queries.properties file");
				e.printStackTrace();
			}	

		
			return dbgrid;
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
		public LocationGrid getWebGrid(String locator,String elementMethod)
		{
			

			LocationGrid uigrid = null;
			List<WebElement> rows = null;
			
			try {
				uigrid = new LocationGrid();
				 rows = getWebElements(elementMethod, locator);
				//Setup.log.error(locator);
			} catch (InvalidSelectorException e1)
			{
				Setup.log.error("Please verify xpath in Object repository file");
				e1.printStackTrace();
			}
			try {
				for(WebElement we : rows)
				{
					String locationname = we.findElement(By.xpath("./td[1]")).getText();
					//String locationname = we.findElement(By.xpath("./td[1csccs]")).getText();
				    String City = we.findElement(By.xpath("./td[2]")).getText();
					String State = we.findElement(By.xpath("./td[3]")).getText();
				    String Postalcode = we.findElement(By.xpath("./td[4]")).getText();
					String Inactive = we.findElement(By.xpath("./td[5]")).getText();
					Setup.log.info(locationname+City+State+ Postalcode+Inactive);
					uigrid.addPopupLocationGridcountRow1(locationname, City, State, Postalcode, Inactive);
				}
			} catch (Exception e) 
			{
				Setup.log.error("Error while fetching the data from the UI");
			}
		
			return uigrid;
			
		}
		


	

}
