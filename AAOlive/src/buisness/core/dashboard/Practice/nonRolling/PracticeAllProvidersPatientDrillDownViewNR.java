package buisness.core.dashboard.Practice.nonRolling;

import buisness.core.dashboard.provider.PatientDrillDownView;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.dashboard.PatientDrillDownGrid;
import configuration.Setup;

/**
 * Verifies Sort of Patient Drill Down present on Dashboard >> Practice >> All tab - Providers For nonRolling<p>
 * Extends PatientDrillDownView<p>
 * This class Query Keyword to Extended PatientDrillDownView class
 * Returns boolean true if grid from UI and Database match<p>
 * Returns boolean false if grid from UI and Database do not match<p>
 * Return  data to validate Grid.
 * @author Rakesh.Kulkarni<p>
 * Created Date: 23/03/2016
 */
public class PracticeAllProvidersPatientDrillDownViewNR extends PatientDrillDownView{
	
	/**
	 * verify(String locator,String elementmethod) For rolling
	 * This method is used to compare UI Grid data with Database grid data for nonRolling <p>
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * @param data quarter or month<p>
	 * Returns boolean true if grid from UI and Database match<p>
	 * Returns boolean false if grid from UI and Database do not match<p>
	 */

	public boolean verify(String locator,String elementmethod,String data)
	{
		ConfigurationManager config=new ConfigurationManager();
		String query = config.getQuery("PracticeAllProvidersPatientDrillDownViewNR");
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
		
		PatientDrillDownGrid databaseGrid =getDatabaseGrid(query);
		PatientDrillDownGrid webGrid =getWebGrid(locator,elementmethod);
		
		if(webGrid.compareTo(databaseGrid)== 0)
		{
			Setup.log.trace("Patient Details from UI and Database is matched");
			Setup.testcase.assertTrue(true);
			return true;			
		}
		else
		{
			Setup.log.trace("Patient Details from UI and Database is not  matched");
			Setup.testcase.fail();
			return false;
		}
	}	
}