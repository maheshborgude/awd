package buisness.core.dashboard.provider;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import buisness.core.DashboardUI;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.dashboard.MeasureGrid;
import configuration.Setup;
/**
 * This class is used to compare Dashboard>>Measure grid from UI and Database.
 * @author Sachin.Gawade
 * Date: 3 Mar 2016
 */
abstract class Measure extends DashboardUI   {

	/**
	 * getDatabaseGrid(String query)<p>
	 * Returns MeasureGrid object containing all measures and their details available<p>
	 * @param query Query to be run on database<p>
	 * @return dbgrid which contains all database rows 
	 * @author Sachin Gawade
	 * Created date 3 Mar 2016
	 * @author probeer.roy Updated Date: 19 Dec 2017
	 */
	
	public MeasureGrid getDatabaseGrid(String query) 
	{
		DatabaseManger.SQLserverConnection();
		System.out.println("getDatabaseGrid method invoked");
		//query=query.replace( "@loginuser",getLoggedInUser());
		//query=query.replace( "@measureuid",getSelectedMeasureUID());
		ResultSet rs = DatabaseManger.exeQuery(query);
		MeasureGrid dbgrid=new MeasureGrid();
		Setup.log.trace(query);
		Setup.log.trace(rs);
		try {
			while(rs.next())
			{
				try {

					String id = trimMultiSpace(rs.getString("ID"));
					// System.out.println(id);
					String measure = trimMultiSpace(rs.getString("Measure"));
					//System.out.println(measure);
					String performance = rs.getString("Performance");
					// System.out.println(performance);
					String reg_avg = trimMultiSpace(rs.getString("RegistryAverage"));
				 //  System.out.println(id+ " " +measure+" " +performance+ " " +reg_avg);					
					dbgrid.addMeasureGridRow(id,measure,performance,reg_avg);

				} catch(SQLException e)
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
	 * getWebGrid(String elementMethod ,String locator)<p>
	 * Returns ProviderLocationGrid object containing all locations\providers and their details available<p>
	 * for logged in user in the database<p>
	 * @param locator Name of locator in object repository<p>
	 * @return uigrid which contains all the UI Data 
	 * 
	 * @author nilesh.patil
	 *Created date 5 Jan 2016
	 */
	public MeasureGrid getWebGrid(String elementMethod ,String locator)
	{
		List<WebElement> rows = getWebElements(elementMethod, locator);
		Setup.log.trace(locator);
		MeasureGrid uigrid = new MeasureGrid();
		try {
			System.out.println("GetWebGrid method invoked.");
			System.out.println("Numbers of rows got from UI: " + rows.size());
			Setup.log.trace(locator);
			for (WebElement Table : rows) {
				// System.out.println("Coming here in Foor loop");
				String id = trimMultiSpace(Table.findElement(By.xpath("./td[1]")).getText());
				// System.out.println(id);
				String measure = trimMultiSpace(Table.findElement(By.xpath("./td[2]")).getText());
				// System.out.println(measure);
				String performance = Table.findElement(By.xpath("./td[3]/table/tbody/tr/td/table/tbody/tr/td[2]"))
						.getText();
				// System.out.println(performance);
				String reg_avg = trimMultiSpace(Table.findElement(By.xpath("./td[3]/table/tbody/tr/td/table/tbody/tr/td[1]/div[4]")).getText());
				// System.out.println(reg_avg);
				 //System.out.println(id+ " " +measure+" " +performance+ " " +reg_avg);
				uigrid.addMeasureGridRow(id, measure, performance, reg_avg);
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


/*
	public String formeasue21(String inputMeasure)
	{
		System.err.println("formeasue21");
		String db21=" Pneumonia Vaccination Status for Older Adults – National Quality\n" +
				"Strategy Domain: Effective Clinical Care";
		String ui21="Pneumonia Vaccination Status for Older Adults – National Quality Strategy Domain: Effective Clinical Care";
        if (inputMeasure == db21)
			return ui21;
		else
			return inputMeasure;
	}
*/

}
