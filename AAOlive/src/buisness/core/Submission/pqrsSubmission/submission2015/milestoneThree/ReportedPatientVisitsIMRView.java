package buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree;

import buisness.core.Submission.ReportedPatientVisitsView;
import buisness.util.datastructures.Submission.ReportedPatientVisitsGrid;
import configuration.Setup;

/**Verifies Sorting of Report PQRS Measures Grid(PQRSubmission) prsent on Report PQRS Measures<p>
 * Extends ReportedPatientVisitsView<p>
 * This class Query Keyword to Extended ReportedPatientVisitsView class
 * This class pass the keywords present in Queries.properties
 * @author Rakesh.kulkarni<p>
 * Created Date: 03-01-2015
 **/

public class ReportedPatientVisitsIMRView extends ReportedPatientVisitsView{
	/**
	 * Passes querylocator
	 * Passes Parameters elementmethod and locator to verify() of PqrsAdvancedStatusView class
	 * This method verify pagination of PQRS Advanced Status and click  on First last forward backward 
	 * Method to compare object of PracticeGrid. It check value present on UI with Database 
	 * @param locator
	 * @param elementmethod
	 * @return result of Test case "Pass" or "Fail"
	 */
	public boolean verify(String elementmethod,String locator)
	{

		ReportedPatientVisitsGrid uiGrid =getWebGrid(elementmethod,locator);
		ReportedPatientVisitsGrid  dbGrid =getDatabaseGrid("ReportedPatientVisitsIMRView");
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
