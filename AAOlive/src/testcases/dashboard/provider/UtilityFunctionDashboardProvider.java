package testcases.dashboard.provider;




import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import buisness.core.ElementMethod;
import buisness.managers.DatabaseManger;
import configuration.Setup;
import configuration.UtilityFunction;

public class UtilityFunctionDashboardProvider {
	
	ResultSet rs1=null;
	DatabaseManger db_exe=new DatabaseManger();
	ElementMethod ele=new ElementMethod();
	public int providercount=0,exceed,below;
	public String provideruid=null,measure_id=null;
	public String quarterenddate=null;
	
/**
 * @author Nikita Desai
 * @return
 */
	
	public  String checkPrvoiderCount()
	{
		try
		{
		 int count_a=Integer.parseInt(Setup.driver.findElement(By.xpath(".//div[@class='accordion-style1 panel-group']")).getAttribute("data-locationcount"));
		 String provider_count_query="select COUNT(serviceprovideruid) from ViewServiceProvider where PracticeUid='"+UtilityFunction.practiceuid+"' and Inactive=0 and Type in ('1','3')";
		 System.out.println("query is "+provider_count_query);
		 rs1=db_exe.SQLserverConnection(provider_count_query);
	     int providercount_e=0;
	       while(rs1.next()){
	    	   providercount_e=Integer.parseInt(rs1.getString(1));	  
	       } 
	      System.out.println("expected provider count is"+providercount_e);
	      System.out.println("actual provider count"+count_a);
	      Assert.assertEquals(count_a,providercount_e);
	      providercount=providercount_e;
		  return "Pass";
		}
		catch(Exception e)
		{
			System.out.println("error while checking provider count"+e);
			e.printStackTrace();
			Setup.log.fatal(e.toString());
			return "Fail";
		}
	}
	

/**
* @author Nikita Desai
* @return
*/
public String checkProviderData()
	{
	   try
	   {
		 	if(checkPrvoiderCount()=="Pass")	 
			{
				System.out.println("Provider count matched and it is "+providercount);
				if(checkprovider()==true)
				{
					System.out.println("Provider data is validated");
				}
			}
			else
			{
				System.out.println("Provider count is not matched");
			}
		 return "Pass";
	   }
	   catch(Exception e)
	   {
           e.printStackTrace();
           Setup.log.fatal(e.toString());
		   return "Fail";
		   
	   }
	}

/**
 * @author Nikita Desai
 * @return
 */
	private  boolean checkprovider() {
		
		try
		{
			
		 if(providercount==0)
		 {
			 String no_row=ele.gettext("xpath",".//*[@id='row']");
			 Assert.assertEquals(no_row,"No record found for given criteria.");
			 return true;
		 }
		 else
		 {
			 
			 String quarter_end_date_query="select distinct Date  from Calendar where "+ UtilityFunction.mq_column +"='"+UtilityFunction.duration+"' and year ='"+UtilityFunction.duration_yr+"'";
		  //String quarter_end_date_query="select distinct QuarterEndDate  from ViewMeasureComputationSummary where  QuarterName='"+UtilityFunction.duration+"'";
		  rs1=db_exe.SQLserverConnection1(quarter_end_date_query);
		 
		  while(rs1.next()){
		    	   quarterenddate=rs1.getString(1);	  
		       } 
		  String fig_uid=buisness.core.login.AfterLoginUtility.getFIGUerUID();
		  String provider_data_query=" select listname,below,exceed from ( "+
				  " select listname,below,exceed,row_number() over(partition by  listname order by below desc) sn from"+
				  " (select listname,below,exceed from"+
				  " (select distinct ListName,EX,COUNT(1) as tmp"+
				  " from ( select  case when Difference > 0 then 'Exceed' else 'Below' end 'Ex',vsp.ListName  "+
				  " from ViewMeasureComputationSummary vmc "+ 
				  " inner join ViewServiceProvider vsp on vsp.ServiceProviderUid=vmc.provideruid "+
				  " where vmc.PracticeUid ='"+UtilityFunction.practiceuid+"'  and Flag='"+UtilityFunction.duration_flag+"' and QuarterEndDate  ='"+quarterenddate+"' and ProviderUid is not null and vsp.Inactive =0 and vsp.Type in ('1','3')" +
				  " )a group by listname,Ex) as b PIVOT (avg(tmp) for Ex in ([Below],[Exceed])) as pivottavble " +
				  " union " +
				  " select listname,below=0,exceed=0 from ViewServiceProvider " +
				  " where PracticeUid = '"+UtilityFunction.practiceuid+"' and Inactive = 0 and Type in ('1','3') " +
				  " )c "+
				  " )a "+
				  " where sn=1 ";
				
				  
		  //"exec [SP_ProviderGet] @PracticeUID = '"+UtilityFunction.practiceuid+"', @FIGUserId = '"+fig_uid+"' , @Flag = '"+UtilityFunction.duration_flag+"', @QuarterEndDate = '"+quarterenddate+"', @Type = '1,3', @IsActive = 0, @PageSize = 100";
	     
		  rs1=db_exe.SQLserverConnection1(provider_data_query); 
		  String []provider_data_e=new String[providercount];
		  int k=0;
	  	  while(rs1.next()){
			            provider_data_e[k]=rs1.getString("Name").trim().replace(" ","")+rs1.getString("ExceedingCount").trim().replace(" ","")+rs1.getString("BelowCount").trim().replace(" ","");
			            k++;
 		      }
		    	  
		  String []provider_data_a=new String[providercount];
	      int j=0,l=0;
	      int count=providercount;
	      do
	      {
	    	 Setup.driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS); 
	         List<WebElement> elements=Setup.driver.findElements(By.xpath(".//div[@class='panel panel-default']"));
	            for(int i=0 ;(i< elements.size());i++)
	           {
	    	       if(elements.get(i).getText() != null)
	    	       {	   
	    	    	  provider_data_a[j]=(String) elements.get(i).getText();
	    	    	  String [] words=provider_data_a[j].split("\n");
	   	    	      String name=words[0].trim().replace(" ","");
	   	    	      String provider_data_act=name+words[1]+words[2];
	   	    	      System.out.println("actual data is "+provider_data_act);
	   	    	      System.out.println("Expected data is"+provider_data_e[l]);
	   		          Assert.assertEquals(provider_data_act,provider_data_e[l]); //validate provider data
        		      String pro_name=words[0].replace(" ","%");
	    	          exceed=Integer.parseInt(words[1]);
	    	    	  below=Integer.parseInt(words[2]);
	    	    	  String provider_uid_query="select ServiceProviderUid from ViewServiceProvider where practiceuid='"+UtilityFunction.practiceuid+"' and name like '%"+pro_name+"'";
	     	          System.out.println(provider_uid_query);
	    	    	  rs1=db_exe.SQLserverConnection(provider_uid_query);
	     	          while(rs1.next()){
	     			        provideruid=rs1.getString(1).toLowerCase();	
	     			        System.out.println("provider uid is"+provideruid);
	 	    		        }

	     	         String first=".//*[@id='";
	     	         String second="row";
	     	         String third="']/div[1]/h4/div/table/tbody/tr/td[2]/a[contains(text(),'";
	     	         String fourth="')]";
	     	         String finalpath=first+second+provideruid+third+words[1]+fourth;
	     	         System.out.println(finalpath);
	   		          //check exceed count and below count
	     	         if((exceed > 0) || (below > 0))
	     	         {
	     	        	Setup.driver.findElement(By.xpath(finalpath)).click(); 
	     	        	checkmeasuredata();
	     	         }
	     	         else if((exceed == 0) && (below == 0))
    	    	     {
   	    	    	   Setup.driver.findElement(By.xpath(finalpath)).click(); 
   	    	    	   String no_data=Setup.driver.findElement(By.xpath(".//*[@id='sample-table-1']/tbody[2]/tr/td")).getText();
   	    	    	   Assert.assertEquals(no_data,"No record found for given criteria.");
   	    	         } 
	   		          j++; l++;
	    	      
	    	    } //first for end
	    	       count=count-1;
	           }
	           
	            if(ele.isElementPresent(By.xpath(".//*[@id='divProviderPager']/a[contains(text(),'>')]")))
	            {
	            	 String style_next=Setup.driver.findElement(By.xpath(".//*[@id='divProviderPager']/a[contains(text(),'>')]")).getCssValue("cursor");
		              if(style_next.equals("pointer"))
		               {
		            	 ele.click_element("xpath", ".//*[@id='divProviderPager']/a[contains(text(),'>')]");
		               }
	            }
	           Thread.sleep(2000);
	            
	      } while((count!=0) && (l<provider_data_e.length));   
	      
	     
	      
		 } 
		 return true;
		}
		catch(Exception e)
		{
		    System.out.println("Exception occures while checking provider name, exceeding count, below count"+e);
		    e.printStackTrace();
		    Setup.log.fatal(e.toString());
			return false;
		}	
	}

/**
 * @author Nikita Desai
 */

private void checkmeasuredata() {
		
		 String measure_id_query="select MeasureId from ViewMeasureComputationSummary vc where PracticeUid='"+UtilityFunction.practiceuid +"' and ProviderUid ='"+provideruid+"'and Flag='"+UtilityFunction.duration_flag+"' and QuarterEndDate = '"+quarterenddate+"' order by MeasureId "; 
		 List <String> measureid=db_exe.SQLserverConnection2(measure_id_query);
		 String measure_name_query="select Measure from ViewMeasureComputationSummary vc where PracticeUid='"+UtilityFunction.practiceuid +"' and ProviderUid ='"+provideruid+"'and Flag='"+UtilityFunction.duration_flag+"'  and QuarterEndDate = '"+quarterenddate+"' order by MeasureId "; 
		 List <String> measurename=db_exe.SQLserverConnection2(measure_name_query);
		 String measure_registrybenchmark_query="select CAST(NationalAverage*100 as decimal(6,2)) from ViewMeasureComputationSummary vc where PracticeUid='"+UtilityFunction.practiceuid +"' and ProviderUid ='"+provideruid+"'and Flag='"+UtilityFunction.duration_flag+"'  and QuarterEndDate = '"+quarterenddate+"' order by MeasureId "; 
		 List <String>  measure_reg_e=db_exe.SQLserverConnection2(measure_registrybenchmark_query);
		 
		//no of row and columns of measures listed under provider 
		
		 int row=Setup.driver.findElements(By.xpath(".//*[@id='sample-table-1']/tbody[1]/tr")).size();
	     int col=Setup.driver.findElements(By.xpath(".//*[@id='sample-table-1']/tbody[1]/tr[1]/td")).size();
         System.out.println("no rows"+row+"column is "+col);
		 String first_part =".//*[@id='sample-table-1']/tbody[1]/tr[";
		 String second_part = "]/td[";
		 String third_part = "]";
		 
		    for (int r=1,f=0;(r<row) && (f<measureid.size());r=r+2,f=f+1){
		    	  //verify measure id
		    	   String measure_id_xpath = first_part+r+second_part+1+third_part;
		           String measure_id_a = Setup.driver.findElement(By.xpath(measure_id_xpath)).getText();
		           String measure_id_e=" IRIS "+ measureid.get(f);
		           Assert.assertEquals(measure_id_a, measure_id_e);
		           measure_id=measure_id_e;
		          //verify measure name
		           String measure_name_xpath = first_part+r+second_part+2+third_part;
			       String measure_name_a = Setup.driver.findElement(By.xpath(measure_name_xpath)).getText();
			       String measure_name_e= measurename.get(f);
			       Assert.assertEquals(measure_name_a, measure_name_e);
			       //verify measure registry benchmark
			       String measure_registry_xpath = first_part+r+second_part+3+third_part;
			       String [] registry_a = Setup.driver.findElement(By.xpath(measure_registry_xpath)).getText().split("\n");
			       String registry_e= measure_reg_e.get(f);
			       String []registry = registry_a[0].split("[(\\s,;\\n\\t\\%)]+");
			       //     System.out.println("actual is"+registry[3]);
			         //   System.out.println("expected is "+registry_e);
			       Assert.assertEquals(registry[3], registry_e);
		           System.out.println("Provider Measure Id, Name and Registry bemchMark is matched");
		        }
		 
	} 
	

/**
 * @author Nikita Desai
 * @return
 */
	
///function to check provider name , exceed and below count	
public String checkProviderNameEBC()
{
	try
	{
		Thread.sleep(1000);
		int pro_count=0;
		String provider_count_query="select COUNT(serviceprovideruid) from ViewServiceProvider where PracticeUid='"+UtilityFunction.practiceuid+"' and Inactive=0 and Type in ('1','3')";
		System.out.println("query is "+provider_count_query);
		rs1=db_exe.SQLserverConnection(provider_count_query);
	      while(rs1.next()){
	    	   pro_count=Integer.parseInt(rs1.getString(1));	  
	          } 
	      providercount=pro_count;
	    System.out.println("Provider count is"+providercount);
		if(providercount==0)
		   {
			 String no_row=ele.gettext("xpath",".//*[@id='row']");
			 Assert.assertEquals(no_row,"No record found for given criteria.");
			 return "Pass";
		   }
		 else
		  {
			  
			  String quarter_end_date_query="select distinct Date  from Calendar where "+ UtilityFunction.mq_column +"='"+UtilityFunction.duration+"' and year ='"+UtilityFunction.duration_yr+"'";
			  System.out.println("quarter  query is "+quarter_end_date_query);
			  rs1=db_exe.SQLserverConnection1(quarter_end_date_query);
			 
			  while(rs1.next()){
			    	   quarterenddate=rs1.getString(1);	  
			       } 
			  
			  String provider_data_query=" select listname,below,exceed from ( "+
					  " select listname,below,exceed,row_number() over(partition by  listname order by below desc) sn from"+
					  " (select listname,below,exceed from"+
					  " (select distinct ListName,EX,COUNT(1) as tmp"+
					  " from ( select  case when Difference > 0 then 'Exceed' else 'Below' end 'Ex',vsp.ListName  "+
					  " from ViewMeasureComputationSummary vmc "+ 
					  " inner join ViewServiceProvider vsp on vsp.ServiceProviderUid=vmc.provideruid "+
					  " where vmc.PracticeUid ='"+UtilityFunction.practiceuid+"'  and Flag='"+UtilityFunction.duration_flag+"' and QuarterEndDate  ='"+quarterenddate+"' and ProviderUid is not null and vsp.Inactive =0 and vsp.Type in ('1','3')" +
					  " )a group by listname,Ex) as b PIVOT (avg(tmp) for Ex in ([Below],[Exceed])) as pivottavble " +
					  " union " +
					  " select listname,below=0,exceed=0 from ViewServiceProvider " +
					  " where PracticeUid = '"+UtilityFunction.practiceuid+"' and Inactive = 0 and Type in ('1','3') " +
					  " )c "+
					  " )a "+
					  " where sn=1 ";
					
					  
					 
		     
		
		    System.out.println(provider_data_query); 
		    rs1=db_exe.SQLserverConnection1(provider_data_query); 
		
		  String []provider_data_e=new String[providercount];
		  int k=0;
		 
	  	  while(rs1.next()){
	  		          
			            provider_data_e[k]=rs1.getString("listname").trim().replace(" ","")+rs1.getString("exceed").trim().replace(" ","")+rs1.getString("below").trim().replace(" ","");
	  		            k++;
 		      }
		    	 
	  	  
		  String []provider_data_a=new String[providercount];
	      int j=0,l=0;
	      int count=providercount;
	      do
	      {
	    	 Setup.driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS); 
	         List<WebElement> elements=Setup.driver.findElements(By.xpath(".//div[@class='panel panel-default']"));
	            for(int i=0 ;(i<elements.size());i++)
	           {
	    	       if(elements.get(i).getText() != null)
	    	       {	   
	    	    	  provider_data_a[j]=(String) elements.get(i).getText();
	    	    	  String [] words=provider_data_a[j].split("\n");
	   	    	      String name=words[0].trim().replace(" ","");
	   	    	      String provider_data_act=name+words[1]+words[2];
	   	    	      System.out.println("Record is"+(j+1));
	   	    	      System.out.println("actual data is "+provider_data_act);
	   	    	      System.out.println("Expected data is"+provider_data_e[l]);
	   		          Assert.assertEquals(provider_data_act,provider_data_e[l]); //validate provider data
	    	        }
	   		          j++; l++;
	    	      
	    	    } //first for end
	    	    count=count-1;
	    	    if(ele.isElementPresent(By.xpath(".//*[@id='divProviderPager']/a[contains(text(),'>')]")))
	    	    {	
	    	      String style_next=Setup.driver.findElement(By.xpath(".//*[@id='divProviderPager']/a[contains(text(),'>')]")).getCssValue("cursor");
	              if(style_next.equals("pointer"))
	               {
	            	 ele.click_element("xpath", ".//*[@id='divProviderPager']/a[contains(text(),'>')]");
	               }
	    	    }
	           
	            Thread.sleep(3000);
	            
	      } while((count!=0) && (l<provider_data_e.length));   
	  	}//else end
		return "Pass";
	 }//try ends	
	
		catch(Exception e)
		{
			Setup.log.fatal(e.toString());
			e.printStackTrace();
			return "Fail";
		}
		
	}


