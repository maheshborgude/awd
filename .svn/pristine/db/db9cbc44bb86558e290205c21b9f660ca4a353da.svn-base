package buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree;

import java.sql.ResultSet;

import buisness.core.DashboardUI;
import buisness.core.ElementMethod;
import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import configuration.Setup;
/**
 * This test case validate total count total Reported Patient Visits >> Submission 2015 
 *      >> Report PQRS Measures Milestone >> Count total Reported Patient Visits For Qualified Clinical Data Registry Reporting
 * This test case validate data present in Grid with data present in Database of eligible patient 
 * This test case compare total view of data present on UI of application 
 * Test case is pass if return result is pass else it will fail 
 * @author rakesh.kulkarni
 * Date 02/03/2016
 */
public class ReportedPatientVisitsQCDRRCount extends DashboardUI{

/**
 * This method is used to get count of Cataracts Measures Group Reporting
 * This method get count from Database
 * @return
 */
	public int getDatabaseCount()
	{

		DatabaseManger.SQLserverConnection(); 
		ConfigurationManager cofig=new ConfigurationManager();
		String query = cofig.getQuery("ReportedPatientVisitsQCDRRCount");	
		ResultSet resultSet =null;
		int dbresult = 0;
		try {
			Setup.log.trace(query);
			resultSet = DatabaseManger.exeQuery(query);
			if (resultSet.next()) {
				dbresult=resultSet.getInt(1);
			}
			else
			{
				Setup.log.error("Please check query in 'Queries.properties.ValidateTotalPracticeCount'or verify the logged in UserName");
				Setup.testcase.fail();
			}
		}
		catch(Exception e)
		{
			Setup.log.error(e);
			Setup.testcase.fail();

		}
		return dbresult;
	}

	/**
	 * This Method is used to get label from UI For Qualified Clinical Data Registry Reporting
	 * @param locator
	 * @param elementmethod
	 * @return count from web
	 */	
	public int getWebCount(String elementmethod,String locator)
	{
		ElementMethod em = new ElementMethod();
		String CountLabel = em.gettext(elementmethod, locator);	
		return trimInvalidDataFromUICount(CountLabel);
	}

	public boolean verify(String elementmethod,String locator) 

	{
		int databaseCount = getDatabaseCount();
		int webCount = getWebCount(elementmethod, locator);

		if(databaseCount==webCount)
		{
			Setup.log.error("Count on UI match with DB");
			Setup.testcase.assertTrue(true);
			return true;	

		}
		else
		{
			Setup.log.error("Count on UI not match with DB");
			Setup.testcase.fail();
			return false;			
		}
	}

}
