package buisness.core.mipss;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.NoSuchElementException;

import buisness.core.DashboardUI;
import buisness.core.ElementMethod;
import buisness.managers.DatabaseManger;
import configuration.Setup;

/**
 * ProviderLocationCount class provides functions needed to compare Location\Provider record count from UI and DB<p>
 * Extends DashboardUI
 * @author Sachin.Gawade
 * Date: 2 Mar 2016
 */

public class MipsProviderCountMaster extends DashboardUI{
	public String resultofCount;
	ResultSet resultSet=null;
	public String query;
    
	
	/** Gets Provider\Location grid count from database<p>
	 *@param query: Name of query in query repository<p>
	 */

	public String getdatabasecount(String query)
	{
	
		DatabaseManger.SQLserverConnection();
		try {
			resultSet = DatabaseManger.exeQuery(query);
			if (resultSet.next()) 
			{
	                return resultSet.getString("SearchCount");
			}
			else
			{
				Setup.log.error("no record is found in the Database.");
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
		return trimuicount(em.gettext(elementmethod, locator));
		}
		catch(NoSuchElementException e)
		{
			Setup.log.error(e);
			Setup.log.error("Element not found on the UI. Please check locator of the object passed. ");
		}
		
		catch(Exception e)
		{
			Setup.log.error(e);
			Setup.log.error("Exception faced while fetching data from UI. ");
		}
		Setup.testcase.fail();
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

