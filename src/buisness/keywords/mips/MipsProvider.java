package buisness.keywords.mips;

import buisness.awadhesh.datastructures.mips.MipsNanogrid;
import buisness.awadhesh.datastructures.mips.Mipsprovidergrid;
import buisness.awadhesh.datastructures.mips.Mipsprovidergridrow;
import buisness.core.mipss.MipsProvidersGrid;
import buisness.core.pro.Customkeyworrrd;
import buisness.keywords.Common;
import configuration.Setup;
import configuration.UtilityFunction;
import testcases.dashboard.provider.UtilityFunctionDashboardProvider;

public class MipsProvider extends Common {
	  UtilityFunction util=new UtilityFunction();
		UtilityFunctionDashboardProvider util_pro=new UtilityFunctionDashboardProvider();
		Customkeyworrrd obj = new Customkeyworrrd();
		MipsProvidersGrid mpg = new MipsProvidersGrid();
		buisness.core.mipss.SearchedProvidersCount SearchedProvidersCount = new buisness.core.mipss.SearchedProvidersCount();
		
		buisness.core.rpc.map.MapCount mapCount = new buisness.core.rpc.map.MapCount();
		@Override
		public String meth(String elementmethod,String action,String locator,String...data)
		{
			result=super.meth(elementmethod, action, locator, data);
			try{
				if(action.equals("IsMenuSelected"))	
				{
					result=util.IsMenuSelected(data[0]);
				}
				else if(action.equals("IsSubMenuSelected"))	
				{
					result=util.IsSubMenuSelected(data[0]);
					
				}
				
				else if(action.equalsIgnoreCase("MipsProvidersGrid"))	
				{
					System.out.println("action:"+action+"locator"+locator);
					result=mpg.verify(elementmethod, locator)?"Pass":"Fail";
				
			
				}
				else if(action.equalsIgnoreCase("Getproviderlistmips"))	
				{
					System.out.println("acction:"+action+"locator"+locator);
					result=mpg.verify(elementmethod, locator)?"Pass":"Fail";
				
			
				}
	
				else if(action.equals("MipsNanogrid"))	
				{
					 ///result=practiceCount.Verify(elementmethod,locator)?"Pass":"Fail";
					
					System.out.println("ready with  mips  ");
				}
				
				else if(action.equals("Customkeyword"))	
				{
					 ///result=practiceCount.Verify(elementmethod,locator)?"Pass":"Fail";
					//result=ckk.Verify(elementmethod,locator)?"Pass":"Fail";
					System.out.println("Hello i am Customkeyword  ");
					
					result="pass";
				}
				
				else if(action.equals("SearchedProvidersCount"))
				{
					System.out.println("currently inside keyword class");
					result =SearchedProvidersCount.verify(elementmethod,locator)?"Pass":"Fail";
					
					
				}
					
					
			}
			catch(Exception e)
			{
				e.printStackTrace();
				Setup.testcase.fail();
			}
	        	
			return result;		
		}
		

	}
