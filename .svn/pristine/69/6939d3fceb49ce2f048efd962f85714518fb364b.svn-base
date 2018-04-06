package buisness.core.administration.groupmanagement;

import java.sql.ResultSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import buisness.core.ElementMethod;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.administration.groupmanagement.GroupManagementGrid;
import configuration.Setup;

abstract public class UserGroup extends ElementMethod{

	private String uname;
	public buisness.core.DashboardUI dashboardui;
	public UserGroup()
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
	public GroupManagementGrid getWebGrid(String elementmethod, String locator )
	{
		if(locator!=null)
		{
			GroupManagementGrid groupmanagemntWebGrid=new GroupManagementGrid();
			try
			{
				List<WebElement> rows = getWebElements(elementmethod, locator);			
				Setup.log.debug(locator);
				for(WebElement table : rows)
				{
					String externalID = table.findElement(By.xpath("./td[1]")).getText();
					String name = table.findElement(By.xpath("./td[2]")).getText();	
					groupmanagemntWebGrid.add(externalID, name);
				}
			}
			catch(Exception e)
			{
				Setup.log.debug(e);
				Setup.log.error("Please check xpath in ObjectRepositary.Properties file ");
			}
			return groupmanagemntWebGrid;	
		}
		else
		{
			Setup.log.error("The Xpath of WebGrid is incorrect on missing please check the GroupManagement.xlsx");
			return null;
		}
		
	}

	/**
	 * This method is used to get data from Database and return a object with Grid value<p>
	 * For logged in user in the database<p>
	 * @param locator
	 * @return Object of specified class
	 */
	public GroupManagementGrid getDatabaseGrid(String query)
	{
		DatabaseManger.SQLserverConnection(); 
		query=query.replace( "@loginuser",uname);	
		ResultSet resultSet= DatabaseManger.exeQuery(query);
		GroupManagementGrid groupmanagemntgridDB=new GroupManagementGrid();
		Setup.log.debug(query);
		if(resultSet != null)
		{
			
			try {
				while(resultSet.next())
				{
					String groupName = resultSet.getString("ExternalID");	
					String groupNameT=trimMultiSpace(groupName).trim();	
					String GroupID = resultSet.getString("Name");	
					String GroupIDT=trimMultiSpace(GroupID).trim();		
					groupmanagemntgridDB.add(groupNameT, GroupIDT);
				}

			}
			catch(Exception e)
			{
				Setup.log.warn("Please check query in 'Queries.properties.ValidateTotalPracticeCount'or verify the logged in UserName");
				Setup.testcase.fail();
			}
			return groupmanagemntgridDB;
		 }
		
		else
		{
			return null;
		}
	}
}
