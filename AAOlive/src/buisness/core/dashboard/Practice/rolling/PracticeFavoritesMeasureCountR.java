package buisness.core.dashboard.Practice.rolling;


import buisness.core.dashboard.provider.ProviderLocationCount;
import buisness.managers.ConfigurationManager;
import configuration.Setup;

/**Verifies Favorites Measure Count present on Dashboard > Practice For Rolling<p>
 * Extends ProviderLocationCount<p>
 * This class Query Keyword to Extended PracticeFavoritesMeasureCountNR class
 * Returns boolean true if grid from UI and Database match<p>
 * Returns boolean false if grid from UI and Database do not match<p>
 * Return  data to validate count.
 * @author Rakesh.Kulkani<p>
 * Created Date: 21/03/2016
 * 
 */

public class PracticeFavoritesMeasureCountR extends ProviderLocationCount{

	/**
	 * Passes locator : To Find the element
	 * Passes Parameters elementmethod and locator to verify() Favorites Measure Count
	 * This method verify Count
	 * Method to compare object of DatabaseGrid and WebGrid. It check value present on UI with Database
	 * @param locator : To Find the element Name of locator in object repository<p>
	 * @param elementmethod : To Find the element by the type of Element Example xpath, id,
	 * @Param data : quarter or month
	 * @return result of Test case "Pass" or "Fail"
	 */
	public boolean verify(String elementmethod,String locator,String data)
	{
		System.out.println(elementmethod+""+locator+""+data);
		String databaseGrid;
		String webGrid;
		ConfigurationManager config=new ConfigurationManager();
		String query = config.getQuery("PracticeFavoritesMeasureCountR");
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

		databaseGrid=getdatabasecount(query);
		webGrid=getuicount(elementmethod,locator);
		
		Setup.log.info("Ui_Count"+webGrid);
		Setup.log.info("Db_Count"+databaseGrid);
		
		
		if(webGrid.equals(databaseGrid))
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