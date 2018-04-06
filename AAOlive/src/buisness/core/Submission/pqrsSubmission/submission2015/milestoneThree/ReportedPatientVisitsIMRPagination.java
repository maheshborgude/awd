package buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree;

import org.openqa.selenium.WebElement;

import buisness.core.Submission.ReportedPatientVisits;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.Submission.ReportedPatientVisitsGrid;
import buisness.util.helpers.Pagination;
import configuration.Setup;

/**Verifies pagination of Reported Patient Visits IMR Pagination Grid(PQRSubmission) prsent on Report PQRS Measures<p>
 * Extends RepPatientVisitsPagination<p>
 * This class Query Keyword to Extended RepPatientVisitsPagination class
 * This class pass the keywords present in Queries.properties
 * Created Date: 02/03/2016
 * 
 */

public class ReportedPatientVisitsIMRPagination extends ReportedPatientVisits{
	/**
	 * Passes querylocator
	 * Passes Parameters elementmethod and locator to verify() of PqrsAdvancedStatusView class
	 * This method verify pagination of PQRS Advanced Status and click  on First last forward backward 
	 * Method to compare object of PracticeGrid. It check value present on UI with Database 
	 * @param locator
	 * @param elementmethod
	 * @return result of Test case "Pass" or "Fail"
	 */
	public boolean verify(String elementmethod,String locater)
	{
		boolean result=true;
		WebElement webtable=getWebElement(elementmethod,locater); 
		Pagination pagination=new Pagination(webtable);
		ConfigurationManager config = new ConfigurationManager();
		String query = config.getQuery("ReportedPatientVisitsIMRPagination"); 
		System.err.println(query);

		if(result) {
			pagination.browseLastPage();
			result = compareGrids(pagination, query, elementmethod, locater);
		}
		if(result) {
			pagination.browsePreviousPage();
			result = compareGrids(pagination, query, elementmethod, locater);
		}
		if(result) {
			pagination.browseNextPage();
			result = compareGrids(pagination, query, elementmethod, locater);
		}
		if(result) {
			pagination.browseFirstPage();
			result = compareGrids(pagination, query, elementmethod, locater);
		}
		if(result) {
			Setup.log.trace("Data present on practice Grid on UI match with Dtabase");
			Setup.testcase.assertTrue(true);
		}
		else {
			Setup.log.trace("Data present on practice Grid on UI not match with Dtabase");
			Setup.testcase.fail();
		}
		return result;
	}	
	public boolean compareTO(ReportedPatientVisitsGrid uiGrid,ReportedPatientVisitsGrid dbGrid)
	{
		if(uiGrid.compareTo(dbGrid) == 0) {
			return true;
		}
		else 	{
			return false;
		}
	}

	public boolean compareGrids(Pagination pagination, String query, String elementmethod,String locater) {
		int i = pagination.getCurrentPage();
		String str = Integer.toString(i);
		String replaceQuery = query.replace("@currentPage", str);
		buisness.util.datastructures.Submission.ReportedPatientVisitsGrid dbGrid = getDatabaseGrid(replaceQuery);
		buisness.util.datastructures.Submission.ReportedPatientVisitsGrid uiGrid = getWebGrid(elementmethod, locater);
		boolean result = compareTO( uiGrid, dbGrid);
		return result;
	}

}
