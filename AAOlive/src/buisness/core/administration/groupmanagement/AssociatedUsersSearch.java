package buisness.core.administration.groupmanagement;

import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.administration.groupmanagement.AssociatedUserGrid;
import configuration.Setup;
/**
 * This class is used to validate Searching property
 * This class Extends PracticeGrid witch is base class to get Data of grid from UI and DB 
 * @author rakesh.kulkarni
 * Date 20-1-2016	
 */
public class AssociatedUsersSearch extends AssociatedUsers {
	private String query;
	public AssociatedUsersSearch(){
	}	
	/**
	 * This method is used to replace the SearchKey value in query given through .xsls
	 * This method calls super method geDatabaseGrid(query)
	 */
	public AssociatedUserGrid getDatabaseGrid(String searchKey ) {
		ConfigurationManager config = new ConfigurationManager();
	    query = config.getQuery("ValidateSearchingThroughLoginName");	
		String replacedQuery=query.replace("@searchvalue",searchKey);
		return super.getDatabaseGrid(replacedQuery);
	}
	/**
	 * This method compare Database grid and UI Grid 	
	 * @param locater is xpath that is used to get DataGrid from UI
	 * @param searchKey value get from .Xlsx and used to pass as searchKey in search text box
	 * @return the result of test case Pass or Fail 
	 */
	public boolean verifyGrid(String elementmethod, String locater, String searchKey)

	{
		AssociatedUserGrid dbGrid =getDatabaseGrid(searchKey);
		AssociatedUserGrid uiGrid =getWebGrid(elementmethod,locater);
		if(uiGrid.compareTo(dbGrid) == 0) 
		{
			Setup.log.trace("Sorted data present on practice Grid on UI match with Database");
			Setup.testcase.assertTrue(true);
			return true;
		}
		else 
		{
			Setup.log.trace("Sorted data present on practice Grid on UI not match with Database");
			Setup.testcase.fail("Sorted data present on practice Grid on UI not match with Database");
			return false;
		}
	}	

}
