package buisness.core.dashboard.Practice.rolling;


import buisness.core.dashboard.provider.ProviderLocationCount;
import buisness.managers.ConfigurationManager;
import configuration.Setup;

import java.util.ArrayList;
import java.util.Arrays;

/**Verifies Practice Measure ComputationS ummary Count present on Practice >> Select Measure  For Rolling<p>
 * Extends MeasureComputationSummaryView<p>
 * This class Query Keyword to Extended MeasureComputationSummaryView class
 * Returns boolean true if grid from UI and Database match<p>
 * Returns boolean false if grid from UI and Database do not match<p>
 * Return  data to validate count.
 * @author Rakesh.Kulkani<p>
 * Created Date: 15/03/2016
 * 
 */

public class PracticeMeasureCountR extends ProviderLocationCount{

	/** Compares Practice\Measure Count for from UI and Database for Rolling
	 *This method is used to compare UI Grid data  with Database grid data <p>
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * @param data quarter or month
	 * Returns boolean true if grid from UI and Database match<p>
	 * Returns boolean false if grid from UI and Database do not match<p>
	 */
	public boolean verify(String elementmethod,String locator,String data)  
	{
		String dbCount;
		String uiCount;
		ConfigurationManager config=new ConfigurationManager();
		String query = config.getQuery("PracticeMeasureCountR");
		query=query.replace( "@quartermonth",data);
		query=query.replace( "@loginuser",getLoggedInUser());

		if(isQuarter(data))
		{
			query=query.replace( "@flag","QR");
		}
		else
		{
			query=query.replace( "@flag","QR");
		}

		dbCount=getdatabasecount(query);
		uiCount=getuicount(elementmethod,locator);
		
		Setup.log.info("Ui_Count"+uiCount);
		Setup.log.info("Db_Count"+dbCount);
		
		
		if(uiCount.equals(dbCount))
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