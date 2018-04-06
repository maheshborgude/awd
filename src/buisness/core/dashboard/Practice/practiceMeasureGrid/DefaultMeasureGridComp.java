package buisness.core.dashboard.Practice.practiceMeasureGrid;

import java.sql.ResultSet;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import buisness.core.DashboardUI;
import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.dashboard.practice.practiceMeasureGrid.DefaultMeasureGrid;
import configuration.Setup;
/**
 * This class has number of methods which are being called from other child classes to get the data from DB and UI.
 * return object of DefaultMeasureGridWeb with data.
 * Return  data to validate Grid.
 * @author probeer.roy 
 * Created Date: 07/12/2017
 * 
 */
public class DefaultMeasureGridComp extends DashboardUI {
	ConfigurationManager Config;
	public buisness.core.DashboardUI DashboardUI;
	private int lowercount;
	private int highercount;

	public DefaultMeasureGridComp() {
		DashboardUI = new buisness.core.DashboardUI();
		Config = new ConfigurationManager();

	}

	/* This method gets data from UI. */
	public DefaultMeasureGrid getWebgrid(String elementmethod, String locator) {
		List<WebElement> rows = null;
		DefaultMeasureGrid DefaultMeasureGridWeb = null;
		try {
			DefaultMeasureGridWeb = new DefaultMeasureGrid();
			System.out.println("GetWebGrid method invoked.");
			rows = getWebElements(elementmethod, locator);
			System.out.println("Numbers of rows got from UI: " + rows.size());
			Setup.log.trace(locator);
			for (WebElement Table : rows) {
				// System.out.println("Coming here in Foor loop");
				String id = Table.findElement(By.xpath("./td[1]")).getText();
				// System.out.println(id);
				String measure = trimMultiSpace(Table.findElement(By.xpath("./td[2]")).getText());
				// System.out.println(measure);
				String performance = Table.findElement(By.xpath("./td[3]/table/tbody/tr/td/table/tbody/tr/td[2]"))
						.getText();
				// System.out.println(performance);
				String reg_avg = trimMultiSpace(
						Table.findElement(By.xpath("./td[3]/table/tbody/tr/td/table/tbody/tr/td[1]/div[4]")).getText());
				// System.out.println(id+ " " +measure+ " " +performance+ " " +reg_avg);
				DefaultMeasureGridWeb.add(id, measure, performance, reg_avg);
			}
		} catch (ElementNotFoundException Ex) {
			Setup.log.error("Element not Found Exception occur.");
		}
		return DefaultMeasureGridWeb;
	}

	/* This method get data from databases. */
	public DefaultMeasureGrid getDBgrid(String query) {
		System.out.println("It is now in core.DefaultMeasureGrid and call the GetDBGrid method.");
		System.out.println("Query Passed to getDBgrid: " + query);
		ResultSet resultSet = DatabaseManger.exeQuery(query);
		// System.out.println(resultSet);
		DefaultMeasureGrid DefaultMeasureGridDB = new DefaultMeasureGrid();
		Setup.log.trace(query);
		System.err.println(query);
		Setup.log.trace(resultSet);
		if (resultSet != null) {
			try {
				while (resultSet.next()) {
					String id = resultSet.getString("ID");
					// System.out.println(id);
					String measure = trimMultiSpace(resultSet.getString("Measure"));
					// System.out.println(measure);
					String performance = resultSet.getString("Performance");
					// System.out.println(performance);
					String reg_avg = trimMultiSpace(resultSet.getString("RegistryAverage"));
					// System.out.println(reg_avg);
					//System.out.println(id+ " " +measure+ " " +performance+ " " +reg_avg);
					DefaultMeasureGridDB.add(id, measure, performance, reg_avg);

				}
			} catch (Exception e) {
				Setup.log.error("Exception while fetching the data from Database");
				Setup.testcase.fail();
			}
			return DefaultMeasureGridDB;
		} else {
			return null;
		}
	}

//	/* This method trim the additional spaces from the field or sentence. */
//	public String trimMultiSpace(String text) {
//		String string = text;
//		String[] parts = string.split(" ");
//		String s = new String();
//		for (int i = 0; i < parts.length; i++) {
//			parts[i] = parts[i].trim();
//			if (!parts[i].equals(" ")) {
//				s = s + "" + parts[i];
//			}
//		}
//		return s;
//	}

