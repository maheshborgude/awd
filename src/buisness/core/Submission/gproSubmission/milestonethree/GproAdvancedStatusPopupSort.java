package buisness.core.Submission.gproSubmission.milestonethree;

import buisness.core.Submission.AdvancedStatusPopupSort;
import buisness.util.datastructures.Submission.AdvancedStatusPopupGrid;
import configuration.Setup;

/**Verifies Sorting for Pqrs Advanced Status Popup Grid(GPROSubmission)<p>
 * @author Sachin.Gawade<p>
 * Created Date: 29 Feb 2016
 * 
 */
public class GproAdvancedStatusPopupSort extends AdvancedStatusPopupSort{
	/**	
	 * Method to compare object UI and Database grid of Advanced status popup grid.<P>
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * @param data1 Parameter used to replace @measure in query with required measure
	 * @param data2 Parameter used to sort query in asc or desc order
	 * @return result of Test case true or false based on the result
	 */

	public boolean verify(String elementmethod,String locator, String data1, String data2)
	{
		AdvancedStatusPopupGrid uiGrid =getWebGrid(elementmethod,locator);
		AdvancedStatusPopupGrid dbGrid =getDatabaseGrid("GPROAdvancedStatusPopupEligibleSortByMrn",data1,data2);
		
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