package buisness.core.dashboard.Practice;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import buisness.core.dashboard.Basics;
import buisness.managers.DatabaseManger;
import configuration.Setup;

/**
 * 
 * @author abhishek.gaikwad
 *
 */
public class MeasureID extends Basics{
	
	protected List<String> displayedmeasureID;
	protected List<String> dbmeasureID;
	protected String query;
	
	/**
	 * As MeasureId on UI is appended With with RegName so it need to be verified separately  
	 * 
	 * @param locator
	 * @return
	 */
	public boolean verifyMeasureID(String locator)
	{
		//As MeasureId on UI is appended With with RegName so it need to be verified separately  
		List<String> displayedmeasureID = getDisplayedMeasureID(locator);
		List<String> dbmeasureID = getDBMeasureID();
		if (displayedmeasureID.equals(dbmeasureID))
			return true;
		
		Setup.testcase.fail();
		return false;
	}

	/**
	 * Registry specific Measure ID are retrieved from database appended with registry name
	 * 
	 * @return
	 */
	public List<String> getDBMeasureID()
	{
		List<String> dbmeasureID = new ArrayList<String>();
		
		query = pr.getQuery("MeasureIDforRegistry");
		try
		{
			ResultSet rs = DatabaseManger.exeQueryWeb(query);
			String currentMeasureID = null;
			String RegistryName = pr.read_Configfile("RegistryNameForMeasure");
			while(rs.next())
			{
				currentMeasureID = rs.getString("MeasureID");
				// Measure ID are appended with registry name Eg. IPRO 01, so we have to append the our MeasureID from Database 
				currentMeasureID = RegistryName + " " + currentMeasureID;
				dbmeasureID.add(currentMeasureID);
			}
		}
		catch(SQLException e)
		{
			Setup.log.error("Error occur in featch data from databas");
		}
		catch( Exception e)
		{
			e.printStackTrace();
		}
		return dbmeasureID;
	}
	
	
	/**
	 * Get measure displayed on UI in Measure Grid
	 * 
	 * @param locator
	 * @return
	 */
	public List<String> getDisplayedMeasureID(String locator)
	{
		List<String> displayedmeasureID = new ArrayList<String>();
		
		List<WebElement> measureIDs = Setup.driver.findElements(By.xpath(locator));
		
		for(WebElement currentElement : measureIDs)
		{
			displayedmeasureID.add(currentElement.getText());
		}
		return displayedmeasureID; 
	}
	
	public String getQuery() 
	{
		return query;
	}

	public void setQuery(String query) 
	{
		this.query = query;
	}
}