/**
 * @author Nikita Desai
 * @param data
 * @return
 */
////////function to check measure id,name of given provider

 public String checkProviderMeasureIdName(String data)
  {
	  try
	  {
		 if(gotoProvider(data).equals("Pass"))
		 {
			 if(providercount==0)
			 {
				 System.out.println("No record Present for practice");
				 String no_row=ele.gettext("xpath",".//*[@id='row']");
				 Assert.assertEquals(no_row,"No record found for given criteria.");
				 return "Pass";
			 }
			else
			{	 
			 if(ele.isElementPresent(By.xpath(".//*[@id='sample-table-1']/tbody[2]/tr/td")))
			  {
				  String no_record=ele.gettext("xpath",".//*[@id='sample-table-1']/tbody[2]/tr/td");
				  System.out.println("No record present for Provider");
				  Assert.assertEquals(no_record, "No record found for given criteria.");
			      
			      return "Pass";
			  }
			 
			 else
			 { 	  
				 String quarter_end_date_query="select distinct Date  from Calendar where "+ UtilityFunction.mq_column +"='"+UtilityFunction.duration+"' and year ='"+UtilityFunction.duration_yr+"'";
				// String quarter_end_date_query="select distinct QuarterEndDate  from ViewMeasureComputationSummary where  QuarterName='"+UtilityFunction.duration+"'";
			  rs1=db_exe.SQLserverConnection1(quarter_end_date_query);
			 
			  while(rs1.next()){
			    	   quarterenddate=rs1.getString(1);	  
			       } 
			 String measure_id_query="select MeasureId from ViewMeasureComputationSummary vc where PracticeUid='"+UtilityFunction.practiceuid +"' and ProviderUid ='"+provideruid+"'and Flag='"+UtilityFunction.duration_flag+"' and QuarterEndDate = '"+quarterenddate+"' order by MeasureId "; 
			 List <String> measureid=db_exe.SQLserverConnection2(measure_id_query);
			 String measure_name_query="select Measure from ViewMeasureComputationSummary vc where PracticeUid='"+UtilityFunction.practiceuid +"' and ProviderUid ='"+provideruid+"'and Flag='"+UtilityFunction.duration_flag+"'  and QuarterEndDate = '"+quarterenddate+"' order by MeasureId "; 
			 List <String> measurename=db_exe.SQLserverConnection2(measure_name_query);
			 String measure_registrybenchmark_query="select CAST(NationalAverage*100 as decimal(6,2)) from ViewMeasureComputationSummary vc where PracticeUid='"+UtilityFunction.practiceuid +"' and ProviderUid ='"+provideruid+"'and Flag='"+UtilityFunction.duration_flag+"'  and QuarterEndDate = '"+quarterenddate+"' order by MeasureId "; 
			 List <String>  measure_reg_e=db_exe.SQLserverConnection2(measure_registrybenchmark_query);
			 
			//no of row and columns of measures listed under provider 
			
			 int row=Setup.driver.findElements(By.xpath(".//*[@id='sample-table-1']/tbody[1]/tr")).size();
		     int col=Setup.driver.findElements(By.xpath(".//*[@id='sample-table-1']/tbody[1]/tr[1]/td")).size();
	         System.out.println("no rows"+row+"column is "+col);
			 String first_part =".//*[@id='sample-table-1']/tbody[1]/tr[";
			 String second_part = "]/td[";
			 String third_part = "]";
			 
			    for (int r=1,f=0;(r<row) && (f<measureid.size());r=r+2,f=f+1){
			    	  //verify measure id
			    	   String measure_id_xpath = first_part+r+second_part+1+third_part;
			           String measure_id_a = Setup.driver.findElement(By.xpath(measure_id_xpath)).getText();
			           String measure_id_e=" IRIS "+ measureid.get(f);
			           
			           Assert.assertEquals(measure_id_a, measure_id_e);
			           System.out.println("Provider Measure id mathced");
			           measure_id=measure_id_e;
			          //verify measure name
			           String measure_name_xpath = first_part+r+second_part+2+third_part;
				       String measure_name_a = Setup.driver.findElement(By.xpath(measure_name_xpath)).getText();
				       String measure_name_e= measurename.get(f);
				       Assert.assertEquals(measure_name_a, measure_name_e);
				       System.out.println("Provider Measure name mathced");
				       //verify measure registry benchmark
				       String measure_registry_xpath = first_part+r+second_part+3+third_part;
				       String [] registry_a = Setup.driver.findElement(By.xpath(measure_registry_xpath)).getText().split("\n");
				       String registry_e= measure_reg_e.get(f);
				       String []registry = registry_a[0].split("[(\\s,;\\n\\t\\%)]+");
				       
				       Assert.assertEquals(registry[3], registry_e);
				       System.out.println("Provider registry benchmark mathced");
			           
			        } //for end
			 }//else ends
		 }//if end
		} 
		 
		 return "Pass";
	  }
	  catch(Exception e)
	  {
		Setup.log.fatal(e.toString());
		e.printStackTrace();
		return "Fail to check measure id ,data";
		  
	  }
  }
  
 /**
  * @author Nikita Desai
  * @param data
  * @return
  */
 public String gotoProvider(String data)
 {
	  try
	  {
         int count=0;
         String pro_uid=null;
		 String provider_count_query="select COUNT(serviceprovideruid) from ViewServiceProvider where PracticeUid='"+UtilityFunction.practiceuid+"' and Inactive=0 and Type in ('1','3')";
	     rs1=db_exe.SQLserverConnection(provider_count_query);
		 while(rs1.next())
		    	   count=Integer.parseInt(rs1.getString(1));	  
         providercount=count; 
	     System.out.println("Provider count is"+providercount);
		 if(providercount==0)
		   {
				 System.out.println("No Record Present for practice");
			     String no_row=Setup.driver.findElement(By.xpath(".//*[@id='row']")).getText();
			     System.out.println(no_row);
				 Assert.assertEquals(no_row,"No record found for given criteria.");
				 return "Pass";
		    }
		else
		 { 
		   String npi_query="select ServiceProviderUid from ViewServiceProvider where PracticeUid='"+UtilityFunction.practiceuid+"' and  type in('1','3') and Inactive=0 and npi='"+data.trim()+"'";
		   System.out.println(npi_query);
		   rs1=db_exe.SQLserverConnection1(npi_query);
		   while(rs1.next()){
		    	   pro_uid=rs1.getString(1).toLowerCase();	  
		    	   
		    } 
		  provideruid=pro_uid;
		  System.out.println("provideruid is"+provideruid);
		  if(provideruid!=null)
		  {
		          int p_count=providercount;
		        if(ele.isElementPresent(By.xpath(".//*[@id='divProviderPager']/a[contains(text(),'<<')]")))
		        {	
		            String style_first=Setup.driver.findElement(By.xpath(".//*[@id='divProviderPager']/a[contains(text(),'<<')]")).getCssValue("cursor");
		            if(style_first.equals("pointer"))
		            {
		            	 ele.click_element("xpath", ".//*[@id='divProviderPager']/a[contains(text(),'<<')]");
		            	 System.out.println("go to first page");
						 Thread.sleep(1000);   
		            }
		        }  
		      
			 do
		      {
		    	 Setup.driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS); 
		         List<WebElement> elements=Setup.driver.findElements(By.xpath(".//div[@class='panel panel-default']"));
		         for(int i=0 ;(i<elements.size());i++)
		         {
		    	       String first=".//*[@id='row";
		     	       String third="']";
		     	       String finalpath=first+provideruid+third;
		     	       System.out.println("Searching for Element "+finalpath);
		   		       if(ele.isElementPresent(By.xpath(finalpath)))
		   		       {  
		   		    	  String first_name_path=finalpath+"/div[1]/h4/div/table/tbody/tr/td[1]/a"; 
		   		    	  //check proivder alreday opened or not
		   		    	 /* String opened_path=".//*[@id='collapse"+provideruid+"']"; 
		     	          String opened_class=Setup.driver.findElement(By.xpath(opened_path)).getAttribute("class");
		     	          if(opened_class.equals("panel-collapse in"))
		     	          {
		     	        	  System.out.println("Provider is already opened");
		     	        	  return "Pass";
		     	          }*/
		     	          //else 
		     	          
		   		    	      if(ele.click_element("xpath",first_name_path).equals("Pass"))
		     	               {
		     	        	        System.out.println("click to provideruid"+provideruid);
		     	        	        //Thread.sleep(1000);
		     	        	        return "Pass";
		     	        	    }
		     	               else
		     	                {
		     	        	          return "Fail to click element";
		     	                }
		     	            
		   		       }
		   		     else
		   		       {
		   		    	   p_count=p_count-elements.size();
		   		    	   System.out.println("Not present on page");
		   		    	   break;
		   		       }
		   		      
		   		     
		   		        	      
		       } //first for end
		        if(ele.isElementPresent(By.xpath(".//*[@id='divProviderPager']/a[contains(text(),'>')]")))
		        {	
		           String style_next=Setup.driver.findElement(By.xpath(".//*[@id='divProviderPager']/a[contains(text(),'>')]")).getCssValue("cursor");
		            if(style_next.equals("pointer"))
		            {
		            	 ele.click_element("xpath", ".//*[@id='divProviderPager']/a[contains(text(),'>')]");
		            }
		        }    
		         
	           Thread.sleep(2000);
		   }while(p_count!=0);
		     
		 }	
		 else if(provideruid==null)
		 {
			 System.out.println("given provider with npi "+data+" is not present in given practice");
			 return "Fail as npi not present";
		 }
		}		 
		 
		 return "Pass";
	  }
	  catch(Exception e)
	  {
		Setup.log.fatal(e.toString());
		e.printStackTrace();
		return "Fail to check go to provider";
		  
	  }
 }  
	
 
 /**
  * @author Nikita Desai
  * @param data
  * @return
  */
 ///Function to check Provider Up and down trending arrow
 
@SuppressWarnings("unused")
public String  checkProviderUpnDownArrow(String data)
	{
		try
		  {
			 if(gotoProvider(data).equals("Pass"))
			 {
				 if(providercount==0)
				 {
					 System.out.println("No Record Present for practice");
				     String no_row=Setup.driver.findElement(By.xpath(".//*[@id='row']")).getText();
				     System.out.println(no_row);
				     Assert.assertEquals(no_row,"No record found for given criteria.");
				     return "Pass";
				 }
				else
				{	 
				 if(ele.isElementPresent(By.xpath(".//*[@id='sample-table-1']/tbody[2]/tr/td")))
				  {
				      String no_record=ele.gettext("xpath",".//*[@id='sample-table-1']/tbody[2]/tr/td");
				      Assert.assertEquals(no_record, "No record found for given criteria.");
				      System.out.println("No record present for Provider so cant check provider Up n down arrow");
				      return "Pass";
				  }
				 
				 else
				 { 	  
					 String quarter_end_date_query="select distinct Date  from Calendar where "+ UtilityFunction.mq_column +"='"+UtilityFunction.duration+"' and year ='"+UtilityFunction.duration_yr+"'";
					 //String quarter_end_date_query="select distinct QuarterEndDate  from ViewMeasureComputationSummary where  QuarterName='"+UtilityFunction.duration+"'";
				  rs1=db_exe.SQLserverConnection1(quarter_end_date_query);
				 
				  while(rs1.next()){
				    	   quarterenddate=rs1.getString(1);	  
				       } 
				 
				//no of row and columns of measures listed under provider 
				
				 int row=Setup.driver.findElements(By.xpath(".//*[@id='sample-table-1']/tbody[1]/tr")).size();
	             int col=Setup.driver.findElements(By.xpath(".//*[@id='sample-table-1']/tbody[1]/tr[1]/td")).size();
		         System.out.println("no rows"+row+"column is "+col);
				 String first_part =".//*[@id='sample-table-1']/tbody[1]/tr[";
				 String second_part = "]/td[";
				 String third_part = "]";
				 String fourth_part="/table/tbody/tr/td[";
				 String fifth_part="]";
				   for(int r=1;r<row;r=r+2)
				    {
				    	   String final_xpath = first_part+r+second_part+3+third_part+fourth_part+1+fifth_part+"/i";
				       	   String final_xpath1 = first_part+r+second_part+1+third_part;
			               String [] measure_id_a =Setup.driver.findElement(By.xpath(final_xpath1)).getText().split(" ",3);
			               String arrow_query="select IsDownwardTrending from  ViewMeasureComputationSummary where PracticeUid='"+UtilityFunction.practiceuid+"' and ProviderUid ='"+provideruid+"' and Flag='"+UtilityFunction.duration_flag+"' and QuarterEndDate='"+quarterenddate+"' and MeasureId='"+measure_id_a[1]+"'";
			               int actual_arrow = 0;
		    	  	       rs1=db_exe.SQLserverConnection1(arrow_query);
		    	           while(rs1.next()){
		    			        actual_arrow=Integer.parseInt(rs1.getString(1));	   
			    		         }
			               String [] arrow_class=Setup.driver.findElement(By.xpath(final_xpath)).getAttribute("class").split(" ");
				           String expected_arrow_dir=null;
				           if(actual_arrow==1)
				           {
				        	   expected_arrow_dir="icon-arrow-down";
				           }
				           else
				           {
				        	   expected_arrow_dir="icon-arrow-up";
				           }
				           System.out.println("actual arrow is"+arrow_class[0]);
				           System.out.println("expected is "+expected_arrow_dir);
				           Assert.assertEquals(arrow_class[0],expected_arrow_dir);
				           return "Pass";
				    	  
				           
				     } //for end
				 }//else ends
			 }//if end
			} 
			 return "Pass";
		  }
		  catch(Exception e)
		  {
			Setup.log.fatal(e.toString());
			e.printStackTrace();
			return "Fail to check measure up n down arrow";
			  
		  }
	 
 }
 
