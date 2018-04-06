package buisness.core.dashboard.provider.nonrolling;

import buisness.core.dashboard.provider.PatientDrillDownView;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.dashboard.PatientDrillDownGrid;
import configuration.Setup;

/**Verifies Dashboard>>Provider>>Patient Drill Down <p>
 * @author Sachin.Gawade<p>
 * Created Date: 9 Mar 2016
 * 
 */
public class ProviderPatientDrillDownViewNR  extends PatientDrillDownView{
	
	/**
	 * verify(String locator,String elementmethod)
	 * This method is used to compare UI Grid data  with Database grid data <p>
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * @param data quarter or month<p>
	 * Returns boolean true if grid from UI and Database match<p>
	 * Returns boolean false if grid from UI and Database do not match<p>
	 */

	public boolean verifyProviderPatientDrillDownViewNR(String elementmethod,String locator,String data, String data1)
	{
		ConfigurationManager config=new ConfigurationManager();
		String query = config.getQuery("ProviderPatientDrillDownViewNR1");
		query=query.replace( "@quartermonth",data);
		query=query.replace( "@loginuser",getLoggedInUser());
		query=query.replace( "@provideruid",newwayProviderUid());
		query=query.replace( "@measureuid",newwayMeasureUid());
		
//		if(isQuarter(data))
//		{
//			query=query.replace( "@flag","QNR");
//		}
//		else
//		{
//			query=query.replace( "@flag","MNR");
//		}
//		
		PatientDrillDownGrid dbGrid =getDatabaseGrid(query);
		PatientDrillDownGrid uiGrid =getWebGrid(elementmethod,locator);
		
		if(uiGrid.compareTo(dbGrid)== 0)
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