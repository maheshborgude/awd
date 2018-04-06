package buisness.keywords.patientoutreach;

import buisness.keywords.Common;
import configuration.Setup;
import configuration.UtilityFunction;

/**
 * Keywords for Patient Outreach
 * @author Sachin.Gawade
 * Created Date: 11 Mar 2016
 *
 */

public class Patientoutreach extends Common{
	
	UtilityFunction util=new UtilityFunction();
	
	@Override
	public String meth(String elementmethod,String action,String locator,String...data)
	{
		result=super.meth(elementmethod, action, locator, data);
		try{
			if(result != null)
			{
				return result;
			}
			else if(action.equals("IsMenuSelected"))	
			{
				result=util.IsMenuSelected(data[0]);
			}
			else if(action.equals("IsSubMenuSelected"))	
			{
				result=util.IsSubMenuSelected(data[0]);
			}

		}
		catch(Exception e)
		{
			Setup.log.error("Exception occured while using Keyword class for patient Outreach\n"+e);
		}
		if(result=="Pass")
		{
			Setup.testcase.assertTrue(true);
			return result;		
		}
		else
		{
			Setup.testcase.fail();
			return result;	
		}

	}
	
}
