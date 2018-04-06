package buisness.core.administration.practice;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.administration.practice.PracticeGrid;
import configuration.Setup; 

/**
 * This class used to get practice grid data from Database and UI and return a object with Grid value<p>
 * For logged in user in the database<p>
 * @author rakesh.kulkarni
 * Date : 13/1/2015
 */
public class PracticeView extends Practice {
	/**
	 * Default constructor for object creation   
	 */
	public PracticeView(){
	}	
	/**
	 * This method is get query from Querys.properties 
	 * This method also replace the key value present in query
	 * This method calls super method getDbGrid(query)
	 */
	public PracticeGrid getDbGrid() {
		ConfigurationManager config = new ConfigurationManager();
		String query = config.getQuery("ValidateTotalPracticeCount");	
		return super.getDbGrid(query);
	}
	/**	
	 * Method to compare object of PracticeGrid. It check value present on UI with Database 
	 * @param locater locater of web element 
	 * @param  elementmethod This method describe the type of locater
	 * @return result of Test case "Pass" or "Fail"
	 */
	public boolean verifyGrid(String elementmethod,String locater)
	{
		PracticeGrid  dbGrid =getDbGrid();
		PracticeGrid uiGrid =getWebGrid(elementmethod,locater);
		if(uiGrid.compareTo(dbGrid) == 0) 
		{
     		Setup.log.debug("Data present on practice Grid on UI match with Dtabase ");
			Setup.testcase.assertTrue(true);
			return true;
		}
		else 
			Setup.log.debug("Data present on practice Grid on UI not match with Dtabase");
		Setup.testcase.fail();
		return false;
	}	
}

