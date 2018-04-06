package buisness.core.Submission;

import buisness.util.datastructures.Submission.AdvancedStatusGrid;
import buisness.util.helpers.Pagination;
import configuration.Setup;

/**
 * This class is used to validate pagination for Advanced Status grid data from Database and UI <p>
 * Returns AdvancedStatusPagination object<p>
 * @author Sachin.Gawade
 * Date : 11 Feb 2016
 */
public class AdvancedStatusPagination extends AdvancedStatus {

	/**
	 * This method is uset to compare two grids of same data type<p>
	 * @param uiGrid Passed UI Grid<p>
	 * @param dbGrid Passed UI Grid<p>
	 * @return true or false
	 */
	public boolean compareTO(AdvancedStatusGrid uiGrid,AdvancedStatusGrid dbGrid)
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
	 * @param pagination Pagination class object
	 * @param query Query to be run on database<p>
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * @return true or false
	 */
	public boolean compareGrid(Pagination pagination, String query, String elementmethod,String locator) {
		int i = pagination.getCurrentPage();
		String str = Integer.toString(i);
		String replaceQuery = query.replace("@pagenumber", str);
		AdvancedStatusGrid dbGrid = getDatabaseGrid(replaceQuery);
		AdvancedStatusGrid uiGrid = getWebGrid(elementmethod, locator);
		return compareTO( uiGrid, dbGrid);
	}
}

