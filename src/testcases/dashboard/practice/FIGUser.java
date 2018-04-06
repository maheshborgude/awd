package testcases.dashboard.practice;

import java.awt.Color;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import buisness.core.ElementMethod;
import buisness.core.login.LoginUtility.FIGUserType;
import buisness.managers.DatabaseManger;
import buisness.managers.ConfigurationManager;
import configuration.Setup;

public class FIGUser {
	
	private String userName;
	private String password;
	private String FIGUserUID;
	public LinkedList<String> PracticeUId;
	private FIGUserType userType;
	private Color progressbarcolor=null;
	private ConfigurationManager pr;
	private ElementMethod em;
	
	public FIGUser(String FIGUserUid) 
	{
		this.FIGUserUID = FIGUserUid;
		PracticeUId = new LinkedList<String>();
		new ElementMethod();
		setUserType();
		setPracticeUID();
		pr = new ConfigurationManager(); 
		em = new ElementMethod();
	}
	
	public boolean verifyTabName(String locator)
	{
		List<String> tabnames = getPopupTabName(locator);
		
		if( tabnames.get(0).equals("PERFORMANCE TREND") 
				&& tabnames.get(1).equals("LOCATIONS")  &&	tabnames.get(2).equals("PROVIDERS") 
				&& tabnames.get(3).equals("ALL") )
			return true;
		
		Setup.testcase.fail();
		return false;
	}
	
	public List<String> getPopupTabName(String locator)
	{
		List<String> tabnames  = new ArrayList<String>();
		
		for(WebElement currentElememt :  Setup.driver.findElements(By.xpath(locator)))
			tabnames.add( currentElememt.getText() );
		
		return tabnames;
	}
	public String getUIReportDuration(String locator)
	{
		WebElement we = Setup.driver.findElement(By.xpath(locator));
		String currentDuration = new Select(we).getFirstSelectedOption().getText();
		return currentDuration;
	}
	
	public boolean verifyReportDuration(String locator,String practiceId)
	{
		String UIDuration = getUIReportDuration(locator).trim();
		String DBDuration = getDBLatestReportDuration(practiceId);
		
		if(UIDuration.equals(DBDuration))
			return true;
		
		Setup.testcase.fail();
		return false;
	}
	
