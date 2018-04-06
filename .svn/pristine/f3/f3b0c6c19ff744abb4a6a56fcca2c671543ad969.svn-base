package buisness.core.Submission.pqrsSubmission.submission2015.milestoneTwo;

import java.sql.ResultSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import buisness.core.ElementMethod;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.Submission.pqrssubmission.SelectProviderGrid;
import configuration.Setup;
/**
 * This is abstract class this class get data from UI and Database 
 * This class also contain trimMultiSpace() function to remove the space present between word 
 * This class get data of  PQRS Submission >> Submission 2015 >> ManageProviderProfile Milestone >>Select Provider
 * This class get data of  PQRS Advanced Status grid
 * This class also contain getWebGrid() method to get Web Grid 
 * This class also contain getDatabaseGrid() method to get Web Grid 
 * This class also reads Qery keywords present in Queries.properties
 * @author rakesh.kulkarni
 *
 */
abstract public class SelectProvider extends ElementMethod {
	public buisness.core.DashboardUI dashboardui;
	public SelectProvider()
	{	
		dashboardui=new buisness.core.DashboardUI();
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
	 * This method is used to get data from UI of 
	 * PQRS Submission >> Submission 2015 >> ManageProviderProfile Milestone >>Select Provider
	 * @param locator
	 * @return Object of specified class
	 */
	public SelectProviderGrid getWebGrid(String elementmethod,String locater)
	{
		if(locater!=null)
		{
			SelectProviderGrid selectProviderGrid=new SelectProviderGrid();
			try
			{
				List<WebElement> rows = getWebElements(elementmethod, locater);			
				for(WebElement table : rows)
				{

					String name = table.findElement(By.xpath("./td[2]")).getText();
					Setup.log.info(name);
					String emil = table.findElement(By.xpath("./td[6]")).getText();
					Setup.log.info(emil);
					String npi = table.findElement(By.xpath("./td[7]")).getText();	
					Setup.log.info(npi);
					String reportingType = table.findElement(By.xpath("./td[10]")).getText();
					Setup.log.info(reportingType);
					selectProviderGrid.add(name, emil, npi, reportingType);
				}
			}
			catch(Exception e)
			{
				Setup.log.error(e);
				Setup.log.error("Please check xpath in ObjectRepositary.Properties file ");
			}
			return selectProviderGrid;	
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
	 * PQRS Submission >> Submission 2015 >> ManageProviderProfile Milestone >>Select Provider
	 * @param locator
	 * @return Object of specified class
	 */
	public SelectProviderGrid getDatabaseGrid(String query)
	{
		DatabaseManger.SQLserverConnection(); 	
		ResultSet resultSet= DatabaseManger.exeQuery(query);
		SelectProviderGrid selectProviderGridDB=new SelectProviderGrid();
		Setup.log.trace(query);
		if(resultSet != null)
		{

			try {
				while(resultSet.next())
				{
					String name = resultSet.getString("Name");
					String nameT=trimMultiSpace(name).trim();
					Setup.log.info(nameT);
					String emil = resultSet.getString("EmailAddress");
					String emilT=trimMultiSpace(emil).trim();	
					Setup.log.info(emilT);
					String npi = resultSet.getString("npi");
					String npiT=trimMultiSpace(npi).trim();	
					Setup.log.info(npiT);
					String reportingType = resultSet.getString("REPORTINGTYPE");	
					String reportingTypeT=trimMultiSpace(reportingType).trim();	
					Setup.log.info(reportingTypeT);
					selectProviderGridDB.add(nameT, emilT, npiT, reportingTypeT);
				}

			}
			catch(Exception e)
			{
				Setup.log.error("Please check query in 'Queries.properties.");
				Setup.testcase.fail();
			}
			return selectProviderGridDB;
		}

		else
		{
			return null;
		}
	}
}
