package buisness.core.dashboard.Practice.rolling;
import buisness.core.Submission.pqrsSubmission.submission2015.milestoneTwo.SelectProvider;
import buisness.core.dashboard.Practice.SubmissionDetails;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.Submission.pqrssubmission.SelectProviderGrid;
import buisness.util.datastructures.dashboard.practice.SubmissionDetailsGrid;
import configuration.Setup;

/**
 * Verifies Submission Details view present on Dashboard > Practice For Rolling<p>
 * Extends ProviderLocationCount<p>
 * This class Query Keyword to Extended PracticeFavoritesMeasureCountNR class
 * Returns boolean true if grid from UI and Database match<p>
 * Returns boolean false if grid from UI and Database do not match<p>
 * Return  data to validate count.
 * For logged in user in the database<p>
 * @author rakesh.kulkarni
 * Date : 16/03/2016
 */
public class SubmissionDetailsViewR extends SubmissionDetails {
	/**
	 * Default constructor for object creation
	 */
	public SubmissionDetailsViewR(){
	}	
	public SubmissionDetailsGrid getDbGrid() {
		ConfigurationManager config = new ConfigurationManager();
		String query = config.getQuery("");
		return super.getDatabaseGrid(query);
	}
	/**
	 * Passes locator : To Find the element
	 * Passes Parameters elementmethod and locator to verify() Submission Details view present on Dashboard > Practice For Rolling
	 * This method verify Count
	 * Method to compare object of DatabaseGrid and WebGrid. It check value present on UI with Database
	 * @param locater : To Find the element Name of locator in object repository<p>
	 * @param elementmethod : To Find the element by the type of Element Example xpath, id,
	 * @Param data : quarter or month
	 * @return result of Test case "Pass" or "Fail"
	 */
	public boolean verify(String elementmethod,String locater)
	{
		SubmissionDetailsGrid webGrid = getWebGrid(elementmethod,locater);
		SubmissionDetailsGrid databaseGrid = getDbGrid();
	//	SubmissionDetailsGrid webGrid = getWebGrid(elementmethod,locater);
		if(databaseGrid.compareTo(webGrid) == 0)
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

