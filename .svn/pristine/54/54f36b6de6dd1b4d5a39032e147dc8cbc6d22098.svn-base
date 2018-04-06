package buisness.keywords.rpc.resetpracticekey;

import buisness.core.rpc.resetpracticekey.ResetPracticeKeyCount;
import buisness.core.rpc.resetpracticekey.ResetPracticeKeySearch;
import buisness.core.rpc.resetpracticekey.ResetPracticeKeySort;
import buisness.core.rpc.resetpracticekey.ResetPracticeKeyView;
import buisness.keywords.Common;
import configuration.Setup;
import configuration.UtilityFunction;
import testcases.dashboard.provider.UtilityFunctionDashboardProvider;

/**
 * This class contain keywords for Administration >> practice
 * 
 * @author rakesh.kulkarni
 * Created date : 1/7/2015
 * Modified date : 1/8/2015
 */
public class ResetPracticeKey extends Common {
	
    UtilityFunction util=new UtilityFunction();
	UtilityFunctionDashboardProvider util_pro=new UtilityFunctionDashboardProvider();
	
	buisness.core.rpc.map.MapCount mapCount = new buisness.core.rpc.map.MapCount();
	ResetPracticeKeyView resetpracticekeyView = new ResetPracticeKeyView();
	ResetPracticeKeySort resetpracticekeySort = new ResetPracticeKeySort();
	ResetPracticeKeyCount resetPracticeKeyCount = new ResetPracticeKeyCount();
	ResetPracticeKeySearch resetpracticekeySearch = new ResetPracticeKeySearch();
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
			else if(action.equals("ResetpracticekeyView"))	
			{
				 result=resetpracticekeyView.verify(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("ResetpracticekeySort"))	
			{
				 result=resetpracticekeySort.verify(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("ResetpracticekeyCount"))	
			{
				 result= resetPracticeKeyCount.Verify(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("ResetpracticekeySearch"))	
			{
				 result=resetpracticekeySearch.Verify(elementmethod,locator,data[0])?"Pass":"Fail";
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
