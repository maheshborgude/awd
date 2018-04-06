package buisness.core.dashboard;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import buisness.managers.DatabaseManger;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.dashboard.MeasureComputationSummaryGrid;
import configuration.Setup;

public class MeasureComputation extends Basics {
	
	
	
	public boolean verifyPopupMeasureSummary(String xpath,String QuarterMonth,String practiceId)
	{
		boolean measureInvalidFlag=false;
		List<WebElement> MeasuresElements = Setup.driver.findElements(By.xpath(xpath));
		WebElement closebutton; 
		ConfigurationManager pr =  new ConfigurationManager(); 
		WebDriverWait wt = new WebDriverWait(Setup.driver, 20);	
		

		for(WebElement we : MeasuresElements)
		{
			try 
			{
				//we.findElement(By.xpath(".//td[@class='nobrder no-border-top']"));
				//String measureValuePracticeTab = we.getText();
				//System.out.println(measureValuePracticeTab);
				//System.out.println(we.findElement(By.xpath("..")).getAttribute("id").substring(2));
				
				//<TR> tag which is parent of current element contain measureuid with prefix tr 
				String measureuid= we.findElement(By.xpath("..")).getAttribute("id").substring(2);
				
				
				
				//System.out.println("Data from DB");
				//getDBQuarterData(practiceId,measureuid);
				//System.out.println("Data from UI");
				
				
				
				we.click();
				wt.until(ExpectedConditions.visibilityOf(Setup.driver.findElement(By.xpath(".//*[@id='ModalSummryProviderLocationPractice']"))));
				wt.until(ExpectedConditions.visibilityOf(Setup.driver.findElement(By.xpath(pr.read_ObjectRepositoryfile("PopupCloseButton")))));
				wt.until(ExpectedConditions.visibilityOf(Setup.driver.findElement(By.xpath(".//*[@id='divPerformanceTrande']//table/tbody"))));
				
				//getUIQaurterData();
				comparemeasuresummary(practiceId, QuarterMonth ,measureuid);
				closebutton = Setup.driver.findElement(By.xpath(pr.read_ObjectRepositoryfile("PopupCloseButton")));
				closebutton.click();
				wt.until(ExpectedConditions.visibilityOf(we));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(measureInvalidFlag==true)
		{
			Setup.testcase.fail();
			return false;
		}
		else
			return true;
	}
	
	/**
	 * Compares MeasureComputaionSummary of Database and UI 
	 * 
	 * @param practiceId should be used for database
	 * @param measureuid should be used for database
	 * @return
	 */
	public boolean comparemeasuresummary(String practiceId,String QuarterMonth,String measureuid)
	{
		MeasureComputationSummaryGrid db_summary = getDBQuarterData(practiceId,QuarterMonth,measureuid);
		MeasureComputationSummaryGrid ui_summary = getUIQaurterData();
		
		//db_summary.print();
		
		if( db_summary.compareTo(ui_summary) == 1)
		{
			Setup.log.info("Different!!");
			Setup.log.info("Measure Computation Summary is ");
			Setup.testcase.fail();
			return false;
		}
		else
		{
			//System.out.println("Same-------");
			return true;
		}
	}
	
	/**
	 * Retrieve data from respective database for given practiceId and MeasureID
	 * and stores them MeasureComputationSummary object 
	 * 
	 * @param practiceId practice ID for which the Data is required
	 * @param MeasureUId MeasureUID for which the data is required
	 * @return MeasureComputationSummary containing data for specified practice and measure
	 * @author abhishek.gaikwad
	 */
	private MeasureComputationSummaryGrid getDBQuarterData(String practiceId,String QuarterMonth,String MeasureUId)
	{
		MeasureComputationSummaryGrid db_summary = new MeasureComputationSummaryGrid();
		
		String query = "select QuarterName,Denominator,Numerator,NotMet,(Average*100) 'Average' "
				+ "from ViewMeasureComputationSummary CS "
				+ "where practiceuid= '"+getPracticeuid(practiceId)+"' "
				+ "and provideruid is null and locationuid is null "
				+ "and Flag= (select distinct Flag from ViewMeasureComputationSummary where QuarterName='" + QuarterMonth.trim() + "' )" 
				+ "and NationalProgramQualityMeasureUid='" + MeasureUId + "' " 
				+ "and quarterEndDate <= (select distinct quarterEndDate from ViewMeasureComputationSummary where QuarterName='" + QuarterMonth.trim() + "' )"
				+ " order by cast(quarterEndDate as date) desc";

		Setup.log.trace(query);
		
		String monQuat;
		int AllPatients;
		int Met;
		int NotMet;
		float percentage;
		try 
		{
			//System.out.println(query);
			ResultSet rs = DatabaseManger.exeQueryWeb(query);
			while(rs.next())
			{
				
				monQuat		= rs.getString("QuarterName");
				AllPatients	= rs.getInt("Denominator");
				Met 		= rs.getInt("Numerator");
				NotMet		= rs.getInt("NotMet");
				percentage	= rs.getFloat("Average");
				
				//System.out.println( monQuat + "\t" +AllPatients + "\t" + Met + "\t" + NotMet + "\t" + percentage) ;				
				db_summary.addMeasureRow(monQuat, Integer.toString(AllPatients), Integer.toString(Met), Float.toString(NotMet), Double.toString(percentage));
			}
			return db_summary;
		} 
		catch (SQLException e) 
		{
			Setup.log.error("Something went wrong!!");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Gets all displayed row of data on the pop up opened after clicking the measure
	 * and add them to MeasureComputationSummary object
	 * 
	 * @author abhishek.gaikwad
	 * @return  MeasureComputationSummary Object contain all data on UI
	 */
	private MeasureComputationSummaryGrid getUIQaurterData()
	{
		List<WebElement> rows =   Setup.driver.findElements(By.xpath(".//*[@id='divPerformanceTrande']//tbody/tr"));
		MeasureComputationSummaryGrid ui_summary = new MeasureComputationSummaryGrid();
		String monQuat;
		int AllPatient;
		int Met;
		int NotMet;
		float percentage;
		
		for(WebElement currentRow : rows)
		{
			monQuat		= currentRow.findElement(By.xpath(".//td[1]")).getText();
			AllPatient	= Integer.valueOf( currentRow.findElement(By.xpath(".//td[2]")).getText());
			Met 		= Integer.valueOf( currentRow.findElement(By.xpath(".//td[3]")).getText());
			NotMet		= Integer.valueOf( currentRow.findElement(By.xpath(".//td[4]")).getText());
			percentage	= Float.valueOf(  currentRow.findElement(By.xpath(".//td[5]")).getText().replace("%", ""));
			
			ui_summary.addMeasureRow(monQuat, Integer.toString(AllPatient), Integer.toString(Met), Integer.toString(NotMet), Float.toString(percentage));
			//System.out.println(monQuat+"\t"+AllPatient +"\t"+Met +"\t"+ NotMet +"\t"+ percentage);
		}
		Setup.log.info("--");
		return ui_summary;
	}
}
