package buisness.core.administration.groupmanagement;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.administration.groupmanagement.AuthorizedUsersGroupsGrid;
import buisness.util.helpers.Pagination;
import configuration.Setup; 

/**
 * This class validate the pagination and compare the result of UI and Databse
 * This class used to get practice grid data from Database and UI and return a object with Grid value<p>
 * For logged in user in the database<p>
 * @author rakesh.kulkarni
 * Date : 13/1/2015
 */
public class AuthorizedUsersGroupsPagination extends AuthorizedUsersGroups {
	/**
	 * Default constructor for object creation   
	 */
	public AuthorizedUsersGroupsPagination(){
	}	

	/**	
	 * This method verify pagination of UserGroup and click  on First last forward backward 
	 * Method to compare object of PracticeGrid. It check value present on UI with Database 
	 * @param locater
	 * @return result of Test case "Pass" or "Fail"
	 */

	public boolean verifyGrid(String elementmethod,String locater)
	{
		boolean result=true;
		WebElement webtable=getWebElement(elementmethod,locater);
		ConfigurationManager config = new ConfigurationManager();
		String query = config.getQuery("AuthorizedUsersGroupsPagination");

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
				Setup.log.error("Data present on practice Grid on UI match with Dtabase");
				Setup.testcase.assertTrue(true);
			}
			else {
				Setup.log.error("Data present on practice Grid on UI not match with Dtabase");
				Setup.testcase.fail();
			}
			return result;
		}
		catch (Exception exce)
		{
			Setup.log.error("Error occured in pagination or Pagination grid is not present On ui");
		}
		return result;
	}	
	public boolean compareTO(AuthorizedUsersGroupsGrid uiGrid,AuthorizedUsersGroupsGrid dbGrid)
	{
		if(uiGrid.compareTo(dbGrid) == 0) {
			return true;
		}
		else 	{
			return false;
		}
	}

	public boolean compareGrids(Pagination pagination, String query, String elementmethod,String locater) {
		boolean result=false;
		try
		{
			int i = pagination.getCurrentPage();
			String str = Integer.toString(i);
			String replaceQuery = query.replace("@currentPage", str);
			AuthorizedUsersGroupsGrid dbGrid = getDatabaseGrid(replaceQuery);
			AuthorizedUsersGroupsGrid uiGrid = getWebGrid(elementmethod, locater);
			result= compareTO( uiGrid, dbGrid);
			return result;
		}
		catch (Exception excep)
		{
			Setup.log.error("Error occured in fetch data from database or UI");
		}
		return result;
	}
}

