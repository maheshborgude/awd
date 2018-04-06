package buisness.core.administration.groupmanagement;

import java.sql.ResultSet;
import java.util.List;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import buisness.core.ElementMethod;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.administration.groupmanagement.AssociatedUserGrid;
import configuration.Setup;

abstract public class AssociatedUsers extends ElementMethod {

	private String uname;

	public buisness.core.DashboardUI dashboardui;
	public AssociatedUsers()
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
	 * @param 
	 * @return Object of specified class
	 */
	public AssociatedUserGrid getWebGrid(String elementmethod,String locater)
	{
		if(locater!=null)
		{
			AssociatedUserGrid associateduserWebGrid=new AssociatedUserGrid();
			try
			{
				List<WebElement> rows = getWebElements(elementmethod, locater);			
				Setup.log.trace(locater);
				for(WebElement table : rows)
				{
					String name = table.findElement(By.xpath("./td[1]")).getText();
					String firstName = table.findElement(By.xpath("./td[2]")).getText();
					String lastName = table.findElement(By.xpath("./td[3]")).getText();	
					String practiceID = table.findElement(By.xpath("./td[5]")).getText();
					String PracticeName = table.findElement(By.xpath("./td[6]")).getText();
					String inactive = table.findElement(By.xpath("./td[7]")).getText();	
					associateduserWebGrid.add(name, firstName, lastName, practiceID, PracticeName, inactive);
				}
			}
			catch(ElementNotFoundException e)
			{
				associateduserWebGrid.add("name", "firstName", "lastName", "practiceID", "PracticeName", "inactive");
				Setup.log.error("Element not Fount Exception occur");
			}
			catch(Exception e)
			{
				associateduserWebGrid.add("name", "firstName", "lastName", "practiceID", "PracticeName", "inactive");
				Setup.log.error("Exception occur while fetching data from UI");
			}

			return associateduserWebGrid;	
		}
		else
		{
			Setup.log.error("The Xpath of WebGrid is incorrect on missing please check the GroupManagement.xlsx or ObjectRepository.properties");
			return null;
		}

	}

	/**
	 * This method is used to get data from Database and return a object with Grid value<p>
	 * For logged in user in the database<p>
	 * @param locator
	 * @return Object of specified class
	 */
	public AssociatedUserGrid getDatabaseGrid(String query)
	{
		DatabaseManger.SQLserverConnection(); 
		query=query.replace( "@loginuser",uname);	
		ResultSet resultSet= DatabaseManger.exeQuery(query);
		AssociatedUserGrid AssociatedUserGridDB=new AssociatedUserGrid();
		Setup.log.trace(query);
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
					String inactive = resultSet.getString("inactive");	
					String inactiveT=trimMultiSpace(inactive).trim();	
					AssociatedUserGridDB.add(nameT, firstNameT, lastNameT, practiceIDT, PracticeNameT, inactiveT);
				}

			}
			catch(Exception e)
			{
				Setup.log.error("Exception while fetching data from Database");
				AssociatedUserGridDB.add("nameT", "firstNameT", "lastNameT", "practiceIDT", "PracticeNameT", "inactiveT");
				Setup.testcase.fail();
			}
			return AssociatedUserGridDB;
		}

		else
		{
			return null;
		}
	}
}
