package buisness.core.Submission;


import buisness.util.datastructures.Submission.ReportedPatientVisitsGrid;
import buisness.util.helpers.Pagination;
import configuration.Setup;
/**Verifies Pagination for Report Patient Visit Grid<p>
 * Extends ReportedPatientVisitsp>
 * @author Sachin.Gawade<p>
 * Created Date: 18 Feb 2016
 * 
 */
public class RepPatientVisitsPagination extends ReportedPatientVisits
{
	
	public boolean compareTO(ReportedPatientVisitsGrid uiGrid,ReportedPatientVisitsGrid dbGrid)
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
	 * @param elementmethod elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * @return true or false
	 */
	public boolean compareGrid(Pagination pagination, String query, String elementmethod,String locator) 
	{
		int i = pagination.getCurrentPage();
		String str = Integer.toString(i);
		String replaceQuery = query.replace("@pagenumber", str);
		ReportedPatientVisitsGrid dbGrid = getDatabaseGrid(replaceQuery);
		ReportedPatientVisitsGrid uiGrid = getWebGrid(elementmethod, locator);
		boolean result = compareTO( uiGrid, dbGrid);
		return result;
	}
	
	
	
	
}
