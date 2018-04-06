package buisness.core.Submission.gproSubmission.milestonethree;

import buisness.core.Submission.ReportedPatientVisitsCount;
import configuration.Setup;

/**Verifies Reported Patient Visits Count(GPROSubmission)<p>
 * Extends ReportedPatientVisitsCount<p>
 * @author Sachin.Gawade<p>
 * Created Date: 29 Feb 2016
 * 
 */
public class GproReportedPatientVisitsCount extends ReportedPatientVisitsCount{

	/** Compares Patient visit Count for logged in user from UI and Database
	 * calls getdbcount(),getuicount()<p>
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * Returns result true or boolean
	 */
	public boolean verify(String elementmethod,String locator)  
	{
		String dbCount;
		String uiCount;
		
		dbCount=getdatabasecount("ReportedPatientVisitsCount");
		uiCount=getuicount(elementmethod,locator);
		
		Setup.log.info("Ui_Count"+uiCount);
		Setup.log.info("Db_Count"+dbCount);
		
		
		if(uiCount.equals(dbCount))
		{
			Setup.log.trace("\nCount from Database and UI getting matched");
			Setup.testcase.assertTrue(true);
			return true;
		}
		else
		{
			Setup.log.trace("\nCount from Database and UI is not getting matched");
			Setup.testcase.fail();
			return false;
		}
		
	}
	

}

