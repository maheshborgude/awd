package buisness.core.dashboard.Practice;

import buisness.core.DashboardUI;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.dashboard.practice.PracticeLocationPopUpGrid;
import buisness.util.datastructures.dashboard.practice.SubmissionDetailsGrid;
import configuration.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * This is abstract class this class get data from UI and Database 
 * This class also contain trimMultiSpace() function to remove the space present between word 
 * This class compare Data row of Location popup  present on Dashboards >> Practice Location popup
 *   present on selecting measure
 * This class get data of Submission Details grid
 * This class also contain getWebGrid() method to get Web Grid 
 * This class also contain getDatabaseGrid() method to get Web Grid 
 * This class also reads Qery keywords present in Queries.properties
 * @author rakesh.kulkarni.
 * @Date 21/03/2016
 *
 */


abstract public class PracticeLocationPopUp extends DashboardUI {


	/**
	 * This class compare Data row of Location popup  present on Dashboards >> Practice Location popup
	 *   present on selecting measure
	 * @param locator
	 * @return Object of specified class
	 */
	public PracticeLocationPopUpGrid getWebGrid(String elementmethod, String locator)
	{
		System.out.printf("the captured x path is ",locator);
		Setup.log.trace(locator);
		if(locator!=null)
		{
			PracticeLocationPopUpGrid practiceLocationPopUpGrid=new PracticeLocationPopUpGrid();
			try
			{
				List<WebElement> rows = getWebElements(elementmethod, locator);
				for(WebElement table : rows)
				{

					String LocationName = table.findElement(By.xpath("./td[1]")).getText();
					String LocationNameT=super.trimMultiSpace(LocationName).trim();
					Setup.log.info(LocationNameT);
					
					////Setup.log.info(locator + "./td[2]");
					String Qualified = table.findElement(By.xpath("./td[2]")).getText();
					Setup.log.info(Qualified);
					
					String Met = table.findElement(By.xpath("./td[3]")).getText();
					Setup.log.info(Met);
					
					String NotMet = table.findElement(By.xpath("./td[4]")).getText();
					Setup.log.info(NotMet);

					String Performance = table.findElement(By.xpath("./td[5]/table/tbody/tr/td[2]")).getText();
					//String Performance = table.findElement(By.xpath(".td[6]/table/tbody/tr/td[2]")).getText();
					//String Performance = table.findElement(By.xpath("./td[6]/table/tbody/tr/td[2]")).getText();
					String PerformanceT=super.trimMultiSpace(Performance).trim();
					Setup.log.info(PerformanceT);

					String RegistryBenchmark = table.findElement(By.xpath("./td[5]//div[4]")).getText();
					//String RegistryBenchmark = table.findElement(By.xpath("./td[6]/table/tbody/tr/td[1]/div[3]")).getText();
					String RegistryBenchmarkT=super.trimMultiSpace(RegistryBenchmark).trim();
					Setup.log.info(RegistryBenchmarkT);
                    
					practiceLocationPopUpGrid.add(LocationNameT, Qualified, Met, NotMet, PerformanceT, RegistryBenchmarkT);
				}
			}
			catch(Exception e)
			{
				Setup.log.error(e);
				Setup.log.error("Please check xpath in ObjectRepositary.Properties file ");
			}
			System.err.println("count from UI");
			return practiceLocationPopUpGrid;
		}
		else
		{
			Setup.log.error("The Xpath of WebGrid is incorrect on missing please check the Submision.xlsx");
			return null;
		}
////////////////////////////////////////////////////////////////////////////////////////////////
	}

	/**
	 * This method is used to get data from Database and return a object with Grid value<p>
	 * This class compare Data row of Location popup  present on Dashboards >> Practice Location popup
	 *   present on selecting measure
	 * @return Object of specified class
	 */


	public PracticeLocationPopUpGrid getDatabaseGrid(String query)
	{
		DatabaseManger.SQLserverConnection(); 	
		ResultSet resultSet= DatabaseManger.exeQuery(query);
		PracticeLocationPopUpGrid practiceLocationPopUpGrid=new PracticeLocationPopUpGrid();
		Setup.log.trace(query);
		if(resultSet != null)
		{

			try {
				while(resultSet.next())
				{
					//String LocationName, String Qualified, String Met, String NotMet,String Performance,String RegistryBenchmark    PracticeLocationPopUpGridRow

					String LocationName = resultSet.getString("LocationName");
					String LocationNameT=super.trimMultiSpace(LocationName).trim();
					Setup.log.info(LocationNameT);
					
					String Qualified = resultSet.getString("Qualified");
					String QualifiedT=super.trimMultiSpace(Qualified).trim();
					Setup.log.info(QualifiedT);
					
					String Met = resultSet.getString("Met");
					String MetT=super.trimMultiSpace(Met).trim();
					Setup.log.info(MetT);
					
					String NotMet = resultSet.getString("NotMet");
					String NotMetT=super.trimMultiSpace(NotMet).trim();
					Setup.log.info(NotMetT);

					String Performance = resultSet.getString("Performance");
					String PerformanceT=super.trimMultiSpace(Performance).trim();
					Setup.log.info(PerformanceT);

					String RegistryBenchmark = resultSet.getString("RegistryBenchmark");
					String RegistryBenchmarkT=super.trimMultiSpace(RegistryBenchmark).trim();
					Setup.log.info(RegistryBenchmarkT);

					practiceLocationPopUpGrid.add(LocationNameT, QualifiedT, MetT, NotMetT, PerformanceT,RegistryBenchmarkT);
				}

			}
			catch(SQLException ex)
			{
				Setup.log.error("Please check query in 'Queries.properties.");
				Setup.testcase.fail();
			}
			catch(Exception excp)
			{
				Setup.log.error("query in 'Queries.properties is correct.");
				Setup.testcase.fail();
			}
			return practiceLocationPopUpGrid;
		}

		else
		{
			Setup.log.error("Nothing to return hence return the NULL");
			return null;
		}
	}
}
