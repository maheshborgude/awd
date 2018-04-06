package buisness.keywords.administration;

import buisness.keywords.Common;
import configuration.Setup;
import configuration.UtilityFunction;
import testcases.dashboard.provider.UtilityFunctionDashboardProvider;

/**
 * This class contain keywords for Administration >> Practice
 * 
 * @author rakesh.kulkarni
 * Created date : 1/7/2015
 * Modified date : 1/8/2015
 */

import buisness.keywords.Common;
import configuration.Setup;
import configuration.UtilityFunction;
import testcases.dashboard.provider.UtilityFunctionDashboardProvider;

public class Practice extends Common {
	
    buisness.core.administration.practice.PracticeCount practiceCount =new  buisness.core.administration.practice.PracticeCount();
    buisness.core.administration.practice.PracticeView practiceView=new buisness.core.administration.practice.PracticeView();
    buisness.core.administration.practice.PracticeSort practiceSort=new buisness.core.administration.practice.PracticeSort();
    buisness.core.administration.practice.PracticeSearch practiceSearch=new buisness.core.administration.practice.PracticeSearch();
   buisness.core.administration.practice.PracticeGridPagination practiceGridPagination =new  buisness.core.administration.practice.PracticeGridPagination();
    
    UtilityFunction util=new UtilityFunction();
	UtilityFunctionDashboardProvider util_pro=new UtilityFunctionDashboardProvider();
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
			else if(action.equals("PracticeCount"))	
			{
				 result=practiceCount.Verify(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("ValidateTabel"))	
			{
				result=practiceView.verifyGrid(elementmethod,locator)?"pass":"Fail";
			}
			else if(action.equals("ValidateSorting"))	
			{
				result=practiceSort.verifyGrid(elementmethod,locator,data[0])?"pass":"Fail";
			}
			else if(action.equals("ValidateSearching"))	
			{
				result=practiceSearch.verifyGrid(elementmethod,locator,data[0])?"pass":"Fail";
			}
			else if(action.equals("ValidatePagination"))	
			{
				result=practiceGridPagination.verifyGrid(elementmethod,locator)?"pass":"Fail";
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
