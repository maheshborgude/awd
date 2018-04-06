package buisness.core.dashboard.provider.rolling;

import buisness.core.dashboard.provider.ProviderPatientDrillDownCount;
import buisness.managers.ConfigurationManager;
import configuration.Setup;
/**Verifies Dashboard>>Provider>>Patient Drill Down count<p>
 * @author Sachin.Gawade<p>
 * Created Date: 3 Mar 2016
 * 
 */
public class ProviderPatientDrillDownCountR extends ProviderPatientDrillDownCount{

	/** Compares Provider\Location Count for from UI and Database
	 * calls getdbcount(),getuicount()
	 * @param elementmethod
	 * @param locator of element that shows record in the UI
	 * @param data quarter or month<p>
	 * Returns result pass\false
	 */
	public boolean verifyProviderPatientDrillDownCountR(String elementmethod,String locator,String data)  
	{
		String dbCount;
		String uiCount;
		ConfigurationManager config=new ConfigurationManager();
		String query = config.getQuery("ProviderPatientDrillDownCountR");
		query=query.replace( "@quartermonth",data);
		query=query.replace( "@loginuser",getLoggedInUser());
		query=query.replace("@provideruid", newwayProviderUid());
		query=query.replace("@measureuid",newwayMeasureUid());
		
//		if(isQuarter(data))
//		{
//			query=query.replace( "@flag",data1);
//		}
//		else
//		{
//			query=query.replace( "@flag",data1);
//		}
		
		dbCount=getdatabasecount(query);
		if(verify_element(elementmethod, locator).equals("Fail")){
			locator=locator+"/b";
			System.out.println(locator);
			uiCount=getuicount(elementmethod,locator);
		} else{
			uiCount=getuicount(elementmethod,locator);
		}
		
		
		Setup.log.info("Ui_Count"+uiCount);
		Setup.log.info("Db_Count"+dbCount);
		
		
		if(uiCount.equals(dbCount))
		{
			Setup.log.info("\nCount from Database and UI getting matched");
			Setup.log.trace("\nCount from Database and UI getting matched");
			Setup.testcase.assertTrue(true);
			return true;
		}
		else
		{
			Setup.log.info("\nCount from Database and UI is not getting matched");
			Setup.log.trace("\nCount from Database and UI is not getting matched");
			Setup.testcase.fail();
			return false;
		}
		
	}
		
}
