package buisness.core.dashboard.Practice.rolling;

import buisness.core.dashboard.Practice.PracticeLocationPopUp;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.dashboard.practice.PracticeLocationPopUpGrid;
import configuration.Setup;

/**Verifies Practice AllProviders View of All Providers on Dashboard > Practice >> Select Measure on All tab For Rolling<p>
 * Extends ProviderLocationCount<p>
 * This class Query Keyword to Extended PracticeFavoritesMeasureCountNR class
 * Returns boolean true if grid from UI and Database match<p>
 * Returns boolean false if grid from UI and Database do not match<p>
 * Return  data to validate count.
 * @author Rakesh.Kulkarni<p>
 * Created Date: 21/03/2016
 * 
 */
public class PracticeAllProvidersPopUpViewR extends PracticeLocationPopUp {

	/**
	 * verify(String locator,String elementmethod)
	 * This method is used to compare UI Grid data  with Database grid data <p>
	 * @param query To replace with key value.<p>
	 */


	public PracticeLocationPopUpGrid getDatabaseGrid(String query)
	{

		query=query.replace( "@loginuser",getLoggedInUser());
	//	query=query.replace( "@provideruid",getSelectedProvierUID());
	//	query=query.replace( "@measureuid",getSelectedMeasureUID());
		return super.getDatabaseGrid(query);
	}

	/**
	 * verify(String locator,String elementmethod)
	 * This method is used to compare UI Grid data  with Database grid data <p>
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * @param data quarter or month<p>
	 * Returns boolean true if grid from UI and Database match<p>
	 * Returns boolean false if grid from UI and Database do not match<p>
	 */

	public boolean verifyPracticeAllProvidersPopUpViewR(String locator,String elementmethod,String data,String data1)
	{
		ConfigurationManager config=new ConfigurationManager();
		String query = config.getQuery("PracticeAllProvidersPopUpViewR");
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

		PracticeLocationPopUpGrid  databaseGrid=getDatabaseGrid(query);
		PracticeLocationPopUpGrid  webGrid=getWebGrid(locator,elementmethod);
		
		if(webGrid.compareTo(databaseGrid)== 0)
		{
			Setup.log.trace("Patient Details from UI and Database is matched");
			Setup.testcase.assertTrue(true);
			return true;			
		}
		else
		{
			Setup.log.trace("Patient Details from UI and Database is not  matched");
			Setup.testcase.fail();
			return false;
		}
	}	
}