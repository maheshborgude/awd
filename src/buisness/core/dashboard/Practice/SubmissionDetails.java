package buisness.core.dashboard.Practice;

import buisness.core.DashboardUI;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.Submission.pqrssubmission.ProviderSubmissionGrid;
import buisness.util.datastructures.dashboard.practice.SubmissionDetailsGrid;
import configuration.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.sql.ResultSet;
import java.util.List;

/**
 * This is abstract class this class get data from UI and Database 
 * This class also contain trimMultiSpace() function to remove the space present between word 
 * This class compare row of Data row of Submission Details >> Dashboards >> Practice
 *   >>PQRS Submission Details
 * This class get data of Submission Details grid
 * This class also contain getWebGrid() method to get Web Grid 
 * This class also contain getDatabaseGrid() method to get Web Grid 
 * This class also reads Qery keywords present in Queries.properties
 * @author rakesh.kulkarni.
 * @Date 16-3-2016
 *
 */
abstract public class SubmissionDetails extends DashboardUI {
	public DashboardUI dashboardui;
	public SubmissionDetails()
	{
		dashboardui=new DashboardUI();
	}

	/**
	 * This class compare row of Data row of Submission Details >> Dashboards >> Practice
	 *   >>PQRS Submission Details
	 * @param locator
	 * @return Object of specified class
	 */
	public SubmissionDetailsGrid getWebGrid(String elementmethod, String locator)
	{
		if(locator!=null)
		{
			SubmissionDetailsGrid submissionDetailsGrid=new SubmissionDetailsGrid();
			try
			{
				List<WebElement> rows = getWebElements(elementmethod, locator);
				for(WebElement table : rows)
				{

					String ProviderName = table.findElement(By.xpath("./td[1]")).getText();
					String ProviderNameT=dashboardui.trimMultiSpace(ProviderName).trim();
					Setup.log.info(ProviderNameT);
					
					String Npi = table.findElement(By.xpath("./td[2]")).getText();
					Setup.log.info(Npi);
					
					String Tin = table.findElement(By.xpath("./td[3]")).getText();
					Setup.log.info(Tin);
					
					String DrcfStatus = table.findElement(By.xpath("./td[4]")).getText();
					Setup.log.info(DrcfStatus);

					submissionDetailsGrid.add(ProviderNameT, Npi, Tin, DrcfStatus);
				}
			}
			catch(Exception e)
			{
				Setup.log.error(e);
				Setup.log.error("Please check xpath in ObjectRepositary.Properties file ");
			}
			return submissionDetailsGrid;
		}
		else
		{
			Setup.log.error("The Xpath of WebGrid is incorrect on missing please check the Submision.xlsx");
			return null;
		}

	}

	/**
	 * This method is used to get data from Database and return a object with Grid value<p>
	 * This class compare row of Data row of Submission Details >> Dashboards >> Practice
	 *   >>PQRS Submission Details
	 * @return Object of specified class
	 */
	public SubmissionDetailsGrid getDatabaseGrid(String query)
	{
		DatabaseManger.SQLserverConnection(); 	
		ResultSet resultSet= DatabaseManger.exeQuery(query);
		SubmissionDetailsGrid submissionDetailsGrid=new SubmissionDetailsGrid();
		Setup.log.trace(query);
		if(resultSet != null)
		{

			try {
				while(resultSet.next())
				{
					String ProviderName = resultSet.getString("ProviderName");
					String ProviderNameT=dashboardui.trimMultiSpace(ProviderName).trim();
					Setup.log.info(ProviderNameT);
					
					String Npi = resultSet.getString("Npi");
					String NpiT=dashboardui.trimMultiSpace(Npi).trim();
					Setup.log.info(NpiT);
					
					String Tin = resultSet.getString("Tin");
					String TinT=dashboardui.trimMultiSpace(Tin).trim();
					Setup.log.info(TinT);
					
					String DrcfStatus = resultSet.getString("DrcfStatus");
					String DrcfStatusT=dashboardui.trimMultiSpace(DrcfStatus).trim();
					Setup.log.info(DrcfStatusT);

					submissionDetailsGrid.add(ProviderNameT, NpiT, TinT, DrcfStatusT);
				}

			}
			catch(Exception e)
			{
				Setup.log.error("Please check query in 'Queries.properties.");
				Setup.testcase.fail();
			}
			return submissionDetailsGrid;
		}

		else
		{
			return null;
		}
	}
}