	/******************************************************************
	 * This method will get the data from UI for Measure with Higher Scores
	 * only.
	 * @author probeer.roy Created Date: 23 Nov 2017
	 */
	public DefaultMeasureGrid getMeasurewithHS(String elementmethod, String locator) {
		List<WebElement> rows = null;
		DefaultMeasureGrid DefaultMeasureGridWeb = null;
		try {
			DefaultMeasureGridWeb = new DefaultMeasureGrid();
			rows = getWebElements(elementmethod, locator);
			System.out.println("Numbers of rows got from UI: " + rows.size());
			Setup.log.trace(locator);
			     highercount=0;
			for (WebElement Table : rows) {
				String id = Table.findElement(By.xpath("./td[1]")).getText();
				String measure = trimMultiSpace(Table.findElement(By.xpath("./td[2]")).getText());
				String performance = Table.findElement(By.xpath("./td[3]/table/tbody/tr/td/table/tbody/tr/td[2]"))
						.getText();
				String reg_avg = trimMultiSpace(
						Table.findElement(By.xpath("./td[3]/table/tbody/tr/td/table/tbody/tr/td[1]/div[4]")).getText());
				String tooltip = Table.findElement(
						By.xpath("./td[5]/i[@class='icon-info-sign bigger-150 light-grey tooltip-hide']")).getAttribute("title");
				
				if (tooltip.contains("Higher")) {
					this.highercount= highercount+1;
					//System.out.println(id+ " " +measure+ " " +performance+ " " +reg_avg);
					DefaultMeasureGridWeb.add(id, measure, performance, reg_avg);
				} else
					continue;
			}
			System.out.println(highercount);
		} catch (ElementNotFoundException Ex) {
			Setup.log.error("Element not Found Exception occur.");
		}
		return DefaultMeasureGridWeb;
	}

	/******************************************************************
	 * This method will get the data from UI for Measure with lower Scores only.
	 * @author probeer.roy Created Date: 23 Nov 2017
	 */
	
	public DefaultMeasureGrid getMeasurewithLS(String elementmethod, String locator) {
		List<WebElement> rows = null;
		DefaultMeasureGrid DefaultMeasureGridWeb = null;
		try {
			DefaultMeasureGridWeb = new DefaultMeasureGrid();
			rows = getWebElements(elementmethod, locator);
			//System.out.println("Numbers of rows got from UI: " + rows.size());
			Setup.log.trace(locator);
			lowercount = 0;
			for (WebElement Table : rows) {
				String id = Table.findElement(By.xpath("./td[1]")).getText();
				String measure = trimMultiSpace(Table.findElement(By.xpath("./td[2]")).getText());
				String performance = Table.findElement(By.xpath("./td[3]/table/tbody/tr/td/table/tbody/tr/td[2]"))
						.getText();
				String reg_avg = trimMultiSpace(
						Table.findElement(By.xpath("./td[3]/table/tbody/tr/td/table/tbody/tr/td[1]/div[4]")).getText());
				String tooltip =  Table.findElement(
						By.xpath("./td[5]/i[@class='icon-info-sign bigger-150 light-grey tooltip-hide']")).getAttribute("title");
			
				if (tooltip.contains("Lower")) {
					this.lowercount=lowercount+1;
					//System.out.println(id+ " " +measure+ " " +performance+ " " +reg_avg);
					DefaultMeasureGridWeb.add(id, measure, performance, reg_avg);
					
				} else
					continue;
					
			}
			System.out.println(lowercount);
		} catch (ElementNotFoundException Ex) {
			Setup.log.error("Element not Found Exception occur.");
		}
		return DefaultMeasureGridWeb;
	}
	
	public int getLowerScoresMeasuresCount(){
		int measurelowcount = this.lowercount;
		System.out.println("GetLowerCountMethod" +measurelowcount);
		return measurelowcount;
	}
	
	public int getHigherScoresMeasuresCount(){
		int measurehighcount = this.highercount;
		System.out.println("GetHigherCountMethod" +measurehighcount);
		return measurehighcount;
	}
}
