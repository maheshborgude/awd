package buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree;

import buisness.core.Submission.AdvancedStatusView;
import buisness.util.datastructures.Submission.AdvancedStatusGrid;
import configuration.Setup;


/**Verifies View of Pqrs Advanced Status CMGR Grid(PQRSubmission) present on Report PQRS Measures<p>
 * Extends PqrsAdvancedStatusViewSort<p>
 * This class Query Keyword to Extended PqrsAdvancedStatusViewSort class
 * This class pass the keywords present in Queries.properties
 * @author Sachin.Gawade<p>
 * Created Date: 03/03/2016
 * 
 */
public class PqrsAdvancedStatusCMGRView extends AdvancedStatusView{
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


		AdvancedStatusGrid  dbGrid =getDatabaseGrid("PqrsAdvancedStatusCMGRView");
		AdvancedStatusGrid uiGrid =getWebGrid(elementmethod,locator);
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
