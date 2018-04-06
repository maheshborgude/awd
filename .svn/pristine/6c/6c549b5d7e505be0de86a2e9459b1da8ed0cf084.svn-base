package buisness.core.dashboard.provider.nonrolling;


import buisness.core.dashboard.provider.ProviderLocationCount;
import buisness.managers.ConfigurationManager;
import configuration.Setup;

/**Verifies Provider\Location Count(Dashboard)<p>
 * @author Sachin.Gawade<p>
 * Created Date: 2 Mar 2016
 * 
 */

public class ProviderCountNR extends ProviderLocationCount{

	/** Compares Provider\Location Count for from UI and Database
	 * 
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator of element that shows record in the UI
	 * @param data quarter or month<p>
	 * Returns result true\false
	 */
	public boolean verifyProviderCountNR(String elementmethod,String locator,String data,String data1)  
	{
		String dbCount;
		String uiCount;
		
		ConfigurationManager config=new ConfigurationManager();
		String query = config.getQuery("ProviderCountRNR");
		query=query.replace( "@quartermonth",trimMultiSpace(data));
		query=query.replace( "@loginuser",getLoggedInUser());
		//query=query.replace( "@provideruid",getSelectedProvierUID());
		//query=query.replace( "@measureuid",getSelectedMeasureUID());
		
		if(isQuarter(data))
		{
			query=query.replace( "@flag","QNR");
		}
		else
		{
			query=query.replace( "@flag","QNR");
		}
		
		dbCount=getdatabasecount(query);
		uiCount=getuicountWithTrim(elementmethod,locator);
		
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