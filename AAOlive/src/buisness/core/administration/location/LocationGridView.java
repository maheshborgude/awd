package buisness.core.administration.location;

import java.sql.SQLException;

import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.administration.location.LocationGrid;
import configuration.Setup;

/**
 * This class is used to get  grid  data of Location from UI and  grid  data from Database   
 *
 * @author nilesh.patil
 *Created date 12 Jan 2016
 */

public class LocationGridView extends Location {
	
	
      ConfigurationManager config;
	
	public LocationGridView() 
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
	
	public LocationGrid getDBLocationListit() 
	{
	 DatabaseManger.SQLserverConnection();
	String query = config.getQuery("LocationEnlisted");
	 query=query.replace("@loginuser",getLoggedInUser());

        
        return super.getDatabaseGrid(query);
		
}
	

	/**
	 * verifyEnlistedLocations(String locator)
	 *This method is used to compare Uilocationgrid data  with Databaselocationgrid data <p>
	 * Returns boolean true if grid from UI and Database match<p>
	 * Returns boolean false if grid from UI and Database do not match<p>
	 *@author nilesh.patil
     *Created date 12 Jan 2016
	 */

	public boolean verifyEnlistedLocations(String locator,String elementmethod) throws SQLException
	{
		LocationGrid dbgrid =getDBLocationListit();
		LocationGrid uigrid =getWebGrid(locator,elementmethod);

		if(uigrid.compareTo(dbgrid)== 0) 
		{
			Setup.log.trace("Locations from Ui and Database is matched");
			Setup.testcase.assertTrue(true);
			return true;			
		}
		else
		{
			Setup.log.trace("Locations from Ui and Database is not  matched");
			Setup.testcase.fail();
			return false;
		}


	
	}	
	

}
