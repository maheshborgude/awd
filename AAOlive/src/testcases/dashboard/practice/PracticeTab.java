package testcases.dashboard.practice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import configuration.Setup;

public class PracticeTab {
	
	private List<String> Row;
	private List<List<String>> Table;
	
	public PracticeTab() {
		Table = new ArrayList<>();
	}
	
	public List<List<String>> setTableContent(String xpath)
	{
		WebElement table = Setup.driver.findElement(By.xpath(xpath));
		List<WebElement> rowsWE = table.findElements(By.tagName("tr"));
		for(WebElement current :rowsWE)
		{
			List<WebElement> rowData = current.findElements(By.tagName("td"));
			Row = new ArrayList<String>();
			for(WebElement currentData : rowData)
			{	
				System.out.println(" " +currentData.getText());
				Row.add(currentData.getText());
			}	
			Table.add(Row);
		}		
		Table.remove(0);
		return Table;
	}
	public void displayTableContent()
	{
		for(List<String> currentRow : Table)
			for(String currentData : currentRow)
				System.out.println(currentData);
	}
}
