package buisness.core.Submission.gproSubmission.milestonethree;
import buisness.core.Submission.AdvancedStatusView;
import buisness.util.datastructures.Submission.AdvancedStatusGrid;
import configuration.Setup;

/**Verifies Advanced Status Grid(GPROSubmission)<p>
 * @author Sachin.Gawade<p>
 * Created Date: 29 Feb 2016
 * 
 */
public class GproAdvancedStatusView extends AdvancedStatusView{
	/**
	 * This method is used to compare UI and Database grid for Advanced status grid<p>
	 * This method when invoked calls getDatabaseGrid() and getWebGrid()<p>
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * @return true or false based on the comparison
	 */
	public boolean verify(String elementmethod,String locator)
	{

		AdvancedStatusGrid uiGrid =getWebGrid(elementmethod,locator);
		AdvancedStatusGrid  dbGrid =getDatabaseGrid("GPROAdvancedStatusView");
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
						 Setup.log.info("Result in Database is null");
				}
		}
		else 
		{
						Setup.log.info("UI grid is null");
		}
				Setup.testcase.fail();
				return false;
	}	

}
