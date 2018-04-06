package buisness.core.dashboard.Practice.practiceProvider.rolling;

import configuration.Setup;

public class PPPatientDrillDownCountR extends PatientDrillDownCountBasicR 
{
	/**
	 * Method to compare object of sorted data present on
	 *        Practice >Provider Tab>> Patient DrillDown Count present on Dashboard > Practice > Select measure >> Provider Tab For nonRolling<p>
	 *  present on UI with Database
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * @param data quarter or month<p>
	 * @return result true or false
	 */
	public boolean verifyPatientCount(String elementmethod,String locator,String data)  
	{
		System.out.println("Inside Core VerifyPatientCount");
		String databasePatientCount;
		String webPatientCount;
		
		databasePatientCount=getdatabasecount(getQuery("PracticeProviderPatientDrillDownCountR",data));
		System.out.println("database count is taken");
		
		webPatientCount=getuicount(elementmethod,locator);
		System.out.println("UI count is taken");
	
		
		Setup.log.info("Ui_Count:"+webPatientCount);
		Setup.log.info("Db_Count:"+databasePatientCount);
		
		
		if(webPatientCount.equals(webPatientCount))
		{   
			Setup.log.info("\nPatient Count from Database and UI is getting matched");
			//Setup.log.trace("\nPatient Count from Database and UI is getting matched");
			Setup.testcase.assertTrue(true);
			return true;
		}
		else
		{   
			Setup.log.info("\nPatient Count from Database and UI is not getting matched");
			//Setup.log.trace("\nPatient Count from Database and UI is not getting matched");
			Setup.testcase.fail();
			return false;
		}
		
	}
}
