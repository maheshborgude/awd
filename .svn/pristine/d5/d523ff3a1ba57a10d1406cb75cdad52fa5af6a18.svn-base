package buisness.core.dashboard.Practice.rolling;

import buisness.core.Submission.pqrsSubmission.submission2015.milestoneTwo.SelectProvider;
import buisness.core.dashboard.Practice.SubmissionDetails;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.Submission.pqrssubmission.SelectProviderGrid;
import buisness.util.datastructures.dashboard.practice.SubmissionDetailsGrid;
import buisness.util.helpers.Pagination;
import configuration.Setup;
import org.openqa.selenium.WebElement;

/**
 * Verifies Submission Details Count present on Dashboard > Practice For Rolling<p>
 * Extends ProviderLocationCount<p>
 * This class Query Keyword to Extended PracticeFavoritesMeasureCountNR class
 * Returns boolean true if grid from UI and Database match<p>
 * Returns boolean false if grid from UI and Database do not match<p>
 * Return  data to validate count.
 * For logged in user in the database<p>
 * @author rakesh.kulkarni
 * Date : 16/03/2016
 */
public class SubmissionDetailsPaginationR extends SubmissionDetails {
	/**
	 * Default constructor for object creation
	 */
	public SubmissionDetailsPaginationR(){
	}

	/**
	 * Passes locator : To Find the element
	 * Passes Parameters elementmethod and locator to verify() Submission Details Count present on Dashboard > Practice For Rolling
	 * This method verify Count
	 * Method to compare object of DatabaseGrid and WebGrid. It check value present on UI with Database
	 * @Param data : quarter or month
	 * @return result of Test case "Pass" or "Fail"
	 */

	public boolean verify(String elementmethod,String locater)
	{
		boolean result=true;
		WebElement webtable=getWebElement(elementmethod,locater); 
		Pagination pagination=new Pagination(webtable);
		ConfigurationManager config = new ConfigurationManager();
		String query = config.getQuery("SubmissionDetailsPaginationR");
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
	public boolean compareTO(SubmissionDetailsGrid uiGrid,SubmissionDetailsGrid dbGrid)
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
		SubmissionDetailsGrid dbGrid = getDatabaseGrid(replaceQuery);
		SubmissionDetailsGrid uiGrid = getWebGrid(elementmethod, locater);
		boolean result = compareTO( uiGrid, dbGrid);
		return result;
	}
}

