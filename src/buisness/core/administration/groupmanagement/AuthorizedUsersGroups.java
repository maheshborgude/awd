package buisness.core.administration.groupmanagement;

import java.sql.ResultSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import buisness.core.ElementMethod;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.administration.groupmanagement.AuthorizedUsersGroupsGrid;
import configuration.Setup;

abstract public class AuthorizedUsersGroups extends ElementMethod {

	private String uname;
	public buisness.core.DashboardUI dashboardui;
	public AuthorizedUsersGroups()
	{	
		dashboardui=new buisness.core.DashboardUI();
		uname =  dashboardui.getLoggedInUser();
	}

	private String trimMultiSpace(String getString)
	{
		String string =getString;
		String[] parts = string.split(" ");
		String s = new String();
		for(int i=0;i<parts.length;i++)
		{   
			parts[i]=parts[i].trim();
			if(!parts[i].equals(""))	
			{
				s=s+" "+parts[i];
			}
		}
		return s;
	}

	/**
	 * This method is used to get data from UI
	 * @param locator
	 * @param elementmethod 
	 * @return Object of specified class
	 */
	public AuthorizedUsersGroupsGrid getWebGrid(String elementmethod, String locator)
	{
		if(locator!=null)
		{
			AuthorizedUsersGroupsGrid authorizedUsersGroupsGrid=new AuthorizedUsersGroupsGrid();
			try
			{
				List<WebElement> rows = getWebElements("Xpath", locator);			
				Setup.log.trace(locator);
				for(WebElement table : rows)
				{
					
					String name = table.findElement(By.xpath("./td[1]")).getText();
					String firstName = table.findElement(By.xpath("./td[2]")).getText();
					String lastName = table.findElement(By.xpath("./td[3]")).getText();	
					String practiceID = table.findElement(By.xpath("./td[5]")).getText();
					String PracticeName = table.findElement(By.xpath("./td[6]")).getText();
					String group = table.findElement(By.xpath("./td[7]")).getText();	
					String inactive = table.findElement(By.xpath("./td[8]")).getText();
					authorizedUsersGroupsGrid.add(name, firstName, lastName, practiceID, PracticeName, group, inactive);
				}
			}
			catch(Exception e)
			{
				Setup.log.error("Please check xpath in ObjectRepositary.Properties file Exception occur while fatching data from UI");
			}
			return authorizedUsersGroupsGrid;	
		}
		else
		{
			Setup.log.error("locater value is null please check Objectrepository");
			return null;
		}
		
	}

	/**
	 * This method is used to get data from Database and return a object with Grid value<p>
	 * For logged in user in the database<p>
	 * @param locator
	 * @return Object of specified class
	 */
	public AuthorizedUsersGroupsGrid getDatabaseGrid(String query)
	{
		DatabaseManger.SQLserverConnection(); 
		query=query.replace( "@loginuser",uname);	
		ResultSet resultSet= DatabaseManger.exeQuery(query);
		AuthorizedUsersGroupsGrid authorizedUsersGroupsGridDB=new AuthorizedUsersGroupsGrid();
		Setup.log.debug(query);
		if(resultSet != null)
		{
			
			try {
				while(resultSet.next())
				{
					String name = resultSet.getString("LoginName");	
					String nameT=trimMultiSpace(name).trim();		
					String firstName = resultSet.getString("First");	
					String firstNameT=trimMultiSpace(firstName).trim();	
					String lastName = resultSet.getString("last");	
					String lastNameT=trimMultiSpace(lastName).trim();	
					String practiceID = resultSet.getString("practice ID");
					String practiceIDT=trimMultiSpace(practiceID).trim();	
					String PracticeName = resultSet.getString("practice Name");
					String PracticeNameT=trimMultiSpace(PracticeName).trim();	
					String group = resultSet.getString("isgroup");	
					String groupT=trimMultiSpace(group).trim();
					String inactive = resultSet.getString("inactive");	
					String inactiveT=trimMultiSpace(inactive).trim();	
					authorizedUsersGroupsGridDB.add(nameT, firstNameT, lastNameT, practiceIDT, PracticeNameT, groupT, inactiveT);
				}

			}
			catch(Exception e)
			{
				Setup.log.warn("Please check query in 'Queries.properties.ValidateTotalPracticeCount'or verify the logged in UserName");
				Setup.testcase.fail();
			}
			return authorizedUsersGroupsGridDB;
		 }
		
		else
		{
			return null;
		}
	}
}
