package buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree;

import org.openqa.selenium.WebElement;

import buisness.core.Submission.AdvancedStatus;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.Submission.AdvancedStatusGrid;
import buisness.util.helpers.Pagination;
import configuration.Setup;

/**Verifies Sorting of Report PQRS Measures Grid(PQRSubmission) prsent on Report PQRS Measures<p>
 * Extends PqrsAdvancedStatusPagination<p>
 * This class Query Keyword to Extended PqrsAdvancedStatusPagination class
 * @author Rakesh.kulkarni<p>
 * Created Date: 03/03/2016
 * 
 */
public class PqrsAdvancedStatusQCDRRPagination extends AdvancedStatus{
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
		String query = config.getQuery("PqrsAdvancedStatusQCDRRPagination"); 

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
	public boolean compareTO(AdvancedStatusGrid uiGrid,AdvancedStatusGrid dbGrid)
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
		AdvancedStatusGrid dbGrid = getDatabaseGrid(replaceQuery);
		AdvancedStatusGrid uiGrid = getWebGrid(elementmethod, locater);
		boolean result = compareTO( uiGrid, dbGrid);
		return result;
	}



}