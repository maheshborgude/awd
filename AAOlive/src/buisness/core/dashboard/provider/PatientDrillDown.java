package buisness.core.dashboard.provider;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import buisness.core.DashboardUI;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.dashboard.PatientDrillDownGrid;
import configuration.Setup;

abstract class PatientDrillDown extends DashboardUI   {

	
	/**
	 * Returns PatientDrillDownGrid object containing all the details available<p>
	 * @param query Query to be run on database<p>
	 * @return dbgrid which contains all database rows 
	 * @author Sachin Gawade
	 * Created date 3 Mar 2016
	 */

	public PatientDrillDownGrid getDatabaseGrid(String query) 
	{
		System.out.println("Db Grid started");
		DatabaseManger.SQLserverConnection(); 
		//query=query.replace( "@loginuser",getLoggedInUser());
		//query=query.replace( "@measureuid",getSelectedMeasureUID());
		ResultSet rs = DatabaseManger.exeQuery(query);
		PatientDrillDownGrid dbgrid=new PatientDrillDownGrid();
		Setup.log.trace(query);
		Setup.log.trace(rs);
		try {
			while(rs.next())
			{
				try {
					String name = rs.getString("name");
					//Setup.log.info(name);
					String mrn= rs.getString("mrn");
					//Setup.log.info(mrn);
					String gender= rs.getString("gender");
					//Setup.log.info(gender);
					String dob= rs.getString("dob");
					Setup.log.info(name+ " " +mrn+ " " +gender+ " " +dob);
					dbgrid.addPatientRow(name,mrn,gender,dob);

				} catch (NullPointerException e) 
				{
					Setup.log.error("Required Column is not present in the result of the query.");
					Setup.testcase.fail();
				}	
				catch(SQLException e)
				{
					Setup.log.error("SQL Exception. Please check query and column names in query repository");
					Setup.testcase.fail();
				}
				catch (Exception e) 
				{
					Setup.log.error("Exception faced while fetching data from Database.");
					Setup.testcase.fail();
				}

			}
		} catch (NullPointerException e) 
		{
			Setup.log.error("Result set for query is Null.");
			Setup.testcase.fail();
		}	
		catch(SQLException e)
		{
			Setup.log.error("SQL Exception. Please check query in query repository");
			Setup.testcase.fail();
		}
		catch (Exception e) 
		{
			Setup.log.error("Exception faced while fetching data for Result Set from Database.");
			Setup.testcase.fail();
		}


		return dbgrid;
	}
	/**
	 * This method is used to get PatientDrillDownGrid object containing all patient and their details available<p>
	 * for logged in user in the database<p>
	 *
	 * @param locator Name of locator in object repository<p>
	 * @return uigrid which contains all the UI Data <p>
	 * @author nilesh.patil
	 * Updated by Sachin.Gawade
	 *Created date 5 Jan 2016
	 */
	public PatientDrillDownGrid getWebGrid(String elementMethod ,String locator)
	{
		System.out.println("UI Grid started");
		PatientDrillDownGrid uigrid = new PatientDrillDownGrid();
		
		try {
			List<WebElement> rows = getWebElements(elementMethod, locator);
			Setup.log.trace(locator);
			for(WebElement we : rows)
			{
				String name = we.findElement(By.xpath("./td[1]")).getText();
				//Setup.log.info(name);
				String mrn = we.findElement(By.xpath("./td[2]")).getText();
				//Setup.log.info(mrn);
				String gender = we.findElement(By.xpath("./td[3]")).getText();
				//Setup.log.info(gender);
				String dob = we.findElement(By.xpath("./td[4]")).getText();
				Setup.log.info(name+ " " +mrn+ " " +gender+ " " +dob);
				uigrid.addPatientRow(name,mrn,gender,dob);
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
