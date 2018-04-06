package buisness.core.administration.groupmanagement;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.administration.groupmanagement.AuthorizedUsersGroupsGrid;
import configuration.Setup; 

/**
 * This class used to get practice grid data from Database and UI and return a object with Grid value<p>
 * For logged in user in the database<p>
 * @author rakesh.kulkarni
 * Date : 28/1/2015
 */
public class AuthorizedUsersGroupsView extends AuthorizedUsersGroups	 {
	/**
	 * Default constructor for object creation   
	 */
	public AuthorizedUsersGroupsView(){
	}	
	public AuthorizedUsersGroupsGrid getDbGrid(String replacekey) {
		ConfigurationManager config = new ConfigurationManager();
		String query = config.getQuery("ValidateTableOfAuthorizedUsersGroups");	
		String replaecQuery=query.replace("@replacekey", replacekey);
		return super.getDatabaseGrid(replaecQuery);
	}
	/**	
	 * Method to compare object of PracticeGrid. It check value present on UI with Database 
	 * @param locater
	 * @param elementmethod 
	 * @return result of Test case "Pass" or "Fail"
	 */
	public boolean verifyGrid(String elementmethod,String locater,String replacekey)
	{
    	AuthorizedUsersGroupsGrid  dbGrid =getDbGrid(replacekey);
		AuthorizedUsersGroupsGrid uiGrid =getWebGrid(elementmethod,locater);
		if(uiGrid.compareTo(dbGrid) == 0) 
		{
     		Setup.log.trace("Data present on practice Grid on UI match with Dtabase");
			Setup.testcase.assertTrue(true);
			return true;
		}
		else 
			Setup.log.trace("Data present on practice Grid on UI not match with Dtabase");
		    Setup.testcase.fail();
		return false;
	}	
}

