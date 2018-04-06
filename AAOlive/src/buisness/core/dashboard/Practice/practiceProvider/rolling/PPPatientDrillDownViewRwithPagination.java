package buisness.core.dashboard.Practice.practiceProvider.rolling;

import java.sql.ResultSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.dashboard.practice.practiceProvider.PatientDrillDownGrid;
import buisness.util.helpers.Pagination;
import configuration.Setup;

public class PPPatientDrillDownViewRwithPagination extends PracticeProviderPopUpTabBasicR
{
	 private String name;
	 private String mrn;
	 private String gender;
	 private String DOB;
     String query;
	 ConfigurationManager config;

	public  PPPatientDrillDownViewRwithPagination() 
	{
			config = new ConfigurationManager();

	}
	
	public PatientDrillDownGrid getDatabasePatientView(String query)
	{

		DatabaseManger.SQLserverConnection();
	    ResultSet rs = DatabaseManger.exeQuery(query);
	    Setup.log.info("Result Set:" + rs);
	    PatientDrillDownGrid dbgrid = new PatientDrillDownGrid();
	    Setup.log.trace(query);
	    try {
		     while (rs.next()) 
		     {
			try {
				name =trimMultiSpace(rs.getString("name"));
				//System.out.println(name);
				mrn = trimMultiSpace(rs.getString("mrn"));
				//System.out.println(mrn);
				gender = trimMultiSpace(rs.getString("gender"));
				//System.out.println(gender);
				DOB = trimMultiSpace(rs.getString("DOB"));
				//System.out.println(DOB);
			   } catch (Exception e) {
				Setup.log.error("Please verify the coulumn names in queries");
			}
			  dbgrid.addPatientRow(name, mrn, gender, DOB);

		}
	} catch (Exception e) {
		Setup.log.error("No record in table of the database");
	}
	    return dbgrid;
}
	
	public PatientDrillDownGrid getUiPatientView(String locator)
	{
		PatientDrillDownGrid uigrid = new PatientDrillDownGrid();
		List<WebElement> rows = em.getWebElements("xpath", locator);
		
		for (WebElement we : rows) {
			try {
				name = trimMultiSpace(we.findElement(By.xpath("./td[1]")).getText());
				//System.out.println(name);
				mrn = trimMultiSpace(we.findElement(By.xpath("./td[2]")).getText());
				//System.out.println(mrn);
				gender = trimMultiSpace(we.findElement(By.xpath("./td[3]")).getText());
				//System.out.println(gender);
				String date = trimMultiSpace(we.findElement(By.xpath("./td[4]")).getText());
				DOB=trimMultiSpace(date.replace('-','/'));
				//System.out.println(DOB);
			} catch (Exception e) {
				Setup.log.error("Error while fetching data from the UI.");
				Setup.testcase.assertTrue(false);
			}
			uigrid.addPatientRow(name, mrn, gender, DOB);
		}
		return uigrid;
	}
	
	
	
	/**
	 * verify(String locator,String elementmethod)
	 * This method is used to compare UI Grid data  with Database grid data for Rolling <p>
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * @param data quarter or month<p>
	 * Returns boolean true if grid from UI and Database match<p>
	 * Returns boolean false if grid from UI and Database do not match<p>
	 */

	public int verifyPatientView(String elementmethod,String locator,String data)
	{
		System.out.println("Inside Core VerifyPatientView");
		PatientDrillDownGrid dbgrid=null;
		PatientDrillDownGrid uigrid=null;
		
		dbgrid=getDatabasePatientView(getQuery("PracticeProviderPatientDrillDownViewR",data));
		System.out.println("database grid is taken");
		Setup.log.info("Db_Count:"+dbgrid);
		
		uigrid=getUiPatientView(locator);
		System.out.println("UI grid is taken");
	    Setup.log.info("Ui_Count:"+uigrid);
	     int result=0;
	     WebElement tablerow = getWebElement(elementmethod, locator);

	    try
	    {
	  			Pagination pg=new Pagination(tablerow);
	  			pg.browseFirstPage();
	  	
	  	do
	  	{		
	  		   int i=pg.getCurrentPage();
	  			String str = Integer.toString(i);
	  			
	  			System.err.println("Inside Page number "+ str + "method");
	  			System.err.println("the page number is"+" "+ str);
	  			String query=getQuery("PracticeProviderPatientDrillDownViewR",data);
	  			query=query.replace("@PageNumber",str);;
	  			dbgrid=getDatabasePatientView(query);
	  			System.out.println("database grid is taken");
	  			Setup.log.info("Db_Count:"+dbgrid);
	  			
	  			uigrid=getUiPatientView(locator);
	  			System.out.println("UI grid is taken");
	  		    Setup.log.info("Ui_Count:"+uigrid);
	  		
	  		    
	  			result=uigrid.compareTo(dbgrid); 
	  			if(result==1)
	  			{
	  				Setup.log.info("\nPatient details from Database and UI is not matched");
	  				Setup.testcase.assertTrue(true);
	  				return result;
	  			}
	  			pg.browseNextPage();
	  		}while (pg.hasNext());	
	  	
	  	}
	  	catch (Exception exsc)
	  	{
	  			Setup.log.error("Error occur in Pagination or pagination is not present on grid");
	  			return result;
	  	}
	  		return result;
	   }
		
}
