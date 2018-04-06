package buisness.core.dashboard.Practice.practicePerformanceTrend;

import java.sql.SQLException;
import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import configuration.Setup;
import buisness.util.datastructures.dashboard.practice.practicePerformanceTrend.*;

/**
 * This class contain Table View for Practice >> Performance View
 * 
 * @author Shrikant.Bhujbal
 * Created date : 1/12/2017
 */

public class PPTTableView extends PPTTable
{

    String query;
	ConfigurationManager config;

	public void PPTTableGrid() 
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

	public PPTTableGrid getDBLocationListit() 
	{
		String query = config.getQuery("PPTTableView");
		DatabaseManger.exeQuery(query);
		//String key=getLoggedInUser();
//		String query1=query.replace("@loginuser",key);
//		String query2=query1.replace("@data",data);
	    System.err.println(query);
		return super.getDBPPTTable(query);
	}
	
	/**
	 * verifyEnlistedLocations(String locator)
	 *This method is used to compare Uilocationgrid data  with Databaselocationgrid data <p>
	 * Returns boolean true if grid from UI and Database match<p>
	 * Returns boolean false if grid from UI and Database do not match<p>
	 *@author nilesh.patil
	 *Created date 21 Jan 2016
	 */

	public boolean verifyPPTTable(String locator,String elementmethod ,String data) throws SQLException
	{  
		Setup.log.info("Inside verifyPPTTable() method");
		//String query= config.getQuery("PPTTableView");
		//Setup.log.info("Query:"+query);
		PPTTableGrid dbgrid =getDBPPTTable(getQuery("PPTTableView"));
		Setup.log.info("Db Grid taken");
		PPTTableGrid uigrid =getUIPPTTable(locator);
		Setup.log.info("UI Grid taken");
		
		if(uigrid.compareTo(dbgrid)== 0) 
		{
			Setup.log.trace("Locations from Ui and Database is matched");
			Setup.testcase.assertTrue(true);
			return true;			
		}
		else
		{
			Setup.log.trace("Locations from Ui and Database is not  matched");
			Setup.testcase.fail();
			return false;
		}
	}	
}
