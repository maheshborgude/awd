package buisness.core.administration.provider;

import java.sql.SQLException;

import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.administration.provider.DashboardLocationProviderGrid;
import configuration.Setup;
/**
 * This class is used to verify Sorting for Admin>>Provider<p>
 * This class extends Provider class
 * @author Sachin.Gawade
 * Date 9 Feb 2016
 */
public class ProviderSort extends Provider{
	public String query;
	public ConfigurationManager config;
	public String getQuery()
	{
		config = new ConfigurationManager();
		query = config.getQuery("ProviderTable");
		query=query.replace("@loginuser",getLoggedInUser());
		return query;
	}

	/**
	 * verify(String locator) is used to compare the Grids<p>
	 * obtained from from UI and Database
	 * Returns true if grids match
	 * Returns false if grid do not match 
	 * @param locator
	 * @return
	 * @throws SQLException
	 */
	public boolean verify(String locator) throws SQLException
	{
		DashboardLocationProviderGrid dbgrid =getDBProviderList(getQuery());
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
