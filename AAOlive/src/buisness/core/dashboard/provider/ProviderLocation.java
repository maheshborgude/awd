package buisness.core.dashboard.provider;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import buisness.core.DashboardUI;
import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.dashboard.provider.ProviderViewGrid;
import configuration.Setup;
/**
 * This class is required to get Dashboard>>Provider\Location grid from UI and Database.<p>
 * @author Sachin.Gawade
 * Created date 5 FEB 2016
 */
abstract class ProviderLocation extends DashboardUI   {

	ConfigurationManager config;

	public ProviderLocation() 
	{
		config = new ConfigurationManager();

	}	 
	/**
	 * Returns DashboardLocationProviderGrid object containing all locations\providers and their details available<p>
	 * for logged in user in the database<p>
	 *  @return dbgrid which contains all database rows 
	 * @author nilesh.patil
	 *Created date 5 FEB 2016
	 *@author probeer.roy Updated Date: 18 Dec 2017
	 */

	public ProviderViewGrid getDatabaseGrid(String query) 
	{
		DatabaseManger.SQLserverConnection();
		ResultSet rs = DatabaseManger.exeQuery(query);
		ProviderViewGrid dbgrid=new ProviderViewGrid();
		Setup.log.trace(query);
		Setup.log.trace(rs);
		try {
			while(rs.next())
			{
				try {
					String providername = rs.getString("name");
					Setup.log.info(providername);
					String exceeding= rs.getString("exceeding");
					Setup.log.info(exceeding);
					String withinrange= rs.getString("withinrange");
					Setup.log.info(withinrange);
					String below= rs.getString("below");
					Setup.log.info(below);
					Setup.log.info(providername+exceeding+withinrange+below);
					dbgrid.addProvider(providername, exceeding,withinrange, below);

				} catch (NullPointerException e) 
				{
					Setup.log.error("Required Column is not present in the result of the query.");
					Setup.testcase.fail();
				}	
				catch(SQLException e)
				{
					Setup.log.error("SQL Exception. Please check query and column names in query repository");
					Setup.testcase.fail();
				}
				catch (Exception e) 
				{
					Setup.log.error("Exception faced while fetching data from Database.");
					Setup.testcase.fail();
				}

			}
		} catch (NullPointerException e) 
		{
			Setup.log.error("Result set for query is Null.");
			Setup.testcase.fail();
		}	
		catch(SQLException e)
		{
			Setup.log.error("SQL Exception. Please check query in query repository");
			Setup.testcase.fail();
		}
		catch (Exception e) 
		{
			Setup.log.error("Exception faced while fetching data for Result Set from Database.");
			Setup.testcase.fail();
		}


		return dbgrid;
	}
	/**
	 * getUILocationlist(String locator)<p>
	 * Returns DashboardLocationProviderGrid object containing all locations\providers and their details available<p>
	 * for logged in user in the database<p>
	 * @param locator<p>
	 * @return uigrid which contains all the UI Data 
	 * 
	 * @author nilesh.patil
	 *Created date 5 Jan 2016
	 */
	public ProviderViewGrid getWebGrid(String elementMethod ,String locator)
	{

		ProviderViewGrid uigrid = new buisness.util.datastructures.dashboard.provider.ProviderViewGrid();
		
		try {
			List<WebElement> rows = getWebElements(elementMethod, locator);
			Setup.log.info(locator);
			for(WebElement we : rows)
			{
				String providername = we.findElement(By.xpath("./div/h4/div/table/tbody/tr/td[1]/a")).getText();
				Setup.log.info(providername);
				String exceeding = we.findElement(By.xpath("./div/h4/div/table/tbody/tr/td[2]/a")).getText();
				Setup.log.info(exceeding);
				String withinrange = we.findElement(By.xpath("./div/h4/div/table/tbody/tr/td[3]/a")).getText();
				Setup.log.info(withinrange);
				String below = we.findElement(By.xpath("./div/h4/div/table/tbody/tr/td[4]/a")).getText();
				Setup.log.info(below);
				Setup.log.info(providername+exceeding+withinrange+below);
				uigrid.addProvider(providername, exceeding,withinrange, below);
			}
		} 
		catch(NoSuchElementException e)
		{
			Setup.log.info(e);
			Setup.log.error("Element not found on the UI. Please check xpath of column in webtable. ");
		}
		
		catch(Exception e)
		{
			Setup.log.info(e);
			Setup.log.error("Exception faced while fetching data from UI. ");
			e.printStackTrace();
		}

		return uigrid;

	}





}
