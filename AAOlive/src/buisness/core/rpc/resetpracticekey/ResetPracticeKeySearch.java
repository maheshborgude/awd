package buisness.core.rpc.resetpracticekey;

import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.rpc.resetpracticekey.ResetPracticeKeyGrid;
import configuration.Setup;
/**
 * This class is used to validate Searching Reset practice Key
 * This class Extends PracticeGrid witch is base class to get Data of grid from UI and DB 
 * @author rakesh.kulkarni
 * Date 20-1-2016	
 */
public class ResetPracticeKeySearch extends ResetPracticeKey {
	private String query;
	public ResetPracticeKeySearch(){
	}	
	/**
	 * This method is used to replace the SearchKey value in query given through .xsls
	 * This method calls super method geDatabaseGrid(query)
	 */
	public ResetPracticeKeyGrid getDatabaseGrid(String searchKey ) {
		ConfigurationManager config = new ConfigurationManager();
	    query = config.getQuery("ResetpracticekeySearch");	
		String replacedQuery=query.replace("@searchvalue",searchKey);
		return super.getDatabaseGrid(replacedQuery);
	}
	/**
	 * This method compare Database grid and UI Grid 	
	 * @param locater is xpath that is used to get DataGrid from UI
	 * @param searchKey value get from .Xlsx and used to pass as searchKey in search text box
	 * @return the result of test case Pass or Fail 
	 */
	public boolean Verify(String elementmethod, String locater, String searchKey)

	{
		ResetPracticeKeyGrid dbGrid =getDatabaseGrid(searchKey);
		ResetPracticeKeyGrid uiGrid =getWebGrid(elementmethod,locater);
		if(uiGrid.compareTo(dbGrid) == 0) 
		{
			Setup.log.trace("search data present on practice Grid on UI match with Database");
			Setup.testcase.assertTrue(true);
			return true;
		}
		else 
		{
			Setup.log.trace("Search data present on practice Grid on UI not match with Database");
			Setup.testcase.fail("Search data present on practice Grid on UI not match with Database");
			return false;
		}
	}	

}
