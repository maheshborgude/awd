
package buisness.core.mipss;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import buisness.awadhesh.datastructures.mips.MipsNanogrid;
import buisness.core.DashboardUI;
import buisness.managers.DatabaseManger;
import configuration.Setup;

public class Mipsnanogridcorebase extends DashboardUI {
	

	/**
	 * This class compare Data row of MIPS Provider
	 *   
	 * @param locator
	 * @return Object of specified class
	 */

public MipsNanogrid getWebGrid(String elementmethod, String locator)
{
	System.out.printf("the captured x path is ",locator);
	Setup.log.trace(locator);
	if(locator!=null)
		
	{
		MipsNanogrid MipsNanogrid=new MipsNanogrid();
		try
		{
			List<WebElement> rows = getWebElements(elementmethod, locator);
			for(WebElement table : rows)
			{
				String PROVIDERNAME = table.findElement(By.xpath("./td[2]")).getText();
				String PROVIDERNAMET=super.trimMultiSpace(PROVIDERNAME).trim();
				Setup.log.info(PROVIDERNAMET);
				
				
			}
		}
		catch(Exception e)
		{
			Setup.log.error(e);
			Setup.log.error("Please check xpath in ObjectRepositary.Properties file ");
		}
		return MipsNanogrid;
	}
	else
	{
		Setup.log.error("The Xpath of WebGrid is incorrect or missing ");
		return null;
	}
	
}
	/**
	 * This method is used to get data from Database and return a object with Grid value<p>
	 * This class compare Data row of Location popup  present on Dashboards >> Practice Location popup
	 *   present on selecting measure
	 * @return Object of specified class
	 */
	
	

	public MipsNanogrid getDatabaseGrid(String query)
	{
		DatabaseManger.SQLserverConnection(); 	
		ResultSet resultSet= DatabaseManger.exeQuery(query);
		MipsNanogrid MipsNanogrid=new MipsNanogrid();
		Setup.log.trace(query);
		if(resultSet != null)
		{

			//Mipsprovidergrid.add(PROVIDERNAME, MIPSELIGIBILITY,NPI,TIN,QUALITY,ACI,IA);
			///Mipsprovidergrid.add(PROVIDERNAMET, MIPSELIGIBILITYT,NPI,TIN,QUALITYT,ACIT,IAT);
			try {
				while(resultSet.next())
				{
					//String LocationName, String Qualified, String Met, String NotMet,String Performance,String RegistryBenchmark    PracticeLocationPopUpGridRow

					String PROVIDERNAME = resultSet.getString("PROVIDERNAME");
					String PROVIDERNAMET=super.trimMultiSpace(PROVIDERNAME).trim();
					Setup.log.info(PROVIDERNAMET);
					
				
					

					MipsNanogrid.add(PROVIDERNAMET);
				}

			}
			catch(SQLException ex)
			{
				Setup.log.error("Please check query in 'Queries.properties.");
				Setup.testcase.fail();
			}
			catch(Exception excp)
			{
				Setup.log.error("query in 'Queries.properties is correct.");
				Setup.testcase.fail();
			}
			return MipsNanogrid;
		}

		else
		{
			Setup.log.error("Nothing to return hence return the NULL");
			return null;
		}
	}
}	
	
	


