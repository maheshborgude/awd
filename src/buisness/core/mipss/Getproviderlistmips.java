package buisness.core.mipss;

import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.administration.usermanagement.UsermanagementGrid;
import buisness.util.datastructures.mipsutil.Mipscliniciangrid;
import configuration.Setup;

public class Getproviderlistmips extends ProviderGridmips  {


    ConfigurationManager config;
	
	public Getproviderlistmips() 
	{
		config = new ConfigurationManager();
	
	}
	
	 
	/**
	 * getDBLocationListit()<p>
	 * Returns AdministrationLocationGrid object containing all locations and their details available<p>
	 * for logged in user in the database<p>
	 *  @return dbgrid which contains all database rows 
	 * 
    *Created date 29 Jan 2016
	 */
	
	public Mipscliniciangrid getDBLocationListit() 
	{
	 DatabaseManger.SQLserverConnection();
	String query = config.getQuery("Getproviderlistmips");
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
		Mipscliniciangrid dbgrid =getDBLocationListit();
		Mipscliniciangrid uigrid =getWebGrid(locator,elementmethod);

		if(uigrid.compareTo(dbgrid)== 0) 
		{
			Setup.log.debug("Mips providers from Ui and Database is matched");
			Setup.testcase.assertTrue(true);
			return true;			
		}
		else
		{
			Setup.log.debug("Mips providers  from Ui and Database is not  matched");
			Setup.testcase.fail();
			return false;
		}


	
	}	
	
	
	
	
	
}
