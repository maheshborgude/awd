package buisness.core.dashboard.Practice.rolling;

import buisness.core.dashboard.provider.ProviderPatientDrillDownCount;
import buisness.managers.ConfigurationManager;
import configuration.Setup;

/**
 * Verifies Practice Patient DrillDown Count present on Dashboard > Practice > Measure computation summary For Rolling<p>
 * Extends ProviderLocationCount<p>
 * This class Query Keyword to Extended PracticeFavoritesMeasureCountNR class
 * Returns boolean true if grid from UI and Database match<p>
 * Returns boolean false if grid from UI and Database do not match<p>
 * Return  data to validate Grid.
 * @author Rakesh.Kulkarni<p>
 * Created Date: 18/03/2016
 * 
 */
public class PracticePatientDrillDownCountR extends ProviderPatientDrillDownCount{

	/**
	 * Compares Provider\Location Count for from UI and Database for Rolling
	 * Passes locator : To Find the element
	 * Passes Parameters elementmethod and locator to verify() Dashboard > Practice > Measure computation summary For NOnRolling
	 * This method verify Count
	 * Method to compare object of DatabaseGrid and WebGrid. It check value present on UI with Database
	 * @param locator : To Find the element Name of locator in object repository<p>
	 * @param elementmethod : To Find the element by the type of Element Example xpath, id,
	 * @Param data : quarter or month
	 * @return result of Test case "Pass" or "Fail"
	 */
	public boolean verifyPracticePatientDrillDownCountR(String elementmethod,String locator,String data,String data1)  
	{

		String databaseCount;
		String webCount;
		ConfigurationManager config=new ConfigurationManager();
		String query = config.getQuery("PracticePatientDrillDownCountR");
		query=query.replace( "@loginuser",getLoggedInUser());
		query=query.replace( "@quartermonth",data);
		query=query.replace( "@measureID",newwayMeasureUid());
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
