package buisness.core.administration.practice;

import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.administration.practice.PracticeGrid;
import configuration.Setup;
/**
 * This class is used to validate Searching property
 * This class Extends PracticeGrid with is base class to get Data of grid from UI and DB 
 * @author rakesh.kulkarni
 * Date 20-1-2016	
 */
public class PracticeSearch extends Practice {
	private String query;
	public PracticeSearch(){
	}	
	/**
	 * This method is get query from Querys.properties 
	 * This method also replace the key value present in query
	 * This method calls super method getDbGrid(query)
	 */
	public PracticeGrid getDbGrid(String searchKey ) {
		ConfigurationManager config = new ConfigurationManager();
	    query = config.getQuery("ValidateSearchingThroughExternallID");	
		String replacedQuery=query.replace("@searchvalue",searchKey);
		return super.getDbGrid(replacedQuery);
	}
	/**
	 * This method compare Db grid and UI Grid 	
	 * @param locater is xpath that is used to get DataGrid from UI
	 * @param searchKey value get from .Xlsx and used to pass as searchKey in search text box
	 * @param elementmethod 
	 * @return the result of test case Pass or Fail 
	 */
	public boolean verifyGrid(String elementmethod, String locater, String searchKey)

	{
		PracticeGrid  dbGrid =getDbGrid(searchKey);
		PracticeGrid uiGrid =getWebGrid(elementmethod, locater);
		if(uiGrid.compareTo(dbGrid) == 0) 
		{
			Setup.log.trace("Sorted data present on practice Grid on UI match with Database ");
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
