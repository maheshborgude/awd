package buisness.core.dashboard.location.rolling;

import buisness.core.dashboard.location.Location;
import buisness.core.dashboard.provider.MeasureComputationSummaryView;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.dashboard.MeasureComputationSummaryGrid;
import buisness.util.datastructures.dashboard.location.LocationGrid;
import configuration.Setup;

/**
 * Verifies Practice Performance Trend View present on All tab >> Select Measure >> All Tab >>
 *    For Rolling<p>
 * Extends MeasureComputationSummaryView<p>
 * This class Query Keyword to Extended MeasureComputationSummaryView class
 * Returns boolean true if grid from UI and Database match<p>
 * Returns boolean false if grid from UI and Database do not match<p>
 * Return  data to validate count.
 * @author Rakesh.kulkarni
 * Created Date: 28/03/2016
 */

public class LocationViewR extends Location{
	
	/**
	 * Verifies Practice Performance Trend View present on All tab >> Select Measure >> All Tab >>
	 *    For Rolling<p>
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * @param data quarter or month
	 * Returns boolean true if grid from UI and Database match<p>
	 * Returns boolean false if grid from UI and Database do not match<p>
	 * @author Rakesh.kulkarni<p>
	 * Created Date: 30/03/2016
	 */

	public boolean verify(String locator,String elementmethod,String data)
	{

		ConfigurationManager config=new ConfigurationManager();
		String query = config.getQuery("LocationViewR");
		query=query.replace( "@loginuser",getLoggedInUser());
		query=query.replace( "@quartermonth",data);
		//query=query.replace( "@SelectedLocation",getSelectedLocationUID());
		//query=query.replace( "@LocationMeasureUID",getMeasureUIDOnLocation());
		
		if(isQuarter(data))
		{
			query=query.replace( "@flag","QR");
		}
		else
		{
			query=query.replace( "@flag","QR");
		}

		LocationGrid databaseGrid =getDatabaseGrid(query);
		LocationGrid webGrid =getWebGrid(locator,elementmethod);
		if(webGrid!=null )
		{
			
			if(databaseGrid!=null )
				{
					if(webGrid.compareTo(databaseGrid) == 0)
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
