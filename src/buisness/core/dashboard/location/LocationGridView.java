package buisness.core.dashboard.location;

import java.sql.SQLException;

import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import configuration.Setup;

public class LocationGridView extends Location {

       String query;
	ConfigurationManager config;

	public LocationGridView() 
	{
		config = new ConfigurationManager();

	}

	/**
	 * getDBLocationListit()<p>
	 * Returns AdministrationLocationGrid object containing all locations and their details available<p>
	 * for logged in user in the database<p>
	 * get the query from Object.propertis file and pass it to Super class Which is name as  Basic<p>
	 *  @return dbgrid which contains all database rows 
	 * @author nilesh.patil
	 *Created date 21 Jan 2016
	 */

	public buisness.util.datastructures.dashboard.location.LocationGrid getDBLocationListit() 
	{
		String query1 = config.getQuery("DashboardLocation");
		DatabaseManger.exeQuery(query1);
		//String key=getLoggedInUser();
//		String query1=query.replace("@loginuser",key);
//		String query2=query1.replace("@data",data);
	    System.err.println(query1);
		return super.getDatabaseGrid(query1);
	}
	
	/**
	 * verifyEnlistedLocations(String locator)
	 *This method is used to compare Uilocationgrid data  with Databaselocationgrid data <p>
	 * Returns boolean true if grid from UI and Database match<p>
	 * Returns boolean false if grid from UI and Database do not match<p>
	 *@author nilesh.patil
	 *Created date 21 Jan 2016
	 */

	public boolean verify(String locator,String elementmethod) throws SQLException
	{
		buisness.util.datastructures.dashboard.location.LocationGrid dbgrid =getDBLocationListit();
		buisness.util.datastructures.dashboard.location.LocationGrid uigrid =getWebGrid(locator,elementmethod);
		
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
