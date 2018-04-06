package buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.Submission.pqrssubmission.ReportedPatientVisitsCMGRGrid;
import configuration.Setup; 

/**
 * This class used to get PQRS Submission >> Submission 2015 >> Report PQRS
 *     Measures Milestone >>Reported Patient Visits CMGR Tab after enter value to search
 * Data from Database and UI and return a object with Grid value<p>
 * For logged in user in the database<p>
 * @author rakesh.kulkarni
 * Date : 08/02/2015
 */
public class ReportedPatientVisitsCMGRSearch extends ReportedPatientVisitsCMGR {
	/**
	 * Default constructor for object creation   
	 */
	public ReportedPatientVisitsCMGRSearch(){
	}	
	public ReportedPatientVisitsCMGRGrid getDbGrid(String data) {
		ConfigurationManager config = new ConfigurationManager();
		String query = config.getQuery("ReportedPatientVisitsCMGRSearch");	
		String replacekey=data;
		String replaecQuery=query.replace("@search", replacekey);
		return super.getDatabaseGrid(replaecQuery);
	}
	/**
	 * Passes querylocator
	 * Passes Parameters elementmethod and locator to verify() of PqrsAdvancedStatusView class
	 * This method verify pagination of PQRS Advanced Status and click  on First last forward backward 
	 * Method to compare object of PracticeGrid. It check value present on UI with Database 
	 * @param locator
	 * @param elementmethod
	 * @return result of Test case "Pass" or "Fail"
	 */
	public boolean verifyGrid(String elementmethod,String locater,String data)
	{
		ReportedPatientVisitsCMGRGrid  dbGrid =getDbGrid(data);
		ReportedPatientVisitsCMGRGrid uiGrid =getWebGrid(elementmethod,locater);

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

