
package buisness.core.Submission;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import buisness.core.DashboardUI;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.Submission.ReportedPatientVisitsGrid;
import configuration.Setup;
/**
 * This abstract class is used to get compare Reported Patient Visits grid
 * This class also contain trimMultiSpace(), getWebGrid() and  getDatabaseGrid functions 
 * @author Sachin.Gawade
 * Date 12 Feb 2016
 */
abstract public class ReportedPatientVisits extends DashboardUI {
	
	/**
	 * This method is used to get data from UI for Reported Patient Visits grid<p>
	 * This method get data from UI as per the passed xpath
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * @return ReportedPatientVisitsGrid grid(UI grid)
	 */
	public ReportedPatientVisitsGrid getWebGrid(String elementmethod,String locator)
	{
		if(locator!=null)
		{
			ReportedPatientVisitsGrid reportedPatientVisitsGrid=new ReportedPatientVisitsGrid();
			try
			{
				List<WebElement> rows = getWebElements(elementmethod, locator);			
				Setup.log.trace(locator);
				for(WebElement table : rows)
				{
					String firstname = table.findElement(By.xpath("./td[1]")).getText();
					Setup.log.info(firstname);
					String lastname = table.findElement(By.xpath("./td[2]")).getText();
					Setup.log.info(lastname);
					String gender = table.findElement(By.xpath("./td[3]")).getText();	
					Setup.log.info(gender);
					String dateofbirth = table.findElement(By.xpath("./td[4]")).getText();
					Setup.log.info(dateofbirth);
					String mrn = table.findElement(By.xpath("./td[5]")).getText();
					Setup.log.info(mrn);
					String dateofvisit = table.findElement(By.xpath("./td[7]")).getText();
					Setup.log.info(dateofvisit);
					String reportedmeasures = table.findElement(By.xpath("./td[8]")).getText();
					Setup.log.info(reportedmeasures);
					reportedPatientVisitsGrid.add(firstname,lastname,gender,dateofbirth,mrn,dateofvisit,reportedmeasures);
				}
			}
			catch(NoSuchElementException e)
			{
				Setup.log.error(e);
				Setup.log.error("Element not found on the UI. Please check xpath of column in webtable. ");
			}
			
			catch(Exception e)
			{
				Setup.log.error(e);
				Setup.log.error("Exception faced while fetching data from UI. ");
			}

			return reportedPatientVisitsGrid;	
		}
		else
		{
			Setup.log.error("The Xpath of WebGrid is incorrect on missing please check the GroupManagement.xlsx");
			return null;
		}

	}

	
	/**
	 * This method is used to get data from Database for Reported Patient Visits grid<p>
	 * This method get data from database as per the column name <p>
	 * @param query Query to be run on database<p>
	 * @return ReportedPatientVisitsGrid grid(Database grid)
	 */
	public ReportedPatientVisitsGrid getDatabaseGrid(String query)
	{
		String userName =getLoggedInUser();
		query=query.replace( "@loginuser",userName);
		DatabaseManger.SQLserverConnection(); 
		ResultSet resultSet= DatabaseManger.exeQuery(query);
		ReportedPatientVisitsGrid reportedPatientVisitsGridDB=new ReportedPatientVisitsGrid();
		Setup.log.trace(query);
		if(resultSet != null)
		{
			try {
				while(resultSet.next())
				{
					String firstname = resultSet.getString("firstname");	
					String firstnameT=trimMultiSpace(firstname).trim();
					Setup.log.info(firstnameT);
					String lastname = resultSet.getString("lastname");	
					String lastnameT=trimMultiSpace(lastname).trim();
					Setup.log.info(lastnameT);
					String gender = resultSet.getString("gender");	
					String genderT=trimMultiSpace(gender).trim();
					Setup.log.info(genderT);
					String dateofbirth = resultSet.getString("dateofbirth");
					Setup.log.info(dateofbirth);
					String mrn = resultSet.getString("mrn");
					String mrnT=trimMultiSpace(mrn).trim();
					Setup.log.info(mrnT);
					String dateofvisit = resultSet.getString("dateofvisit");
					Setup.log.info(dateofvisit);
					String reportedmeasures = resultSet.getString("reportedmeasures");
					String reportedmeasuresT=trimMultiSpace(reportedmeasures).trim();
					Setup.log.info(reportedmeasuresT);
					reportedPatientVisitsGridDB.add(firstnameT, lastnameT, genderT, dateofbirth,mrnT,dateofvisit,reportedmeasuresT);
				}
			}
			catch(SQLException e)
			{
				Setup.log.error("SQL Exception. Please check query in query repository");
				Setup.testcase.fail();
			}
			catch(Exception e)
			{
				Setup.log.error("Exception faced while fetching data from Database.");
				Setup.testcase.fail();
			}
			return reportedPatientVisitsGridDB;
		}

		else
		{
			return null;
		}
	}
}
