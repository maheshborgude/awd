package buisness.core.dashboard.provider;

import buisness.util.datastructures.dashboard.PatientDrillDownGrid;
import buisness.util.helpers.Pagination;
import configuration.Setup;

/**
 * This class is used to validate pagination Dashboard>>Provider or Dashboard>>Location Patient Drill Down grid
 * @author Sachin.Gawade
 * Date : 3 Mar 2016
 */
public class PatientDrillDownPagination extends PatientDrillDown {
	
	public boolean compareTO(PatientDrillDownGrid uiGrid,PatientDrillDownGrid dbGrid)
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
	 * This method also replaces '@pagenumber' text from the query with actual current page<p>
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
		PatientDrillDownGrid dbGrid = getDatabaseGrid(replaceQuery);
		PatientDrillDownGrid uiGrid = getWebGrid(elementmethod, locator);
		boolean result = compareTO( uiGrid, dbGrid);
		return result;
	}
}