/**
 * @author Nikita Desai
 * @param data
 * @return
 */
//////////function to check provider score of all measure
public String checkProviderScoreofMeasure(String data)
{
   try
	  {
		 if(gotoProvider(data).equals("Pass"))
		 {
			 if(providercount==0)
			 {
				 System.out.println("No record Present for practice");
				 String no_row=Setup.driver.findElement(By.xpath(".//*[@id='row']")).getText();
			    
				 Assert.assertEquals(no_row,"No record found for given criteria.");
				 return "Pass";
			 }
			else
			{	 
			 if(ele.isElementPresent(By.xpath(".//*[@id='sample-table-1']/tbody[2]/tr/td")))
			  {
			      String no_record=ele.gettext("xpath",".//*[@id='sample-table-1']/tbody[2]/tr/td");
			      Assert.assertEquals(no_record, "No record found for given criteria.");
			      System.out.println("No record present For Provider");
			      return "Pass";
			  }
			 
			 else
			 { 	  
				 String quarter_end_date_query="select distinct Date  from Calendar where "+ UtilityFunction.mq_column +"='"+UtilityFunction.duration+"' and year ='"+UtilityFunction.duration_yr+"'"; 
			  //String quarter_end_date_query="select distinct QuarterEndDate  from ViewMeasureComputationSummary where  QuarterName='"+UtilityFunction.duration+"'";
			  rs1=db_exe.SQLserverConnection1(quarter_end_date_query);
			 
			  while(rs1.next()){
			    	   quarterenddate=rs1.getString(1);	  
			       } 
			 
			//no of row and columns of measures listed under provider 
			
			 int row=Setup.driver.findElements(By.xpath(".//*[@id='sample-table-1']/tbody[1]/tr")).size();
                         int col=Setup.driver.findElements(By.xpath(".//*[@id='sample-table-1']/tbody[1]/tr[1]/td")).size();
	                 System.out.println("no rows"+row+"column is "+col);
			 String first_part =".//*[@id='sample-table-1']/tbody[1]/tr[";
			 String second_part = "]/td[";
			 String third_part = "]";
			 String fourth_part="/table/tbody/tr/td/table/tbody/tr/td[";
			 String fifth_part="]";
			 
			    for (int r=1;r<row;r=r+2){
			    	  //check provider score measure
			    	 String practice_score_xpath = first_part+r+second_part+3+third_part+fourth_part+2+fifth_part;
			       	
			       	 String measure_id_xpath =first_part+r+second_part+1+third_part;
		             String [] measure_id_a = Setup.driver.findElement(By.xpath(measure_id_xpath)).getText().split(" ",3);
		             
		               String practice_score_actual=Setup.driver.findElement(By.xpath(practice_score_xpath)).getText();
		               String mquery1="select cast(Average*100 as decimal (6,2)) from  ViewMeasureComputationSummary where  PracticeUid='"+UtilityFunction.practiceuid+"' and ProviderUid ='"+provideruid+"'and Flag='"+UtilityFunction.duration_flag+"' and QuarterEndDate = '"+quarterenddate+"' and MeasureId='"+measure_id_a[2]+"'";
		               System.out.println("query is"+mquery1);
		               rs1=db_exe.SQLserverConnection1(mquery1);
		              String practice_score_expected=null;
	    	           while(rs1.next()){
	    			        practice_score_expected=rs1.getString(1)+"%";	   
		    		         }
		               
			            System.out.println("actual provider score is"+practice_score_actual);
			            System.out.println("expected provider score is "+practice_score_expected);
			            Assert.assertEquals(practice_score_actual,practice_score_expected);
			            
			        } //for end
			 }//else ends
		 }//if end
		} 
		 return "Pass";
	  }
	  catch(Exception e)
	  {
		Setup.log.fatal(e);
		e.printStackTrace();
		return "Fail to check measure score";
		  
	  }


}

/**
 * @author Nikita Desai
 * @param data
 * @return
 */
//function to check favorite measure
public String checkProviderFavoriteMeasure(String data)
{
   try
	  {
	     int flag_pr=0;
		 int pro_count=0;
		 String pro_uid=null;
		String provider_count_query="select COUNT(serviceprovideruid) from ViewServiceProvider where PracticeUid='"+UtilityFunction.practiceuid+"' and Inactive=0 and Type in ('1','3')";
		System.out.println("query is "+provider_count_query);
		rs1=db_exe.SQLserverConnection(provider_count_query);
	      while(rs1.next()){
	    	   pro_count=Integer.parseInt(rs1.getString(1));	  
	          } 
	    providercount=pro_count;
	    System.out.println("Provider count is"+providercount);
		if(providercount==0)
		   {
			 String no_row=ele.gettext("xpath",".//*[@id='row']");
			 Assert.assertEquals(no_row,"No record found for given criteria.");
		     System.out.println("No record present for practice");
			 return "Pass";
		   }
	   else
	   {
	       int p_count=providercount;
	      if(ele.isElementPresent(By.xpath(".//*[@id='divProviderPager']/a[contains(text(),'<<')]")))
	      {	   
	            String style_first=Setup.driver.findElement(By.xpath(".//*[@id='divProviderPager']/a[contains(text(),'<<')]")).getCssValue("cursor"); 
                 if(style_first.equals("pointer"))
                   {
        	          ele.click_element("xpath",".//*[@id='divProviderPager']/a[contains(text(),'<<')]");
			          System.out.println("go to first page");
			          Thread.sleep(1000);
			       }
	      } 
			
	    int j=0;
	    do
	      {
	    	 String quarter_end_date_query="select distinct Date  from Calendar where "+ UtilityFunction.mq_column +"='"+UtilityFunction.duration+"' and year ='"+UtilityFunction.duration_yr+"'";
	    	//String quarter_end_date_query="select distinct QuarterEndDate  from ViewMeasureComputationSummary where  QuarterName='"+UtilityFunction.duration+"'";
			  rs1=db_exe.SQLserverConnection1(quarter_end_date_query);
			 
			  while(rs1.next()){
			    	   quarterenddate=rs1.getString(1);	  
			       } 
			  
	    	 Setup.driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS); 
	    	 List<WebElement> elements=Setup.driver.findElements(By.xpath(".//div[@class='panel panel-default']"));
	         for(int i=0 ;(i<elements.size());i++)
	         {
	        	// if(elements.get(i).getText() != null)
 	                
 	    	       String provider_data=elements.get(i).getText();
 	    	       String [] words=provider_data.split("\n");
	    	       System.out.println(provider_data);   	  
 		           String pro_name=words[0].replace(" ","%");
 	               exceed=Integer.parseInt(words[1]);
 	    	       below=Integer.parseInt(words[2]);
 	    	      
  	               if((exceed > 0) || (below > 0))
  	               {  
  	            	 String provider_uid_query="select ServiceProviderUid from ViewServiceProvider where practiceuid='"+UtilityFunction.practiceuid+"' and name like '%"+pro_name+"'";
    	             System.out.println(provider_uid_query);
   	    	         rs1=db_exe.SQLserverConnection(provider_uid_query);
    	               while(rs1.next()){
    			        pro_uid=rs1.getString(1).toLowerCase();	
    			        
  	    		       }
    	               provideruid=pro_uid;
    	             System.out.println("provider uid is"+provideruid); 
  	            	  String first=".//*[@id='";
	     	          String second="row";
	     	          String third="']/div[1]/h4/div/table/tbody/tr/td[1]/a";
	     	          	//	+ "[contains(text(),'";
	     	          //String fourth="')]";
	     	          String finalpath=first+second+provideruid+third;
	     	        		  //+words[1]+fourth;
	     	          String opened_path=".//*[@id='collapse"+provideruid+"']"; 
	     	          String opened_class=Setup.driver.findElement(By.xpath(opened_path)).getAttribute("class");
	     	          if(opened_class.equals("panel-collapse in"))
	     	          {
	     	        	  System.out.println("Provider is already opened");
	     	        	
	     	          }
	     	          else
	     	          {	  
	     	             Setup.driver.findElement(By.xpath(finalpath)).click();
	     	          }
	     	          
	     	             int row=Setup.driver.findElements(By.xpath(".//*[@id='sample-table-1']/tbody[1]/tr")).size();
	     	             int col=Setup.driver.findElements(By.xpath(".//*[@id='sample-table-1']/tbody[1]/tr[1]/td")).size();
	     		         System.out.println("no rows"+row+"column is "+col);
	     				 String first_part =".//*[@id='fav";
	     				 String second_part = "']";
	     				 String fig_uid=buisness.core.login.AfterLoginUtility.getFIGUerUID();
	     				 String mquery1="select COUNT(value)  from FIGUserFavorite where figuseruid='"+fig_uid+"' ";
	     		         int exp_f_count=0;
	     		  	     rs1=db_exe.SQLserverConnection1(mquery1);
	     		           while(rs1.next()){
	     				        exp_f_count=Integer.parseInt(rs1.getString(1));	   
	     	  		         }
	     		           int act_f_count=0;
	     				    for (int r=1;r<row;r=r+2){
	     				    	  //check provider score measure
	     				    	   String final_xpath1 =".//*[@id='sample-table-1']/tbody[1]/tr["+r+"]/td["+1+"]";
	     				           String [] measure_id_a = Setup.driver.findElement(By.xpath(final_xpath1)).getText().split(" ",3);
	     				           String mquery="select NationalProgramQualityMeasureUid from ViewMeasureComputationSummary vc where  PracticeUid='"+UtilityFunction.practiceuid+"' and ProviderUid ='"+provideruid+"'and Flag='"+UtilityFunction.duration_flag+"' and QuarterEndDate = '"+quarterenddate+"' and MeasureId='"+measure_id_a[2]+"'";
	     				           String measure_uid=null;
	     			    	  	   rs1=db_exe.SQLserverConnection1(mquery);
	     			    	           while(rs1.next()){
	     			    			        measure_uid=rs1.getString(1).toLowerCase();	   
	     				    		         }
	     				               String fav_path=first_part+measure_uid+second_part;		  
	     			    	           String fav_class=Setup.driver.findElement(By.xpath(fav_path)).getAttribute("class");
	     					           System.out.println("favorite class is"+fav_class);
	     					           if(fav_class.contains("empty"))
	     					           {
	     					        	   System.out.println(measure_id_a[2]+"is not favorite");
	     					        	  
	     					           }
	     					           else
	     					           {
	     					        	   System.out.println(measure_id_a[2]+"is favorite measure");
	     					        	   act_f_count=act_f_count+1;
	     					           }
	     				            
	     				        } //for end
	     				    
	     				    
	     				    if(exp_f_count==act_f_count)
	     				    {
	     				    	System.out.println("count matched");
	     				    	System.out.println("Actual count is"+act_f_count);
	     				    	System.out.println("expected count is"+exp_f_count);
	     				    	Assert.assertEquals(act_f_count,exp_f_count);
	     				    	flag_pr=1;
	     				        return "Pass";
	     				    }
	     				    else
	     				    {
	     				    	System.out.println("Actual count is"+act_f_count);
	     				    	System.out.println("expected count is"+exp_f_count);
	     				    	Assert.fail("Fail to match Favorite mesaure count");
	     				    }
	     	          }
	   		       	
  	              
	   		       j++;
	   		       p_count=p_count-1;
 	             } 
	   		        	      
	    	
	         if(ele.isElementPresent(By.xpath(".//*[@id='divProviderPager']/a[contains(text(),'>')]")))
	         {	 
	          String style_next=Setup.driver.findElement(By.xpath(".//*[@id='divProviderPager']/a[contains(text(),'>')]")).getCssValue("cursor"); 
	          if(style_next.equals("pointer"))
	          {
	          	 ele.isElementPresent(By.xpath(".//*[@id='divProviderPager']/a[contains(text(),'>')]"));
              }
	         } 
        Thread.sleep(2000);
        
	   }while(p_count!=0);
	    
	    if(flag_pr==0)
	    {
	    	System.out.println("There is no such provider having any data");
	    	return "Pass";
	    }
	   }  
	return "Pass";
			
		 
		 
		
	  }
	  catch(Exception e)
	  {
		Setup.log.fatal(e.toString());
		e.printStackTrace();
		return "Fail to check measure score";
		  
	  }
}
 
/**
 * @author Nikita Desai
 * @param data
 * @param data1
 * @return
 */
// go to specific measure
public String gotoMeasure(String data,String data1)
{
   try
	  {
	  
	      int measure_flag=0;
	   if(data1.isEmpty())
          {
	                   System.out.println("Measure id is not given. \n Please give Measure");
	                   return "Pass";
          }
	   else
	    {	  
		  if(gotoProvider(data).equals("Pass"))
		   {
			// Thread.sleep(1000);
			 if(providercount==0)
			 {
				 System.out.println("No record Present for practice");
				 String no_row=ele.gettext("xpath",".//*[@id='row']");
				 Assert.assertEquals(no_row,"No record found for given criteria.");
			     
				 return "Pass";
			 }
			else
			{	 
			     if(ele.isElementPresent(By.xpath(".//*[@id='sample-table-1']/tbody[2]/tr/td")))
			       {
			           String no_record=ele.gettext("xpath",".//*[@id='sample-table-1']/tbody[2]/tr/td");
			           Assert.assertEquals(no_record, "No record found for given criteria.");
			           System.out.println("No record present for Provider");
			           return "Pass";
			        }
			   else
			    { 	  
			 		 
				    int row=Setup.driver.findElements(By.xpath(".//*[@id='sample-table-1']/tbody[1]/tr")).size();
                    System.out.println("no rows"+row);
                    String first_part1 =".//*[@id='sample-table-1']/tbody[1]/tr[";
            	    String second_part1 = "]/td[";
            	    String third_part1 = "]";
            	  
		          for (int r1=1;r1<row;r1=r1+2)
		          {
		               	String final_xpath1 =first_part1+r1+second_part1+1+third_part1;
		             	System.out.println(Setup.driver.findElement(By.xpath(final_xpath1)).getText());
			            String [] measure_id_a1 = Setup.driver.findElement(By.xpath(final_xpath1)).getText().split(" ",3);
			          //  System.out.println("measure id is "+measure_id_a1[2]);
			            if(measure_id_a1[2].equals(data1))
			              {	
			        	        Setup.driver.findElement(By.xpath(final_xpath1)).click();
			        	        measure_flag=1;
			                    return "Pass";   	
			              }
			        		    	   
			     } //for end
			    
			    if(measure_flag==0)
			    {
			    	System.out.println("Given Measure "+data1+" is not present ");
			    	return "Fail";
			    }
			    
			    
			 }//else ends
		    }//if end
		 }		 
		 else if(!gotoProvider(data).equals("Pass"))
		 {
			 return "Fail";
		 }
	    }  
		 return "Pass";
	  }
	  catch(Exception e)
	  {
		Setup.log.fatal(e);
		
		e.printStackTrace();
		return "Fail to get measure ";
		  
	  }
}
 
