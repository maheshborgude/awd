package buisness.core.Submission.gproSubmission.milestonethree;

import buisness.core.Submission.ReportedPatientVisitsSearch;
import buisness.util.datastructures.Submission.ReportedPatientVisitsGrid;
import configuration.Setup;

/**Verifies Search Functionality of Reported Patient Visits Grid(GPROSubmission)<p>
 * @author Sachin.Gawade<p>
 * Created Date: 29 Feb 2016
 * 
 */

public class GproReportedPatientVisitsSearch extends ReportedPatientVisitsSearch{
	
	/**
	 * This method is used to verify Search functionality for Reported Patient Visits Grid<
	 * This method when invoked calls getDbGrid() and getWebGrid()<p>
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * @param data string to be searched<p>
	 * @return true or false based on the comparison
	 */
	public boolean verify(String elementmethod,String locator,String data)
	{
		ReportedPatientVisitsGrid  dbGrid =getDatabaseGrid("GPRORPVSearchByMrn",data);
		ReportedPatientVisitsGrid uiGrid =getWebGrid(elementmethod,locator);

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
