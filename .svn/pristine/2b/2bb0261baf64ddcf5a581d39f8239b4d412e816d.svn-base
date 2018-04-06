package buisness.core.administration.provider;

import java.sql.SQLException;

import org.openqa.selenium.WebElement;

import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.administration.provider.DashboardLocationProviderGrid;
import buisness.util.helpers.Pagination;
import configuration.Setup;
/**Verifies Pagination for Administrator>>Provider Grid<p>
 * Extends ProviderTable<p>
 * @author Sachin.Gawade<p>
 * Created Date: 10 Feb 2016
 * 
 */
public class ProviderPagination extends Provider
{
	public String query;
	
	public ProviderPagination()
	{
		super();
	}
	
	/**
	 * Replaces variables present in Query(obtained from object repository) 
	 * @param locator
	 * @param currentPage
	 * @return query as String
	 */
	public String getQuery(String locator, int currentPage)
	{
		config = new ConfigurationManager();
		query = config.getQuery("ProviderPagination");
		query=query.replace("@loginuser",getLoggedInUser());
		query=query.replace("@pagenumber",String.valueOf(currentPage));
		return query;
	}
	/**
	 * This method is used to test all scenarios for Pagination<p>
	 * First, Last, Next, Previous button are verified.<p>
	 * @param locator
	 * @return Boolean true or false based on the comparison of ui grid and database <p>
	 * with respect to pagination button<p>
	 * @throws SQLException
	 * @throws InterruptedException
	 */
	public boolean verify(String elementmethod,String locator) throws SQLException, InterruptedException
	{
		WebElement table =  getWebElement("xpath", locator);
		Pagination at=new Pagination(table);
	
		Thread.sleep(1000);
		at.browseLastPage();

		if(verifyPagination(elementmethod,locator,at.getCurrentPage()))
		{
			
			at.browsePreviousPage();
			if(verifyPagination(elementmethod,locator,at.getCurrentPage()))
			{
				
				at.browseFirstPage();
				if(verifyPagination(elementmethod,locator,at.getCurrentPage()))
				{
				
					at.browseNextPage();
					if(verifyPagination(elementmethod,locator,at.getCurrentPage()))
					{
						
						Setup.log.trace("Pagination successfully verified.");
						Setup.testcase.assertTrue(true);
						return true;
					}
					else
					{
						Setup.log.error("UI grid and database table do not match for "+(at.getCurrentPage()+1));
						Setup.testcase.fail();
						return false;
					}
				}
				else
				{
					Setup.log.error("UI grid and database table do not match for "+(at.getCurrentPage()+1));
					Setup.testcase.fail();
					return false;
				}
			}
			else
			{
				Setup.log.error("UI grid and database table do not match for "+(at.getCurrentPage()+1));
				Setup.testcase.fail();
				return false;
			}
		}
		else
		{
			Setup.log.error("UI grid and database table do not match for "+(at.getCurrentPage()+1));
			Setup.testcase.fail();
			return false;
		}
		/*em.click_element("xpath","GridPreviousButton");
		em.click_element("xpath","GridFirstButton");
		em.click_element("xpath","GridNextButton");*/
		//return true;
	}
	
	/**
	 * Compares UI grid and database records
	 * @param locator
	 * @param currentPage
	 * @return Boolean true or false based on the comparison of ui grid and database <p>
	 * @throws SQLException
	 */

	public boolean verifyPagination(String elementmethod,String locator, int currentPage) throws SQLException
	{
		DashboardLocationProviderGrid dbgrid =getDBProviderList(getQuery(locator,currentPage));
		DashboardLocationProviderGrid uigrid =getUIProviderlist(locator);

		if(uigrid.compareTo(dbgrid)== 0) 
		{
			Setup.log.trace("UI grid and database table match");
			return true;			
		}
		else
		{
			Setup.log.trace("UI grid and database table do not match");
			return false;
		}
	
	}
	
	
}
