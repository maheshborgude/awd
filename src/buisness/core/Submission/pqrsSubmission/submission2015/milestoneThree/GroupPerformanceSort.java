package buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree;

import buisness.util.datastructures.Submission.pqrssubmission.GroupPerformanceGrid;
import configuration.Setup;

/**Verifies Sorting of Report PQRS Measures Grid(PQRSubmission) prsent on Report PQRS Measures<p>
 * Extends GroupPerformanceViewSort<p>
 * This class Query Keyword to Extended GroupPerformanceViewSort class
 * This class pass the keywords present in Queries.properties
 * @author Rakesh.kulkarni<p>
 * Created Date: 04/03/2016
 * 
 */
public class GroupPerformanceSort extends GroupPerformance { /*extends GroupPerformanceViewSort/*
/**
 * Passes querylocator
 * Passes Parameters elementmethod and locator to verify() of PqrsAdvancedStatusView class
 * This method verify pagination of PQRS Advanced Status and click  on First last forward backward 
 * Method to compare object of PracticeGrid. It check value present on UI with Database 
 * @param locator
 * @return result of Test case "Pass" or "Fail"
 */
	public boolean verify(String elementmethod,String locator)
	{


		GroupPerformanceGrid  dbGrid =getDatabaseGrid("GroupPerformanceSortNew");
		GroupPerformanceGrid uiGrid =getWebGrid(elementmethod,locator);
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