/**
 * @author Nikita Desai
 * @param data
 * @param data1
 * @return
 */
 public String checkProviderMeasureSpecific(String data,String data1)
 {
	 try
	 {
		 if(gotoMeasure(data,data1).equals("Pass"))
		 {
			 if(providercount==0)
			 {
				 System.out.println("No record Present for practice");
				 String no_row=ele.gettext("xpath",".//*[@id='row']");
				 Assert.assertEquals(no_row,"No record found for given criteria.");
				 return "Pass";
			 }
			else
			{	 
			 System.out.println("click to measure"+data1);
			// Thread.sleep(1000);
			 String quarter_end_date_query="select distinct Date  from Calendar where "+ UtilityFunction.mq_column +"='"+UtilityFunction.duration+"' and year ='"+UtilityFunction.duration_yr+"'";
			 // String quarter_end_date_query="select distinct QuarterEndDate  from ViewMeasureComputationSummary where  QuarterName='"+UtilityFunction.duration+"'";
			  rs1=db_exe.SQLserverConnection1(quarter_end_date_query);
			 
			  while(rs1.next()){
			    	   quarterenddate=rs1.getString(1);	  
			       } 
			 
			 String mquery="select NationalProgramQualityMeasureUid from ViewMeasureComputationSummary vc where  PracticeUid='"+UtilityFunction.practiceuid+"' and ProviderUid ='"+provideruid+"'and Flag='"+UtilityFunction.duration_flag+"' and QuarterEndDate = '"+quarterenddate+"' and MeasureId='"+data1+"'";  
			 String tableuid=null;
	  	     rs1=db_exe.SQLserverConnection1(mquery);
	            while(rs1.next()){
			        tableuid=rs1.getString(1).toLowerCase();	   
   		          }
	         System.out.println("tale_uid is"+tableuid);
	           String first1 =".//*[@id='divGraph";
			   String second1 ="']/div[4]/div[2]/table/tbody/tr";
			   String third1="[";
			   String fourth1="]/td[";
			   String fifth="]";
			   String table_path=first1+tableuid+second1;
			   System.out.println(table_path);
			   //Thread.sleep(1000);
	           List<WebElement> tables= Setup.driver.findElements(By.xpath(table_path));
	           int trow=tables.size();
	           String col_path=table_path+"[1]/td";
		       int tcol=Setup.driver.findElements(By.xpath(col_path)).size();
              System.out.println("no rows"+trow+"column is "+tcol); 
              String [][] tb_data=new String[trow][tcol];
              //get UI data in table
              for (int r1=1,u=0;(r1<=trow) && (u<trow);r1++,u++)
              { 	
                for(int c1=1,v=0;(c1<=tcol) && (v<tcol);c1++,v++)
                {	  
	               String tbody_path=table_path+third1+r1+fourth1+c1+fifth;
                   String tb_a_data=Setup.driver.findElement(By.xpath(tbody_path)).getText();
                   tb_data[u][v]=tb_a_data; 
                   System.out.println("actual data is"+tb_data[u][v]);
                }
              }	
              
              //get data from database
              String mquery1="select QuarterName,Denominator,Numerator,NotMet , cast(Average*100 as decimal(6,2)) from ViewMeasureComputationSummary  where PracticeUid='"+UtilityFunction.practiceuid+"' and ProviderUid ='"+provideruid+"'and Flag='"+UtilityFunction.duration_flag+"' "+
              		 "and QuarterEndDate <= '"+quarterenddate+"' and QuarterEndDate >= DATEADD(q, DATEDIFF(q,365,'"+quarterenddate+"')+1,0)"+ 
                      " and NationalProgramQualityMeasureUid ='"+tableuid+"'order by QuarterName desc "; 
      	      String [][]measure_exp=new String[trow][5];
      	      int k=0;
      	
      	      rs1=db_exe.SQLserverConnection1(mquery1);
      	     while(rs1.next()){
      	    	                    measure_exp[k][0]=rs1.getString(1);
      	    	                    measure_exp[k][1]=rs1.getString(2);
      	    	                    measure_exp[k][2]=rs1.getString(3);
      	    	                    measure_exp[k][3]=rs1.getString(4);
      	    	                    measure_exp[k][4]=rs1.getString(5)+" "+"%";
      	          	    			   k++;
      	      	    		      }
      	     // match measure data    	  
      	     for (int u=0;u<trow;u++)
  	          { 	
  	             for(int v=0;v<tcol;v++)
  	                  {	  
  	                       System.out.println("actual is "+tb_data[u][v]);	 
  	                       System.out.println("expected is"+measure_exp[u][v]);
  	    		           Assert.assertEquals(tb_data[u][v],measure_exp[u][v]);
  	                  }
  	            }	
			}    
		 }
		 
		 else if(!gotoMeasure(data,data1).equalsIgnoreCase("Pass"))
		 {
			 return "Fail";
		 }
	      return "Pass";
	 }
	 catch(Exception e)
	  {
		Setup.log.fatal(e.toString());
		e.printStackTrace();
		return "Fail to check  measure data";
		  
	  }
 }

/**
 * @author Nikita Desai
 * @param data
 * @param data1
 * @return
 */
public String checkProviderMeasurePatientDrill(String data, String data1) {
	// TODO Auto-generated method stub
	 try
	 {
		 String table_name=null;
		  String column_name=null;
		 if(gotoMeasure(data,data1).equalsIgnoreCase("Pass"))
		 {
			 //Thread.sleep(1000);
			 if(providercount==0)
			 {
				 System.out.println("No record Present for practice");
				 String no_row=ele.gettext("xpath",".//*[@id='row']");
				 Assert.assertEquals(no_row,"No record found for given criteria.");
				 return "Pass";
			 }
			else
			{	
			  System.out.println("click to measure"+data1);
			  if(UtilityFunction.duration_flag.equalsIgnoreCase("MR"))
          	  {
          		  table_name="MeasureComputationProviderRollingMonthly";
          		  column_name="MonthEndDate";
          	  }
          	  else if(UtilityFunction.duration_flag.equalsIgnoreCase("QR"))
          	  {
          		  table_name="MeasureComputationProviderRollingQuarterly";
          		  column_name="QuarterEndDate";
          	  }
			  
			
			 String mquery="select NationalProgramQualityMeasureUid from [FIGMDHQIManagement].[dbo].NationalProgramQualityMeasure  where   Id='"+data1+"'";  
			 String tableuid=null;
	  	     rs1=db_exe.SQLserverConnection1(mquery);
	            while(rs1.next()){
			        tableuid=rs1.getString(1).toLowerCase();	   
   		          }
	          // System.out.println("tale_uid is"+tableuid);
	           String first1 =".//*[@id='divGraph";
			   String second1 ="']/div[2]/div[2]/table/tbody/tr";
			   String third1="[";
			   String fourth1="]/td[";
			   String fifth="]";
			   String table_path=first1+tableuid+second1;
	           List<WebElement> tables= Setup.driver.findElements(By.xpath(table_path));
	           int trow=tables.size();
	           String col_path=table_path+"[1]/td";
		       int tcol=Setup.driver.findElements(By.xpath(col_path)).size();
               System.out.println("no rows"+trow+"column is "+tcol); 
               String [][] tb_data=new String[trow][tcol];
              //get UI data in table
              for (int r1=1,u=0;(r1<=trow) && (u<trow);r1++,u++)
              { 	
                for(int c1=1,v=0;(c1<=tcol) && (v<tcol);c1++,v++)
                {	  
                  String header_xpath=".//*[@id='divGraph"+tableuid+"']/div[2]/div[2]/table/thead/tr/th["+c1+"]";
              	  String header_name=Setup.driver.findElement(By.xpath(header_xpath)).getText();
              	  System.out.println("Header name is "+header_name);
              	  String duration_xpath=table_path+third1+r1+fourth1+1+fifth;
              	  String duration_name=Setup.driver.findElement(By.xpath(duration_xpath)).getText();
              	  String column_value=null;
              	  String duration_yr=null;
              	  int duration=0;
              	  String calendar_col=null;
              	  System.out.println("Duration is " +duration_name);
              	  if(duration_name.contains("Q"))
              	  {	  
              	    String [] quarters=duration_name.split("Q");
			        duration=Integer.parseInt(quarters[1]);
			        duration_yr=quarters[0];
			        calendar_col="Quarter";
              	  }  
              	  else 
              	  {
              		  String months=duration_name.replaceAll("[0-9]","");
					  duration=UtilityFunction.getMonth(months);
					  duration_yr=duration_name.replaceAll("[a-z|A-Z]","");;
					  calendar_col="Month";
              	  }
              	  if(header_name.contains("+"))
              	  {
              		  column_value="1";
              	  }
              	  else if(header_name.contains("-"))
              	  {
              		  column_value="0";
              	  }
              	  
              	  
              	  String quarter_end_date_query="select distinct Date  from Calendar where "+ calendar_col +"='"+duration+"' and year ='"+duration_yr+"'";
                  System.out.println(quarter_end_date_query); 			  
    			  rs1=db_exe.SQLserverConnection1(quarter_end_date_query);
    			 
    			  while(rs1.next()){
    			    	   quarterenddate=rs1.getString(1);	  
    			       } 
    			 
              	  String tbody_path=table_path+third1+r1+fourth1+c1+fifth;
                  String click_record=Setup.driver.findElement(By.xpath(tbody_path)).getAttribute("class");
                  if(click_record.equals("blue"))
                  { 		
                     int patient_record=Integer.parseInt(Setup.driver.findElement(By.xpath(tbody_path)).getText());
                     System.out.println("patient record is "+patient_record);
                     int record_count=patient_record; 
                    
                    if(patient_record!=0)
                    {	   
                       Setup.driver.findElement(By.xpath(tbody_path)).click();
                       Thread.sleep(2000);
                    
                      int u1=0;
                      String [][]patient_drill_table_a=new String[record_count][4];
                      do
                      {
                    	  
                    	  Setup.driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS); 
                    	  int p_row=Setup.driver.findElements(By.xpath(".//*[@id='tblPatientList']/tbody[1]/tr")).size();
                          int p_col=Setup.driver.findElements(By.xpath(".//*[@id='tblPatientList']/tbody[1]/tr[1]/td")).size();
                            //patient_drill_table_a =new String[p_row][p_col];
                          for (int p_r=1;(p_r<=p_row);p_r++)
                          { 	
                                int v1=0;	
                              	System.out.print("\n");		
                              	System.out.println(patient_record);
                            for(int p_c=1;(p_c<=p_col);p_c++)
                              {	  
                                 String patient_drill_down_xpath=".//*[@id='tblPatientList']/tbody[1]/tr["+p_r+"]/td["+p_c+"]";
                                 String p_data=Setup.driver.findElement(By.xpath(patient_drill_down_xpath)).getText();
                                 
                                 patient_drill_table_a[u1][v1]=p_data;
                                 System.out.print("\t"+patient_drill_table_a[u1][v1]);
                                 v1++;
                              }
                                u1++;
                                patient_record--;
                          }
                      
                         if(ele.isElementPresent(By.xpath(".//*[@id='divProviderDrilDownPager']/a[contains(text(),'>')]")))
                          { 	 
                               String style_next=Setup.driver.findElement(By.xpath(".//*[@id='divProviderDrilDownPager']/a[contains(text(),'>')]")).getCssValue("cursor"); 
                               if(style_next.equals("pointer"))
                                  {
                      	                ele.click_element("xpath",".//*[@id='divProviderDrilDownPager']/a[contains(text(),'>')]");
                      	           }
                          }   
                         else
                           {
                    	             ele.click_element("xpath",".//*[@id='ModalNumerator']/div/div/div[1]/button");
                           }
                         Thread.sleep(3000);
                      }while(patient_record!=0); 
                     

          String cdr_query="select ServerName ,DatabaseName  from ClinicalDataRepository where ClinicalDataRepositoryUid in ( "
          		+ " select ClinicalDataRepositoryUid  from practice where PracticeUid ='"+UtilityFunction.practiceuid+ "')";
          
          rs1=db_exe.SQLserverConnection(cdr_query);
          String server = null,dbname=null;
          while(rs1.next()){
        	  server=rs1.getString("servername");
        	  dbname=rs1.getString("databasename");
          }
          
          String patient_details_query="select * from ["+server+"] . ["+ dbname +"].[dbo]. ViewPatientFromWeb where PatientUid in "+
                		   " (select patientuid from [FIGMDWebDev].[dbo]."+table_name+ 
                		   " where PracticeUid='"+UtilityFunction.practiceuid+"' and ProviderUid ='"+provideruid+"'  and MeasureUid='"+tableuid+"'" +
                		   " and " + column_name+ " = ' "+quarterenddate+"' and Numerator  ='"+column_value+"' ) ";

                		   
                	
                		  //"exec [SP_GetPatientDetails] @MeasureComputationSummaryUid='"+measure_compt_uid+"', @DataField='"+column_name+"' , @PageNumber=1, @PageSize=600";    	                                    	
                   
                   String [][]patient_drill_table_exp=new String[record_count][4];
	    		   int k=0;
	    		   System.out.println(patient_details_query);
 	    	  	   
	    		   rs1=db_exe.SQLserverConnection1(patient_details_query);
 	    	  	     
 	    	  	   while(rs1.next()){
 	    	            	patient_drill_table_exp[k][0]=rs1.getString("Name");
 	    	            	patient_drill_table_exp[k][1]=rs1.getString("MRN");
 	    	            	patient_drill_table_exp[k][2]=rs1.getString("Gender");
 	    	            	patient_drill_table_exp[k][3]=rs1.getString("DOB");
 	    			        System.out.println("expected data is "+patient_drill_table_exp[k][0]+"\t"+patient_drill_table_exp[k][1]
 	    			            		             +"\t"+patient_drill_table_exp[k][2]+"\t"+patient_drill_table_exp[k][3]);
 	    			       k++;
    	    		      }
 	    	  	    Arrays.sort(patient_drill_table_a, new configuration.ColumnComparator(0));
 	    	  	    Arrays.sort(patient_drill_table_exp, new configuration.ColumnComparator(0));
 	    	  	    for (int u2=0;u2<record_count;u2++)
                    { 	
                     for(int v2=0;v2<4;v2++)
                     {	  
                       System.out.println("actual is "+patient_drill_table_a[u2][v2]);	 
                       System.out.println("expected is"+patient_drill_table_exp[u2][v2]);
		               Assert.assertEquals(patient_drill_table_a[u2][v2], patient_drill_table_exp[u2][v2]);
                     }
                   }	
                      
                     
 	    	  	 
                }
                else if (patient_record==0)
                {
                  	Setup.driver.findElement(By.xpath(tbody_path)).click();
                  	Thread.sleep(2000);
                  	ele.wait_page_load();
                  	String no_record=Setup.driver.findElement(By.xpath(".//*[@id='tblPatientList']/tbody[1]/tr/td")).getText();
                  	Assert.assertEquals(no_record,"No record found for given criteria.");
                  	Setup.driver.findElement(By.xpath(".//*[@id='ModalNumerator']/div/div/div[1]/button")).click();
                  }
              
              }	
	      
                }
              }	
			}   
            
		 }
		 
		 else if(!gotoMeasure(data,data1).equalsIgnoreCase("Pass"))
		 {
			 return "Fail";
		 }
	      return "Pass";
	 }
	 catch(Exception e)
	  {
		Setup.log.fatal(e.toString());
		e.printStackTrace();
		Assert.assertTrue(false, e.getMessage());
		return "Fail to check  measure data";
		  
	  }
	 finally
	 {
		 close_Patientdrill();
	 }
}

