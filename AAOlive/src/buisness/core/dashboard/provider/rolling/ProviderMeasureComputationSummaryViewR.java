package buisness.core.dashboard.provider.rolling;

import buisness.core.dashboard.provider.MeasureComputationSummaryView;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.dashboard.MeasureComputationSummaryGrid;
import configuration.Setup;

/**Verifies Measure Computation Summary Grid for Dashboard>>Provider<p>
 * @author Sachin.Gawade<p>
 * Created Date: 3 Mar 2016
 * @author probeer.roy Updated Date: 19 Dec 2017
 */

public class ProviderMeasureComputationSummaryViewR extends MeasureComputationSummaryView{
	
	/**
	 *This method is used to compare UI Grid data  with Database grid data <p>
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * @param data quarter or month
	 * Returns boolean true if grid from UI and Database match<p>
	 * Returns boolean false if grid from UI and Database do not match<p>
	 */

	public boolean verifyProviderMeasureComputationSummaryViewR(String elementmethod,String locator,String data,String data1)
	{
		System.out.println(data+ " " +data1);
		ConfigurationManager config=new ConfigurationManager();
		String query = config.getQuery("ProviderMeasureComputationSummaryViewR");
		query=query.replace( "@quartermonth",data);
		query=query.replace( "@loginuser",getLoggedInUser());
		//query=query.replace( "@provideruid",getSelectedProvierUID());
		query=query.replace( "@provideruid",GetProvideruidFromDashboardProvider());
	    query=query.replace( "@measureuid",GetMeasureUIDfromDashboardProvider());
		
		if(isQuarter(data))
		{
			query=query.replace("@flag",data1);
		}
		else
		{
			query=query.replace("@flag",data1);
		}
		System.out.println(query);
		
		MeasureComputationSummaryGrid dbGrid =getDatabaseGrid(query);
		MeasureComputationSummaryGrid uiGrid =getWebGrid(elementmethod,locator);
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
