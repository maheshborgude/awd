package buisness.core.mipss;

import buisness.awadhesh.datastructures.mips.MipsNanogrid;
import buisness.awadhesh.datastructures.mips.Mipsprovidergrid;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.dashboard.practice.PracticeLocationPopUpGrid;
import configuration.Setup;
public class Mipsnanogridcore extends Mipsnanogridcorebase{
	
	/**
	 * verify(String locator,String elementmethod)
	 * This method is used to compare UI Grid data  with Database grid data <p>
	 * @param query To replace with key value.<p>
	 */

	public MipsNanogrid getDatabaseGrid(String query)
	{
		query=query.replace( "@loginuser",getLoggedInUser());
/*		query=query.replace( "@loginuser",getLoggedInUser());
		query=query.replace( "@provideruid",getSelectedProvierUID());
		query=query.replace( "@measureuid",getSelectedMeasureUID());*/
		return super.getDatabaseGrid(query);
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
	////public boolean verify(String locator,String elementmethod,String data)
	public boolean verify(String elementmethod,String locator,String data)
	{
		ConfigurationManager config=new ConfigurationManager();
		////replaced keyword with the query mentioned in queries.properties
		String query = config.getQuery("MipsNanoGrid");
	
		/*
		query=query.replace( "@quartermonth",data);
		query=query.replace( "@measureID",getSelectrdMeasureUIDonMeasuePopup());
		
		if(isQuarter(data))
		{
			query=query.replace( "@flag","QNR");
		}
		else
		{
			query=query.replace( "@flag","QNR");
		}

*/
		MipsNanogrid  databaseGrid=getDatabaseGrid(query);
		MipsNanogrid  webGrid=getWebGrid(locator,elementmethod);
		
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
	
	
	
	
	
	


