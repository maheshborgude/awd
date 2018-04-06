package buisness.core.dashboard.Practice.nonRolling;


import buisness.core.dashboard.provider.ProviderLocationCount;
import buisness.managers.ConfigurationManager;
import configuration.Setup;

/**Verifies Practice Measure ComputationS ummary Count present on Practice >> Select Measure  For NOnRolling<p>
 * Extends MeasureComputationSummaryView<p>
 * This class get Query Keyword to Extended MeasureComputationSummaryView class
 * Returns boolean true if grid from UI and Database match<p>
 * Returns boolean false if grid from UI and Database do not match<p>
 * Return  data to validate count.
 * @author Rakesh.kulkarni<p>
 * Created Date: 15/03/2016
 * 
 */

public class PracticeMeasureCountNR extends ProviderLocationCount{

	/**
	 *This method is used to compare UI Grid data  with Database grid data <p>
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * @param data quarter or month
	 * Returns boolean true if grid from UI and Database match<p>
	 * Returns boolean false if grid from UI and Database do not match<p>
	 */
	public boolean verify(String elementmethod,String locator,String data)  
	{

		String databaseCount;
		String webCount;
		ConfigurationManager config=new ConfigurationManager();
		String query = config.getQuery("PracticeMeasureCountNR");
		query=query.replace( "@quartermonth",data);
		query=query.replace( "@loginuser",getLoggedInUser());

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