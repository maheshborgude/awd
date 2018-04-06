package buisness.core.dashboard.Practice.practiceProvider.rolling;

import java.sql.SQLException;

import buisness.managers.ExcelReportManager;
import org.apache.jasper.tagplugins.jstl.core.Catch;
import org.openqa.selenium.WebElement;

import buisness.core.administration.location.Location;
import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.administration.location.LocationGrid;
import buisness.util.helpers.Pagination;
import configuration.Setup;


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
	 *Created date 1 FEB 2016
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
	 *Created date 1 FEB 2016
	 * @Updater rohan.mane
	 *Updation date 4 DEC 2017
	 */

	public boolean verify(String locator,String elementmethod) throws SQLException
	{
		DatabaseManger.SQLserverConnection();
		String query = config.getQuery("Locationpagination");
		WebElement tablerow = getWebElement(elementmethod, locator);
		boolean Result=true;

		try
		{
			Pagination pg=new Pagination(tablerow);

			
			pg.browseFirstPage();
			while (pg.hasNext())
			{
			int i=pg.getCurrentPage();
			String str = Integer.toString(i);
			query = config.getQuery("Locationpagination");
			query=query.replace("@PageNumber",str);
			 System.err.println("Inside Page number "+ str + "method");
			 System.err.println("the page number is"+" "+ str);
			LocationGrid dbgrid = super.getDatabaseGrid(query);
			LocationGrid uigrid = super.getWebGrid( locator, elementmethod);
			System.err.println(query);
			Result= compareTO(uigrid,dbgrid);
			if(Result==false)
			{	System.err.println("Data not matching on "+str +"page ");
				return Result;			
			}
			pg.browseNextPage();
			}


		}
		catch (Exception exsc)
		{
			Setup.log.error("Error occur in Pagination or pagination is not present on grid");
			return false;
		}
		return Result;
		
	}
	

	
}