/**
 * @author Nikita Desai
 */
private void close_Patientdrill() {
	// TODO Auto-generated method stub
	if(ele.isElementPresent(By.xpath(".//*[@id='ModalNumerator']/div/div/div[1]/button")))
	 {
		 if(ele.click_element("xpath",".//*[@id='ModalNumerator']/div/div/div[1]/button").equals("Pass"))
			{
				System.out.println("click to 'Done'");
			}
			
	 }
}

/**
 * @author Nikita Desai
 * @param string
 * @return
 */

public String checkDefaultduration(String string) {
try
{
	if(Setup.driver.findElement(By.xpath(".//*[@id='radioQuartly']")).isSelected())
    {
		System.out.println("Quarterly radio button is selected");
		WebElement e=Setup.driver.findElement(By.xpath(".//*[@id='ddlQuarter']"));
		
		String quarter_a = new Select(Setup.driver.findElement(By.xpath(".//*[@id='ddlQuarter']"))).getFirstSelectedOption().getText();
		if(!quarter_a.equals("2014Q3"))
		{	
		  Select quarter_list=new Select(e);
		  quarter_list.deselectByVisibleText(quarter_a);
		  quarter_list.selectByIndex(0);
		  quarter_a = new Select(Setup.driver.findElement(By.xpath(".//*[@id='ddlQuarter']"))).getFirstSelectedOption().getText();
		}
		
		System.out.println(quarter_a);
        String first_Quarterdata_query="select MAX(quartername)  from ViewMeasureComputationSummary where PracticeUid='"+UtilityFunction.practiceuid+"' and Flag='QR'";
		System.out.println(first_Quarterdata_query);
        rs1=db_exe.SQLserverConnection1(first_Quarterdata_query);
		String quarter_e=null;
		String quarter = null;
		 while(rs1.next()){
		    	   quarter=rs1.getString(1);	  
		       }
		  if(quarter==null)
		  {
			  quarter_e="2014Q3";
		  }
		  else
		  {
			  quarter_e=quarter;
		  }

		  System.out.println("actual quarter is "+quarter_a);
		  System.out.println("expected quarter is "+quarter_e);
		  Assert.assertEquals(quarter_a, quarter_e);
    }
	else
	{
		
		System.out.println("As Quarter radio button default not selected");
		if(ele.radioselect_element("xpath",".//*[@id='radioQuartly']").equals("Pass"))
		{
		  System.out.println("Quarterly radio button is selected");
		  WebElement e1=Setup.driver.findElement(By.xpath(".//*[@id='ddlQuarter']"));
			
			String quarter_a1 = new Select(Setup.driver.findElement(By.xpath(".//*[@id='ddlQuarter']"))).getFirstSelectedOption().getText();
			if(!quarter_a1.equals("2014Q3"))
			{	
			  Select quarter_list=new Select(e1);
			  quarter_list.deselectByVisibleText(quarter_a1);
			  quarter_list.selectByIndex(0);
			  quarter_a1 = new Select(Setup.driver.findElement(By.xpath(".//*[@id='ddlQuarter']"))).getFirstSelectedOption().getText();
			}
			
			System.out.println(quarter_a1);
	        String first_Quarterdata_query="select MAX(quartername)  from ViewMeasureComputationSummary where PracticeUid='"+UtilityFunction.practiceuid+"' and Flag='QR'";
			rs1=db_exe.SQLserverConnection1(first_Quarterdata_query);
			String quarter_e1=null;
			String quarter1 = null;
			 while(rs1.next()){
			    	   quarter1=rs1.getString(1);	  
			       }
			  if(quarter1==null)
			  {
				  quarter_e1="2014Q3";
			  }
			  else
			  {
				  quarter_e1=quarter1;
			  }

			  System.out.println("actual quarter is "+quarter_a1);
			  System.out.println("expected quarter is "+quarter_e1);
			  Assert.assertEquals(quarter_a1, quarter_e1);
		 }	  
	}
    
  
	return "Pass";
	
}
catch(Exception e)
{
	System.out.println("exception occcured while checking defaut duration");
	e.printStackTrace();
	Setup.log.fatal(e.toString());
	return "Fail to check default duration";
}
}

/**
 * @author Nikita Desai
 * @param data
 * @return
 */
public String checkProviderScoreColor(String data) {
	// TODO Auto-generated method stub
	try
	  {
		 if(gotoProvider(data).equals("Pass"))
		 {
			 if(providercount==0)
			 {
				 System.out.println("There is no record for practice");
				 String no_row=ele.gettext("xpath",".//*[@id='row']");
				 Assert.assertEquals(no_row,"No record found for given criteria.");
				 return "Pass";
			 }
			else
			{	 
			 Thread.sleep(1000);
			 if(ele.isElementPresent(By.xpath(".//*[@id='sample-table-1']/tbody[2]/tr/td")))
			  {
			      String no_record=ele.gettext("xpath",".//*[@id='sample-table-1']/tbody[2]/tr/td");
			      Assert.assertEquals(no_record, "No record found for given criteria.");
			      System.out.println("No record present for Provider");
			      return "Pass";
			  }
			 
			 else
			 { 	  
				 String quarter_end_date_query="select distinct Date  from Calendar where "+ UtilityFunction.mq_column +"='"+UtilityFunction.duration+"' and year ='"+UtilityFunction.duration_yr+"'"; 
			  //String quarter_end_date_query="select distinct QuarterEndDate  from ViewMeasureComputationSummary where  QuarterName='"+UtilityFunction.duration+"'";
			  rs1=db_exe.SQLserverConnection1(quarter_end_date_query);
			 
			  while(rs1.next()){
			    	   quarterenddate=rs1.getString(1);	  
			       } 
			 
			  
				//no of row and columns of measures listed under provider 
			
			 int row=Setup.driver.findElements(By.xpath(".//*[@id='sample-table-1']/tbody[1]/tr")).size();
           //  int col=Setup.driver.findElements(By.xpath(".//*[@id='sample-table-1']/tbody[1]/tr[1]/td")).size();
	         
			 String first_part =".//*[@id='sample-table-1']/tbody[1]/tr[";
			 String second_part = "]/td[";
			 String third_part = "]";
			 String fourth_part="/table/tbody/tr/td/table/tbody/tr/td[";
			 String fifth_part="]";
			 
			    for (int r=1;r<row;r=r+2){
			    	  //check provider score measure
			    	String provider_score_xpath = first_part+r+second_part+3+third_part+fourth_part+2+fifth_part;
			       	     	  
		            String provider_score_actual=Setup.driver.findElement(By.xpath(provider_score_xpath)).getText();
		            System.out.println("Provider Score is"+provider_score_actual);
		            
		            
			       	 String measure_id_xpath =first_part+r+second_part+1+third_part;
		             String [] measure_id_a = Setup.driver.findElement(By.xpath(measure_id_xpath)).getText().split(" ",3);
		             
		             String Difference_query="select cast(DIFFERENCE as decimal(5,2)) from ViewMeasureComputationSummary where PracticeUid='"+UtilityFunction.practiceuid+
							  "' and Provideruid='"+provideruid+"' and QuarterEndDate='"+quarterenddate+"' and Flag='"+UtilityFunction.duration_flag+"' and MeasureId ='"+measure_id_a[2]+"'";
				               
		            System.out.println("query is"+Difference_query);
		             rs1=db_exe.SQLserverConnection1(Difference_query);
		             
		             double difference = 0 ;
		             while(rs1.next()){
	    			       difference=Double.parseDouble(rs1.getString(1));
		    		     }
		                 	           
			            String reg_query="select CAST(NationalAverage*100 as decimal(6,2)) from ViewMeasureComputationSummary vc where  PracticeUid='"+UtilityFunction.practiceuid+"' and ProviderUid ='"+provideruid+"'and Flag='"+UtilityFunction.duration_flag+"' and QuarterEndDate = '"+quarterenddate+"' and MeasureId='"+measure_id_a[2]+"'"; 
			            float reg = 0;
			            rs1=db_exe.SQLserverConnection1(reg_query);
			            while(rs1.next()){
					        reg=Float.valueOf(rs1.getString(1));	   
		   		          }
			            //get measure uid
						 String mquery="select NationalProgramQualityMeasureUid from ViewMeasureComputationSummary vc where  PracticeUid='"+UtilityFunction.practiceuid+"' and ProviderUid ='"+provideruid+"'and Flag='"+UtilityFunction.duration_flag+"' and QuarterEndDate = '"+quarterenddate+"' and MeasureId='"+measure_id_a[2]+"'";  
						 String measureuid=null;
				  	     rs1=db_exe.SQLserverConnection1(mquery);
				            while(rs1.next()){
						        measureuid=rs1.getString(1).toLowerCase();	   
			   		          }
			          String color_path=".//*[@id='progress"+measureuid+"']"; 
			          
			          //get color class
			          String class_a=Setup.driver.findElement(By.xpath(color_path)).getAttribute("class");
			          
			          //get UI color
			          //class
			          String color=Setup.driver.findElement(By.xpath(color_path)).getCssValue("background-color");
			          String[] numbers = color.replace("rgba(", "").replace(")", "").split(",");
			  		    int r1 = Integer.parseInt(numbers[0].trim());
			  		    int g = Integer.parseInt(numbers[1].trim());
			  		    int b = Integer.parseInt(numbers[2].trim());
			  		    System.out.println("r: " + r1 + "g: " + g + "b: " + b);

			  		    String actualColor = "#" + Integer.toHexString(r1) + Integer.toHexString(g) + Integer.toHexString(b);
			  		    
			  		 System.out.println("Registry benchmark is "+reg);
			  		 float five_per=(float) (-((reg * 0.05) / 100));
			  		 System.out.println("five percent is "+five_per);
			  		 System.out.println("For Measure Id:"+measure_id_a[2]);   
			  		 if(provider_score_actual.equals("0.00%"))
			  		 {
			  			 //provider score is 0 % but check color class 
			  			  System.out.println("There is no color as score is 0.00%");
			  			  if(difference>0.00)
			  		      {
			  		    	//green color class
			  		    	System.out.println("Actual class is"+class_a);
			  		    	System.out.println("Expected class is"+"progress-bar progress-bar-success");
			  		    	Assert.assertEquals(class_a, "progress-bar progress-bar-success");
			  		    	System.out.println("Green color is not present as provider score is"+provider_score_actual);
			  		    	
			  		       }
			  		    else if(difference>=five_per)
			  		      {///check yellow color
			  		    	System.out.println("Actual class is"+class_a);
			  		    	System.out.println("Expected class is"+"progress-bar progress-bar-warning");
			  		    	Assert.assertEquals(class_a, "progress-bar progress-bar-warning");
			  		    	System.out.println("yellow color is not present as provider score is"+provider_score_actual);
			  		    	
			  		      }  
			  		    else
			  		     {  	//check red color
			  		    	System.out.println("Actual class is"+class_a);
			  		    	System.out.println("Expected class is"+"progress-bar progress-bar-danger");
			  		    	Assert.assertEquals(class_a,"progress-bar progress-bar-danger");
			  		    	System.out.println("Red color is not present as provider score is"+provider_score_actual);
			  		    	
			  		     }
			  		 }
			  		 else
			  		 {	//check diffference 
			  		    if(difference>0.00)
			  		    {
			  		    	//green color
			  		    	System.out.println("diffence is"+difference);
			  		    	System.out.println("Actual color is"+actualColor);
			  		    	Assert.assertEquals(actualColor, "#29b829"); //color matched
			  		    	Assert.assertEquals(class_a, "progress-bar progress-bar-success"); //class mathced
			  		    	System.out.println("Green color is found");
			  		    	
			  		    }
			  		   else if(difference>=five_per)
			  		    {///check yellow color
			  		    	System.out.println("diffence is"+difference);
			  		    	System.out.println("Actual color is"+actualColor);
			  		    	Assert.assertEquals(actualColor, "#ffa63");
			  		    	Assert.assertEquals(class_a, "progress-bar progress-bar-warning");
			  		    	System.out.println("Yellow color is found");
			  		    }  
			  		   else
			  		    {  	//check red color
			  		    	System.out.println("diffence is"+difference);
			  		    	System.out.println("Actual color is"+actualColor);
			  		    	Assert.assertEquals(actualColor, "#f51e1e");
			  		   	    Assert.assertEquals(class_a,"progress-bar progress-bar-danger");
			  		    	System.out.println("Red color is found");
			  		    }
			  		 } 
			        } //for end
			 }//else ends
		  }//if end
		 } 
		 return "Pass";
	  }
	  catch(Exception e)
	  {
		Setup.log.fatal(e.toString());
		e.printStackTrace();
		return "Fail to check provider score color";
		  
	  }
}

/**
 * @author Nikita Desai
 * @param data
 * @return
 */
