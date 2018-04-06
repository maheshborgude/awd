package buisness.core.gprosubmission;


import java.sql.SQLException;

import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.gprosubmission.GproMeasureGrid;
import configuration.Setup;
/**
 * Class used to compare provider grid from UI and database.
 * @author Sachin.Gawade
 * Created 11 Feb 2016
 */
public class GPROReportingMeasuresVerify extends GPROReportingMeasures{
	
	public String query;
	public ConfigurationManager config;
	
	/**
	 * Replaces variables present in Query(obtained from object repository) 
	 * @return query as String
	 */
	public String getQuery()
	{
		config = new ConfigurationManager();
		query = config.getQuery("GroupPracticeMeasure");
		return query;
	}

	/**
	 * Compares UI grid and database records
	 * @param locator
	 * @return Boolean true or false based on the comparison of ui grid and database <p>
	 * @throws SQLException
	 */

	public boolean VerifyMeasures(String locator) throws SQLException
	{
		GproMeasureGrid dbgrid =getDBList(getQuery());
		GproMeasureGrid uigrid =getUIlist(locator);
	
		//TODO: try using invalid locator

		if(uigrid.compareTo(dbgrid)== 0) 
		{
			//TODO: no debug log:done
			Setup.log.trace("UI grid and database table match");
			Setup.testcase.assertTrue(true);
			return true;			
		}
		else
		{//TODO: no debug log:done
			Setup.log.trace("UI grid and database table do not match");
			Setup.testcase.fail();
			return false;
		}
	
	}
	
}
