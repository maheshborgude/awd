package buisness.core.administration.groupmanagement;
import java.sql.SQLException;

import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.administration.groupmanagement.GroupManagementGrid;
import configuration.Setup; 

/**
 * This class used to get practice grid data from Database and UI and return a object with Grid value<p>
 * For logged in user in the database<p>
 * @author rakesh.kulkarni
 * Date : 28/1/2015
 */	
public class UserGroupView extends UserGroup {
	/**
	 * Default constructor for object creation   
	 */
	public UserGroupView(){
	}	
	public GroupManagementGrid getDbGrid() {
		ConfigurationManager config = new ConfigurationManager();
	//	DashboardUI dashboardUI=new DashboardUI();
	//	String loginUserUID=dashboardUI.getLoggedInUserFIGUserUID();
		String query = config.getQuery("ValidateGroupManagementTable");	
	//	String replaecQuery=query.replace("@LoggedInUser", loginUserUID);
		return super.getDatabaseGrid(query);
	}
	/**	
	 * Method to compare object of PracticeGrid. It check value present on UI with Database 
	 * @param locater
	 * @param elementmethod 
	 * @return result of Test case "Pass" or "Fail"
	 * @throws SQLException 
	 */
	public boolean verifyGrid( String elementmethod, String locater) 
	{
		GroupManagementGrid  dbGrid =getDbGrid();
		GroupManagementGrid uiGrid =getWebGrid(elementmethod,locater);
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

