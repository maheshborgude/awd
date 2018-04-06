package buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.Submission.pqrssubmission.ReportedPatientVisitsCMGRGrid;
import configuration.Setup; 

/**
 * This class used to get PQRS Submission >> Submission 2015 >> Report PQRS Measures Milestone >>Report PQRS Measures Milestone
 *    >>Reported Patient Visits >> For Qualified Clinical Data Registry Reporting
 * For logged in user in the database<p>
 * This class returns result where the test case is Pass or Fail
 * @author rakesh.kulkarni
 * Date : 18/02/2016
 */
public class ReportedPatientVisitsQCDRRView extends ReportedPatientVisitsQCDRR	 {
	
	public ReportedPatientVisitsCMGRGrid getDbGrid() {
		ConfigurationManager config = new ConfigurationManager();
		String query = config.getQuery("ReportedPatientVisitsQCDRRView");	
		String replacekey="";
		String replaecQuery=query.replace("@GroupID", replacekey);
		return super.getDatabaseGrid(replaecQuery);
	}
	/**	
	 * Method to compare object of PQRS Submission >> Submission 2015 >> Report PQRS Measures Milestone >>
	 *   >>Reported Patient Visits >> For Qualified Clinical Data Registry Reporting
	 * It check value present on UI with Database 
	 * @param locator To locate web element on UI
	 * @param elementmethod Type of locater
	 * @return result of Test case "Pass" or "Fail"
	 */
	public boolean verify(String elementmethod,String locater)
	{
		ReportedPatientVisitsCMGRGrid  dbGrid =getDbGrid();
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

