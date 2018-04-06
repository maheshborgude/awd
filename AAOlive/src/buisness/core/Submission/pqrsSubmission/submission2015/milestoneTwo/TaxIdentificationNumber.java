package buisness.core.Submission.pqrsSubmission.submission2015.milestoneTwo;

import java.sql.ResultSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import buisness.core.ElementMethod;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.Submission.pqrssubmission.TaxIdentificationNumberGrid;
import configuration.Setup;
/**
 * This is abstract class this class get data from UI and Database 
 * This class also contain trimMultiSpace() function to remove the space present between word 
 * This class get data of  PQRS Submission >> Submission 2015 >> ManageProviderProfile Milestone >>TaxIdentificationNumber
 * This class get data of  PQRS Advanced Status grid
 * This class also contain getWebGrid() method to get Web Grid 
 * This class also contain getDatabaseGrid() method to get Web Grid 
 * This class also reads Qery keywords present in Queries.properties
 * @author rakesh.kulkarni
 *
 */
abstract public class TaxIdentificationNumber extends ElementMethod {

	private String uname;

	public buisness.core.DashboardUI dashboardui;
	public TaxIdentificationNumber()
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
	 * This method is used to get data from UI of 
	 * PQRS Submission >> Submission 2015 >> ManageProviderProfile Milestone >>tax Identification Number 
	 * @param locator
	 * @return Object of specified class
	 */
	public TaxIdentificationNumberGrid getWebGrid(String elementmethod,String locater)
	{
		if(locater!=null)
		{
			TaxIdentificationNumberGrid taxIdentificationNumberGrid=new TaxIdentificationNumberGrid();
			try
			{
				List<WebElement> rows = getWebElements(elementmethod, locater);			
				for(WebElement table : rows)
				{
					String npi = table.findElement(By.xpath("./td[1]")).getText();
					String ValidFromDate = table.findElement(By.xpath("./td[2]")).getText();
					String ValidTodate = table.findElement(By.xpath("./td[3]")).getText();	
					taxIdentificationNumberGrid.add(npi, ValidFromDate, ValidTodate);
				}
			}
			catch(Exception e)
			{
				Setup.log.error(e);
				Setup.log.error("Please check xpath in ObjectRepositary.Properties file ");
			}
			return taxIdentificationNumberGrid;	
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
	 * PQRS Submission >> Submission 2015 >> ManageProviderProfile Milestone >>TaxIdentificationNumber
	 * @param locator
	 * @return Object of specified class
	 */
	public TaxIdentificationNumberGrid getDatabaseGrid(String query)
	{
		DatabaseManger.SQLserverConnection(); 
		query=query.replace( "@loginuser",uname);	
		ResultSet resultSet= DatabaseManger.exeQuery(query);
		TaxIdentificationNumberGrid taxIdentificationNumberGridDB=new TaxIdentificationNumberGrid();
		Setup.log.trace(query);
		if(resultSet != null)
		{

			try {
				while(resultSet.next())
				{
					String tin = resultSet.getString("TIN");	
					String tinT=trimMultiSpace(tin).trim();		
					String ValidFromDate = resultSet.getString("ValidFromDate");	
					String ValidFromDateT=trimMultiSpace(ValidFromDate).trim();
					String ValidTodate = resultSet.getString("ValidTodate");	
					String ValidTodateT=trimMultiSpace(ValidTodate).trim();	
					taxIdentificationNumberGridDB.add(tinT, ValidFromDateT, ValidTodateT);
				}

			}
			catch(Exception e)
			{
				Setup.log.error("Please check query in 'Queries.properties'or verify the logged in UserName");
				Setup.testcase.fail();
			}
			return taxIdentificationNumberGridDB;
		}

		else
		{
			return null;
		}
	}
}
