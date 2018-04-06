package buisness.core.dashboard.provider;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import buisness.core.DashboardUI;
import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.dashboard.MeasureComputationSummaryGrid;
import configuration.Setup;
/**
 * This class is used to Compare Dashboard>>Measure Computation Summary grid present in UI and Database 
 * @author Sachin.Gawade
 * Date: 4 Mar 2016
 */
abstract class MeasureComputationSummary extends DashboardUI   {

	ConfigurationManager config;

	//MeasureComputationSummary constructor
	public MeasureComputationSummary() 
	{
		config = new ConfigurationManager();

	}	 
	/**
	 * getDatabaseGrid()<p>
	 * Returns MeasureComputationSummaryGrid object containing all the details available<p>
	 * @param query Query to be run on database<p>
	 * @return dbgrid which contains all database rows 
	 * @author Sachin Gawade
	 * Created date 4 Mar 2016
	 */

	public MeasureComputationSummaryGrid getDatabaseGrid(String query) 
	{
		DatabaseManger.SQLserverConnection(); 
		query=query.replace("@loginuser",getLoggedInUser());
	//	query=query.replace( "@measureuid",getSelectedMeasureUID());
		ResultSet rs = DatabaseManger.exeQuery(query);
		MeasureComputationSummaryGrid dbgrid=new MeasureComputationSummaryGrid();
		Setup.log.trace(query);
		Setup.log.trace(rs);
		try {
			while(rs.next())
			{
				try {
					String monquat = rs.getString("Quarter");
					String allmeasures= rs.getString("Allmeasures");
					String met= rs.getString("Met");
					String notmet= rs.getString("Notmet");
					String percentage= rs.getString("Score");
					//Setup.log.info(monquat+allmeasures+met+notmet+percentage);
					System.out.println(monquat+ " " +allmeasures+ " " +met+ " " +notmet+ " " +percentage);
					dbgrid.addMeasureRow(monquat, allmeasures, met, notmet, percentage);

				}  catch(SQLException e)
				{
					Setup.log.error("SQL Exception. Please check query in query repository");
					Setup.testcase.fail();
				}
				catch(Exception e)
				{
					Setup.log.error("Exception faced while fetching data from Database.");
					Setup.testcase.fail();
				}
			
			}
		} catch (NullPointerException e) 
		{
			Setup.log.error("Result set for query is Null.");
			e.printStackTrace();
		}	
		catch (Exception e) 
		{
			Setup.log.error("Exception faced while fetching data from Database.");
			e.printStackTrace();
		}

		return dbgrid;
	}
	/**
	 * Returns MeasureComputationSummaryGrid object containing all patient and their details from the UI<p>
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * 
	 * @author Sachin Gawade
	 *Created date 4 March 2016
	 */
	public MeasureComputationSummaryGrid getWebGrid(String elementMethod ,String locator)
	{

		MeasureComputationSummaryGrid uigrid = new MeasureComputationSummaryGrid();
		
		try {
			List<WebElement> rows = getWebElements(elementMethod, locator);
			Setup.log.trace(locator);
			for(WebElement we : rows)
			{
				String monquat = we.findElement(By.xpath("./td[1]")).getText();
				String allmeasures = we.findElement(By.xpath("./td[2]")).getText();
				String met = we.findElement(By.xpath("./td[3]/a")).getText();
				String notmet = we.findElement(By.xpath("./td[4]/a")).getText();
				String percentage = we.findElement(By.xpath("./td[5]")).getText();
				System.out.println(monquat+ " " +allmeasures+ " " +met+ " " +notmet+ " " +percentage);
				//Setup.log.info(monquat+allmeasures+met+notmet+percentage);
				uigrid.addMeasureRow(monquat, allmeasures, met, notmet, percentage);
			}
		} 
		catch (NoSuchElementException e) 
		{
			Setup.log.error("Element not found.");
			e.printStackTrace();
		}

		catch (Exception e) 
		{
			Setup.log.error("Error while fetching the data from the UI");
			e.printStackTrace();
		}

		return uigrid;

	}





}
