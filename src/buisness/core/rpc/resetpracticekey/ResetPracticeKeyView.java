package buisness.core.rpc.resetpracticekey;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.rpc.resetpracticekey.ResetPracticeKeyGrid;
import configuration.Setup; 

/**
 * This class used to get practice grid data from Database and UI and return a object with Grid value<p>
 * For logged in user in the database<p>
 * @author rakesh.kulkarni
 * Date : 11/03/2015
 */
public class ResetPracticeKeyView extends ResetPracticeKey {
	/**
	 * Default constructor for object creation   
	 */
	public ResetPracticeKeyView(){
	}	
	public ResetPracticeKeyGrid getDbGrid() {
		ConfigurationManager config = new ConfigurationManager();
		String query = config.getQuery("ResetpracticekeyView");
		query = query.replace("@loginName", getLoggedInUser());
		return super.getDatabaseGrid(query);
	}
	/**	
	 * Method to compare object of PracticeGrid. It check value present on UI with Database 
	 * @param locater
	 * @return result of Test case "Pass" or "Fail"
	 */
	public boolean verify(String elementmethod,String locater)
	{
		ResetPracticeKeyGrid  dbGrid =getDbGrid();
		ResetPracticeKeyGrid uiGrid =getWebGrid(elementmethod,locater);
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

