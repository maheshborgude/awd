

package buisness.core.dashboard.provider.rolling;

import buisness.core.dashboard.provider.PatientDrillDownSort;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.dashboard.PatientDrillDownGrid;
import configuration.Setup;

/**Verifies Sorting for Dashboard>>Provider Patient Drill Down<p>
 * @author Sachin.Gawade<p>
 * Created Date: 3 Mar 2016
 * 
 */

public class ProviderPatientDrillDownSortR  extends PatientDrillDownSort{
	/**	
	 * Method to compare object of sorted Dashboard>>Provider>>Patient Drill Down grid <p>
	 *  present on UI with Database 
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * @param data1 this parameter is used in order to fetch ascending or descending query
	 * @param data2 quarter or month<p>
	 * @return result true or false
	 */
	public boolean verifyProviderPatientDrillDownSortR(String elementmethod,String locator,String data,String data1)
	{
		ConfigurationManager config=new ConfigurationManager();
		String query = config.getQuery("ProviderPatientDrillDownSortR");
		query=query.replace( "@quartermonth",data);
		query=query.replace( "@loginuser",getLoggedInUser());
		query=query.replace( "@provideruid",GetProvideruidFromDashboardProvider());
		query=query.replace( "@measureuid",GetMeasureUIDfromDashboardProvider());
		query=query.replace( "@sort",data1);
//		if(isQuarter(data))
//		{
//			query=query.replace( "@flag",data1);
//		}
//		else
//		{
//			query=query.replace( "@flag",data1);
//		}
		
		PatientDrillDownGrid  dbGrid =getDatabaseGrid(query);
		PatientDrillDownGrid uiGrid =getWebGrid(elementmethod,locator);

		if(uiGrid!=null ) 
		{
			
			if(dbGrid!=null ) 
				{ 	
					if(uiGrid.compareTo(dbGrid) == 0)
						{
							Setup.log.trace("Data on UI and Database matches.");
							Setup.testcase.assertTrue(true);
							return true;
						}
						else 
						{
							Setup.log.trace("Data on UI and Database does not match.");
							Setup.testcase.fail();
							return false;
						}
				 }

			else 
				{
						 Setup.log.error("Result in Database is null");
				}
		}
		else 
		{
						Setup.log.error("UI grid is null");
		}
				Setup.testcase.fail();
				return false;
	}	
}