package buisness.core.dashboard.provider.nonrolling;

import buisness.core.dashboard.provider.ProviderLocationGridView;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.dashboard.provider.ProviderViewGrid;
import configuration.Setup;


/**Verifies Report Patient Visit Grid(GPROSubmission)<p>
 * @author Sachin.Gawade<p>
 * Created Date: 1 Mar 2016
 */
public class ProviderGridViewNR extends ProviderLocationGridView{
	
	/**
	 *This method is used to compare UI Grid data  with Database grid data <p>
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * @param data quarter or month<p>
	 * Returns boolean true if grid from UI and Database match<p>
	 * Returns boolean false if grid from UI and Database do not match<p>
	 *@author nilesh.patil
	 *Created date 21 Jan 2016
	 */

	public boolean verifyProviderGridViewNR(String elementmethod,String locator,String data,String data1)
	{
		ConfigurationManager config=new ConfigurationManager();
		String query = config.getQuery("ProviderGridViewNR");
		query=query.replace( "@quartermonth",trimMultiSpace(data));
		query=query.replace( "@loginuser",getLoggedInUser());
		
		if(isQuarter(data))
		{
			query=query.replace( "@flag","QNR");
		}
		else
		{
			query=query.replace( "@flag","QNR");
		}
		
		ProviderViewGrid dbGrid = getDatabaseGrid(query);
		ProviderViewGrid uiGrid =getWebGrid(elementmethod,locator);
		
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
