package buisness.core.dashboard.Practice.practiceProvider.rolling;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.NoSuchElementException;

import buisness.core.DashboardUI;
import buisness.core.ElementMethod;
import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import configuration.Setup;

/**
 * PatientDrillDownCount class provides functions needed to compare Patient record count from UI and DB<p>
 * @author Ashwini.Gore
 * Date: 12 dec 2017
 */

public class PatientDrillDownCountBasicR extends DashboardUI{
	public String resultofCount;
	ResultSet resultSet=null;
	public String query;
	public ConfigurationManager config;
	/*Returns query as string  */
	public String getQuery(String queryName,String data) 
	{
		config = new ConfigurationManager();
		String query = config.getQuery(queryName);
		query = query.replace("@loginuser", getLoggedInUser());
		//query = query.replace("@flag", getFlag());
		query=query.replace("@QuarterOrMonth",data);
		return query;
	}
	
	
	/** Gets Provider\Location grid count from database<p>
	 * @param query Query to run in database<p>
	 */

	public String getdatabasecount(String query)
	{
		DatabaseManger.SQLserverConnection(); 
		Setup.log.trace(query);
	
		try {
			resultSet = DatabaseManger.exeQuery(query);
			if (resultSet.next()) {
				   System.out.println("Inside getDBcount Method:"+resultSet.getString("MetCount"));
	                return resultSet.getString("MetCount");
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
			Setup.log.error("Exception faced while fetching data from Database..");
		}
		Setup.testcase.fail();
		return "0";
	}
	

	/** Gets Provider\Location grid count from UI<p>
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator of Provider\Location record count in the UI is passed<p>
	 */
	public String getuicount(String elementmethod,String locator)
	{
		ElementMethod em=new ElementMethod();
		try
		{
			System.out.println("UI Count before Trim:"+em.gettext(elementmethod, locator));
		    return trimuicount(em.gettext(elementmethod, locator));
		}
		catch(NoSuchElementException e)
		{
			Setup.log.error(e);
			Setup.log.error("Element not found on the UI. Please check xpath of column in webtable. ");
		}
		catch (Exception e)
		{
			Setup.testcase.fail();
			Setup.log.error("No Provider Record found in the UI");
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