	public String getDBLatestReportDuration(String practiceId)
	{
		String latestQuarterOrMonth=null;
		String query = pr.getQuery("LatestQuaterOrMonthQuery");
		query = query.replace("@practiceuid", getPracticeuid(practiceId));
		try
		{
			ResultSet rs = DatabaseManger.exeQueryWeb(query);
			if(rs.next())
				latestQuarterOrMonth = rs.getString(1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return latestQuarterOrMonth;
	}
	
	
	/**
	 *  Compares measure count from UI and Database
	 * @param locator
	 * @return
	 */
	public boolean verifyMeasureCount(String locator)
	{
		int countFromUI = getUIMeasureCount(locator);
		int countFromDB = getDBMeasureCount();
		
		//System.out.println(countFromUI);
		//System.out.println(countFromDB);
		
		if( countFromUI == countFromDB )
			return true;
		
		Setup.log.error("Count from UI and DB does not match, Count from UI is " + countFromUI + ", "
				+ "and count from Database is " + countFromDB);
		Setup.testcase.fail();
		return false;
	}
	
	/**
	 * Measure Count DB
	 * @return
	 */
	public int getDBMeasureCount()
	{
		String query = pr.getQuery("MeasureIDCount");
		int CountfromDB=0;
		try 
		{
			ResultSet rs = DatabaseManger.exeQueryWeb(query);
			if(rs.next())
				CountfromDB = rs.getInt(1);
			else
				System.out.println("No count has been returned");
			
		}
		catch (Exception e) 
		{

		}
		return CountfromDB;
	}
	/**
	 * Get UI count of measure, and strips all non-numeric values
	 * @param locator
	 * @return
	 */
	public int getUIMeasureCount(String locator)
	{
		// The String from UI contains text like "Total Records: 32" ,so we have to strip all character from it
		String TotalCountfromUI = em.gettext("xpath", locator).replaceAll("[^\\d]", "");
		
		return Integer.parseInt(TotalCountfromUI);
	}
	
	
	
	
	
	/**
	 * Searches for PracticeUID in practice table of Management Database for given practiceid
	 * Return practiceuid if practice present else returns NULL
	 * 
	 * @param practiceId 
	 * @return practiceuid
	 */
	public String getPracticeuid(String practiceId)
	{
		String query = "select practiceuid c from practice where externalid=" + practiceId;
		
		//System.out.println("practice id is :" + practiceId);
		return DatabaseManger.getQuery(query).get(0);
	}
	/**
	 * 
	 * @param QuarterMonth
	 * @return
	 * @author abhishek.gaikwad
	 */
	public String getQuaterOrMonthDate(String QuarterMonth)
	{
		String query = "select distinct quarterEndDate from ViewMeasureComputationSummary where QuarterName = '" + QuarterMonth + "'";
		
		try 
		{
			ResultSet rs = DatabaseManger.exeQueryWeb(query);
			if(rs.next())
				return ( rs.getString("quarterEndDate") );
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param QuarterMonth
	 * @return
	 * @author abhishek.gaikwad
	 */
	public String getQuaterOrMonthFlag(String QuarterMonth)
	{
		String query = "select distinct Flag from ViewMeasureComputationSummary where QuarterName = '" + QuarterMonth + "'";
		
		try 
		{
			ResultSet rs = DatabaseManger.exeQueryWeb(query);
			if(rs.next())
				return ( rs.getString("Flag") );
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	
	public boolean verifyPopupProgressBarColor(String xpath)
	{
		return false;
	}
	public boolean verifyPopup(String xpath)
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
				String measureValuePracticeTab = we.findElement(By.xpath(".//td[@class='nobrder no-border-top']")).getText();
				//System.out.println(measureValuePracticeTab);
				we.click();
				wt.until(ExpectedConditions.visibilityOf(Setup.driver.findElement(By.xpath(".//*[@id='ModalSummryProviderLocationPractice']"))));
				wt.until(ExpectedConditions.visibilityOf(Setup.driver.findElement(By.xpath(pr.read_ObjectRepositoryfile("PopupCloseButton")))));
				wt.until(ExpectedConditions.visibilityOf(Setup.driver.findElement(By.xpath(".//*[@id='spnAverage']"))));
				closebutton = Setup.driver.findElement(By.xpath(pr.read_ObjectRepositoryfile("PopupCloseButton")));
				String measureValuefromPopup = Setup.driver.findElement(By.xpath(".//*[@id='spnAverage']")).getText().replace(" ", "");
				//System.out.println(measureValuefromPopup);
				if(measureValuePracticeTab.equals(measureValuefromPopup))
				{
					System.out.println("Both values matches.\tPopup value: " +measureValuefromPopup +"\tTab value: " + measureValuePracticeTab);
					getProgressBarColor(Setup.driver.findElement(By.xpath(".//*[@id='divprogress']")));
				}
				else
				{
					measureInvalidFlag=true;
					System.err.println("Both values does not matches.\tPop value: " +measureValuefromPopup +"\tTab value: " + measureValuePracticeTab);
				}
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
	


	public boolean verifyProgressBarColor(String quarter)
	{
		quarter = getSelectedQuarter();
		quarter = quarter.trim();
		quarter = quarter.replace(" - ", "");
		boolean scoreNotMatchedFlag =false;
		
		String query = "select Measureid,Measure,Cast(Average * 100 as decimal (6,2)) 'Performace Score' "
				+ "from FIGMDWebDemo.dbo.ViewMeasureComputationSummary ms" 
				+ " inner join FIGMDWebDemo.dbo.ViewPractice p on p.PracticeUid=ms.PracticeUid "
				+ "where p.listname='"+getUIPracticeInPracticeTab()+"' and QuarterName ='"+quarter+"' "
				+ "and LocationUid is null and ProviderUid is null order by measureid";
		//System.out.println(query);
		List<WebElement> progressBars = Setup.driver.findElements(By.xpath(".//div[@class='progress no-margin']/div"));
		
		try 
		{
			
			DatabaseManger.SQLserverConnection();
			ResultSet rs = DatabaseManger.exeQuery(query);
			for(WebElement currentprogressBar : progressBars)
			{
				if(rs.next())		
				{
					String DBscore = rs.getString("Performace Score");
					//String UIscore = currentprogressBar.getAttribute("class");
					String UIscore = currentprogressBar.getAttribute("style").replaceAll("[A-Z|a-z|%|,|;|:| ]+", "");
					getProgressBarColor(currentprogressBar);
					
					// TODO:  The calculation formula for color selection is going to change
					if(DBscore.equals(UIscore)==false)
					{	
						scoreNotMatchedFlag=true;
						System.err.println("UIscore: " + UIscore + "\tDBscore: " + DBscore);
						System.err.flush();
					}
					else
					{
						System.out.println("UIscore:" + UIscore + "\tDBscore:" + DBscore);
					}
				}
				else
				{
					System.out.println("Score differs from database");
					Setup.testcase.fail();
					return false;
				}
					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(scoreNotMatchedFlag==true)
		{
			Setup.testcase.fail();
			return false;
		}
		return true;
	}
	
	public boolean verifyRegistryBenchmark(String quarter) throws InterruptedException
	{
		quarter = quarter.trim();
		quarter = quarter.replace(" - ", "");
		boolean scoreNotMatchedFlag =false;
		
		String query = "select Measureid,Measure,Cast(NationalAverage * 100 as decimal (6,2)) 'Registry Benchmark' "
				+ "from FIGMDWebDemo.dbo.ViewMeasureComputationSummary ms" 
				+ " inner join FIGMDWebDemo.dbo.ViewPractice p on p.PracticeUid=ms.PracticeUid "
				+ "where p.listname='"+getUIPracticeInPracticeTab()+"' and QuarterName ='"+quarter+"' "
				+ "and LocationUid is null and ProviderUid is null order by measureid";
		//System.out.println(query);
		List<WebElement> linecut = Setup.driver.findElements(By.xpath(".//*[@id='sample-table-1']//div[@class='vertical-progress-linecut']"));
		
		try 
		{
			
			DatabaseManger.SQLserverConnection();
			ResultSet rs = DatabaseManger.exeQuery(query);
			for(WebElement currentLineCut : linecut)
			{
				if(rs.next())		
				{
					String DBscore = rs.getString("Registry Benchmark");
					String UIscore = currentLineCut.getAttribute("Style").replaceAll("[^0-9.]", "");
					if(DBscore.equals(UIscore)==false)
					{	
						scoreNotMatchedFlag=true;
						System.err.println("Score does not matched");
						System.err.println("UIscore: " + UIscore + "\tDBscore: " + DBscore);
					}
					else
					{
						System.out.println("UIscore:" + UIscore + "\tDBscore:" + DBscore);
					}
				}
				else
				{
					System.out.println("Score differs from database");
					Setup.testcase.fail();
					return false;
				}
					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(scoreNotMatchedFlag==true)
		{
			Setup.testcase.fail();
			return false;
		}
		return true;
	}
	
	
	public boolean checkMeasureScore(String quarter)
	{
		quarter = quarter.trim();
		quarter = quarter.replace(" - ", "");
		boolean scoreNotMatchedFlag =false;
		String query = "select Measureid,Measure,Cast(Average* 100 as decimal (6,2)) Percentage from FIGMDWebDemo.dbo.ViewMeasureComputationSummary ms" 
				+ " inner join FIGMDWebDemo.dbo.ViewPractice p on p.PracticeUid=ms.PracticeUid "
				+ "where p.listname='"+getUIPracticeInPracticeTab()+"' and QuarterName ='"+quarter+"' "
				+ "and LocationUid is null and ProviderUid is null order by measureid";
		
		List<WebElement> scores = Setup.driver.findElements(By.xpath(".//*[@id='sample-table-1']//td[3]//td[2]"));
		
		try
		{
			DatabaseManger.SQLserverConnection();
			ResultSet rs = DatabaseManger.exeQuery(query);
			for(WebElement currentscore :scores)
			{
				if(rs.next())		
				{
					String UIscore = currentscore.getText().replace("%", "");
					//String DBscore = String.valueOf(rs.getDouble("Percentage"));
					String DBscore = rs.getString("Percentage");
					if(UIscore.equals(DBscore)==false)
					{
						scoreNotMatchedFlag=true;
						System.err.println("Score does not matched");
						System.err.println("UIscore:" + UIscore + "\tDBscore:" + DBscore);
					}
					else
					{
						System.out.println("UIscore:" + UIscore + "\tDBscore:" + DBscore);
					}
				}
				else
				{
					System.out.println("Score differs from database");
					Setup.testcase.fail();
					return false;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(scoreNotMatchedFlag==true)
		{
			Setup.testcase.fail();
			return false;
		}
		return true;
	}
	
	public boolean selectPracticeInPracticeList(String locator,String practiceID) throws InterruptedException
	{
		WebElement we = Setup.driver.findElement(By.xpath(locator));
		WebElement nextbutton=null;
		//System.out.println(locator);
		WebDriverWait wait = new WebDriverWait(Setup.driver, 10);
		Setup.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		for(int i=0;i<=(PracticeUId.size()/10);i++)
		{
			try
			{
				we = Setup.driver.findElement(By.xpath(locator));
				try 
				{
					nextbutton = Setup.driver.findElement(By.xpath(".//*[@id='divMasterPagerPractice']/a[last()-1]"));
				} catch (Exception e) 
				{
					System.out.println("practice list not present");
					Setup.testcase.fail();
					return false;
				}
				String xpath=".//*[td='"+practiceID+"']/td[1]/input";
				//System.out.println(xpath);
				WebElement child = we.findElement(By.xpath(xpath));
				child.click();
				return true;
			}
			catch(Exception e)
			{
				nextbutton.click();
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
			}
		}
		Setup.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return false;
	}
	
	public void verifyMeasureComputationalSummary(String practiceid,String quarter)
	{
		quarter = quarter.trim();
		quarter = quarter.replace(" - ", "");
		
		String query = "select CMS,COUNT(1) count from( select case when DIFFERENCE<0 then 'Below' else 'Exceeding' end CMS " + 
					"from FIGMDWebDev.dbo.ViewMeasureComputationSummary ms inner join FIGMDWebDev.dbo.ViewPractice p "
					+ "on p.PracticeUid=ms.PracticeUid where p.listname='"+getUIPracticeInPracticeTab()+"'  and QuarterName ='"+quarter+"' "
					+ "and LocationUid is null and ProviderUid is null )bushmills group by CMS order by CMS";
		
		int exceedingDB = 0,bellowDB = 0;
		String practiceName = Setup.driver.findElement(By.xpath(".//*[@id='divPracticeCollapsble']//td[1]/a")).getText();
		String ExceedingUI = Setup.driver.findElement(By.xpath(".//*[@id='divPracticeCollapsble']//td[2]/a")).getText();
		String BellowUI = Setup.driver.findElement(By.xpath(".//*[@id='divPracticeCollapsble']//td[3]/a")).getText();
		System.out.println(practiceid+" "+quarter);
		System.out.println(practiceName + " " + ExceedingUI +" " + BellowUI );
		try
		{
			DatabaseManger.SQLserverConnection();
			ResultSet rs = DatabaseManger.exeQuery(query);
			if(rs.next())
			{
				bellowDB = rs.getInt("count");
				rs.next();
				exceedingDB = rs.getInt("count");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("DB Scores: " + bellowDB + " " +exceedingDB);
		System.out.println(getUIPracticeInPracticeTab());
	}
	
	public String getUIPracticeInPracticeTab()
	{
		WebElement practiceText;
		practiceText=Setup.driver.findElement(By.xpath(".//*/div[1]/h4/div/table/tbody/tr/td[1]/a"));
		
		if(!practiceText.isDisplayed())
		{
			//practiceText=Setup.driver.findElement(By.xpath(".//*[@id='ctl00_HeaderContent_lblPracticeName']"));
			practiceText=Setup.driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_HeaderContent_lblPracticeName']"));
		}
		return practiceText.getText().trim();
	}
	
	public LinkedList<String> getAllPracticeUID()
	{
		LinkedList<String> PracticeUId = new LinkedList<String>();
		String query;
		ResultSet rs;
		try
		{
			switch(getUserType())
			{
				case SinglePractice:
					query = "select PracticeUid  from Individual where IndividualUid='"+ this.FIGUserUID + "'";
					rs = DatabaseManger.exeQuery(query);
					if(rs.next())
					{
						PracticeUId.add( rs.getString("PracticeUid") );
					}
					else
						System.out.println("No practice assigned");
					break;
					
				case MultiPractice:
					query = "select PracticeUid from practice where PracticeUid in ( select ObjectUid from FIGUserAuthorization where ObjectName='practice' and FIGUserUid = '" + this.FIGUserUID + "') order by Externalid";
					rs = DatabaseManger.exeQuery(query);
					while(rs.next())
						PracticeUId.add( rs.getString("PracticeUid") );
					break;
					
				case Super:
					query = "select PracticeUid from practice order by Externalid ";
					rs = DatabaseManger.exeQuery(query);
					while(rs.next())
						PracticeUId.add( rs.getString("PracticeUid") );
					break;
					
				case Invaild:
					break;
					
				default:
						System.out.println("Something went wrong in method setPractice.");
					break;
			}	
		}
		catch(Exception e)
		{
			System.out.println("Something went wrong in method setPractice. Error:" + e);
			Setup.log.fatal(e.toString());
		}
		return PracticeUId;
	}
	
	/**
	 * @author  Abhishek Gaikwad
	 * @return The user type i.e single, multiple, super or invalid
	 */
	public FIGUserType getUserType() 
	{
		return userType;
	}
	
	/**
	 * Fetch PracticeUID(s) from database as per user type. 
	 * 
	 * @author  Abhishek Gaikwad
	 */
	private void setPracticeUID()
	{
		String query;
		ResultSet rs;
		try
		{
			switch(getUserType())
			{
				case SinglePractice:
					query = "select PracticeUid from Individual where IndividualUid='"+ this.FIGUserUID + "' and inactive=0";
					rs = DatabaseManger.exeQuery(query);
					if(rs.next())
					{
						PracticeUId.add( rs.getString("PracticeUid") );
					}
					else
						System.out.println("No practice assigned");
					break;
					
				case MultiPractice:
					query = "select ObjectUid from FIGUserAuthorization where ObjectName='practice' and FIGUserUid = '" + this.FIGUserUID + "'";
					rs = DatabaseManger.exeQuery(query);
					while(rs.next())
						PracticeUId.add( rs.getString("ObjectUid") );
					break;
					
				case Super:
					query = "select PracticeUid from practice where inactive=0 and ClinicalDataRepositoryUid is not null order by listname ";
					rs = DatabaseManger.exeQuery(query);
					while(rs.next())
						PracticeUId.add( rs.getString("PracticeUid") );
					break;
					
				case Invaild:
					break;
					
				default:
						System.out.println("Something went wrong in method setPractice.");
					break;
			}	
		}
		catch(Exception e)
		{
			System.out.println("Something went wrong in method setPractice. Error:" + e);
			Setup.log.fatal(e.toString());
		}
	}
	
	private void setUserType() 
	{	
		String query;
		ResultSet rs;

		try 
		{	
			//For single practice User
			query = "select PracticeUid from Individual where PracticeUid is not null and IndividualUid='"+ this.FIGUserUID + "'";
			rs = DatabaseManger.exeQuery(query);
			if( rs.first()== true)
			{
				userType = FIGUserType.SinglePractice;
				return;
			}
			
			//For Multi-practice user
			query = "select ObjectUid from FIGUserAuthorization where ObjectName='practice' and ObjectUid is not null "
					+" and FIGUserUid = '" + this.FIGUserUID + "'";
			rs = DatabaseManger.exeQuery(query);
			if( rs.first()==true)
			{
				userType = FIGUserType.MultiPractice;
				return;
			}
			
			//If its a valid user and not a single or multi practice user means a Super user
			userType = FIGUserType.Super;
			
			
		} catch (Exception e) 
		{
			System.out.println("Error in method TestCases.Login.TestCases.setUserType. Error: " +e);
			Setup.log.fatal(e.toString());
		}
	}
	public void getProgressBarColor(WebElement progressBarDiv)
	{
		String elementClass = progressBarDiv.getAttribute("class");
		String elementValue = progressBarDiv.getAttribute("Style").replaceAll("[^0-9.]", "");
		
		if(elementClass.equals("progress-bar progress-bar-success"))
		{
			progressbarcolor = Color.GREEN;
			System.out.println("Green");
		}
		else if(elementClass.equals("progress-bar progress-bar-danger"))
		{
			if(elementValue.equals("0"))
			{
				progressbarcolor = Color.GRAY;
				System.out.println("Gray");
			}
			else
			{
				progressbarcolor = Color.RED;
				System.out.println("Red");
			}
		}
		else if(elementClass.equals("progress-bar progress-bar-warning"))
		{
			progressbarcolor = Color.ORANGE;
			System.out.println("Orange");
		}
		else
		{
			System.out.println("Something else has happened please verify getProgressBarColor");
		}
	}
	private String getSelectedQuarter()
	{
		ElementMethod em = new ElementMethod();
		return em.getSelectValue("xpath", ".//*[@id='ddlQuarter']");
	}
	

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public Color getProgressbarcolor() {
		return progressbarcolor;
	}
}
