package buisness.core.dashboard.Practice.practiceProvider.rolling;

import java.sql.SQLException;

import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.dashboard.practice.practiceProvider.PracticeProviderPT_TableGrid;
import configuration.Setup;

public class PracticeProviderPT_TableViewR extends PracticeProviderPopUpTabBasicR
{

    String query;
	ConfigurationManager config;

	public  PracticeProviderPT_TableViewR() 
	{
		config = new ConfigurationManager();

	}

	/**
	 * getDBLocationListit()<p>
	 * Returns AdministrationLocationGrid object containing all locations and their details available<p>
	 * for logged in user in the database<p>
	 * get the query from Object.propertis file and pass it to Super class Which is name as  Basic<p>
	 *  @return dbgrid which contains all database rows 
	 * @author nilesh.patil
	 *Created date 21 Jan 2016
	 */

	/*public PracticeProviderPT_TableView getDBLocationListit() 
	{
		String query = config.getQuery("PPTTableView");
		DatabaseManger.exeQuery(query);
		//String key=getLoggedInUser();
		String query1=query.replace("@loginuser",key);
		String query2=query1.replace("@data",data);
	    System.err.println(query);
		return super.getDBPPTTable(query);
	}*/
	
	/**
	 * verifyEnlistedLocations(String locator)
	 *This method is used to compare Uilocationgrid data  with Databaselocationgrid data <p>
	 * Returns boolean true if grid from UI and Database match<p>
	 * Returns boolean false if grid from UI and Database do not match<p>
	 *@author nilesh.patil
	 *Created date 21 Jan 2016
	 */

	public boolean verifyPracticeProviderTable(String elementmethod,String locator,String data) throws SQLException
	{  
		Setup.log.info("Inside verifyPracticeProviderTable() method");
		//String query= config.getQuery("PPTTableView");
		//Setup.log.info("Query:"+query);
		PracticeProviderPT_TableGrid dbgrid =getDBPracticeProviderPTTable(getQuery("PracticeProviderPT_Table",data));
		Setup.log.info("Db Grid taken");
		Setup.log.info("UI Locator:"+locator);
		PracticeProviderPT_TableGrid uigrid =getUIPracticeProviderPTTable(locator);
		Setup.log.info("UI Grid taken");
		
		if(uigrid.compareTo(dbgrid)== 0) 
		{
			Setup.log.info("Practice>>Provider Tab Performance Trend Table from Ui and Database is matched");
			Setup.testcase.assertTrue(true);
			return true;			
		}
		else
		{
			Setup.log.info("Practice>>Provider Tab Performance Trend Table from Ui and Database is not matched");
			Setup.testcase.fail();
			return false;
		}
	}	
}
