
package buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree;

import java.sql.ResultSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import buisness.core.DashboardUI;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.Submission.pqrssubmission.ReportedPatientVisitsCMGRGrid;
import configuration.Setup;
/**
 * This is abstract class this class get data from UI and Database 
 * This class also contain trimMultiSpace() function to remove the space present between word 
 * This class get data of  PQRS Submission >> Submission 2015 >> Report PQRS Measures Milestone >>Reported Patient Visits
 *  * This class get data of  PQRS Advanced Status grid
 * This class also contain getWebGrid() method to get Web Grid 
 * This class also contain getDatabaseGrid() method to get Web Grid 
 * @author rakesh.kulkarni
 * date 08/02/2016
 */
abstract public class ReportedPatientVisitsCMGR extends DashboardUI {


	public String trimMultiSpace(String getString)
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
	 * PQRS Submission >> Submission 2015 >> ManageProviderProfile Milestone >>Reported Patient Visits CMGR
	 * @param locator
	 * @return Object of specified class
	 */
	public ReportedPatientVisitsCMGRGrid getWebGrid(String elementmethod,String locater)
	{
		if(locater!=null)
		{
			ReportedPatientVisitsCMGRGrid reportedPatientVisitsGrid=new ReportedPatientVisitsCMGRGrid();
			try
			{
				List<WebElement> rows = getWebElements(elementmethod, locater);			
				Setup.log.info(locater);
				for(WebElement table : rows)
				{
					String firstName = table.findElement(By.xpath("./td[1]")).getText();
					Setup.log.info(firstName);
					String lastName = table.findElement(By.xpath("./td[2]")).getText();
					Setup.log.info(lastName);
					String grnder = table.findElement(By.xpath("./td[3]")).getText();	
					Setup.log.info(grnder);
					String dateOfBirth = table.findElement(By.xpath("./td[4]")).getText();
					Setup.log.info(dateOfBirth);
					String mrn = table.findElement(By.xpath("./td[5]")).getText();
					Setup.log.info(mrn);
					String medicare = table.findElement(By.xpath("./td[6]")).getText();
					Setup.log.info(medicare);
					String dateOfSurgery = table.findElement(By.xpath("./td[7]")).getText();
					Setup.log.info(dateOfSurgery);
					String operativeEye = table.findElement(By.xpath("./td[9]")).getText();
					Setup.log.info(operativeEye);
					reportedPatientVisitsGrid.add(firstName,lastName, grnder, dateOfBirth, mrn, medicare, dateOfSurgery, operativeEye);
				}
			}
			catch(Exception e)
			{
				Setup.log.error(e);
				Setup.log.error("Please check xpath in ObjectRepositary.Properties file ");
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
	 * This method is used to get data from Database and return a object with Grid value<p>
	 * For logged in user in the database<p>
	 * PQRS Submission >> Submission 2015 >> ManageProviderProfile Milestone >>Reported Patient Visits CMGR
	 * @param locator
	 * @return Object of specified class
	 */
	public ReportedPatientVisitsCMGRGrid getDatabaseGrid(String query)
	{
		DatabaseManger.SQLserverConnection(); 
		String userName =getLoggedInUser();
		String Newquery=query.replace( "@loginuser",userName);	
		System.err.println(Newquery);
		ResultSet resultSet= DatabaseManger.exeQuery(Newquery);
		ReportedPatientVisitsCMGRGrid reportedPatientVisitsGridDB=new ReportedPatientVisitsCMGRGrid();
		Setup.log.info(query);
		if(resultSet != null)
		{
			try {
				while(resultSet.next())
				{
					String firstName = resultSet.getString("firstname");	
					String firstNameT=trimMultiSpace(firstName).trim();	
					Setup.log.info(firstNameT);
					String lastName = resultSet.getString("lastname");	
					String lastNameT=trimMultiSpace(lastName).trim();	
					Setup.log.info(lastNameT);
					String grnder = resultSet.getString("gender");	
					String grnderT=trimMultiSpace(grnder).trim();	
					Setup.log.info(grnderT);
					String dateOfBirth = resultSet.getString("dateofbirth");	
					String dateOfBirthT=trimMultiSpace(dateOfBirth).trim();
					Setup.log.info(dateOfBirthT);
					String mrn = resultSet.getString("mrn");	
					String mrnT=trimMultiSpace(mrn).trim();
					Setup.log.info(mrnT);
					String medicare = resultSet.getString("Medicare");	
					String medicareT=trimMultiSpace(medicare).trim();
					Setup.log.info(medicareT);
					String dateOfSurgery = resultSet.getString("dateofvisit");	
					String dateOfSurgeryT=trimMultiSpace(dateOfSurgery).trim();
					Setup.log.info(dateOfSurgeryT);
					String operativeEye = resultSet.getString("OperativeEye");	
					String operativeEyeT=trimMultiSpace(operativeEye).trim();	
					Setup.log.info(operativeEyeT);
					reportedPatientVisitsGridDB.add(firstNameT, lastNameT, grnderT, dateOfBirthT,mrnT,medicareT,dateOfSurgeryT,operativeEyeT);					
				}
			}
			catch(Exception e)
			{
				Setup.log.warn("Please check query in 'Queries.properties.ValidateTotalPracticeCount'or verify the logged in UserName");
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
