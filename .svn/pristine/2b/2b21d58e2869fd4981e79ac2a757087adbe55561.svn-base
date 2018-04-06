package buisness.core.Submission.pqrsSubmission.submission2015.milestoneFour;

import org.openqa.selenium.WebElement;

import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.Submission.pqrssubmission.ProviderSubmissionGrid;
import buisness.util.helpers.Pagination;
import configuration.Setup;

/**Verifies Sorting of Report PQRS Measures Grid(PQRSubmission) prsent on Report PQRS Measures<p>
 * Extends PqrsAdvancedStatusPagination<p>
 * This class Query Keyword to Extended PqrsAdvancedStatusPagination class
 * @author Rakesh.kulkarni<p>
 * Created Date: 03/03/2016
 * 
 */
public class ProviderSubmissionPagination extends ProviderSubmission{
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
		ConfigurationManager config = new ConfigurationManager();
		String query = config.getQuery("ProviderSubmissionPagination");

		try
		{
			Pagination pagination=new Pagination(webtable);
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
				Setup.log.error("Data present on practice Grid on UI not match with Dtabase");
				Setup.testcase.fail();
			}
			return result;
		}
		catch (Exception e)
		{
			Setup.log.error("Data present on practice Grid on UI not match with Dtabase");
			return false;
		}

	}	
	public boolean compareTO(ProviderSubmissionGrid uiGrid,ProviderSubmissionGrid dbGrid)
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
	    replaceQuery = replaceQuery.replace("@loginuser",getLoggedInUser());
	    System.err.println(replaceQuery);
		ProviderSubmissionGrid dbGrid = getDatabaseGrid(replaceQuery);
		ProviderSubmissionGrid uiGrid = getWebGrid(elementmethod, locater);
		boolean result = compareTO( uiGrid, dbGrid);
		return result;
	}



}