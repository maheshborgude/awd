package buisness.keywords.pro;


import buisness.core.pro.Customkeyworrrd;
import buisness.core.pro.Picker;
import buisness.keywords.Common;
import configuration.Setup;
import configuration.UtilityFunction;
import testcases.dashboard.provider.UtilityFunctionDashboardProvider;

/**
 * This class contain keywords for PRO>>Clinician Portal
 * 
 * @author Awadhesh.sengar
 * Created date : 1/7/2015
 * Modified date : 1/8/2015
 * need to create a object of testcase class here 
 * 
 */
public class ClinicianPortal extends Common {
	
    UtilityFunction util=new UtilityFunction();
	UtilityFunctionDashboardProvider util_pro=new UtilityFunctionDashboardProvider();
	Customkeyworrrd obj = new Customkeyworrrd();
	
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
			
			else if(action.equals("datepicker"))	
			{
				 ///result=practiceCount.Verify(elementmethod,locator)?"Pass":"Fail";
				System.out.println("Hello i am datepicker  ");
			}
			
			else if(action.equals("Customkeyword"))	
			{
				 ///result=practiceCount.Verify(elementmethod,locator)?"Pass":"Fail";
				//result=ckk.Verify(elementmethod,locator)?"Pass":"Fail";
				System.out.println("Hello i am Customkeyword  ");
				
				result="pass";
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
