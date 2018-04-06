package buisness.core.dashboard.Practice.rolling;

import buisness.core.dashboard.provider.MeasureView;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.dashboard.MeasureGrid;
import configuration.Setup;

/**Verifies Favorites Measure View present on Dashboard > Practice For Rolling<p>
 * Extends MeasureView<p>
 * This class Query Keyword to Extended PracticeFavoritesMeasureViewNR class
 * Returns boolean true if grid from UI and Database match<p>
 * Returns boolean false if grid from UI and Database do not match<p>
 * Return  data to validate count.
 * @author Rakesh.kulkarni<p>
 * Created Date: 15/03/2016
 */

public class PracticeFavoritesMeasureViewR extends MeasureView{
	
	/**
	 *This method is used to compare UI Grid data  with Database grid data For Rolling and Favorites Measure<p>
	 * Passes locator : To Find the element
	 * Passes Parameters elementmethod and locator to verify() of PqrsAdvancedStatusView class
	 * This method verify Count
	 * Method to compare object of DatabaseGrid and WebGrid. It check value present on UI with Database
	 * @param locator : To Find the element Name of locator in object repository<p>
	 * @param elementmethod : To Find the element by the type of Element Example xpath, id,
	 * @Param data : quarter or month
	 * @return result of Test case "Pass"  or  "Fail"
	 * Return  data to validate count.
	 */

	public boolean verify(String locator,String elementmethod,String data)
	{
		ConfigurationManager config=new ConfigurationManager();
		String query = config.getQuery("PracticeFavoritesMeasureViewR");
		query=query.replace( "@quartermonth",data);
		
		if(isQuarter(data))
		{
			query=query.replace( "@flag","QR");
		}
		else
		{
			query=query.replace( "@flag","QR");
		}
		MeasureGrid dbGrid =getDatabaseGrid(query);
		MeasureGrid uiGrid =getWebGrid(locator,elementmethod);
		if(uiGrid!=null ) 
		{
			
			if(dbGrid!=null ) 
				{
					if(uiGrid.compareTo(dbGrid) == 0)
						{
							Setup.log.trace("Data on UI and Database matches.");
							Setup.testcase.assertTrue(true);
							return true;
						}
						else 
						{
							Setup.log.trace("Data on UI and Database does not match.");
							Setup.testcase.fail();
							return false;
						}
				 }

			else 
				{
						 Setup.log.error("Result in Database is null");
				}
		}
		else 
		{
						Setup.log.error("UI grid is null");
		}
				Setup.testcase.fail();
				return false;
	}	

}