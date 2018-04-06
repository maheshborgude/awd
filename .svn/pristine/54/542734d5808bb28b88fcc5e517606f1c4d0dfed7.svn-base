package buisness.core.Submission.pqrsSubmission.submission2015.milestoneFour;

import java.sql.ResultSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import buisness.core.DashboardUI;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.Submission.pqrssubmission.ProviderSubmissionGrid;
import configuration.Setup;
/**
 * This is abstract class this class get data from UI and Database 
 * This class also contain trimMultiSpace() function to remove the space present between word 
 * This class get data of  PQRS Submission >> Submission 2015 >> ManageProviderProfile Milestone >>Select Provider
 * This class get data of  PQRS Advanced Status grid
 * This class also contain getWebGrid() method to get Web Grid 
 * This class also contain getDatabaseGrid() method to get Web Grid 
 * This class also reads Qery keywords present in Queries.properties
 * @author rakesh.kulkarni.
 * @Date 09/03/2016
 *
 */
abstract public class ProviderSubmission extends DashboardUI {
	public buisness.core.DashboardUI dashboardui;
	public ProviderSubmission()
	{	
		dashboardui=new buisness.core.DashboardUI();
	}

	/**
	 * This method is used to get data from UI of 
	 * PQRS Submission >> Submission 2015 >> ManageProviderProfile Milestone >>Select Provider
	 * @param locator
	 * @return Object of specified class
	 */
	public ProviderSubmissionGrid getWebGrid(String elementmethod,String locater)
	{
		if(locater!=null)
		{
			ProviderSubmissionGrid providerSubmissionGrid=new ProviderSubmissionGrid();
			try
			{
				List<WebElement> rows = getWebElements(elementmethod, locater);			
				for(WebElement table : rows)
				{
					String ProviderName = table.findElement(By.xpath("./td[1]")).getText();
					String ProviderNameT=dashboardui.trimMultiSpace(ProviderName).trim();
					Setup.log.info(ProviderNameT);
					
					String ReportingOption = table.findElement(By.xpath("./td[2]")).getText();
					Setup.log.info(ReportingOption);
					
					String DRCFStatus = table.findElement(By.xpath("./td[3]")).getText();
					Setup.log.info(DRCFStatus);
					
					String SubmissionStatus = table.findElement(By.xpath("./td[4]")).getText();
					Setup.log.info(SubmissionStatus);
					
					providerSubmissionGrid.add(ProviderNameT, ReportingOption, DRCFStatus, SubmissionStatus);
				}
			}
			catch(Exception e)
			{
				Setup.log.error(e);
				Setup.log.error("Please check xpath in ObjectRepositary.Properties file ");
			}
			return providerSubmissionGrid;	
		}
		else
		{
			Setup.log.error("The Xpath of WebGrid is incorrect on missing please check the Submision.xlsx");
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
	public ProviderSubmissionGrid getDatabaseGrid(String query)
	{
		DatabaseManger.SQLserverConnection(); 	
		ResultSet resultSet= DatabaseManger.exeQuery(query);
		ProviderSubmissionGrid providerSubmissionGrid=new ProviderSubmissionGrid();
		Setup.log.trace(query);
		if(resultSet != null)
		{

			try {
				while(resultSet.next())
				{
					
					String ProviderName = resultSet.getString("ProviderName");	
					String ProviderNameT=dashboardui.trimMultiSpace(ProviderName).trim();
					Setup.log.info(ProviderNameT);
					
					String ReportingOption = resultSet.getString("ReportingOption");	
					String ReportingOptionT=dashboardui.trimMultiSpace(ReportingOption).trim();	
					Setup.log.info(ReportingOptionT);
					
					String DRCFStatus = resultSet.getString("DRCFStatus");	
					String DRCFStatusT=dashboardui.trimMultiSpace(DRCFStatus).trim();	
					Setup.log.info(DRCFStatusT);
					
					String SubmissionStatus = resultSet.getString("SubmissionStatus");	
					String SubmissionStatusT=dashboardui.trimMultiSpace(SubmissionStatus).trim();	
					Setup.log.info(SubmissionStatusT);
					
					providerSubmissionGrid.add(ProviderNameT, ReportingOptionT, DRCFStatusT, SubmissionStatusT);
				}

			}
			catch(Exception e)
			{
				Setup.log.error("Please check query in 'Queries.properties.");
				Setup.testcase.fail();
			}
			return providerSubmissionGrid;
		}

		else
		{
			return null;
		}
	}
}
