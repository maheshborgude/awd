package buisness.core.administration.usermanagement;


import org.junit.internal.runners.statements.Fail;
import org.openqa.selenium.WebElement;

import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.administration.usermanagement.UsermanagementGrid;
import buisness.util.helpers.Pagination;
import configuration.Setup;

public class UserManagementGridPagination extends UserManagement{

	ConfigurationManager config;
	
	public UserManagementGridPagination() 
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

	public boolean compareTO(UsermanagementGrid uigrid,UsermanagementGrid dbgrid)
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
	 * verify()<p>
	 * Returns AdministrationLocationGrid object containing all locations and their details available<p>
	 * for logged in user in the database<p>
	 * this method also returns the dbgid and uigrid for pagination ON browseLastPage,browsePreviousPage,browseNextPage,browseFirstPage<p>
	 * get the query from Object.propertis file and pass it to Super class Which is name as  Basic<p>
	 *  @return dbgrid which contains all database rows 
	 * @author nilesh.patil
	 *Created date 1 FEB 2016
	 */

	public boolean verify(String locator,String elementmethod)
	{
		DatabaseManger.SQLserverConnection();
		String query = config.getQuery("UsermangementPagination");
		WebElement tablerow = getWebElement(elementmethod, locator);

		try
		{
			Pagination pg=new Pagination(tablerow);
			pg.browseLastPage();
			int i=pg.getCurrentPage();
			String str = Integer.toString(i);
			query=query.replace("@PageNumber",str);
			UsermanagementGrid dbgrid = super.getDatabaseGrid(query);
			UsermanagementGrid uigrid = super.getWebGrid( locator, elementmethod);


			pg.browsePreviousPage();
			i=pg.getCurrentPage();
			str = Integer.toString(i);
			query = config.getQuery("UsermangementPagination");
			query=query.replace("@PageNumber",str);

			dbgrid = super.getDatabaseGrid(query);
			uigrid =  super.getWebGrid( locator, elementmethod);



			pg.browseNextPage();
			i=pg.getCurrentPage();
			str = Integer.toString(i);
			query = config.getQuery("UsermangementPagination");
			query=query.replace("@PageNumber",str);

			dbgrid = super.getDatabaseGrid(query);
			uigrid =  super.getWebGrid( locator, elementmethod);


			pg.browseFirstPage();
			i=pg.getCurrentPage();
			str = Integer.toString(i);
			query = config.getQuery("UsermangementPagination");
			query=query.replace("@PageNumber",str);

			dbgrid = super.getDatabaseGrid(query);
			uigrid =  super.getWebGrid( locator, elementmethod);

			return compareTO(uigrid,dbgrid);
		}
		catch (Exception e)
		{
			Setup.log.error("Error occur in pagination or pagination is not present on grid");
			return false;
		}

	}


}
