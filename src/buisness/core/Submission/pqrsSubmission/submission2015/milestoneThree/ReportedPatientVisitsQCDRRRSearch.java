package buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.Submission.pqrssubmission.ReportedPatientVisitsCMGRGrid;
import configuration.Setup; 

/**
 * This test case validate Reported Patient Visits For Qualified Clinical Data Registry Reporting
 *  Search present on PQRS Submission >> Submission 2015 >> Report PQRS Measures Milestone >>Reported Patient Visits QCDRRR Search 
 * This test case validate data present in Grid
 * This test case validate data present in Grid with data present in Database of eligible patient 
 * This test case compare total view of data present on UI of application 
 * Test case is pass if return result is pass else it will fail 
 * @author rakesh.kulkarni
 * Date : 03/02/2015
 */
public class ReportedPatientVisitsQCDRRRSearch extends ReportedPatientVisitsQCDRR {
	/**
	 * Default constructor for object creation   
	 */
	public ReportedPatientVisitsQCDRRRSearch(){
	}	
	public ReportedPatientVisitsCMGRGrid getDbGrid(String data) {
		ConfigurationManager config = new ConfigurationManager();
		String query = config.getQuery("ReportedPatientVisitsQCDRRRSearch");	
		String replacekey=data;
		String replaecQuery=query.replace("@searchkey", replacekey);
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
	public boolean verify(String elementmethod,String locater,String data)
	{
		ReportedPatientVisitsCMGRGrid dbGrid =getDbGrid(data);
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