public String selectFavoriteMeasure(String data) {
	// TODO Auto-generated method stub
try
{    
		int flag_pr=0;
		int pro_count=0;
		String provider_count_query="select COUNT(serviceprovideruid) from ViewServiceProvider where PracticeUid='"+UtilityFunction.practiceuid+"' and Inactive=0 and Type in ('1','3')";
		System.out.println("query is "+provider_count_query);
		rs1=db_exe.SQLserverConnection(provider_count_query);
	      while(rs1.next()){
	    	   pro_count=Integer.parseInt(rs1.getString(1));	  
	          } 
	    providercount=pro_count;
	    System.out.println("Provider count is"+providercount);
		if(providercount==0)
		   {
			 String no_row=ele.gettext("xpath",".//*[@id='row']");
			 Assert.assertEquals(no_row,"No record found for given criteria.");
		     System.out.println("No record present for practice");
			 return "Pass";
		   }
	  else
	   {
	    int p_count=providercount;
	    if(ele.isElementPresent(By.xpath(".//*[@id='divProviderPager']/a[contains(text(),'<<')]")))
	    {	   
	      String style_first=Setup.driver.findElement(By.xpath(".//*[@id='divProviderPager']/a[contains(text(),'<<')]")).getCssValue("cursor"); 
         if(style_first.equals("pointer"))
          {
         	 ele.click_element("xpath",".//*[@id='divProviderPager']/a[contains(text(),'<<')]");
			 System.out.println("go to first page");
			 Thread.sleep(1000);
			 
		 }
	   } 
			
	    int j=0;
	    do
	      {
	    	 Setup.driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS); 
	    	 List<WebElement> elements=Setup.driver.findElements(By.xpath(".//div[@class='panel panel-default']"));
	         for(int i=0 ;(i<elements.size());i++)
	         {
	        	// if(elements.get(i).getText() != null)
  	             {	   
  	    	       String provider_data=elements.get(i).getText();
  	    	       String [] words=provider_data.split("\n");
 	    	       System.out.println(provider_data);   	  
  		           String pro_name=words[0].replace(" ","%");
  	               exceed=Integer.parseInt(words[1]);
  	    	       below=Integer.parseInt(words[2]);
  	    	       String provider_uid_query="select ServiceProviderUid from ViewServiceProvider where practiceuid='"+UtilityFunction.practiceuid+"' and name like '%"+pro_name+"'";
   	               System.out.println(provider_uid_query);
  	    	       rs1=db_exe.SQLserverConnection(provider_uid_query);
   	               while(rs1.next()){
   			        provideruid=rs1.getString(1).toLowerCase();	
   			        System.out.println("provider uid is"+provideruid);
	    		       }

   	               if(exceed > 0 || below >0)
   	               {  
   	            	  String first=".//*[@id='";
 	     	          String second="row";
 	     	          String third="']/div[1]/h4/div/table/tbody/tr/td[1]/a";
 	     	          	//	+ "[contains(text(),'";
 	     	          //String fourth="')]";
 	     	          String finalpath=first+second+provideruid+third;
 	     	        		  //+words[1]+fourth;
 	     	          String opened_path=".//*[@id='collapse"+provideruid+"']"; 
	     	          String opened_class=Setup.driver.findElement(By.xpath(opened_path)).getAttribute("class");
	     	          if(opened_class.equals("panel-collapse in"))
	     	          {
	     	        	  System.out.println("Provider is already opened");
	     	        	//  return "Pass";
	     	          }
	     	          else
	     	          {	  
 	     	              Setup.driver.findElement(By.xpath(finalpath)).click();
	     	          }   
 	     	          if(gotomeasureid(data).equals("Pass"))
 	     	           {
 	     	        	 //System.out.println("Test case Passed");
 	     	        	 flag_pr=1;
 	     	        	 return "Pass";  
 	     	        	}
 	     	          else
 	     	          {
 	     	        	return "Fail";  
 	     	          }
	   		        }
   	              
	   		       j++;
	   		       p_count=p_count-1;
  	             } 
	   		        	      
	    	    } //first for end
	         if(ele.isElementPresent(By.xpath(".//*[@id='divProviderPager']/a[contains(text(),'>')]")))
	         {	 
	          String style_next=Setup.driver.findElement(By.xpath(".//*[@id='divProviderPager']/a[contains(text(),'>')]")).getCssValue("cursor"); 
	          if(style_next.equals("pointer"))
	          {
	          	 ele.isElementPresent(By.xpath(".//*[@id='divProviderPager']/a[contains(text(),'>')]"));
              }
	         } 
         Thread.sleep(2000);
         
	   }while(p_count!=0);
	    
	    if(flag_pr==0)
	    {
	    	System.out.println("There is no such proivder having any data");
	    	return "Pass";
	    }
	   }  
	return "Pass";
 }
 catch(Exception e)
 {
	 System.out.println("Exception occured while selecting favorite measure");
	 Setup.log.fatal(e.toString());
	 e.printStackTrace();
	 return "Fail";
 }
	
 
}

/**
 * @author Nikita Desai
 * @param data
 * @return
 */
private String gotomeasureid(String data) {
  try
	{	
	   int flag_pr=0;
	   if(data.isEmpty())
	   {
		   System.out.println("Please Provide Measure id");
		   return "Pass";
	   }
	   
	  else
	  {	   
		  String quarter_end_date_query="select distinct Date  from Calendar where "+ UtilityFunction.mq_column +"='"+UtilityFunction.duration+"' and year ='"+UtilityFunction.duration_yr+"'";
		  //String quarter_end_date_query="select distinct QuarterEndDate  from ViewMeasureComputationSummary where  QuarterName='"+UtilityFunction.duration+"'";
		  rs1=db_exe.SQLserverConnection1(quarter_end_date_query);
		 
		  while(rs1.next()){
		    	   quarterenddate=rs1.getString(1);	  
		       } 
		   
	    int row=Setup.driver.findElements(By.xpath(".//*[@id='sample-table-1']/tbody[1]/tr")).size();
         
        String first_part =".//*[@id='sample-table-1']/tbody[1]/tr[";
	    String second_part = "]/td[";
	    String third_part = "]";
	  
	   
	    for (int r=1;r<row;r=r+2)
	    {
	    	            
	       	String measure_id_xpath =first_part+r+second_part+1+third_part;
            String [] measure_id_a = Setup.driver.findElement(By.xpath(measure_id_xpath)).getText().split(" ",3);
            String mquery="select NationalProgramQualityMeasureUid from ViewMeasureComputationSummary vc where  PracticeUid='"+UtilityFunction.practiceuid+"' and ProviderUid ='"+provideruid+"'and Flag='"+UtilityFunction.duration_flag+"' and QuarterEndDate = '"+quarterenddate+"' and MeasureId='"+measure_id_a[2]+"'";  
			
            System.out.println(mquery);
            String measureuid=null;
	  	     rs1=db_exe.SQLserverConnection1(mquery);
	            while(rs1.next()){
			        measureuid=rs1.getString(1).toLowerCase();	   
  		          }
         
	        if(measure_id_a[2].equals(data))
            {
            	
	        	String fav_xpath=".//*[@id='fav"+measureuid+"']";
            	String fav_class=Setup.driver.findElement(By.xpath(fav_xpath)).getAttribute("class");
            	System.out.println("class is"+fav_class);		
            	if(ele.isElementPresent(By.xpath(fav_xpath)))
            	{
            	  if(fav_class.contains("empty"))
                	{
            		  if(ele.click_element("xpath",fav_xpath).equals("Pass"))
            		   {
            			 String Roaster_msg=Setup.driver.findElement(By.xpath(".//*[@class='alert alert-success padding10 border-radius-10 fontSize13']")).getText().trim();
            			 String fig_id=buisness.core.login.AfterLoginUtility.getFIGUerUID();
            			 String fav_measure_count_query="select case when count(*) = 1 then 1 else 0 end from FIGUserFavorite where figuseruid='"+fig_id+"' and value='"+measureuid+"'";
     	    	         rs1=db_exe.SQLserverConnection1(fav_measure_count_query);
                         int db_entry= 0;
     	    	         while(rs1.next()){
     	    			         db_entry=Integer.parseInt(rs1.getString(1));	   
        	    		          	   }
     	    	           if(db_entry==1)
     	    	           {
     	    	        	 System.out.println("Measure id"+measure_id_a[2]+"is selected and entry is inserted in Database");
     	    	        	 Assert.assertEquals(Roaster_msg,"Added to favorites");
     	    	        	 flag_pr=1;
     	    	        	 return "Pass";
     	    	           }
     	    	         else
     	    	           {	 
     	    	        	 System.out.println("Measure id"+measure_id_a[2]+"is selected but entry is not inserted in Database");
     	    	        	 return "Fail as not inserted in db";
     	    	           }
            		    }  
            		  else
            		    {
            			  System.out.println("cant click xpath"+measure_id_a[2]);
            			  return "Fail";
            		     }
            		}
            	  else
            	   {
            		  System.out.println("Meausre id"+measure_id_a[2]+"is already Favoritte measure");
            		  flag_pr=1;
            		  return "Pass";
            	   }
            	 }
              }
           }
	       if(flag_pr==0)
	       {
	    	   System.out.println("Measure not present...Pleasse check measure id");
	    	   return "Pass";
	       }
	    }
	    return "Pass";
	}  
	catch(Exception e)
	{
	    	e.printStackTrace();
	    	System.out.println("Exception while going to measure id");
	    	Setup.log.fatal(e.toString());
	    	return "Fail to go to measure id"+data;
	}

}

/**
 * @author Nikita Desai
 * @param data
 * @return
 */
public String checkfavorite(String data) {
	// TODO Auto-generated method stub
 try
 {
	 String provider_count_query="select COUNT(serviceprovideruid) from ViewServiceProvider where PracticeUid='"+UtilityFunction.practiceuid+"' and Inactive=0 and Type in ('1','3')";
     System.out.println("query is "+provider_count_query);
	 rs1=db_exe.SQLserverConnection(provider_count_query);
	   while(rs1.next()){
	    	   providercount=Integer.parseInt(rs1.getString(1));	  
	          } 
	    System.out.println("Provider count is"+providercount);
	if(providercount==0)
		   {
			 String no_row=ele.gettext("xpath",".//*[@id='row']");
			 Assert.assertEquals(no_row,"No record found for given criteria.");
		     System.out.println("No record present for practice");
			 return "Pass";
		   }
	else
	{
	  int p_count=providercount;
	 if(ele.isElementPresent(By.xpath(".//*[@id='divProviderPager']/a[contains(text(),'<<')]")))
	 {		 
	  String style_first=Setup.driver.findElement(By.xpath(".//*[@id='divProviderPager']/a[contains(text(),'<<')]")).getCssValue("cursor");
	  if(style_first.equals("pointer"))
	  {
			 ele.click_element("xpath",".//*[@id='divProviderPager']/a[contains(text(),'<<')]");
			 System.out.println("go to first page");
			 Thread.sleep(1000);
			
	  }
	 }		
	  int j=0;
	  int flag_pr=0;
	  do
	   {
	    	 Setup.driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS); 
	    	 List<WebElement> elements=Setup.driver.findElements(By.xpath(".//div[@class='panel panel-default']"));
	         for(int i=0 ;(i<elements.size());i++)
	         {
	        	// if(elements.get(i).getText() != null)
	             {	   
	    	       String provider_data=elements.get(i).getText();
	    	       String [] words=provider_data.split("\n");
	    	       System.out.println(provider_data);   	  
		           String pro_name=words[0].replace(" ","%");
	               exceed=Integer.parseInt(words[1]);
	    	       below=Integer.parseInt(words[2]);
	    	       String provider_uid_query="select ServiceProviderUid from ViewServiceProvider where practiceuid='"+UtilityFunction.practiceuid+"' and name like '%"+pro_name+"'";
	               System.out.println(provider_uid_query);
	    	       rs1=db_exe.SQLserverConnection(provider_uid_query);
	               while(rs1.next()){
			        provideruid=rs1.getString(1).toLowerCase();	
			        System.out.println("provider uid is"+provideruid);
	    		       }

	               if(exceed > 0 || below >0)
	               {  
	            	  String first=".//*[@id='";
	     	          String second="row";
	     	          String third="']/div[1]/h4/div/table/tbody/tr/td[1]/a";
	     	          
	     	          String finalpath=first+second+provideruid+third;
	     	        		
	     	          String opened_path=".//*[@id='collapse"+provideruid+"']"; 
	     	          String opened_class=Setup.driver.findElement(By.xpath(opened_path)).getAttribute("class");
	     	          if(opened_class.equals("panel-collapse in"))
	     	          {
	     	        	  System.out.println("Provider is already opened");
	     	        	
	     	          }
	     	          else
	     	          {	  
	     	              Setup.driver.findElement(By.xpath(finalpath)).click();
	     	          }   
	     	          if(favoritemeasure().equals("Pass"))
	     	           {
	     	        	  System.out.println("Test case Passed");
	     	        	  flag_pr=1;
	     	        	  //return "Pass";  
	     	        	}
	     	          else
	     	          {
	     	        	return "Fail to check Favorite measures of all provider";  
	     	          }
	   		        }
	              
	   		       j++;
	   		       p_count=p_count-1;
	             } 
	   		        	      
	    	    } //first for end
	        if(ele.isElementPresent(By.xpath(".//*[@id='divProviderPager']/a[contains(text(),'>')]")))
	        {    		 
	         String style_next=Setup.driver.findElement(By.xpath(".//*[@id='divProviderPager']/a[contains(text(),'>')]")).getCssValue("cursor");
	    	 if(style_next.equals("pointer"))
	    	  {
	    	             ele.click_element("xpath", ".//*[@id='divProviderPager']/a[contains(text(),'>')]");
               }
	        } 
            Thread.sleep(2000);
	   }while(p_count!=0);
	  if(flag_pr==0)
	    {
	    	System.out.println("There is no such provider having any data so cant check Favorite measures ");
	    	return "Pass";
	    }
	} 
	    return "Pass";
  }
 catch(Exception e)
	{
	    	e.printStackTrace();
	    	System.out.println("Exception while going to measure id");
	    	Setup.log.fatal(e.toString());
	    	return "Fail to check favorite measures of all"+data;
	}
 
 }

/**
 * @author Nikita Desai
 * @return
 */
private String favoritemeasure() {
	// TODO Auto-generated method stub
	try
	{
		 String quarter_end_date_query="select distinct Date  from Calendar where "+ UtilityFunction.mq_column +"='"+UtilityFunction.duration+"' and year ='"+UtilityFunction.duration_yr+"'";
		 //String quarter_end_date_query="select distinct QuarterEndDate  from ViewMeasureComputationSummary where  QuarterName='"+UtilityFunction.duration+"'";
		 rs1=db_exe.SQLserverConnection1(quarter_end_date_query);
		 
		  while(rs1.next()){
		    	   quarterenddate=rs1.getString(1);	  
		       } 
		   
	    int row=Setup.driver.findElements(By.xpath(".//*[@id='sample-table-1']/tbody[1]/tr")).size();
        
        String first_part =".//*[@id='sample-table-1']/tbody[1]/tr[";
	    String second_part = "]/td[";
	    String third_part = "]";
	  
	   
	    for (int r=1;r<row;r=r+2)
	    {
	    	            
	       String measure_id_xpath =first_part+r+second_part+1+third_part;
           String [] measure_id_a = Setup.driver.findElement(By.xpath(measure_id_xpath)).getText().split(" ",3);
           String mquery="select NationalProgramQualityMeasureUid from ViewMeasureComputationSummary vc where  PracticeUid='"+UtilityFunction.practiceuid+"' and ProviderUid ='"+provideruid+"'and Flag='"+UtilityFunction.duration_flag+"' and QuarterEndDate = '"+quarterenddate+"' and MeasureId='"+measure_id_a[2]+"'";  
			
           System.out.println(mquery);
           String measureuid=null;
	  	     rs1=db_exe.SQLserverConnection1(mquery);
	            while(rs1.next()){
			        measureuid=rs1.getString(1).toLowerCase();	   
 		          }
        
	       
	        String fav_xpath=".//*[@id='fav"+measureuid+"']";
           	String fav_class=Setup.driver.findElement(By.xpath(fav_xpath)).getAttribute("class");
           	System.out.println("class is"+fav_class);		
           	if(ele.isElementPresent(By.xpath(fav_xpath)))
           	{
           	  if(!fav_class.contains("empty"))
               	{
           		 String fig_d=buisness.core.login.AfterLoginUtility.getFIGUerUID();	 
           		    String fav_measure_count_query="select case when count(*) = 1 then 1 else 0 end from FIGUserFavorite where figuseruid='"+fig_d+"' and value='"+measureuid+"'";
    	    	     rs1=db_exe.SQLserverConnection1(fav_measure_count_query);
                     int db_entry= 0;
    	    	      while(rs1.next()){
    	    			         db_entry=Integer.parseInt(rs1.getString(1));	   
       	    		          	   }
    	    	      if(db_entry==1)
    	    	        {
    	    	        	 System.out.println("Measure id"+measure_id_a[2]+"is favorite measure");
    	    	        	 
    	    	        }
    	    	       else
    	    	         {	 
    	    	        	 System.out.println("Measure id"+measure_id_a[2]+"is selected but entry is not inserted in Database");
    	    	        	 return "Fail as not inserted in db";
    	    	          }
           		 }  
           	  else
           		    {
           			   System.out.println("Measure is not selected still present in favorite "+measure_id_a[2]);
           			   return "Fail";
           		     }
           	}
           	else
           	   {
           		  System.out.println("For Meausre id"+measure_id_a[2]+"is Favorite Star is not present");
           		  return "Fail as Favorite star not present";
           	   }
          }
            
       return "Pass"; 
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Exception is occured while checking favorite measures of all proivder");
		Setup.log.fatal(e.toString());
		return "Fail while checking favorite measures of all provider";
	}
}

