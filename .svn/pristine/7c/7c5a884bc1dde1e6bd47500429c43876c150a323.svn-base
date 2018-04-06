package buisness.core.mipss;


import buisness.managers.ConfigurationManager;
import configuration.Setup;

/**Verifies Location popup present on Dashboard > Practice >> Select Measure on Location Tab For Rolling<p>
 * Extends ProviderLocationCount<p>
 * This class Query Keyword to Extended PracticeFavoritesMeasureCountNR class
 * Returns boolean true if grid from UI and Database match<p>
 * Returns boolean false if grid from UI and Database do not match<p>
 * Return  data to validate count.
 * @author Rakesh.Kulkani<p>
 * Created Date: 21/03/2016
 * 
 */
public class SearchedProvidersCount extends MipsProviderCountMaster{

	/** Compares Location popup present on Dashboard > Practice >> Select Measure on Location Tab for from UI and Database for Rolling
	 * Passes locator : To Find the element
	 * This method verify Count
	 * Method to compare object of DatabaseGrid and WebGrid. It check value present on UI with Database
	 * @param locator : To Find the element Name of locator in object repository<p>
	 * @param elementmethod : To Find the element by the type of Element Example xpath, id,
	 * @Param data : quarter or month
	 * @return result of Test case "Pass" or "Fail"
	 */
	public boolean verify(String elementmethod,String locator)  
	{
		String databaseCount;
		String webCount;
		ConfigurationManager config=new ConfigurationManager();
		String query = config.getQuery("SearchedProviderCount");
	

		databaseCount=getdatabasecount(query);
		webCount=getuicount(elementmethod,locator);
		
		Setup.log.info("Ui_Count"+webCount);
		Setup.log.info("Db_Count"+databaseCount);
		
		
		if(webCount.equals(databaseCount))
		{
			Setup.log.debug("\nCount from Database and UI getting matched");
			Setup.testcase.assertTrue(true);
			return true;
		}
		else
		{
			Setup.log.debug("\nCount from Database and UI is not getting matched");
			Setup.testcase.fail();
			return false;
		}
		
	}
		
}
