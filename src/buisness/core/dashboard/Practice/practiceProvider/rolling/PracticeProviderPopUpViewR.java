package buisness.core.dashboard.Practice.practiceProvider.rolling;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.dashboard.practice.practiceProvider.*;
import configuration.Setup;

/**
 * This class is used to verify Practice Provider Pop Up view<p>
 * Class takes UI grid data and compare it with DB grid <p>
 * get the query from Object.propertis file and pass it to Super class Which is name as  Basic<p>
 *  @return comparison result of UI and Db grid 
 * @author nilesh.patil
 *Created date 4 Dec 2017
 */

public class PracticeProviderPopUpViewR extends PracticeProviderPopUpTabBasicR
{
	  private String providerName;
	  private String All;
	  private String Met;
	  private String NotMet;
	  private String Performance;
	  private String registryAverage;
      String query;
	  ConfigurationManager config;

		public  PracticeProviderPopUpViewR() 
		{
			config = new ConfigurationManager();

		}
		
		public PracticeProviderPopUpViewGrid getDBPracticeProviderPopUpData(String query)
		{
			DatabaseManger.SQLserverConnection();
		    ResultSet rs = DatabaseManger.exeQuery(query);
		    Setup.log.info("Result Set:" + rs);
		    PracticeProviderPopUpViewGrid dbgrid = new PracticeProviderPopUpViewGrid();
		    Setup.log.trace(query);
		try {
			while (rs.next()) {
				try {
					providerName = trimMultiSpace(rs.getString("providerName"));
					System.out.println(providerName);
					All = trimMultiSpace(rs.getString("All"));
					System.out.println(All);
					Met = trimMultiSpace(rs.getString("Met"));
					System.out.println(Met);
					NotMet = trimMultiSpace(rs.getString("NotMet"));
					System.out.println(NotMet);
					Performance = trimMultiSpace(rs.getString("Performance"));
					System.out.println(Performance);
					registryAverage = trimMultiSpace(rs.getString("registryAverage"));
					System.out.println(registryAverage);
				} catch (Exception e) {
					Setup.log.error("Please verify the coulumn names in queries");
				}
				dbgrid.addRowToTable(providerName, All, Met, NotMet, Performance,registryAverage);

			}
		} catch (Exception e) {
			Setup.log.error("No record in table of the database");
		}

		return dbgrid;
			
		}
		
		public PracticeProviderPopUpViewGrid getUIPracticeProviderPopUpData(String elementMethod,String locator)
		{
			PracticeProviderPopUpViewGrid uigrid = new PracticeProviderPopUpViewGrid();
			List<WebElement> rows = em.getWebElements(elementMethod, locator);
			
			for (WebElement we : rows) {
				try {
					providerName = trimMultiSpace(we.findElement(By.xpath("./td[1]")).getText());
					System.out.println(providerName);
					All = trimMultiSpace(we.findElement(By.xpath("./td[2]")).getText());
					System.out.println(All);
					Met = trimMultiSpace(we.findElement(By.xpath("./td[3]")).getText());
					System.out.println(Met);
					NotMet = trimMultiSpace(we.findElement(By.xpath("./td[4]")).getText());
					System.out.println(NotMet);
					Performance = trimMultiSpace(we.findElement(By.xpath("./td[5]/table/tbody/tr/td[2]")).getText());
					System.out.println(Performance);
					registryAverage = trimMultiSpace(we.findElement(By.xpath("./td[5]/table/tbody/tr/td[1]/div[4]")).getText());
					System.out.println(registryAverage);
				} catch (Exception e) {
					Setup.log.error("Error while fetching data from the UI.");
					Setup.testcase.assertTrue(false);
				}
				uigrid.addRowToTable(providerName, All, Met, NotMet, Performance,registryAverage);
			}
			return uigrid;

		}
		
		/**
		 *This method is used to compare UiPractice-Provider grid data  with UiPractice-Provider grid data <p>
		 * Returns boolean true if grid from UI and Database match<p>
		 * Returns boolean false if grid from UI and Database do not match<p>
		 *@author Ashwini.Gore
		 *Created date 6 Dec 2017
		 */

		public boolean verifyPracticeProviderPopUpView(String elementmethod,String locator,String data) throws SQLException
		{  
			Setup.log.info("Inside verifyPracticeProviderTable() method");
			//String query= config.getQuery("PPTTableView");
			//Setup.log.info("Query:"+query);
			PracticeProviderPopUpViewGrid dbgrid =getDBPracticeProviderPopUpData(getQuery("PracticeProviderPopUpView",data));
			Setup.log.info("Db Grid taken");
			Setup.log.info("UI Locator:"+locator);
			PracticeProviderPopUpViewGrid uigrid =getUIPracticeProviderPopUpData(elementmethod,locator);
			Setup.log.info("UI Grid taken");
			
			if(uigrid.compareTo(dbgrid)== 0) 
			{
				Setup.log.info("Practice>>Provider Tab View data from Ui and Database is matched");
				Setup.testcase.assertTrue(true);
				return true;			
			}
			else
			{
				Setup.log.info("Practice>>Provider Tab View data from Ui and Database is not matched");
				Setup.testcase.fail();
				return false;
			}
		}
		/*This method will trim all the spaces while getting the data.*/
		public String trimMultiSpace(String text) 
		{
			String string = text;
			String[] parts = string.split(" ");
			String s = new String();
			for (int i = 0; i < parts.length; i++) {
				parts[i] = parts[i].trim();
				if (!parts[i].equals(" ")) {
					s = s + "" + parts[i];
				}
			}
			return s;
			
        }
		
		/*This method will trim all the spaces while getting the data.*/
		public String trimStartEndSpace(String text) 
		{
		   String s=text.trim();
			return s;
			
        }
}

