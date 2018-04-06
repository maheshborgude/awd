package buisness.core.administration.usermanagement;

import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.administration.usermanagement.UsermanagementGrid;
import configuration.Setup;

/**
 * This class is used to get  grid  data of Location from UI and  grid  data from Database   
 *
 * @author nilesh.patil
 *Created date 29 Jan 2016
 */

public class UserManagementGridView extends UserManagement {
	
	
      ConfigurationManager config;
	
	public UserManagementGridView() 
	{
		config = new ConfigurationManager();
	
	}
	
	
	 
	/**
	 * getDBLocationListit()<p>
	 * Returns AdministrationLocationGrid object containing all locations and their details available<p>
	 * for logged in user in the database<p>
	 *  @return dbgrid which contains all database rows 
	 * @author nilesh.patil
     *Created date 29 Jan 2016
	 */
	
	public UsermanagementGrid getDBLocationListit() 
	{
	 DatabaseManger.SQLserverConnection();
	String query = config.getQuery("Usermangementlistofuser");
	 //query=query.replace("@loginuser",getLoggedInUser());
        return super.getDatabaseGrid(query);
		
}
	

	/**
	 * verify(String locator,String elementmethod)
	 *This method is used to compare Uilocationgrid data  with Databaselocationgrid data <p>
	 * Returns boolean true if grid from UI and Database match<p>
	 * Returns boolean false if grid from UI and Database do not match<p>
	 *@author nilesh.patil
     *Created date 29 Jan 2016
	 */

	public boolean verify(String locator,String elementmethod)
	{
		UsermanagementGrid dbgrid =getDBLocationListit();
		UsermanagementGrid uigrid =getWebGrid(locator,elementmethod);

		if(uigrid.compareTo(dbgrid)== 0) 
		{
			Setup.log.debug("Locations from Ui and Database is matched");
			Setup.testcase.assertTrue(true);
			return true;			
		}
		else
		{
			Setup.log.debug("Locations from Ui and Database is not  matched");
			Setup.testcase.fail();
			return false;
		}


	
	}	
	

}
