package buisness.core.Submission;
import buisness.util.datastructures.Submission.AdvancedStatusPopupGrid;
import buisness.util.helpers.Pagination;
import configuration.Setup; 

/**
 * This class used to validate pagination Advanced Status Popup<P>
 * grid data from Database and UI and return a object with Grid value<p>
 * For logged in user in the database<p>
 * @author Sachin.Gawade
 * Date : 29 Feb 2016
 */
public class AdvancedStatusPopupPagination extends AdvancedStatusPopup{

	public boolean compareTO(AdvancedStatusPopupGrid uiGrid,AdvancedStatusPopupGrid dbGrid)
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
	 * @param data measure number<p>
	 * @return true or false based on the comparison
	 */

	public boolean compareGrid(Pagination pagination, String query, String elementmethod,String locator, String data) {
		int i = pagination.getCurrentPage();
		String str = Integer.toString(i);
		String replaceQuery = query.replace("@pagenumber", str);
		replaceQuery = replaceQuery.replace("@measure", data);
		AdvancedStatusPopupGrid dbGrid = getDatabaseGrid(replaceQuery);
		AdvancedStatusPopupGrid uiGrid = getWebGrid(elementmethod, locator);
		boolean result = compareTO( uiGrid, dbGrid);
		return result;
	}
}

