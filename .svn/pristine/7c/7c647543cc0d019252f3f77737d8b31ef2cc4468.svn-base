package buisness.core.Submission.pqrsSubmission.submission2015.milestoneTwo;

import java.sql.ResultSet;

import buisness.core.DashboardUI;
import buisness.core.ElementMethod;
import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import configuration.Setup;
/**
 * This class is used to validate the count of Individual Measures Reporting 
 * present on to the Manage Provider Profile milestone 
 * This class also reads Qery keywords present in Queries.properties
 * This clas return True if test cass is pass else Fail 
 * @author rakesh.kulkarni
 * Date 18-02-2016
 */
public class CountIndividualMeasuresReporting extends DashboardUI{

/**
 * This method is used to get count of Individual Measures Reporting 
 * This method get count from Database
 * @return Database sesult
 */
	public int getDatabaseCount()
	{

		DatabaseManger.SQLserverConnection(); 
		ConfigurationManager cofig=new ConfigurationManager();
		String query = cofig.getQuery("CountIndividualMeasuresReporting");	
		ResultSet resultSet =null; // Set initially NULL
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
			Setup.log.error("Exception occur in query");
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
