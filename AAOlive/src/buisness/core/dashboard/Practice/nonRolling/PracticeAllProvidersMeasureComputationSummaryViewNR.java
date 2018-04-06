package buisness.core.dashboard.Practice.nonRolling;

import buisness.core.dashboard.provider.MeasureComputationSummaryView;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.dashboard.MeasureComputationSummaryGrid;
import configuration.Setup;

/**Verifies Practice Location Measure Computation Summary View present on All tab for Providers >> Select Measure >> All Tab >>
 *      Select Provider For NonRolling<p>
 * Extends MeasureComputationSummaryView<p>
 * This class Query Keyword to Extended MeasureComputationSummaryView class
 * Returns boolean true if grid from UI and Database match<p>
 * Returns boolean false if grid from UI and Database do not match<p>
 * Return  data to validate count.
 * @author Rakesh.kulkarni
 * Created Date: 28/03/2016
 */

public class PracticeAllProvidersMeasureComputationSummaryViewNR extends MeasureComputationSummaryView{
	
	/**
	 *Verifies Practice Location Measure Computation Summary View present on All tab for Providers >> Select Measure >> All Tab >>
	 *      Select Provider For NonRolling<p>
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * @param data quarter or month
	 * Returns boolean true if grid from UI and Database match<p>
	 * Returns boolean false if grid from UI and Database do not match<p>
	 */

	public boolean verify(String locator,String elementmethod,String data)
	{

		ConfigurationManager config=new ConfigurationManager();
		String query = config.getQuery("PracticeAllProvidersMeasureComputationSummaryViewNR");
		query=query.replace( "@quartermonth",data);
		query=query.replace( "@measureID",getSelectrdMeasureUIDonMeasuePopup());
		
		if(isQuarter(data))
		{
			query=query.replace( "@flag","QNR");
		}
		else
		{
			query=query.replace( "@flag","QNR");
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
