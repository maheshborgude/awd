package buisness.core.dashboard;

import java.sql.ResultSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import buisness.core.ElementMethod;
import buisness.managers.DatabaseManger;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.dashboard.PatientDrillDownGrid;
import configuration.Setup;

public class PatientDrillDown extends Basics{

	public boolean verifyPatientDrillDown(String locator)
	{
		ElementMethod em = new ElementMethod();
		if(em.verify_element("xpath", locator).equalsIgnoreCase("pass") == true)
			return true;
		
		Setup.testcase.fail();
		return false;
	}
	
	/**
	 * To verify Displayed patients in DrillDown 
	 * 
	 * @return
	 */
	public boolean verifyPatientDrillDownData(String locator,String PracticeID,String QuarterOrMonth)
	{
		PatientDrillDownGrid UIGrid = getUIPatientDrillDownData(locator);
		PatientDrillDownGrid DBGrid = getDBPatientDrillDownData(locator, PracticeID, QuarterOrMonth);
		Setup.log.info("DB grid");
		if(DBGrid.compareTo(UIGrid)==0)
			return true;
		
		Setup.testcase.fail();
		return false;
	}
	
	/**
	 * get patients data from Database
	 * 
	 * @param locator
	 * @param PracticeID
	 * @param QuarterOrMonth
	 * @return
	 */
	public PatientDrillDownGrid getDBPatientDrillDownData(String locator, String PracticeID,String QuarterOrMonth)
	{
		PatientDrillDownGrid grid = new PatientDrillDownGrid();
		String xpathForMeasureName = locator + "//div[@class=\"activeCls word-break\"]";
		String patientquery;
		//System.out.println(xpathForMeasureName);
		
		WebElement displayedMeasureIDWE = Setup.driver.findElement(By.xpath(xpathForMeasureName));
		
		String displayedMeasureID = displayedMeasureIDWE.getText();
		

		//TODO: Put this in separate function
	    Pattern p = Pattern.compile("(^|\\s)([0-9]+)($|\\s)");
	    Matcher m = p.matcher(displayedMeasureID);
	    if (m.find()) 
	    {
	    	displayedMeasureID = m.group(2);
	    }
	    else
			Setup.log.error("Measure ID and name is not displayed");
	    
	    //If Starting String is numeric means it is Quarterly as Duration is like 2014Q4 or June2014
	    if( Character.isDigit(QuarterOrMonth.charAt(0)) ==true )
	    {
	    	patientquery = pr.getQuery("MeasureComputationPracticeRollingQuarterly");
	    }
	    else
	    {
	    	patientquery =  pr.getQuery("MeasureComputationPracticeRollingMonthly");
	    }
	    
	    Setup.log.debug("Query used: " +  patientquery);
	    
	    patientquery = patientquery.toLowerCase();
	    patientquery = patientquery.replace("@measureid", displayedMeasureID);
	    patientquery = patientquery.replace("@practiceuid",getPracticeuid(PracticeID) );
	    patientquery = patientquery.replace("@quarterormonth",QuarterOrMonth.replace(" ", "").replace("-", "") );
	    
	    Setup.log.trace(patientquery);
	    
	    //Query to find database and 
	    String ServerNameAndDatabaseQuery = pr.getQuery("ServerNameAndDatabaseQuery");
	    ServerNameAndDatabaseQuery = ServerNameAndDatabaseQuery.toLowerCase();
	    ServerNameAndDatabaseQuery = ServerNameAndDatabaseQuery.replace("@practiceid",PracticeID);
	    
	    String servername=null,databasename=null;
	  
	    try
	    {
	    	ResultSet rs = DatabaseManger.exeQuery(ServerNameAndDatabaseQuery);
	    	if(rs.next())
	    	{
	    		servername = rs.getString("servername");
	    		databasename = rs.getString("databasename");
	    	}
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    	return null;
	    }
	    
	    String PatientDrillDownQuery = pr.getQuery("PatientDrillDownQuery");
	    PatientDrillDownQuery = PatientDrillDownQuery.toLowerCase();
	    
	    PatientDrillDownQuery = PatientDrillDownQuery.replace("@servername", servername);
	    PatientDrillDownQuery = PatientDrillDownQuery.replace("@databasename", databasename);
	    PatientDrillDownQuery = PatientDrillDownQuery.replace("@innerquery", patientquery );

		Setup.log.trace(PatientDrillDownQuery);
	    
	    try 
	    {
	    	ResultSet rs = DatabaseManger.exeQueryWeb(PatientDrillDownQuery);
	    	String Name,MRN,Gender,DOB;
	    	while(rs.next())
	    	{
	    		Name = rs.getString("name");
	    		MRN = rs.getString("mrn");
	    		Gender = rs.getString("gender");
	    		DOB = rs.getString("dob").replace("/", "-");
	    		//grid.addMeasureRow(Name, MRN, Gender, DOB);
	    	}
		} catch (Exception e) 
	    {
			e.printStackTrace();
		}
		return grid;
	}
	/**
	 * Get data from UI
	 * 
	 * @param locator
	 * @return
	 */
	public PatientDrillDownGrid getUIPatientDrillDownData(String locator)
	{
		String Name,MRN,Gender,DOB;
		PatientDrillDownGrid Grid = new PatientDrillDownGrid();
		ConfigurationManager pr = new ConfigurationManager();
    	try 
    	{
    		String cursorAttrib;
    		WebElement PopDrillDownMetWindow = Setup.driver.findElement(By.xpath(locator));
    		WebElement PopDrillDownMetPaginationNextButton ;
    		List<WebElement> PopDrillDownMetDataRow;
    		do
    		{
    			PopDrillDownMetPaginationNextButton = PopDrillDownMetWindow.findElement(
				By.xpath(pr.read_ObjectRepositoryfile("PopDrillDownMetPaginationNextButton")));
    			//new WebDriverWait(Setup.driver,60).until(ExpectedConditions.stalenessOf(element)));		
    			
    			PopDrillDownMetDataRow = PopDrillDownMetWindow.findElements(By.xpath(pr.read_ObjectRepositoryfile("PopDrillDownMetData")));
    			
    			for(WebElement currentRow : PopDrillDownMetDataRow)
    			{
    				Name = currentRow.findElement(By.xpath("./td[1]")).getText();
    				MRN = currentRow.findElement(By.xpath("./td[2]")).getText();
    				Gender = currentRow.findElement(By.xpath("./td[3]")).getText();
    				DOB = currentRow.findElement(By.xpath("./td[4]")).getText();
    			//	Grid.addMeasureRow(Name, MRN, Gender, DOB);
    			}
    			
    			cursorAttrib = PopDrillDownMetPaginationNextButton.getCssValue("pointer-events");
    			PopDrillDownMetPaginationNextButton.click();
    			
    			//new WebDriverWait(Setup.driver,60).until(ExpectedConditions.visibilityOfElementLocated(By.id(".//*[@id='btnExportToExcel']")));

    			Thread.sleep(3000);

				Setup.log.info(cursorAttrib);
    		}while(cursorAttrib.equals("auto") == true);
    		
		} catch (InterruptedException e) 
    	{
			Setup.log.error("Thread inturupted");
			e.printStackTrace();
		}
		return Grid;
	}
	
}
