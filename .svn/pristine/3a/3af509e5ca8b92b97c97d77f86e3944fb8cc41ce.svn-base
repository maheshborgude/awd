package buisness.core.Submission.pqrsSubmission.submission2015.milestoneTwo;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.Submission.pqrssubmission.TaxIdentificationNumberGrid;
import configuration.Setup; 

/**
 * This class used to get PQRS Submission >> Submission 2015 >> ManageProviderProfile Milestone >>Tax Identification Number Tab
 *     data from Database and UI and return a object with Grid value<p>
 * This class get Query keyword form Query locator class
 * This class read query by keywords present in Queries.properties
 * For logged in user in the database<p>
 * @author rakesh.kulkarni
 * Date : 28/1/2015
 */
public class TaxIdentificationNumberView extends TaxIdentificationNumber	 {
	/**
	 * Default constructor for object creation   
	 */
	public TaxIdentificationNumberView(){
	}	
	public TaxIdentificationNumberGrid getDbGrid() {
		ConfigurationManager config = new ConfigurationManager();
		String query = config.getQuery("TaxIdentificationNumberView");	
		return super.getDatabaseGrid(query);
	}
	/**	
	 * Method to compare object of PQRS Submission >> Submission 2015 >> ManageProviderProfile Milestone >>Tax Identification Number
	 *  . It check value present on UI with Database 
	 * @param locater
	 * @return result of Test case "Pass" or "Fail"
	 */
	public boolean verifyGrid(String elementmethod,String locater)
	{
		TaxIdentificationNumberGrid  dbGrid =getDbGrid();
		TaxIdentificationNumberGrid uiGrid =getWebGrid(elementmethod,locater);

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

