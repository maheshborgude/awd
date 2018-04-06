package buisness.core.dashboard.provider.nonrolling;

import buisness.core.dashboard.provider.MeasureView;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.dashboard.MeasureGrid;
import configuration.Setup;

/**Verifies Measure Grid for Dashboard>>Provider from UI and Database<p>
 * @author Sachin.Gawade<p>
 * Created Date: 4 Mar 2016
 */

public class ProviderMeasureViewNR extends MeasureView{
	
	/**
	 * This method is used to compare UI Grid data  with Database grid data <p>
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * @param data quarter or month<p>
	 * Returns boolean true if grid from UI and Database match<p>
	 * Returns boolean false if grid from UI and Database do not match<p>
	 */


	public boolean verifyProviderMeasureViewNR(String elementmethod,String locator,String data, String data1)
	{
		ConfigurationManager config=new ConfigurationManager();
		String query = config.getQuery("ProviderMeasureViewRNR");
		query=query.replace( "@quartermonth",data);
		query=query.replace( "@loginuser",getLoggedInUser());
		query=query.replace( "@provideruid",newwayProviderUid());
		query=query.replace( "@measureuid",newwayMeasureUid());
		
		if(isQuarter(data))
		{
			query=query.replace( "@flag",data1);
		}
		else
		{
			query=query.replace( "@flag",data1);
		}
		System.err.println(query);
		MeasureGrid dbGrid =getDatabaseGrid(query);
		MeasureGrid uiGrid =getWebGrid(elementmethod,locator);
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