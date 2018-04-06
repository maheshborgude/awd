

package buisness.core.dashboard.Practice.nonRolling;

import buisness.core.dashboard.provider.PatientDrillDownSort;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.dashboard.PatientDrillDownGrid;
import configuration.Setup;

/**Verifies Practice Patient DrillDown Sort present on Dashboard > Practice > Measure computation summary For NOnRolling<p>
 * Extends ProviderLocationCount<p>
 * This class Query Keyword to Extended PracticeFavoritesMeasureCountNR class
 * Returns boolean true if grid from UI and Database match<p>
 * Returns boolean false if grid from UI and Database do not match<p>
 * Return  data to validate Grid.
 * @author Rakesh.Kulkarni<p>
 * Created Date: 18/03/2016
 */

public class PracticePatientDrillDownSortNR extends PatientDrillDownSort{
	/**	
	 * Method to compare object of sorted present on Dashboard > Practice > Measure computation summary For NOnRolling <p>
	 *  present on UI with Database 
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * @param data1 this parameter is used in order to fetch ascending or descending query
	 * @param data2 quarter or month<p>
	 * @return result true or false
	 */
	public boolean verify(String elementmethod,String locator,String data1, String data2)
	{
		ConfigurationManager config=new ConfigurationManager();
		String query = config.getQuery("PracticePatientDrillDownSortNR");
		query=query.replace( "@quartermonth",data2);
		query=query.replace( "@measureID",getSelectrdMeasureUIDonMeasuePopup());
		if(isQuarter(data2))
		{
			query=query.replace( "@flag","QNR");
		}
		else
		{
			query=query.replace( "@flag","QNR");
		}
		
		PatientDrillDownGrid  dbGrid =getDatabaseGrid(query,data1);
		PatientDrillDownGrid uiGrid =getWebGrid(elementmethod,locator);

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