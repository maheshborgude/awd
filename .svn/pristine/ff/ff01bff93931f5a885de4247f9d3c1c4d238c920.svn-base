package buisness.core.administration.provider;

import java.sql.SQLException;

import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.administration.provider.DashboardLocationProviderGrid;
import configuration.Setup;
/**
 * Class used to compare provider grid from UI and database.
 * @author Sachin.Gawade
 * Created 12 Jan 2016
 */
public class ProviderView extends Provider{
	
	public String query;
	public ConfigurationManager config;
	
	/**
	 * Replaces variables present in Query(obtained from object repository) 
	 * @return query as String
	 */
	public String getQuery()
	{
		config = new ConfigurationManager();
		query = config.getQuery("ProviderTable");
		query=query.replace("@loginuser",getLoggedInUser());
		return query;
	}

	/**
	 * Compares UI grid and database records
	 * @param locator
	 * @return Boolean true or false based on the comparison of ui grid and database <p>
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
