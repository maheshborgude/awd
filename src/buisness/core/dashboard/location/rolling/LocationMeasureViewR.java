package buisness.core.dashboard.location.rolling;

import buisness.core.dashboard.provider.MeasureView;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.dashboard.MeasureGrid;
import configuration.Setup;

/**
 * Verifies Location Measure View present on Dashboard >> Location ofter select Location For Rolling<p>
 * Extends MeasureComputationSummaryView<p>
 * This class Query Keyword to Extended MeasureComputationSummaryView class
 * Returns boolean true if grid from UI and Database match<p>
 * Returns boolean false if grid from UI and Database do not match<p>
 * Return  data to validate count.
 * @author Rakesh.kulkarni<p>
 * Created Date: 30/03/2016
 */

public class LocationMeasureViewR extends MeasureView{
	
	/**
	 * This method is used to compare UI Grid data with Database grid data for Rolling <p>
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * @param data quarter or month<p>
	 * Returns boolean true if grid from UI and Database match<p>
	 * Returns boolean false if grid from UI and Database do not match<p>
	 */

	public boolean verify(String locator,String elementmethod,String data)
	{
		System.err.println(locator+ " " + elementmethod + " " + data );
		ConfigurationManager config=new ConfigurationManager();
		String query = config.getQuery("LocationMeasureViewR");
		query=query.replace( "@quartermonth",data);
		query=query.replace( "@SelectedLocation",getSelectedLocationUID());
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