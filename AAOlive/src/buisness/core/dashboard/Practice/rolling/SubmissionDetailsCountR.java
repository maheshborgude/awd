package buisness.core.dashboard.Practice.rolling;

import buisness.core.DashboardUI;
import buisness.core.ElementMethod;
import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import configuration.Setup;

import java.sql.ResultSet;

/**
 * Verifies Submission Details Count present on Dashboard > Practice For NOnRolling<p>
 * Extends ProviderLocationCount<p>
 * This class Query Keyword to Extended PracticeFavoritesMeasureCountNR class
 * Returns boolean true if grid from UI and Database match<p>
 * Returns boolean false if grid from UI and Database do not match<p>
 * Return  data to validate count.
 * For logged in user in the database<p>
 * @author rakesh.kulkarni
 * Date : 16/03/2016
 */
public class SubmissionDetailsCountR extends DashboardUI{

	public SubmissionDetailsCountR()
	{
		
	}
/**
 * Passes locator : To Find the element
 * Passes Parameters elementmethod and locator to verify() Favorites Measure Count
 * This method verify Count
 * Method to compare object of DatabaseGrid and WebGrid. It check value present on UI with Database
 * @Param data : quarter or month
 * @return result of Test case "Pass" or "Fail"
 */
	public int getDatabaseCount()
	{

		DatabaseManger.SQLserverConnection(); 
		ConfigurationManager cofig=new ConfigurationManager();
		String query = cofig.getQuery("MapCount");	
		ResultSet resultSet =null;
		int dbresult = 0;
		try {
			Setup.log.info(query);
			resultSet = DatabaseManger.exeQuery(query);
			if (resultSet.next()) {
				dbresult=resultSet.getInt(1);
			}
			else
			{
				Setup.log.error("Please check query in 'Queries.properties.MapCount'or verify the logged in UserName");
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
			Setup.log.info("Count on UI match with DB");
			Setup.testcase.assertTrue(true);
			return true;	

		}
		else
		{
			Setup.log.info("Count on UI not match with DB");
			Setup.testcase.fail();
			return false;			
		}
	}

}