/**
 * @author Nikita Desai
 * @param string
 * @return
 */

public String checkAllMeasures(String string) {
	// TODO Auto-generated method stub
	try
	 {
        int pro_count=0;
		String pro_uid=null;
		String provider_count_query="select COUNT(serviceprovideruid) from ViewServiceProvider where PracticeUid='"+UtilityFunction.practiceuid+"' and Inactive=0 and Type in ('1','3')";
		System.out.println("query is "+provider_count_query);
		rs1=db_exe.SQLserverConnection(provider_count_query);
	      while(rs1.next()){
	    	   pro_count=Integer.parseInt(rs1.getString(1));	  
	          } 
	      providercount=pro_count;
	    System.out.println("Provider count is"+providercount);
		if(providercount==0)
		   {
			 String no_row=ele.gettext("xpath",".//*[@id='row']");
			 Assert.assertEquals(no_row,"No record found for given criteria.");
		     System.out.println("No record present for practice");
			 return "Pass";
		   }
	 else
	  {
		 int p_count=providercount;
		 if(ele.isElementPresent(By.xpath(".//*[@id='divProviderPager']/a[contains(text(),'<<')]")))
		 {		 
		  String style_first=Setup.driver.findElement(By.xpath(".//*[@id='divProviderPager']/a[contains(text(),'<<')]")).getCssValue("cursor");
		  if(style_first.equals("pointer"))
		  {
				 ele.click_element("xpath",".//*[@id='divProviderPager']/a[contains(text(),'<<')]");
				 System.out.println("go to first page");
				 Thread.sleep(1000);
				
		  } 
		 }		
		  int j=0;
		  int flag_pr=0;
		  do
		   {
		    	 Setup.driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS); 
		    	 List<WebElement> elements=Setup.driver.findElements(By.xpath(".//div[@class='panel panel-default']"));
		         for(int i=0 ;(i<elements.size());i++)
		         {
		        	if(elements.get(i).getText() != null)
		        	{	   
		    	       String provider_data=elements.get(i).getText();
		    	       String [] words=provider_data.split("\n");
		    	       System.out.println(provider_data);   	  
			           String pro_name=words[0].replace(" ","%");
		               exceed=Integer.parseInt(words[1]);
		    	       below=Integer.parseInt(words[2]);
		    	       String provider_uid_query="select ServiceProviderUid from ViewServiceProvider where practiceuid='"+UtilityFunction.practiceuid+"' and name like '%"+pro_name+"'";
		               System.out.println(provider_uid_query);
		    	       rs1=db_exe.SQLserverConnection(provider_uid_query);
		               while(rs1.next()){
				        pro_uid=rs1.getString(1).toLowerCase();	
				        	       }
                        provideruid=pro_uid;

		               if(exceed > 0 || below >0)
		               {  
		            	  String first=".//*[@id='";
		     	          String second="row";
		     	          String third="']/div[1]/h4/div/table/tbody/tr/td[1]/a";
		     	          
		     	          String finalpath=first+second+provideruid+third;
		     	        		
		     	          String opened_path=".//*[@id='collapse"+provideruid+"']"; 
		     	          String opened_class=Setup.driver.findElement(By.xpath(opened_path)).getAttribute("class");
		     	          if(opened_class.equals("panel-collapse in"))
		     	          {
		     	        	  System.out.println("Provider is already opened");
		     	        	
		     	          }
		     	          else
		     	          {	  
		     	              Setup.driver.findElement(By.xpath(finalpath)).click();
		     	          }   
		     	          if(allmeasure().equals("Pass"))
		     	           {
		     	        	  System.out.println("Record"+i+"is correct");
		     	        	  flag_pr=1;
		     	        	  
		     	        	}
		     	          else
		     	          {
		     	        	return "Fail to check all measures of all provider";  
		     	          }
		   		        }
		        	}
		   		       j++;
		   		       p_count=p_count-1;
		           
		   		        	      
		    	    } //first for end
		        if(ele.isElementPresent(By.xpath(".//*[@id='divProviderPager']/a[contains(text(),'>')]")))
		        { 	
		         String style_next=Setup.driver.findElement(By.xpath(".//*[@id='divProviderPager']/a[contains(text(),'>')]")).getCssValue("cursor");
		    	 if(style_next.equals("pointer"))
		    	  {
		    		     	  ele.click_element("xpath", ".//*[@id='divProviderPager']/a[contains(text(),'>')]");
		    	  }
		        } 
	            Thread.sleep(2000);
		   }while(p_count!=0);
		
		  if(flag_pr==0)
		    {
		    	System.out.println("There is no such provider having any data so cant check All measures ");
		    	return "Pass";
		    }
	  }	  
		    return "Pass";
	  }
	 catch(Exception e)
		{
		    	e.printStackTrace();
		    	Setup.log.fatal(e.toString());
		    	System.out.println("Exception while checking all measures");
		    	return "Fail to check all measures";
		}
}

/**
 * @author Nikita Desai
 * @return
 */
private String allmeasure() {
	// TODO Auto-generated method stub
	try
	{
		 String quarter_end_date_query="select distinct Date  from Calendar where "+ UtilityFunction.mq_column +"='"+UtilityFunction.duration+"' and year ='"+UtilityFunction.duration_yr+"'";
		// String quarter_end_date_query="select distinct QuarterEndDate  from ViewMeasureComputationSummary where  QuarterName='"+UtilityFunction.duration+"'";
		 rs1=db_exe.SQLserverConnection1(quarter_end_date_query);
		 
		  while(rs1.next()){
		    	   quarterenddate=rs1.getString(1);	  
		       } 
		   
	    int row=Setup.driver.findElements(By.xpath(".//*[@id='sample-table-1']/tbody[1]/tr")).size();
        
        String first_part =".//*[@id='sample-table-1']/tbody[1]/tr[";
	    String second_part = "]/td[";
	    String third_part = "]";
	  
	   
	    for (int r=1;r<row;r=r+2)
	    {
	       int db_entry= 0;	            
	       String measure_id_xpath =first_part+r+second_part+1+third_part;
           String [] measure_id_a = Setup.driver.findElement(By.xpath(measure_id_xpath)).getText().split(" ");
           String mquery="select case when COUNT(*)=1 then 1 else 0 end FROM  FIGMDHQIManagement.dbo.NationalProgramQualityMeasure NPQM"+ 
                         " INNER JOIN FIGMDHQIManagement.dbo.MasterQualityMeasure AS MQM ON MQM.QualityMeasureUid = NPQM.QualityMeasureUid"+  
                         " where NPQM.Inactive=0 and NPQM.ID='"+measure_id_a[2]+"'"; 
           		  
			
           System.out.println(mquery);
       	   rs1=db_exe.SQLserverConnection1(mquery);
	             
    	    	      while(rs1.next()){
    	    			         db_entry=Integer.parseInt(rs1.getString(1));	   
       	    		          	   }
    	    	      if(db_entry==1)
    	    	        {
    	    	        	 System.out.println("Measure id"+measure_id_a[2]+"is ");
    	    	        	 
    	    	        }
    	    	       else
    	    	         {	 
    	    	        	 System.out.println("Measure id"+measure_id_a[2]+"is present on UI but There is no entry in Database");
    	    	        	 return "Fail as not in Database";
    	    	         }
          }
            
       return "Pass"; 
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
		Setup.log.fatal(e.toString());
		System.out.println("Exception is occured while checking all measures of all proivder");
		return "Fail while checking all measures of all provider";
	}
}

/**
 * @author nikita.desai
 * Funtion to De-select Measure
 */
public String deselectFavoriteMeasure(String data) {
	// TODO Auto-generated method stub
try
{    
		int flag_pr=0;
		int pro_count=0;
		String provider_count_query="select COUNT(serviceprovideruid) from ViewServiceProvider where PracticeUid='"+UtilityFunction.practiceuid+"' and Inactive=0 and Type in ('1','3')";
		System.out.println("query is "+provider_count_query);
		rs1=db_exe.SQLserverConnection(provider_count_query);
	      while(rs1.next()){
	    	   pro_count=Integer.parseInt(rs1.getString(1));	  
	          } 
	    providercount=pro_count;
	    System.out.println("Provider count is"+providercount);
		if(providercount==0)
		   {
			 String no_row=ele.gettext("xpath",".//*[@id='row']");
			 Assert.assertEquals(no_row,"No record found for given criteria.");
		     System.out.println("No record present for practice");
			 return "Pass";
		   }
	  else
	   {
	    int p_count=providercount;
	    if(ele.isElementPresent(By.xpath(".//*[@id='divProviderPager']/a[contains(text(),'<<')]")))
	    {	   
	      String style_first=Setup.driver.findElement(By.xpath(".//*[@id='divProviderPager']/a[contains(text(),'<<')]")).getCssValue("cursor"); 
         if(style_first.equals("pointer"))
          {
         	 ele.click_element("xpath",".//*[@id='divProviderPager']/a[contains(text(),'<<')]");
			 System.out.println("go to first page");
			 Thread.sleep(1000);
			 
		 }
	   } 
			
	    int j=0;
	    do
	      {
	    	 Setup.driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS); 
	    	 List<WebElement> elements=Setup.driver.findElements(By.xpath(".//div[@class='panel panel-default']"));
	         for(int i=0 ;(i<elements.size());i++)
	         {
	        	// if(elements.get(i).getText() != null)
  	             {	   
  	    	       String provider_data=elements.get(i).getText();
  	    	       String [] words=provider_data.split("\n");
 	    	       System.out.println(provider_data);   	  
  		           String pro_name=words[0].replace(" ","%");
  	               exceed=Integer.parseInt(words[1]);
  	    	       below=Integer.parseInt(words[2]);
  	    	       String provider_uid_query="select ServiceProviderUid from ViewServiceProvider where practiceuid='"+UtilityFunction.practiceuid+"' and name like '%"+pro_name+"'";
   	               System.out.println(provider_uid_query);
  	    	       rs1=db_exe.SQLserverConnection(provider_uid_query);
   	               while(rs1.next()){
   			        provideruid=rs1.getString(1).toLowerCase();	
   			        System.out.println("provider uid is"+provideruid);
	    		       }

   	               if(exceed > 0 || below >0)
   	               {  
   	            	  String first=".//*[@id='";
 	     	          String second="row";
 	     	          String third="']/div[1]/h4/div/table/tbody/tr/td[1]/a";
 	     	          	//	+ "[contains(text(),'";
 	     	          //String fourth="')]";
 	     	          String finalpath=first+second+provideruid+third;
 	     	        		  //+words[1]+fourth;
 	     	          String opened_path=".//*[@id='collapse"+provideruid+"']"; 
	     	          String opened_class=Setup.driver.findElement(By.xpath(opened_path)).getAttribute("class");
	     	          if(opened_class.equals("panel-collapse in"))
	     	          {
	     	        	  System.out.println("Provider is already opened");
	     	        	//  return "Pass";
	     	          }
	     	          else
	     	          {	  
 	     	              Setup.driver.findElement(By.xpath(finalpath)).click();
	     	          }   
 	     	          if(de_measureid(data).equals("Pass"))
 	     	           {
 	     	        	 System.out.println("Test case Passed");
 	     	        	 flag_pr=1;
 	     	        	 return "Pass";  
 	     	        	}
 	     	          else
 	     	          {
 	     	        	return "Fail";  
 	     	          }
	   		        }
   	              
	   		       j++;
	   		       p_count=p_count-1;
  	             } 
	   		        	      
	    	    } //first for end
	         if(ele.isElementPresent(By.xpath(".//*[@id='divProviderPager']/a[contains(text(),'>')]")))
	         {	 
	          String style_next=Setup.driver.findElement(By.xpath(".//*[@id='divProviderPager']/a[contains(text(),'>')]")).getCssValue("cursor"); 
	          if(style_next.equals("pointer"))
	          {
	          	 ele.isElementPresent(By.xpath(".//*[@id='divProviderPager']/a[contains(text(),'>')]"));
              }
	         } 
         Thread.sleep(2000);
         
	   }while(p_count!=0);
	    
	    if(flag_pr==0)
	    {
	    	System.out.println("There is no such proivder having any data");
	    	return "Pass";
	    }
	   }  
	return "Pass";
 }
 catch(Exception e)
 {
	 System.out.println("Exception occured while selecting favorite measure");
	 Setup.log.fatal(e.toString());
	 e.printStackTrace();
	 return "Fail";
 }
}

/**
 * @author nikita.desai
 * Function to deselect Measure
 * @param data
 * @return
 */
