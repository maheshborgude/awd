package buisness.core.dashboard.location.nonRolling;

import buisness.core.dashboard.provider.ProviderPatientDrillDownCount;
import buisness.core.dashboard.provider.ProviderLocationCount;
import buisness.managers.ConfigurationManager;
import configuration.Setup;

/**Verifies Location count as displayed on side bar <p>
 * Extends ProviderLocationCount<p>
 * 
 * Returns boolean true if grid from UI and Database match<p>
 * Returns boolean false if grid from UI and Database do not match<p>
 * Return  data to validate count.
 * @author Awadhesh Sengar<p>
 * Created Date: 12/19/2017
 *
 */
public class LocationBubbleCountNR extends ProviderLocationCount {

	/** Verifies Location count as displayed on side bar for non Rolling
	 * Passes locator : To Find the element
	 * This method verify Count
	 * Method to compare object of DatabaseGrid and WebGrid. It check value present on UI with Database
	 * @param locator : To Find the element Name of locator in object repository<p>
	 * @param elementmethod : To Find the element by the type of Element Example xpath, id,
	 * @Param data : quarter or month
	 * @return result of Test case "Pass" or "Fail"
	 */
	public boolean verifyLocationBubbleCountNR(String elementmethod,String locator,String data,String data1)
	{
		String databaseCount;
		String webCount;
		ConfigurationManager config=new ConfigurationManager();
		String query = config.getQuery("LocationBubbleCountNR");
		query=query.replace( "@quartermonth",data);
		query=query.replace( "@loginuser",getLoggedInUser());

		if(isQuarter(data))
		{
			query=query.replace( "@flag",data1);
		}
		else
		{
			query=query.replace( "@flag",data1);
		}

		databaseCount=getdatabasecount(query);
		webCount=getuicount(elementmethod,locator);

		Setup.log.debug("Ui_Count"+webCount);
		Setup.log.debug("Db_Count"+databaseCount);


		if(webCount.equals(databaseCount))
		{
			Setup.log.debug("\nCount from Database and UI getting matched. ");
			Setup.testcase.assertTrue(true);
			return true;
		}
		else
		{
			Setup.log.debug("\nCount from Database and UI is not getting matched. ");
			Setup.testcase.fail();
			return false;
		}

	}

}
