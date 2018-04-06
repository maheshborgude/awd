package configuration;

import java.io.IOException;

import buisness.core.ElementMethod;
import buisness.managers.ConfigurationManager;

public class SelectElementMethod {

	ElementMethod element=new ElementMethod();
	ConfigurationManager rd=new ConfigurationManager();
	
  public void methodselect(String action,String locator,String elementmethod,String data) throws IOException
  {
	if(action.equalsIgnoreCase("type"))
	{
	    locator=rd.read_ObjectRepositoryfile(locator);
	    element.type_element(elementmethod,locator,data);
	    
	}
	else if(action.equalsIgnoreCase("click"))
	{		
		locator=rd.read_ObjectRepositoryfile(locator);
		element.click_element(elementmethod,locator);
	}
	else if(action.equalsIgnoreCase("verifyelement"))
	{
		locator=rd.read_ObjectRepositoryfile(locator);
	    element.verify_element(elementmethod,locator);
	}
	

  else if(action.equalsIgnoreCase("radioselect"))
	  {
	  locator=rd.read_ObjectRepositoryfile(locator);
	  element.radioselect_element(elementmethod,locator);
	  }
  else if(action.equalsIgnoreCase("select"))
  {
     locator=rd.read_ObjectRepositoryfile(locator);
     element.selectDropDownByVisibltext(elementmethod,locator,data);
  }
  }	
}
