package buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree;
import org.openqa.selenium.WebElement;

import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.Submission.pqrssubmission.ReportedPatientVisitsCMGRGrid;
import buisness.util.helpers.Pagination;
import configuration.Setup; 

/**
 * This test case validate Reported Patient Visits CMGR Pagination present on PQRS Submission >> Submission 2015 
 *      >> Report PQRS Measures Milestone >>Reported Patient Visits of CMGR
 * This test case validate data present in Grid
 * This test case validate data present in Grid with data present in Database of eligible patient 
 * This test case compare total view of data present on UI of application 
 * Test case is pass if return result is pass else it will fail 
 * @author rakesh.kulkarni
 * Date 01/03/2016
 */
public class ReportedPatientVisitsCMGRPagination extends ReportedPatientVisitsCMGR {
	/**
	 * Default constructor for object creation   
	 */
	public ReportedPatientVisitsCMGRPagination(){
	}	

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
		String query = config.getQuery("ReportedPatientVisitsCMGRPagination"); 

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
	public boolean compareTO(ReportedPatientVisitsCMGRGrid uiGrid,ReportedPatientVisitsCMGRGrid dbGrid)
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
		ReportedPatientVisitsCMGRGrid dbGrid = getDatabaseGrid(replaceQuery);
		ReportedPatientVisitsCMGRGrid uiGrid = getWebGrid(elementmethod, locater);
		boolean result = compareTO( uiGrid, dbGrid);
		return result;
	}
}

