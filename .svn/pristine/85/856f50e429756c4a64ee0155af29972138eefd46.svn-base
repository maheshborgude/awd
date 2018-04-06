package buisness.core.dashboard.Practice.nonRolling;

import buisness.core.dashboard.provider.ProviderPatientDrillDownCount;
import buisness.managers.ConfigurationManager;
import configuration.Setup;

/**
 * Verifies the Practice >Provider Tab>> Patient DrillDown Count present on Dashboard > Practice > Select measure >> Provider Tab For nonRolling<p>
 * Extends PatientDrillDownCount<p>
 * This class Query Keyword to Extended PatientDrillDownCount class
 * Returns boolean true if grid from UI and Database match<p>
 * Returns boolean false if grid from UI and Database do not match<p>
 * Return  data to validate Grid.
 * @author Rakesh.Kulkarni<p>
 * Created Date: 24/03/2016
 * 
 */
public class PracticeProvidersPatientDrillDownCountNR extends ProviderPatientDrillDownCount{

	/**
	 * Method to compare object of sorted data present on
	 *        Practice >Provider Tab>> Patient DrillDown Count present on Dashboard > Practice > Select measure >> Provider Tab For nonRolling<p>
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
		String query = config.getQuery("PracticeProvidersPatientDrillDownCountNR");
		query=query.replace( "@quartermonth",data);
		query=query.replace( "@measureID",getSelectrdMeasureUIDonMeasuePopup());
		Setup.log.trace(query);

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
			Setup.log.trace("\nCount from Database and UI getting matched");
			Setup.testcase.assertTrue(true);
			return true;
		}
		else
		{
			Setup.log.trace("\nCount from Database and UI is not getting matched");
			Setup.testcase.fail();
			return false;
		}
		
	}
		
}
