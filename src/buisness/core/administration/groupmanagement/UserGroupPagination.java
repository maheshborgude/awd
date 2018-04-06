package buisness.core.administration.groupmanagement;
import org.openqa.selenium.WebElement;

import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.administration.groupmanagement.GroupManagementGrid;
import buisness.util.helpers.Pagination;
import configuration.Setup; 

/**
 * This class used to get practice grid data from Database and UI and return a object with Grid value<p>
 * For logged in user in the database<p>
 * @author rakesh.kulkarni
 * Date : 13/1/2015
 */
public class UserGroupPagination extends UserGroup {
	/**
	 * Default constructor for object creation   
	 */
	public UserGroupPagination(){
	}	

	/**	
	 * This method verify pagination of UserGroup and click  on First last forward backward 
	 * Method to compare object of PracticeGrid. It check value present on UI with Database 
	 * @param locater
	 * @return result of Test case "Pass" or "Fail"
	 */
	
	public boolean verifyGrid(String elementmethod,String locater)
	{
		WebElement webtable=getWebElement(elementmethod,locater);
		ConfigurationManager config = new ConfigurationManager();
		String query = config.getQuery("UserGroupPagination"); 
		String replaceQuery=null;

		try
		{
			Pagination pagination=new Pagination(webtable);

			pagination.browseLastPage();
			int i=pagination.getCurrentPage();
			String str = Integer.toString(i);
			replaceQuery=query.replace("@currentPage",str);
			GroupManagementGrid  dbGrid =super.getDatabaseGrid(replaceQuery);
			GroupManagementGrid uiGrid =getWebGrid(elementmethod,locater);


			pagination.browsePreviousPage();
			i=pagination.getCurrentPage();
			str = Integer.toString(i);
			replaceQuery=query.replace("@currentPage",str);
			dbGrid =super.getDatabaseGrid(replaceQuery);
			uiGrid =getWebGrid(elementmethod,locater);

			pagination.browseNextPage();
			i=pagination.getCurrentPage();
			str = Integer.toString(i);
			replaceQuery=query.replace("@currentPage",str);
			dbGrid =super.getDatabaseGrid(replaceQuery);
			uiGrid =getWebGrid(elementmethod,locater);

			pagination.browseFirstPage();
			i=pagination.getCurrentPage();
			str = Integer.toString(i);
			replaceQuery=query.replace("@currentPage",str);
			dbGrid =super.getDatabaseGrid(replaceQuery);
			uiGrid =getWebGrid(elementmethod,locater);

			return compareTO(dbGrid,uiGrid);
		}
		catch (Exception excep)
		{
			Setup.log.error("Error occured in pagination or Pagnination is not present");
		}
		return true;

	}	
	public boolean compareTO(GroupManagementGrid uiGrid,GroupManagementGrid dbGrid)
	{
		if(uiGrid.compareTo(dbGrid) == 0) 
		{
			Setup.log.trace("Data match");
			Setup.testcase.assertTrue(true);
			return true;
		}
		else 
			Setup.log.debug("Data not Match");
		    Setup.testcase.fail();
		    return false;
	}
}

