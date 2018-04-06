package buisness.core.dashboard.provider.nonrolling;

import buisness.core.dashboard.provider.ProviderPatientDrillDownCount;
import buisness.managers.ConfigurationManager;
import configuration.Setup;
/**Verifies Dashboard>>Provider>>Patient Drill Down count(Non Rolling)<p>
 * @author Sachin.Gawade<p>
 * Created Date: 9 Mar 2016
 * 
 */
public class ProviderPatientDrillDownCountNR extends ProviderPatientDrillDownCount{

	/** Compares Provider\Location Count for from UI and Database
	 * calls getdbcount(),getuicount()
	 * @param elementmethod Example xpath,id
	 * @param locator of element that shows record in the UI
	 * @param data quarter or month<p>
	 * @return result true\false
	 */
	public boolean verifyProviderPatientDrillDownCountNR(String elementmethod,String locator,String data,String data1)  
	{
		String dbCount;
		String uiCount;
		ConfigurationManager config=new ConfigurationManager();
		String query = config.getQuery("ProviderPatientDrillDownCountNR");
		query=query.replace( "@quartermonth",data);
		query=query.replace( "@loginuser",getLoggedInUser());
		query=query.replace( "@provideruid",GetProvideruidFromDashboardProvider());
		query=query.replace( "@measureuid",GetMeasureUIDfromDashboardProvider());
		
		if(isQuarter(data))
		{
			query=query.replace( "@flag","QNR");
		}
		else
		{
			query=query.replace( "@flag","MNR");
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
