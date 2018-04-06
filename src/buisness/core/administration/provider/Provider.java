package buisness.core.administration.provider;

import java.sql.ResultSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import buisness.core.DashboardUI;
import buisness.core.ElementMethod;
import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.administration.provider.DashboardLocationProviderGrid;
import configuration.Setup;

/**
 * Provider class<p>
 * Extends DashboardUI
 * Provides getDBProviderList, getUIProviderlist methods
 * @author Sachin.Gawade
 * 12 Jan 2016
 */

public class Provider  extends DashboardUI {
	public String firstname ;
	public String middlename;
	public String lastname;
	public String emailaddress;
	public String npi;
	public String inactive;
	public ConfigurationManager config;
	public ElementMethod em;
	public String locator; 
	
	
	//ProviderTable constructor
	public Provider() 
	{
		em  = new ElementMethod();
	
	}
	
	/**
	 * getDBProviderList method<p>
	 * Returns PopupProviderGrid object containing all providers and their details available<p>
	 * for logged in user in the database.
	 * @author Sachin.Gawade
	 * 12 Jan 2016
	 */
	public DashboardLocationProviderGrid  getDBProviderList(String query) 
	{
	 DatabaseManger.SQLserverConnection();
    ResultSet rs = DatabaseManger.exeQuery(query);
    DashboardLocationProviderGrid dbgrid = new DashboardLocationProviderGrid();
    Setup.log.trace(query);
    Setup.log.info(rs);
		try {
			while(rs.next())
        	{
				try {
					firstname = rs.getString("firstname");
					Setup.log.info(firstname);
					middlename= rs.getString("middlename");
					Setup.log.info(middlename);
					lastname= rs.getString("lastname");
					Setup.log.info(lastname);
					emailaddress= rs.getString("emailaddress");
					Setup.log.info(emailaddress);
					npi= rs.getString("npi");
					Setup.log.info(npi);
					inactive= rs.getString("inactive");
					Setup.log.info(inactive);
				}
				catch (Exception e) {
					Setup.log.error("Please verify the coulumn names in queries");
				}
				dbgrid.ProviderGridCountRow(firstname,middlename,lastname,emailaddress,npi,inactive);
				
	    	}
				} catch (Exception e) {
					Setup.log.error("No providers found for the logged in user in the database");
				}
	
		return dbgrid;
    }
	/**
	 * getUIProviderlist method<p>
	 * Returns DashboardLocationProviderGrid object containing all providers and their details available<p>
	 * for logged in user in the UI.
	 * @param locator (of the table in the UI)
	 * @author Sachin.Gawade
	 * 12 Jan 2016
	 */
	public DashboardLocationProviderGrid getUIProviderlist(String locator)
	{
		DashboardLocationProviderGrid uigrid = new DashboardLocationProviderGrid();
		List<WebElement> rows = em.getWebElements("xpath", locator);
	
		
		for(WebElement we : rows)
		{
			try
			{
			firstname= we.findElement(By.xpath("./td[2]")).getText();
				Setup.log.info(firstname);
			middlename= we.findElement(By.xpath("./td[3]")).getText();
				Setup.log.info(middlename);
			lastname= we.findElement(By.xpath("./td[4]")).getText();
				Setup.log.info(lastname);
			emailaddress= we.findElement(By.xpath("./td[5]")).getText();
				Setup.log.info(emailaddress);
			npi= we.findElement(By.xpath("./td[6]")).getText();
				Setup.log.info(npi);
			inactive= we.findElement(By.xpath("./td[8]")).getText();
				Setup.log.info(inactive);
			}
			catch (Exception e)
				{
					Setup.log.error("Error while fetching data from the UI.");
					Setup.testcase.assertTrue(false);
				}
			uigrid.ProviderGridCountRow(firstname,middlename,lastname,emailaddress,npi,inactive);
					}
		return uigrid;
		
	}
	
	
}
