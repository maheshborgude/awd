package buisness.core.administration.usermanagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebElement;

import buisness.core.DashboardUI;
import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.administration.usermanagement.UsermanagementGrid;
import configuration.Setup;

abstract class UserManagement extends DashboardUI {
	
	ConfigurationManager config;
	
	public UserManagement() 
	{
		config = new ConfigurationManager();
	
	}	 
	/**
	 * getDatabasegrid()<p>
	 * Returns AdministrationLocationGrid object containing all locations and their details available<p>
	 * for logged in user in the database<p>
	 *  @return dbgrid which contains all database rows 
	 * @author nilesh.patil
     *Created date 29 Jan 2016
	 */
	
	public UsermanagementGrid getDatabaseGrid(String query) 
	{
//	 DatabaseManger.SQLserverConnection();
//	String query = config.getQuery("LocationEnlisted");
//   query=query.replace("@loginuser",getLoggedInUser());
	
    ResultSet rs = DatabaseManger.exeQuery(query);
    UsermanagementGrid dbgrid = new UsermanagementGrid();
        Setup.log.trace(query);
        Setup.log.trace(rs);
	
		try {
			while(rs.next())
{
				try {
					String firstname = rs.getString("firstname");
					String middlename= rs.getString("middlename");
					String lastname= rs.getString("lastname");
					String practiceid= rs.getString("practiceid");
					String practicename= rs.getString("practicename");
					String loginame= rs.getString("loginame");
					String inactive= rs.getString("inactive");
			        Setup.log.info(firstname+middlename+lastname+practiceid+practicename+loginame+inactive);
				   dbgrid.addPopupuserGridcountRow1(firstname,middlename,lastname,practiceid,practicename,loginame,inactive);
				} catch (SQLException e)
				{
					Setup.log.warn("Please verify the coulumn  input query in   Queries.properties file");
					Setup.log.debug(e.getMessage());
					return null;
				}
       
}
		} catch (SQLException e) 
		{
			Setup.log.debug("Please verify input query in Queries.properties file");
			e.printStackTrace();
		}	

	
		return dbgrid;
}
	/**
	 * getWebGrid(String locator)<p>
	 * Returns AdministrationLocationGrid object containing all locations and their details available<p>
	 * for logged in user in the database<p>
	 * @param locator<p>
	 * @return uigrid which contains all the UI Data 
	 * 
	 * @author nilesh.patil
     *Created date 29 Jan 2016
	 */
	public UsermanagementGrid getWebGrid(String locator,String elementmethod)
	{
		

		UsermanagementGrid uigrid = null;
		List<WebElement> rows = null;
		
		try {
			uigrid = new UsermanagementGrid();
			 rows = getWebElements(elementmethod, locator);
			//Setup.log.debug(locator);
		} catch (InvalidSelectorException e1)
		{
			Setup.log.error("Please verify xpath in Object repository file");
			e1.printStackTrace();
		}

		try {

			for(WebElement we : rows)
			{

				String firstname = we.findElement(By.xpath("./td[1]")).getText();
			    String middlename = we.findElement(By.xpath("./td[2]")).getText();
				String lastname = we.findElement(By.xpath("./td[3]")).getText();
			    String practiceid = we.findElement(By.xpath("./td[4]")).getText();
				String practicename = we.findElement(By.xpath("./td[5]")).getText();
				String loginame = we.findElement(By.xpath("./td[6]")).getText();
				String inactive = we.findElement(By.xpath("./td[7]")).getText();
				Setup.log.info(firstname+middlename+lastname+practiceid+practicename+loginame+inactive);
				uigrid.addPopupuserGridcountRow1(firstname,middlename,lastname,practiceid,practicename,loginame,inactive);
			}
		} catch (Exception e) 
		{
			Setup.log.error("Error while fetching the data from the UI");
			e.printStackTrace();
		}
		
		return uigrid;
		
	}
}
