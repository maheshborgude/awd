package buisness.core.dashboard.provider.rolling;

import buisness.core.dashboard.provider.ProviderLocationCount;
import buisness.managers.ConfigurationManager;
import configuration.Setup;

/**
 * Verifies Provider\Location Count(Dashboard)<p>
 * @author Sachin.Gawade<p>
 * Created Date: 2 Mar 2016
 * @author probeer.roy Updated Date: 19 Dec 2017
 * 
 */


public class ProviderCountR extends ProviderLocationCount{

	/** Compares Provider\Location Count for from UI and Database
	 * calls getdbcount(),getuicount()
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator of element that shows record in the UI
	 * @param data quarter or month
	 * Returns result true\false
	 */
	public boolean verifyProviderCountR(String elementmethod,String locator,String data,String data1)  
	{
		String dbCount;
		String uiCount;
		
		ConfigurationManager config=new ConfigurationManager();
		String query = config.getQuery("ProviderCountRNR");
		query=query.replace( "@quartermonth",data);
		query=query.replace( "@loginuser",getLoggedInUser());
		//query=query.replace( "@provideruid",getSelectedProvierUID());
		//query=query.replace( "@measureuid",getSelectedMeasureUID());
		
		if(isQuarter(data))
		{
			query=query.replace( "@flag",data1);
		}
		else
		{
			query=query.replace( "@flag",data1);
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