package buisness.core.Submission;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.NoSuchElementException;

import buisness.core.DashboardUI;
import buisness.core.ElementMethod;
import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import configuration.Setup;

/**
 * This class is required to verify Reported Patient Visits Count from UI and Database<p>
 * @author Sachin.Gawade
 * Date: 18 Feb 2016
 */

public class ReportedPatientVisitsCount extends DashboardUI
	{
 
	/** Gets Patient visit for logged in user from database<p>
	 * @param querylocator Name of query in query repository<p>
	 * Returns count of Patient visit of logged in user as String<p>
	 * Returns 0 as String if no record is found or error is faced<p>
	 */

	public String getdatabasecount(String querylocator)
	{
	
		ResultSet resultSet=null;
		DatabaseManger.SQLserverConnection(); 
		ConfigurationManager config=new ConfigurationManager();
		String query = config.getQuery(querylocator);
		query=query.replace( "@loginuser",getLoggedInUser());
	
		try {
			resultSet = DatabaseManger.exeQuery(query);
			if (resultSet.next()) {
	                return resultSet.getString("totalcount");
			}
			else
			{
				Setup.log.error("No patient visit found in the Database.");
			}
			
		}

		catch(SQLException e)
		{
			Setup.log.error("SQL Exception. Please check query in query repository");
			Setup.testcase.fail();
		}
		catch(Exception e)
		{
			Setup.log.error("Exception faced while fetching data from Database.");
			Setup.testcase.fail();
		}
		return "0";
	}
	

	/** Gets Patient visit count for logged in user from the UI<p>
	 * Returns Patient visit count of logged in user as String<p>
	 * Returns 0 as String if no record is found or error is faced<p>
	 * calls trimuicount(String rawcount) to clear redundant data<p>
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 */
	public String getuicount(String elementmethod,String locator)
	{
		ElementMethod em=new ElementMethod();
		try
		{
		return trimuicount(em.gettext(elementmethod, locator));
		}
		catch(NoSuchElementException e)
		{
			Setup.log.error(e);
			Setup.log.error("Element not found on the UI. Please check xpath of column in webtable. ");
		}
		
		catch(Exception e)
		{
			Setup.log.error(e);
			Setup.log.error("Exception faced while fetching data from UI. ");
		}
		return "0";
	}
	
	/** Trims unnecessary data for the captured data from the UI
	 * @param rawcount:  Untrimmed total record from the UI
	 * Returns actual count as String
	 */
	public String  trimuicount(String rawcount)
	{
		int index=0;
		char character = ' ';
		for(int i = 0; i < rawcount.length(); i++){
		    if(rawcount.charAt(i) == character){
		    	index=i;
		    }
		}
		return rawcount.substring(index+1,rawcount.length());
		
	}
	
}
