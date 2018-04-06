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
public class ResetPracticeKeySort extends ResetPracticeKey {
	/**
	 * Default constructor for object creation   
	 */
	public ResetPracticeKeySort(){
	}	
	public ResetPracticeKeyGrid getDbGrid() {
		ConfigurationManager config = new ConfigurationManager();
		String query = config.getQuery("ResetpracticekeySort");	
		String Newquery = query.replace("@loginName", getLoggedInUser());
		return super.getDatabaseGrid(Newquery);
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
     		Setup.log.trace("Data present on practice Grid on UI match with Database");
			Setup.testcase.assertTrue(true);
			return true;
		}
		else 
			Setup.log.trace("Data present on practice Grid on UI not match with Database");
		Setup.testcase.fail();
		return false;
	}	
}

