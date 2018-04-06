package buisness.keywords.analytics;

import buisness.keywords.Common;
import configuration.Setup;
import configuration.UtilityFunction;
import testcases.dashboard.provider.UtilityFunctionDashboardProvider;

/**
 * This class contain keywords for Administration >> practice
 * 
 * 
 * Created date : 1/7/2015
 * Modified date : 1/8/2015
 */
public class RegistryDataDictionary extends Common {
	
    UtilityFunction util=new UtilityFunction();
	UtilityFunctionDashboardProvider util_pro=new UtilityFunctionDashboardProvider();
	
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
		/*	else if(action.equals("VerifyAdminiStrationPractice"))	
			{
				 result=pr.CompareDBAndUIcount(elementmethod,locator)?"Pass":"Fail";
			} */
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Setup.testcase.fail();
		}
        	
		return result;		
	}
	

}
