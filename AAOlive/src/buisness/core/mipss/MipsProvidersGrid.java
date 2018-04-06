package buisness.core.mipss;

import buisness.awadhesh.datastructures.mips.Mipsprovidergrid;
import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import configuration.Setup;
public class MipsProvidersGrid extends MipsProvidersGridbase{
	
	/**
	 * verify(String locator,String elementmethod)
	 * This method is used to compare UI Grid data  with Database grid data <p>
	 * @param query To replace with key value.<p>
	 */


	public Mipsprovidergrid getDatabaseGrid( )
	{
		DatabaseManger.SQLserverConnection();
		ConfigurationManager config=new ConfigurationManager();
		String query1 = config.getQuery("MipsProvidersGrid");
		return super.getDatabaseGrid(query1);
	}

	/**
	 * verify(String locator,String elementmethod)
	 * This method is used to compare UI Grid data  with Database grid data <p>
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * @param data quarter or month<p>
	 * Returns boolean true if grid from UI and Database match<p>
	 * Returns boolean false if grid from UI and Database do not match<p>
	 */
    ////changed by awadhesh
	public boolean verify(String elementmethod,String locator)
	{
		
		System.out.println("Verify Method Invoked.");
		Mipsprovidergrid  databaseGrid = getDatabaseGrid();
		System.out.println("DB Grid taken");
		
		System.out.println("locator is:" +locator);
		System.out.println("Elementmethod is:" +elementmethod);
		Mipsprovidergrid  webGrid = getWebGrid(elementmethod,locator);
		System.out.println("UI Grid taken");
		
		if(webGrid.compareTo(databaseGrid)== 0)
		{
			Setup.log.trace("Clinician displayed from UI and database is matched");
			Setup.testcase.assertTrue(true);
			return true;			
		}
		else
		{
			Setup.log.trace("Clinician displayed from UI and Database is not  matched");
			Setup.testcase.fail();
			return false;
		}

	}	
}
	
	
	
	
	
	


