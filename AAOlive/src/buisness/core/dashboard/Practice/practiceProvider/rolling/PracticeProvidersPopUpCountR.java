package buisness.core.dashboard.Practice.practiceProvider.rolling;

import buisness.managers.ConfigurationManager;
import configuration.Setup;

/**Verifies Providers Count present on Dashboard>>Practice>Provider <p>
 * Extends PracticeProviderPopUpTabBasicR to get UI Count and DB Count<p>
 * Returns boolean true if grid from UI and Database match<p>
 * Returns boolean false if grid from UI and Database do not match<p>
 * Return  data to validate count.
 * @author Ashwini.Gore<p>
 * Created Date: 11 Dec 2017
 * 
 */
public class PracticeProvidersPopUpCountR extends PracticeProviderPopUpTabBasicR {

	/** Compares Total Provider Count from Dashboard>>Practice>Provider tab to the databse Provider Count<p>
	 * This method verifyPracticeProviderCount Count
	 * @param elementmethod : To Find the element by the type of Element Example xpath, id,
	 * @Param data : quarter or month
	 * @return result of Test case "Pass" or "Fail"
	 */
	public boolean verifyPracticeProviderCount(String elementmethod,String locator,String data)  
	{
		String databaseCount;
		String webCount;
		databaseCount=getdatabasePracticeProvidercount(getQuery("PracticeProvidersPopUpCountR",data));
		Setup.log.info("Db_Count:"+databaseCount);
		webCount=getuiPracticeProvidercount(elementmethod,locator);
		Setup.log.info("Ui_Count:"+webCount);
	
		if(webCount.equals(databaseCount))
		{
			//Setup.log.trace("\nCount from Database and UI getting matched");
			Setup.log.info("\nPractice>>Provider Count from Database and UI is getting matched");
			Setup.testcase.assertTrue(true);
			return true;
		}
		else
		{
			//Setup.log.trace("\nCount from Database and UI is not getting matched");
			Setup.log.info("\nPractice>>Provider Count from Database and UI is not matched");
			Setup.testcase.fail();
			return false;
		}
		
	}
		
}
