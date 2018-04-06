package buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree;

import buisness.core.Submission.AdvancedStatusSort;
import buisness.util.datastructures.Submission.AdvancedStatusGrid;
import configuration.Setup;

/**Verifies Sorting of RPqrs Advanced StatusIMR Grid(PQRSubmission) present on Report PQRS Measures<p>
 * Extends PqrsAdvancedStatusViewSort<p>
 * This class Query Keyword to Extended PqrsAdvancedStatusViewSort class
 * This class pass the keywords present in Queries.properties
 * @author Rakesh.kulkarni<p>
 * Created Date: 02/03/2016
 * 
 */
public class PqrsAdvancedStatusIMRSort extends AdvancedStatusSort{
	/**
	 * Passes querylocator
	 * Passes Parameters elementmethod and locator to verify() of PqrsAdvancedStatusView class
	 * This method verify pagination of PQRS Advanced Status and click  on First last forward backward 
	 * Method to compare object of PracticeGrid. It check value present on UI with Database 
	 * @param locator
	 * @param elementmethod
	 * @return result of Test case "Pass" or "Fail"
	 */
	public boolean verify(String elementmethod,String locator,String data)
	{
		AdvancedStatusGrid  dbGrid =getDatabaseGrid("PqrsAdvancedStatusIMRSort","asc");
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
