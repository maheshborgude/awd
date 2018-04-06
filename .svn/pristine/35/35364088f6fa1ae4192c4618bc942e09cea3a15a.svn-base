package buisness.core.mipss;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebElement;

import buisness.core.DashboardUI;
import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.administration.usermanagement.UsermanagementGrid;
import buisness.util.datastructures.mipsutil.Mipscliniciangrid;
import configuration.Setup;

abstract public class ProviderGridmips  extends DashboardUI  {


    ConfigurationManager config;
	
	public ProviderGridmips() 
	{
		config = new ConfigurationManager();
	
	}
	 
		/**
		 * getDBLocationListit()<p>
		 * Returns Mipscliniciangrid object containing all clinicians and their details available<p>
		 * for logged in user in the database<p>
		 *  @return dbgrid which contains all database rows 
		 * @author
	     *
		 */
	public Mipscliniciangrid getDatabaseGrid(String query) 
	{
//	 DatabaseManger.SQLserverConnection();
//	String query = config.getQuery("LocationEnlisted");
//   query=query.replace("@loginuser",getLoggedInUser());
		 System.out.println("Get data from Database");
    ResultSet rs = DatabaseManger.exeQuery(query);
    System.out.println(rs);
    Mipscliniciangrid dbgrid = new Mipscliniciangrid();
        Setup.log.trace(query);
        Setup.log.trace(rs);
	
		try {
			while(rs.next())
{
				try {
					String PROVIDERNAME = rs.getString("PROVIDERNAME");
					System.out.println(PROVIDERNAME);
					String MIPSELIGIBILITY= rs.getString("MIPSELIGIBILITY");
					String NPI= rs.getString("NPI");
					String TIN= rs.getString("TIN");
					String QUALITY= rs.getString("QUALITY");
					String ACI= rs.getString("ACI");
					String IA= rs.getString("IA");
					String MIPSFINALSCORE= rs.getString("MIPSFINALSCORE");
					String SUBMISSIONSTATUS= rs.getString("SUBMISSIONSTATUS");
					
					
			        Setup.log.info(PROVIDERNAME+MIPSELIGIBILITY+NPI+TIN+QUALITY+ACI+IA+MIPSFINALSCORE+SUBMISSIONSTATUS);
				   dbgrid.addPopupuserGridcountRow1(PROVIDERNAME,MIPSELIGIBILITY,NPI,TIN,QUALITY,ACI,IA,MIPSFINALSCORE,SUBMISSIONSTATUS);
				} catch (SQLException e)
				{
					Setup.log.warn("Please verify the coulumn  input query in   Queries.properties file");
					Setup.log.debug(e.getMessage());
					return null;
				}
       
}
		} catch (SQLException e) 
		{
			Setup.log.debug("Please verify input query in Queries.properties file");
			e.printStackTrace();
		}	

	
		return dbgrid;
		
	}
	/**
	 * getWebGrid(String locator)<p>
	 * Returns Mipscliniciangrid object containing  providers and their details available<p>
	 * for logged in user in the database<p>
	 * @param locator<p>
	 * @return uigrid which contains all the UI Data 
	 * 
	 * @author nilesh.patil
     *Created date 29 Jan 2016
	 */
	public Mipscliniciangrid getWebGrid(String locator,String elementmethod)
	{
		

		Mipscliniciangrid uigrid = null;
		List<WebElement> rows = null;
		
		try {
			uigrid = new Mipscliniciangrid();
			 rows = getWebElements(elementmethod, locator);
			//Setup.log.debug(locator);
		} catch (InvalidSelectorException e1)
		{
			Setup.log.error("Please verify xpath in Object repository file");
			e1.printStackTrace();
		}

		try {

			for(WebElement we : rows)
			{

				String PROVIDERNAME = we.findElement(By.xpath("./td[2]")).getText();
			    String MIPSELIGIBILITY = we.findElement(By.xpath("./td[3]")).getText();
				String NPI = we.findElement(By.xpath("./td[4]")).getText();
			    String TIN = we.findElement(By.xpath("./td[5]")).getText();
				String QUALITY = we.findElement(By.xpath("./td[6]")).getText();
				String ACI = we.findElement(By.xpath("./td[7]")).getText();
				String IA = we.findElement(By.xpath("./td[8]")).getText();
				String MIPSFINALSCORE = we.findElement(By.xpath("./td[9]")).getText();
				String SUBMISSIONSTATUS = we.findElement(By.xpath("./td[10]")).getText();
				
				
				Setup.log.info(PROVIDERNAME+MIPSELIGIBILITY+NPI+TIN+QUALITY+ACI+IA+MIPSFINALSCORE+SUBMISSIONSTATUS);
				uigrid.addPopupuserGridcountRow1(PROVIDERNAME,MIPSELIGIBILITY,NPI,TIN,QUALITY,ACI,IA,MIPSFINALSCORE,SUBMISSIONSTATUS);
			}
		} catch (Exception e) 
		{
			Setup.log.error("Error while fetching the data from the UI");
			e.printStackTrace();
		}
		
		return uigrid;
		
	}
}
		
		
		
