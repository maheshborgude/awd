package buisness.core.dashboard.provider;

import buisness.util.datastructures.dashboard.provider.ProviderViewGrid;
import buisness.util.helpers.Pagination;
import configuration.Setup;

/**
 * This class used to validate pagination Dashboard>>Provider or Dashboard>>Location 
 * grid data from Database and UI and return a object with Grid value<p>
 * For logged in user in the database<p>
 * @author Sachin.Gawade
 * Date : 1 Mar 2016
 */
public class ProviderLocationPagination extends ProviderLocation {
	
	/**
	 * This method is uset to compare two grids of same data type<p>
	 * @param uiGrid Passed UI Grid<p>
	 * @param dbGrid Passed Database Grid<p>
	 * @return true or false<p>
	 */
	public boolean compareTO(ProviderViewGrid uiGrid,ProviderViewGrid dbGrid)
	{
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
	
	/**
	 * This method when invoked calls getDatabaseGrid() and getWebGrid()<p>
	 * @param pagination Pagination class object<p>
	 * @param query Query to be run on database<p>
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * @return true or false based on the comparison
	 */

	public boolean compareGrid(Pagination pagination, String query, String elementmethod,String locator) {
		int i = pagination.getCurrentPage();
		String str = Integer.toString(i);
		String replaceQuery = query.replace("@pagenumber", str);
		ProviderViewGrid dbGrid = getDatabaseGrid(replaceQuery);
		ProviderViewGrid uiGrid = getWebGrid(elementmethod, locator);
		boolean result = compareTO( uiGrid, dbGrid);
		return result;
	}
}

