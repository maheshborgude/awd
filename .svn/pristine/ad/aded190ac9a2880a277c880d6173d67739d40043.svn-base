package buisness.core.Submission.pqrsSubmission.submission2015.milestoneFour;

import java.sql.ResultSet;

import buisness.core.DashboardUI;
import buisness.core.ElementMethod;
import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import configuration.Setup;
/**
 * This class is used to validate the count of total Reported Patient Visits CMGR Count
 * present on to the Manage Provider Profile milestone 
 * This class returns pass or fail depend on UI and DB count
 * present on to the Manage Provider Profile milestone 
 * @author rakesh.kulkarni
 * Date 09/03/2016
 */
public class ProviderSubmissionCount extends DashboardUI{
	
	public ProviderSubmissionCount()
	{
		
	}
/**
 * This method is used to get count of Cataracts Measures Group Reporting CMGR Count
 * This method get count from Database CMGR Count
 * The count is depend on Query preseny in Queries.properties file a 
 * @return
 */
	public int getDatabaseCount()
	{

		DatabaseManger.SQLserverConnection(); 
		ConfigurationManager cofig=new ConfigurationManager();
		String query = cofig.getQuery("ProviderSubmissionCount");	
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
			Setup.log.error("Please check query in 'Queries.properties.ValidateTotalPracticeCount'or verify the logged in UserName");
			Setup.log.error(e);
			Setup.testcase.fail();

		}
		return dbresult;
	}

	/**
	 * This Method is used to get label from UI
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
			Setup.log.trace("Count on UI match with DB");
			Setup.testcase.assertTrue(true);
			return true;	

		}
		else
		{
			Setup.log.trace("Count on UI not match with DB");
			Setup.testcase.fail();
			return false;			
		}
	}

}
