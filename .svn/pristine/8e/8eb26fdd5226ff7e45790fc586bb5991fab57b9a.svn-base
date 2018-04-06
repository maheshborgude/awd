package buisness.core.dashboard.provider.rolling;

import buisness.core.dashboard.provider.PatientDrillDownView;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.dashboard.PatientDrillDownGrid;
import configuration.Setup;

/**Verifies Dashboard>>Provider>>Patient Drill Down <p>
 * @author Sachin.Gawade<p>
 * Created Date: 3 Mar 2016
 * 
 */
public class ProviderPatientDrillDownViewR  extends PatientDrillDownView{
	
	/**
	 * verify(String locator,String elementmethod)
	 * This method is used to compare UI Grid data  with Database grid data <p>
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * @param data quarter or month<p>
	 * Returns boolean true if grid from UI and Database match<p>
	 * Returns boolean false if grid from UI and Database do not match<p>
	 */

	public boolean verifyProviderPatientDrillDownViewR(String elementmethod,String locator,String data)
	{
		ConfigurationManager config=new ConfigurationManager();
		String query = config.getQuery("ProviderPatientDrillDownViewR1");
		query=query.replace( "@quartermonth",trimMultiSpace(data));
		query=query.replace( "@loginuser",getLoggedInUser());
		query=query.replace( "@provideruid",GetProvideruidFromDashboardProvider());
		query=query.replace( "@measureuid",GetMeasureUIDfromDashboardProvider());
//		
//		if(isQuarter(data))
//		{
//			query=query.replace( "@flag",data1);
//		}
//		else
//		{
//			query=query.replace( "@flag",data1);
//		}
//		
		PatientDrillDownGrid dbGrid =getDatabaseGrid(query);
		PatientDrillDownGrid uiGrid =getWebGrid(elementmethod,locator);
		int a=dbGrid.getRowcount();
		int b=uiGrid.getRowcount();
		if(uiGrid.compareTo(dbGrid)== 0)
		{
			Setup.log.info("Patient Details from UI and Database is matched");
			Setup.log.trace("Patient Details from UI and Database is matched");
			Setup.testcase.assertTrue(true);
			return true;			
		}
		else
		{
			Setup.log.info("Patient Details from UI and Database is not  matched");
			Setup.log.trace("Patient Details from UI and Database is not  matched");
			Setup.testcase.fail();
			return false;
		}
	}	
}