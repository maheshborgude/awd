package buisness.core.Submission.gproSubmission.milestonethree;

import buisness.core.Submission.AdvancedStatusSort;
import buisness.util.datastructures.Submission.AdvancedStatusGrid;
import configuration.Setup;

/**Verifies Sorting for Advanced Status Grid(GPROSubmission)<p>
 * @author Sachin.Gawade<p>
 * Created Date: 29 Feb 2016
 * 
 */
public class GproAdvancedStatusSort extends AdvancedStatusSort{
	
	/**
	 * This method is used to compare UI and Database grid for Advanced status grid<p>
	 * This method when invoked calls getDatabaseGrid() and getWebGrid()<p>
	 * This method also replaces '@pagenumber' text from the query with actual current page<p>
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * @param data measure number<p>
	 * @return true or false based on the comparison
	 */
	public boolean verify(String elementmethod,String locator, String data)
	{
		AdvancedStatusGrid uiGrid =getWebGrid(elementmethod,locator);
		AdvancedStatusGrid dbGrid =getDatabaseGrid("GPROAdvancedStatusSortByEligible",data);
		
		if(uiGrid!=null ) 
		{
			
			if(dbGrid!=null ) 
				{
					if(uiGrid.compareTo(dbGrid) == 0)
						{
							Setup.log.trace("Data on UI and Database matches.");
							Setup.testcase.assertTrue(true);
							return true;
						}
						else 
						{
							Setup.log.trace("Data on UI and Database does not match.");
							Setup.testcase.fail();
							return false;
						}
				 }

			else 
				{
						 Setup.log.error("Result in Database is null");
				}
		}
		else 
		{
						Setup.log.error("UI grid is null");
		}
				Setup.testcase.fail();
				return false;
	}	
	

}