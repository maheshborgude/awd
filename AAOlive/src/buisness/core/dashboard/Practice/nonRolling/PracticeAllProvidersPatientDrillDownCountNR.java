package buisness.core.dashboard.Practice.nonRolling;

import buisness.core.dashboard.provider.ProviderPatientDrillDownCount;
import buisness.managers.ConfigurationManager;
import configuration.Setup;

/**
 * Verifies Patient Drill Down Count present on AllProviders >> Practice > Select measure > All tab For nonRolling<p>
 * Extends PatientDrillDownView<p>
 * This class Query Keyword to Extended PatientDrillDownView class
 * Returns boolean true if grid from UI and Database match<p>
 * Returns boolean false if grid from UI and Database do not match<p>
 * Return  data to validate Grid.
 * @author Rakesh.Kulkarni<p>
 * Created Date: 28/03/2016
 * 
 */
public class PracticeAllProvidersPatientDrillDownCountNR extends ProviderPatientDrillDownCount{

	/**
	 * Method to compare object of Patient Drill Down Count present on AllProviders >> Practice > Select measure > All tab For nonRolling<p>
	 *  present on UI with Database
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * @param data quarter or month<p>
	 * @return result true or false
	 */
	public boolean verify(String elementmethod,String locator,String data)  
	{
		String databaseCount;
		String webCount;
		ConfigurationManager config=new ConfigurationManager();
		String query = config.getQuery("PracticeAllProvidersPatientDrillDownCountNR");
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

		databaseCount=getdatabasecount(query);
		webCount=getuicount(elementmethod,locator);
		
		Setup.log.info("Ui_Count"+webCount);
		Setup.log.info("Db_Count"+databaseCount);
		
		
		if(webCount.equals(databaseCount))
		{
			Setup.log.error("\nCount from Database and UI getting matched");
			Setup.testcase.assertTrue(true);
			return true;
		}
		else
		{
			Setup.log.error("\nCount from Database and UI is not getting matched");
			Setup.testcase.fail();
			return false;
		}
		
	}
		
}
