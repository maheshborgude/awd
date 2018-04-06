package buisness.core.dashboard.Practice.nonRolling;

import buisness.core.dashboard.Practice.SubmissionDetails;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.dashboard.practice.SubmissionDetailsGrid;
import buisness.util.helpers.Pagination;
import configuration.Setup;
import org.openqa.selenium.WebElement;

/**
 * Verifies Submission Details Count present on Dashboard > Practice For NOnRolling<p>
 * Extends ProviderLocationCount<p>
 * This class Query Keyword to Extended PracticeFavoritesMeasureCountNR class
 * Returns boolean true if grid from UI and Database match<p>
 * Returns boolean false if grid from UI and Database do not match<p>
 * Return  data to validate Grid.
 * For logged in user in the database<p>
 * @author rakesh.kulkarni
 * Date : 16/03/2016
 */
public class SubmissionDetailsPaginationNR extends SubmissionDetails {
	/**
	 * Default constructor for object creation
	 */
	public SubmissionDetailsPaginationNR(){
	}

	/**
	 * This class compare row of Data row of Submission Details Count present on Dashboard > Practice For NOnRolling
	 *   >>PQRS Submission Details for NonRolling
	 *  . It check value present on UI with Daftabase
	 * @param locater
	 * @param elementmethod
	 * @return result of Test case "Pass" or "Fail"
	 */

	public boolean verify(String elementmethod,String locater)
	{
		boolean result=true;
		WebElement webtable=getWebElement(elementmethod,locater); 
		Pagination pagination=new Pagination(webtable);
		ConfigurationManager config = new ConfigurationManager();
		String query = config.getQuery("SubmissionDetailsPaginationNR");
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
	public boolean compareTO(SubmissionDetailsGrid webGrid,SubmissionDetailsGrid databaseGrid)
	{
		if(webGrid.compareTo(databaseGrid) == 0) {
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
		SubmissionDetailsGrid databaseGrid = getDatabaseGrid(replaceQuery);
		SubmissionDetailsGrid webGrid = getWebGrid(elementmethod, locater);
		boolean result = compareTO( databaseGrid, webGrid);
		return result;
	}
}

