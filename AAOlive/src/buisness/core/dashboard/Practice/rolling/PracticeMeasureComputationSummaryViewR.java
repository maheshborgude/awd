package buisness.core.dashboard.Practice.rolling;

import buisness.core.dashboard.provider.MeasureComputationSummaryView;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.dashboard.MeasureComputationSummaryGrid;
import configuration.Setup;

/**Verifies Practice Measure Computation Summary View present on Practice >> Select Measure  For Rolling<p>
 * Extends MeasureComputationSummaryView<p>
 * This class Query Keyword to Extended MeasureComputationSummaryView class
 * Returns boolean true if grid from UI and Database match<p>
 * Returns boolean false if grid from UI and Database do not match<p>
 * Return  data to validate count.
 * @author Rakesh.kulkarni
 * Created Date: 17/03/2016
 */

public class PracticeMeasureComputationSummaryViewR extends MeasureComputationSummaryView{
	
	/**
	 *This method is used to compare UI Grid data  with Database grid data for Rolling<p>
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * @param data quarter or month
	 * Returns boolean true if grid from UI and Database match<p>
	 * Returns boolean false if grid from UI and Database do not matchs<p>
	 */

	public boolean verify(String locator,String elementmethod,String data)
	{

		ConfigurationManager config=new ConfigurationManager();
		String query = config.getQuery("PracticeMeasureComputationSummaryViewR");

		query=query.replace( "@quartermonth",data);
		query=query.replace( "@measureID",getSelectrdMeasureUIDonMeasuePopup());

		if(isQuarter(data))
		{
			query=query.replace( "@flag","MR");
		}
		else
		{
			query=query.replace( "@flag","QR");
		}
		MeasureComputationSummaryGrid databaseGrid =getDatabaseGrid(query);
		MeasureComputationSummaryGrid webGrid =getWebGrid(locator,elementmethod);
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
