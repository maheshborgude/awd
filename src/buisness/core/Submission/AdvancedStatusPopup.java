
package buisness.core.Submission;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import buisness.core.DashboardUI;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.Submission.AdvancedStatusPopupGrid;
import configuration.Setup;
/**
 * This is used to fetch Advanced Status Popup grid from UI and Database <p>
 * This class has the following methods trimMultiSpace(),getWebGrid() and getDatabaseGrid() <p> 
 * @author Sachin Gawade
 * date 11/02/2016
 */
abstract public class AdvancedStatusPopup extends DashboardUI {

	/**
	 * This method is used to get data from UI for Advanced Status popup<p>
	 * This method get data from UI as per the passed xpath
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * @return AdvancedStatusPopupGrid grid(UI grid)
	 */
	public AdvancedStatusPopupGrid getWebGrid(String elementmethod,String locater)
	{
		if(locater!=null)
		{
			AdvancedStatusPopupGrid AdvancedStatusPopupGrid=new AdvancedStatusPopupGrid();
			try
			{
				List<WebElement> rows = getWebElements(elementmethod, locater);			
				Setup.log.trace(locater);
				for(WebElement table : rows)
				{
					String name = table.findElement(By.xpath("./td[1]")).getText();
					Setup.log.info(name);
					String mrn = table.findElement(By.xpath("./td[2]")).getText();
					Setup.log.info(mrn);
					String gender = table.findElement(By.xpath("./td[3]")).getText();	
					Setup.log.info(gender);
					String dateOfVisit = table.findElement(By.xpath("./td[4]")).getText();
					Setup.log.info(dateOfVisit);
					String dateofBirth = table.findElement(By.xpath("./td[5]")).getText();
					Setup.log.info(dateofBirth);
					AdvancedStatusPopupGrid.add(name, mrn, gender, dateOfVisit, dateofBirth);
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
			return AdvancedStatusPopupGrid;	
		}
		else
		{
			Setup.log.error("The Xpath of WebGrid is incorrect on missing please check the GroupManagement.xlsx");
			return null;
		}

	}
	
	
	/**
	 * This method is used to get data from Database for Advanced Status popup<p>
	 * This method get data from database as per the column name 
	 * @param query Query to be run on database<p>
	 * @return AdvancedStatusPopupGrid grid(Database grid)
	 * 
	 */
	
	
	public AdvancedStatusPopupGrid getDatabaseGrid(String query)
	{
		
		String userName =getLoggedInUser();
		query=query.replace( "@loginuser",userName);
		DatabaseManger.SQLserverConnection(); 
		Setup.log.trace(query);
		ResultSet resultSet= DatabaseManger.exeQuery(query);
		AdvancedStatusPopupGrid dbgrid=new AdvancedStatusPopupGrid();
		
		if(resultSet != null)
		{
			try {
				while(resultSet.next())
				{
					String name = resultSet.getString("name");	
					String nameT=trimMultiSpace(name).trim();		
					String mrn = resultSet.getString("mrn");	
					String mrnT=trimMultiSpace(mrn).trim();	
					String gender = resultSet.getString("gender");	
					String genderT=trimMultiSpace(gender).trim();	
					String dateOfVisit = resultSet.getString("dateOfVisit");	
					String dateOfVisitT=trimMultiSpace(dateOfVisit).trim();
					String dateofBirth = resultSet.getString("dateOfBirth");	
					String dateofBirthT=trimMultiSpace(dateofBirth).trim();				
					dbgrid.add(nameT, mrnT, genderT, dateOfVisitT,dateofBirthT);
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
			
			return dbgrid;
		}

		else
		{
			return null;
		}
	}
}