private String de_measureid(String data) {
	// TODO Auto-generated method stub
try
{	
	   int flag_pr=0;
	   if(data.isEmpty())
	   {
		   System.out.println("Please Provide Measure id");
		   return "Fail As  Measure id is not given";
	   }
	   
	  else
	  {	   
		  String quarter_end_date_query="select distinct Date  from Calendar where "+ UtilityFunction.mq_column +"='"+UtilityFunction.duration+"' and year ='"+UtilityFunction.duration_yr+"'";
		  //String quarter_end_date_query="select distinct QuarterEndDate  from ViewMeasureComputationSummary where  QuarterName='"+UtilityFunction.duration+"'";
		  rs1=db_exe.SQLserverConnection1(quarter_end_date_query);
		 
		  while(rs1.next()){
		    	   quarterenddate=rs1.getString(1);	  
		       } 
		   
	     int row=Setup.driver.findElements(By.xpath(".//*[@id='sample-table-1']/tbody[1]/tr")).size();
         
        String first_part =".//*[@id='sample-table-1']/tbody[1]/tr[";
	    String second_part = "]/td[";
	    String third_part = "]";
	  
	   
	    for (int r=1;r<row;r=r+2)
	    {
	    	            
	       	String measure_id_xpath =first_part+r+second_part+1+third_part;
            String [] measure_id_a = Setup.driver.findElement(By.xpath(measure_id_xpath)).getText().split(" ",3);
            String mquery="select NationalProgramQualityMeasureUid from ViewMeasureComputationSummary vc where  PracticeUid='"+UtilityFunction.practiceuid+"' and ProviderUid ='"+provideruid+"'and Flag='"+UtilityFunction.duration_flag+"' and QuarterEndDate = '"+quarterenddate+"' and MeasureId='"+measure_id_a[2]+"'";  
			
            System.out.println(mquery);
            String measureuid=null;
	  	     rs1=db_exe.SQLserverConnection1(mquery);
	            while(rs1.next()){
			        measureuid=rs1.getString(1).toLowerCase();	   
  		          }
         
	        if(measure_id_a[2].equals(data))
            {
            	
	        	String fav_xpath=".//*[@id='fav"+measureuid+"']";
            	String fav_class=Setup.driver.findElement(By.xpath(fav_xpath)).getAttribute("class");
            	System.out.println("class is"+fav_class);		
            	if(ele.isElementPresent(By.xpath(fav_xpath)))
            	{
            	  if(!fav_class.contains("empty"))
                	{
            		  if(ele.click_element("xpath",fav_xpath).equals("Pass"))
            		   {
            			 String Roaster_msg=Setup.driver.findElement(By.xpath(".//*[@class='alert alert-success padding10 border-radius-10 fontSize13']")).getText().trim();
            			 String fig_id=buisness.core.login.AfterLoginUtility.getFIGUerUID();
            			 String fav_measure_count_query="select case when count(*) = 0 then 1 else 0 end from FIGUserFavorite where figuseruid='"+fig_id+"' and value='"+measureuid+"'";
     	    	         rs1=db_exe.SQLserverConnection1(fav_measure_count_query);
                         int db_entry= 0;
     	    	         while(rs1.next()){
     	    			         db_entry=Integer.parseInt(rs1.getString(1));	   
        	    		          	   }
     	    	           if(db_entry==1)
     	    	           {
     	    	        	 System.out.println("Measure id "+measure_id_a[2]+" is deselected and entry is removeded from Database");
     	    	        	 Assert.assertEquals(Roaster_msg,"Removed from favorites");
     	    	        	 flag_pr=1;
     	    	        	 return "Pass";
     	    	           }
     	    	          else
     	    	           {	 
     	    	        	 System.out.println("Measure id "+measure_id_a[2]+" is deselected but entry is not removed from  Database");
     	    	        	 return "Fail as not inserted in db";
     	    	           }
            		    }  
            		  else
            		    {
            			  System.out.println("cant click xpath "+measure_id_a[2]);
            			  return "Fail";
            		     }
            		 }
            	  else
            	   {
            		  System.out.println("Meausre id "+measure_id_a[2]+" is not Favorite measure so cant deselect it");
            		  return "Fail";
            	   }
            	 }
              }
           }
	       if(flag_pr==0)
	       {
	    	   System.out.println("Measure not present....."+data+"\nPleasse check measure id");
	    	   return "Pass";
	       }
	    }
	    return "Pass";
	}  
	catch(Exception e)
	{
	    	e.printStackTrace();
	    	System.out.println("Exception while going to measure id");
	    	Setup.log.fatal(e.toString());
	    	return "Fail to go to measure id"+data;
	}
	
}


public String checkProviderRegistryVLine(String data) {
	// TODO Auto-generated method stub
try
  {
		 if(gotoProvider(data).equals("Pass"))
		 {
			 if(providercount==0)
			 {
				 System.out.println("No record Present for practice");
				 String no_row=ele.gettext("xpath",".//*[@id='row']");
				 Assert.assertEquals(no_row,"No record found for given criteria.");
				 return "Pass";
			 }
			else
			{	 
			 if(ele.isElementPresent(By.xpath(".//*[@id='sample-table-1']/tbody[2]/tr/td")))
			  {
			      String no_record=ele.gettext("xpath",".//*[@id='sample-table-1']/tbody[2]/tr/td");
			      System.out.println("No record present For Provider");
			      Assert.assertEquals(no_record, "No record found for given criteria.");
			     
			      return "Pass";
			  }
			 
			 else
			 { 	  
				 String quarter_end_date_query="select distinct Date  from Calendar where "+ UtilityFunction.mq_column +"='"+UtilityFunction.duration+"' and year ='"+UtilityFunction.duration_yr+"'"; 
			  //String quarter_end_date_query="select distinct QuarterEndDate  from ViewMeasureComputationSummary where  QuarterName='"+UtilityFunction.duration+"'";
			  rs1=db_exe.SQLserverConnection1(quarter_end_date_query);
			 
			  while(rs1.next()){
			    	   quarterenddate=rs1.getString(1);	  
			       } 
			 
			  
			 
			//no of row and columns of measures listed under provider 
			
			 int row=Setup.driver.findElements(By.xpath(".//*[@id='sample-table-1']/tbody[1]/tr")).size();
             int col=Setup.driver.findElements(By.xpath(".//*[@id='sample-table-1']/tbody[1]/tr[1]/td")).size();
	         System.out.println("no rows"+row+"column is "+col);
			 String first_part =".//*[@id='sample-table-1']/tbody[1]/tr[";
			 String second_part = "]/td[";
			 String third_part = "]";
			 String fourth_part="/table/tbody/tr/td/table/tbody/tr/td[";
			 String fifth_part="]/div[1]";
			 
			    for (int r=1;r<row;r=r+2){
			    	  //check provider Registry benchmark Verticle line
			    	 String registry_line_xpath = first_part+r+second_part+3+third_part+fourth_part+1+fifth_part;
			       	
			       	 String measure_id_xpath =first_part+r+second_part+1+third_part;
		             String [] measure_id_a = Setup.driver.findElement(By.xpath(measure_id_xpath)).getText().split(" ",3);
		             
		               String registry_line_actual=Setup.driver.findElement(By.xpath(registry_line_xpath)).getAttribute("style");
		              float reg_a=Float.valueOf(getValue(registry_line_actual));
		               
		               String mquery1="select CAST(NationalAverage*100 as decimal(6,2)) from  ViewMeasureComputationSummary where  PracticeUid='"+UtilityFunction.practiceuid+"' and ProviderUid ='"+provideruid+"'and Flag='"+UtilityFunction.duration_flag+"' and QuarterEndDate = '"+quarterenddate+"' and MeasureId='"+measure_id_a[2]+"'";
		               System.out.println("query is"+mquery1);
		               rs1=db_exe.SQLserverConnection1(mquery1);
		               float registry_line_expected=0;
	    	           while(rs1.next()){
	    	        	   registry_line_expected=Float.valueOf(rs1.getString(1));	   
		    		         }
		               
			            System.out.println("Actual width of registry benchmark line is "+reg_a);
			            System.out.println("Expected width of registry benchmark line is "+registry_line_expected);
			            Assert.assertEquals(reg_a, registry_line_expected);
			            
			        } //for end
			 }//else ends
		 }//if end
		} 
		 return "Pass";
	  }
	  catch(Exception e)
	  {
		Setup.log.fatal(e);
		e.printStackTrace();
		return "Fail to check measure registry benchmark line";
		  
	  }

}

private String getValue(String string) {
    Pattern pattern = Pattern.compile("[(\\d\\.\\d)]+|[(\\d)]+"); 
    ///another pattern but if value is 90.70 then only 90.7 is getting but 0 is not getting \\d+(?:\\.\\d+)?
    java.util.regex.Matcher matcher = pattern.matcher(string);
    matcher.find();
    return matcher.group();
}


public String checkProviderMeasureDocument(String data) {
	String oldTab = null;
try
 {
	 
			 if(gotoProvider(data).equals("Pass"))
			 {
				 if(providercount==0)
				 {
					 System.out.println("No record Present for practice");
					 String no_row=ele.gettext("xpath",".//*[@id='row']");
					 Assert.assertEquals(no_row,"No record found for given criteria.");
					 return "Pass";
				 }
				else
				{	 
				 if(ele.isElementPresent(By.xpath(".//*[@id='sample-table-1']/tbody[2]/tr/td")))
				  {
				      String no_record=ele.gettext("xpath",".//*[@id='sample-table-1']/tbody[2]/tr/td");
				           System.out.println("No record present For Provider");
				      Assert.assertEquals(no_record, "No record found for given criteria.");
				     
				      return "Pass";
				  }
				 
				 else
				 { 	  
					 String quarter_end_date_query="select distinct Date  from Calendar where "+ UtilityFunction.mq_column +"='"+UtilityFunction.duration+"' and year ='"+UtilityFunction.duration_yr+"'"; 
				  //String quarter_end_date_query="select distinct QuarterEndDate  from ViewMeasureComputationSummary where  QuarterName='"+UtilityFunction.duration+"'";
				  rs1=db_exe.SQLserverConnection1(quarter_end_date_query);
				 
				  while(rs1.next()){
				    	   quarterenddate=rs1.getString(1);	  
				       } 
				 
				  
				 
				//no of row and columns of measures listed under provider 
				
				 int row=Setup.driver.findElements(By.xpath(".//*[@id='sample-table-1']/tbody[1]/tr")).size();
	             int col=Setup.driver.findElements(By.xpath(".//*[@id='sample-table-1']/tbody[1]/tr[1]/td")).size();
		         System.out.println("no rows"+row+"column is "+col);
				 String first_part =".//*[@id='sample-table-1']/tbody[1]/tr[";
				 String second_part = "]/td[";
				 String third_part = "]";
				 String fourth_part="/i[3]";
				 
				    for (int r=1;r<row;r=r+2){
				    	  //check provider Registry benchmark Verticle line
				    	 String document_xpath = first_part+r+second_part+4+third_part+fourth_part;
				       	
				       	 String measure_id_xpath =first_part+r+second_part+1+third_part;
			             String [] measure_id_a = Setup.driver.findElement(By.xpath(measure_id_xpath)).getText().split(" ",3);
			             
			             oldTab = Setup.driver.getWindowHandle();
			             //Setup.driver.findElement(By.xpath(document_xpath)).sendKeys(Keys.CONTROL +"t");
			             Setup.driver.findElement(By.xpath(document_xpath)).click();
			             ArrayList<String> newTab = new ArrayList<String>(Setup.driver.getWindowHandles());
			             newTab.remove(oldTab);
			             // change focus to new tab
			             Setup.driver.switchTo().window(newTab.get(0));
			             String document_url=Setup.driver.getCurrentUrl();
			             System.out.println(document_url);
			              
			             String []Measure=document_url.split("/");
			             System.out.println("Measure for pdf is "+Measure[4]);
                         String [] Measure_e=Measure[4].split("\\.",2);
                         System.out.println("Meausre document for measure "+Measure_e[0]);
			             String Measure_a="Measure"+measure_id_a[2];
                         Assert.assertEquals(Measure_e[0],Measure_a);

			             Setup.driver.close();
			             
			             // change focus back to old tab
			             Setup.driver.switchTo().window(oldTab);
			             
			              
				            
				        } //for end
				 }//else ends
			 }//if end
			} 
			 return "Pass";
		  }
		  catch(Exception e)
		  {
			Setup.log.fatal(e);
			e.printStackTrace();
			return "Fail to check measure document";
			  
		  }
finally
{
	 String url=Setup.driver.getCurrentUrl();
     if(url.contains("Measure"))
     {
    	 Setup.driver.close();
         
         // change focus back to old tab
         Setup.driver.switchTo().window(oldTab);
     }
}
  
   
}


public String checkdurationofMeasure(String data) {
try
 {
	if(gotoProvider(data).equals("Pass"))
	{
		 if(providercount==0)
	 	 {
				 System.out.println("No record Present for practice");
				 String no_row=ele.gettext("xpath",".//*[@id='row']");
				 Assert.assertEquals(no_row,"No record found for given criteria.");
				 return "Pass";
		 }
		else
		{	 
			 if(ele.isElementPresent(By.xpath(".//*[@id='sample-table-1']/tbody[2]/tr/td")))
			  {
				  String no_record=ele.gettext("xpath",".//*[@id='sample-table-1']/tbody[2]/tr/td");
				  System.out.println("No record present for Provider");
				  Assert.assertEquals(no_record, "No record found for given criteria.");
			      
			      return "Pass";
			  }
			 
			 else
             { 	  
			     //query to find quarter and month (those having data) of selected duration
				 String quarter_query="select distinct QuarterName  from ViewMeasureComputationSummary " + 
				                      " where Flag='" +UtilityFunction.duration_flag + "' and QuarterEndDate in ( " + 
				 	                  " select date from Calendar where "
				 	                  + " DATEDIFF(MONTH, (select date from Calendar where " + UtilityFunction.mq_column +"='"+UtilityFunction.duration+"' and year ='"+UtilityFunction.duration_yr+"' ),date) in ( " ;
				 
				 if(UtilityFunction.duration_flag.equals("QR"))
				     quarter_query=quarter_query + " 0,-3,-6,-9) ) order by QuarterName desc ";
				 else if (UtilityFunction.duration_flag.equals("MR"))
				     quarter_query=quarter_query + " 0,-1,-2,-3,-4,-5) ) order by QuarterName desc"; 			
				 			

				 System.out.println("quarter_query is "+quarter_query);
			     List <String> quarter_e=db_exe.SQLserverConnection2(quarter_query);
			     //expected duration
			     for(int h=0;h<quarter_e.size();h++)
		    	  {
		    		  
		    		  System.out.println("Duration "+ quarter_e.get(h));
		    	  }
			  
			 
			  
			//no of row and columns of measures listed under provider 
			
			 int row=Setup.driver.findElements(By.xpath(".//*[@id='sample-table-1']/tbody[1]/tr")).size();
		     int col=Setup.driver.findElements(By.xpath(".//*[@id='sample-table-1']/tbody[1]/tr[1]/td")).size();
	         System.out.println("no rows"+row+"column is "+col);
			 String first_part =".//*[@id='sample-table-1']/tbody[1]/tr[";
			 String second_part = "]/td[";
			 String third_part = "]";
			 
			    for (int r=1;r<row;r=r+2){
			    	String Measure_path=first_part+r+second_part+1+third_part;
			    	String [] measure_id_a = Setup.driver.findElement(By.xpath(Measure_path)).getText().split(" ",3);
			    	Setup.driver.findElement(By.xpath(Measure_path)).click();
			    	//find measure id
			    	String mquery="select NationalProgramQualityMeasureUid from [FIGMDHQIManagement].[dbo].NationalProgramQualityMeasure  where   Id='"+measure_id_a[2]+"'";  
					System.out.println("query is "+mquery);
			    	String tableuid=null;
			  	    rs1=db_exe.SQLserverConnection1(mquery);
			          while(rs1.next()){
					        tableuid=rs1.getString(1).toLowerCase();	   
		   		          }
			    	  
			          String mrow_path=".//*[@id='divGraph"+tableuid+"']/div[2]/div[2]/table/tbody/tr";
			          
			          int mrow=Setup.driver.findElements(By.xpath(mrow_path)).size();
					  System.out.println("No of rows are "+mrow);
					  String [] quarter_a=new String[mrow];
			    	  for(int j=1,s=0;(j<=mrow)&&(s<=mrow);j++,s++)
			    	  {
			    		   	   String quarter_path=".//*[@id='divGraph"+tableuid+"']/div[2]/div[2]/table/tbody/tr["+j+"]/td[1]";
			    		  	   quarter_a[s]=Setup.driver.findElement(By.xpath(quarter_path)).getText();
			    			   System.out.println(quarter_a[s]); 		    		  
			    	  }
			    	
			          //matched quarter or month 
			    	  for(int h=0;h<quarter_a.length;h++)
			    	  {
			    		  Assert.assertEquals(quarter_a[h],quarter_e.get(h));
			    		  System.out.println(" Given duration "+ quarter_a[h] +"is mathced");
			    	  }
			    	  
			        } //for end
			 }//else ends
		 }//if end
		} 
		 
		 return "Pass";
	  }
	  catch(Exception e)
	  {
		Setup.log.fatal(e.toString());
		e.printStackTrace();
		return "Fail to check measure duration";
		  
	  }	
}

}
