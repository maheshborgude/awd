package buisness.core.dashboard.location;

import java.sql.SQLException;

import org.junit.internal.runners.statements.Fail;
import org.openqa.selenium.WebElement;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.dashboard.location.LocationGrid;
import buisness.util.helpers.Pagination;
import configuration.Setup;
import org.openqa.selenium.support.ui.SystemClock;


public class LocationGridPagination extends Location{

	ConfigurationManager config;
	 boolean i;
	public LocationGridPagination() 
	{
		config = new ConfigurationManager();

	}
	
	/**
	 * verifyEnlistedLocations(String locator)
	 *This method is used to compare Uilocationgrid data  with Databaselocationgrid data <p>
	 * Returns boolean true if grid from UI and Database match<p>
	 * Returns boolean false if grid from UI and Database do not match<p>
	 *@author nilesh.patil
	 *Created date 10 FEB 2016
	 */
	
	
	public boolean compareTO(LocationGrid uigrid,LocationGrid dbgrid)
	{
	
		
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
	
	
	/**
	 * verifyEnlistedLocations()<p>
	 * Returns AdministrationLocationGrid object containing all locations and their details available<p>
	 * for logged in user in the database<p>
	 * this method also returns the dbgid and uigrid for pagination ON browseLastPage,browsePreviousPage,browseNextPage,browseFirstPage<p>
	 * get the query from Object.propertis file and pass it to Super class Which is name as  Basic<p>
	 *  @return dbgrid which contains all database rows 
	 * @author nilesh.patil
	 *Created date 10 FEB 2016
	 */

	public boolean verify(String locator,String elementmethod) throws SQLException
	{
		String query1 = config.getQuery("DashboardLocationpagination");
		String paginationxpth= config.read_ObjectRepositoryfile("DashboardLocationspagination");
		WebElement tablerow = getWebElement(locator,elementmethod);

		try
		{
			Pagination pg=new Pagination(tablerow,paginationxpth);
			pg.browseLastPage();
			int i=pg.getCurrentPage();
			String str = Integer.toString(i);
			String query2=query1.replace("@PageNumber",str);
			LocationGrid dbgrid = super.getDatabaseGrid(query2);
			LocationGrid uigrid = super.getWebGrid( locator, elementmethod);



			pg.browsePreviousPage();
			i=pg.getCurrentPage();
			str = Integer.toString(i);
			query1 = config.getQuery("DashboardLocationpagination");
			query2=query1.replace("@PageNumber",str);
			dbgrid = super.getDatabaseGrid(query2);
			uigrid =  super.getWebGrid( locator, elementmethod);



			pg.browseNextPage();
			i=pg.getCurrentPage();
			str = Integer.toString(i);
			query1 = config.getQuery("DashboardLocationpagination");
			query2=query1.replace("@PageNumber",str);
			dbgrid = super.getDatabaseGrid(query2);
			uigrid =  super.getWebGrid( locator, elementmethod);


			pg.browseFirstPage();
			i=pg.getCurrentPage();
			str = Integer.toString(i);
			query1 = config.getQuery("DashboardLocationpagination");
			query2=query1.replace("@PageNumber",str);
			dbgrid = super.getDatabaseGrid(query2);
			uigrid =  super.getWebGrid( locator, elementmethod);

			return compareTO(uigrid,dbgrid);
		}
		catch (Exception ex)
		{
			Setup.log.error("Error in pagination grid");
			return false;
		}

	
	}

	

	
}
