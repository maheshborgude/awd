package buisness.core.Submission.pqrsSubmission.submission2015.milestoneFour;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.Submission.pqrssubmission.ProviderSubmissionGrid;
import configuration.Setup; 

/**
 * This class used to get PQRS Submission >> Submission 2015 >> ManageProviderProfile Milestone >>Select Provider tab
 * data from Database and UI and return a object with Grid value<p>
 * This class get Query keyword form Query locator class
 * This class read query by keywords present in Queries.properties
 * For logged in user in the database<p>
 * @author rakesh.kulkarni
 * Date : 28/1/2015
 */
public class ProviderSubmissionView extends ProviderSubmission {

	
	public ProviderSubmissionGrid getDatabaseGrid(String querylocator) 
	{
		ConfigurationManager config = new ConfigurationManager();
		String query = config.getQuery(querylocator);	
		String replaceQuery=query.replace("@loginuser",getLoggedInUser());
		return super.getDatabaseGrid(replaceQuery);
	}	
	
	/**	
	 * Method to compare object of PQRS Submission >> Submission 2015 >> ManageProviderProfile Milestone >>Select Provider tab
	 *  . It check value present on UI with Database 
	 * @param locater
	 * @return result of Test case "Pass" or "Fail"
	 */
	public boolean verify(String elementmethod,String locater)
	{
		ProviderSubmissionGrid uiGrid =getWebGrid(elementmethod,locater);
		ProviderSubmissionGrid  dbGrid =getDatabaseGrid("ProviderSubmissionView");
		
		if(uiGrid.compareTo(dbGrid) == 0) 
		{
     		Setup.log.trace("Data present on practice Grid on UI match with Dtabase");
			Setup.testcase.assertTrue(true);
			return true;
		}
		else 
			Setup.log.trace("Data present on practice Grid on UI not match with Database");
		Setup.testcase.fail();
		return false;
	}	
}

