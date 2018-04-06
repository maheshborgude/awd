package buisness.core.Submission.gproSubmission.milestonethree;

import buisness.core.Submission.ReportedPatientVisitsView;
import buisness.util.datastructures.Submission.ReportedPatientVisitsGrid;
import configuration.Setup;

/**Verifies Report Patient Visit Grid(GPROSubmission)<p>
 * @author Sachin.Gawade<p>
 * Created Date: 29 Feb 2016
 * 
 */

public class GproReportedPatientVisitsView extends ReportedPatientVisitsView{
	
	/**
	 * This method is used to verify Reported Patient Visits grid from UI and Database
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * @return true or false based on the comparison
	 */
	public boolean verify (String elementmethod,String locator)
	{
		ReportedPatientVisitsGrid  dbGrid =getDatabaseGrid("GPROReportedPatientVisitGrid");
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
