package buisness.core.dashboard.provider.rolling;

import java.sql.ResultSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import buisness.core.DashboardUI;
import buisness.core.ElementMethod;
import buisness.core.dashboard.provider.ProviderPatientDrillDownCount;
import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import configuration.Setup;

public class DetailedPPDrillDownCountR extends ProviderPatientDrillDownCount {
	ElementMethod Ele = new ElementMethod();
	DashboardUI Dash = new DashboardUI();
	public String quarter;
	public String uiCount;
	public String dbCount;
	public String measureuid;
	public String query;
	public String getmeasurename;
	public boolean verifyDetailedPPDrillDownCountR(String elementmethod, String locator, String data) {

		ConfigurationManager config = new ConfigurationManager();
		
	
		List<WebElement> Provider = getWebElements(elementmethod, locator);
		int noofproviders = Provider.size();
		System.out.println("Number of providers are " + noofproviders);

		for (WebElement Table : Provider) {
			Table.findElement(By.xpath(".//tr/td[1]/a/i")).click();
			String getProvidername = Table.findElement(By.xpath(".//tr/td[1]/a")).getText();
			System.out.println("---- "+getProvidername+ " ----");
			
			String mlocator = config.read_ObjectRepositoryfile("PracticeMeasure_Grid");
			List<WebElement> Measures = getWebElements("xpath", mlocator);
		
			MeasureLoop: for (WebElement Table1 : Measures) {

				Table1.findElement(By.xpath("./td[1]/i")).click();
				measureuid = getSelectedMeasureUID();
				
				String ptlocator = ".//*[@class='providermeasuredetaildata']/div[2]/div[2]/table[@id='" + measureuid
						+ "']//tbody/tr";
				List<WebElement> PerformanceTrend = getWebElements("xpath", ptlocator);
				getmeasurename = getSelectedMeasureDetails();
				System.out.println("Measure: " +getmeasurename);

				PTtable: for (WebElement Table2 : PerformanceTrend) {
					query = config.getQuery("ProviderPatientDrillDownCountR");
					query = query.replace("@loginuser", getLoggedInUser());
					query = query.replace("@provideruid", newwayProviderUid());
					query = query.replace("@measureuid", measureuid);
					quarter = Table2.findElement(By.xpath("./td[1]")).getText();
					System.out.println(quarter);
					String getmetcount = Table2.findElement(By.xpath("./td[3]/a")).getText();
					System.out.println("getmetcountis" +getmetcount);
					Table2.findElement(By.xpath("./td[3]/a")).click();
					String Pagecountlocator = config.read_ObjectRepositoryfile("ProviderPatientDrillDownCountR");
					String countlocator = config.read_ObjectRepositoryfile("ProviderPatientDDNoPaginationCountR");
					Ele.wait_click("xpath", Pagecountlocator);
					
					if (Integer.parseInt(getmetcount)>15) {
						Pagecountlocator =Pagecountlocator + "/b";
						System.out.println("replaced query:"  + query);
						query = query.replace("@quartermonth", quarter);
						System.out.println("query passed:" +query);
						dbCount=getdatabasecount(query);
						//System.out.println(quarter+ " = " +uiCount);
						Ele.wait_click("xpath", config.read_ObjectRepositoryfile("PatientDrillDownCloseButton"));
						Ele.click_element("xpath", config.read_ObjectRepositoryfile("PatientDrillDownCloseButton"));
						
					} else {

						uiCount = getuicount("xpath", countlocator);
						query = query.replace("@quartermonth", quarter);
						System.out.println("query passed:" +query);
						dbCount=getdatabasecount(query);
						//System.out.println(quarter+ " = " +uiCount);
						Ele.wait_click("xpath", config.read_ObjectRepositoryfile("PatientDrillDownCloseButton"));
						Ele.click_element("xpath", config.read_ObjectRepositoryfile("PatientDrillDownCloseButton"));

					}
					Setup.log.info(quarter+ " Ui_Count " +uiCount);
					Setup.log.info(quarter+ " Db_Count " +dbCount);
	
					if (uiCount != null) {
						if(uiCount.equals(dbCount))
						{
							Setup.log.info("\nCount from Database and UI getting matched");
							Setup.log.trace("\nCount from Database and UI getting matched");
							continue;
						}
					 else{
						 Setup.log.info("\nCount from Database and UI is not getting matched");
						Setup.log.trace("\nCount from Database and UI is not getting matched");
						Setup.testcase.fail();
					   return false;
					}
				}
				}
				Ele.click_element("xpath", config.read_ObjectRepositoryfile("SelectedRandomMeasure"));
			}
			Ele.click_element("xpath", config.read_ObjectRepositoryfile("SelectedRandomProvider"));
		}
		Setup.testcase.assertTrue(true);
		return true;

	}

}
