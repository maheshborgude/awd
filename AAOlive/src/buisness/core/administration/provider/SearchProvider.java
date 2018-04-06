package buisness.core.administration.provider;


import java.sql.SQLException;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.administration.provider.DashboardLocationProviderGrid;
import configuration.Setup;


/**
 * ProviderSearch class<p>
 * Extends ProviderTable
 * Provides getDBProviderList, getUIProviderlist,VerifyProviderTable methods
 * @author Sachin.Gawade
 * 3 Feb 2016
 */


public class SearchProvider extends Provider{
	
	public String query;
	public ConfigurationManager config;
	
	public String getQuery(String data)
	{
		config = new ConfigurationManager();
		query = config.getQuery("SearchProviderByNPI");
		query=query.replace("@loginuser",getLoggedInUser());
		query=query.replace("@searchnpi",data);
		return query;
	}
	
	/**
	 * verify(String locator,String data)
	 * Compares UI grid and database records
	 * @param locator
	 * @param data
	 * @return Boolean true or false based on the comparison of ui grid and database <p>
	 * @throws SQLException
	 */

	public boolean verify(String locator,String data) throws SQLException
	{
		DashboardLocationProviderGrid dbgrid =getDBProviderList(getQuery(data));
		DashboardLocationProviderGrid uigrid =getUIProviderlist(locator);

		if(uigrid.compareTo(dbgrid)== 0) 
		{
			Setup.log.trace("UI grid and database table match");
			Setup.testcase.assertTrue(true);
			return true;			
		}
		else
		{
			Setup.log.trace("UI grid and database table do not match");
			Setup.testcase.fail();
			return false;
		}
	
	}
	

}
