package buisness.core.administration.practice;
import org.openqa.selenium.WebElement;

import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.administration.practice.PracticeGrid;
import buisness.util.helpers.Pagination;
import configuration.Setup; 

/**
 * This class used to get practice grid data from Database and UI and return a object with Grid value<p>
 * For logged in user in the database<p>
 * @author rakesh.kulkarni
 * Date : 13/1/2015
 */
public class PracticeGridPagination extends Practice {
	/**
	 * Default constructor for object creation   
	 */
	public PracticeGridPagination(){
	}	

	/**	
	 * This method verify pagination of practice and click  on First last forward backward
	 * Method to compare object of PracticeGrid. It check value present on UI with Database 
	 * @param locater
	 * @return result of Test case "Pass" or "Fail"
	 */
	@SuppressWarnings("unused")
	public boolean verifyGrid(String elementmethod,String locater)
	{
		boolean result=true;
		WebElement webtable=getWebElement(elementmethod,locater); 
		Pagination pagination=new Pagination(webtable);
		ConfigurationManager config = new ConfigurationManager();
		String query = config.getQuery("PracticePegination"); 
		
		if(pagination == null)
		{
			return true;
		}
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
	public boolean compareTO(PracticeGrid uiGrid,PracticeGrid dbGrid)
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
		PracticeGrid dbGrid = getDbGrid(replaceQuery);
		PracticeGrid uiGrid = getWebGrid(elementmethod, locater);
		boolean result = compareTO( uiGrid, dbGrid);
		return result;
	}
}

