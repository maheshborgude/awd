package buisness.managers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;

import configuration.Setup;

public class ConfigurationManager {
	
	   public String read_Configfile(String scriptname)
	   {
		   String property=null;
		   try
		   {
			   Properties or_prop=new Properties();
			   FileInputStream or_file=new FileInputStream(System.getProperty("user.dir")+"\\Configurations\\ApplicationConfig.properties");
			   or_prop.load(or_file);
			   property=or_prop.getProperty(scriptname);
		   } catch (FileNotFoundException e) 
		   {
			   System.out.println("Unable to find the file for properties");
		   } catch (IOException e) 
		   {
			   e.printStackTrace();
		   }
			return property;
			
	   }

	   public String read_ObjectRepositoryfile(String scriptname) 
	   {
		   String property=null;
		   try
		   {
			   Properties or_prop=new Properties();
			   FileInputStream or_file=new FileInputStream(System.getProperty("user.dir")+"\\Configurations\\Object Repository\\ObjectRepository2.properties");
			   or_prop.load(or_file);
			   property=or_prop.getProperty(scriptname);
		   } catch (FileNotFoundException e) 
		   {
			   System.out.println("Unable to find the file for properties");
		   } catch (IOException e) 
		   {
			   e.printStackTrace();
			   
		   }
			return property;
	   }
	   
	   public String getQuery(String scriptname) 
	   {
		   String property=null;
		   try 
		   {
			   Properties or_prop=new Properties();
			   FileInputStream or_file;
			   or_file = new FileInputStream(System.getProperty("user.dir")+"\\Configurations\\Queries\\Queries.properties");
			   or_prop.load(or_file);
			   property=or_prop.getProperty(scriptname);
		   } catch (FileNotFoundException e) 
		   {
			   System.out.println("Unable to find the file for properties");
		   } catch (IOException e) 
		   {
			   e.printStackTrace();
		   }
		   return property;
	   }
	   public  Hashtable<String, String> getDatabaseProperties() 
	   {
		   Hashtable<String, String>  dbconfig = new Hashtable<String, String>  ();
		   
		    String property=null;
		    Properties or_prop=new Properties();
			
			try 
			{
			FileInputStream or_file=new FileInputStream(System.getProperty("user.dir")+"\\Configurations\\DatabaseConfigration.properties");
			Setup.log.debug(or_file);
			or_prop.load(or_file);	
			property=or_prop.getProperty("Driver");
			dbconfig.put("Driver", property);
			property=or_prop.getProperty("ConncetinString");
			dbconfig.put("ConncetinString", property);
			property=or_prop.getProperty("UserName");
			dbconfig.put("UserName", property);
			property=or_prop.getProperty("Password");
			dbconfig.put("Password", property);
			property=or_prop.getProperty("WebDatabase");
			dbconfig.put("WebDemoDatabase", property);
			property=or_prop.getProperty("ManagementDatabase");
			dbconfig.put("ManagementDatabase", property);
			property=or_prop.getProperty("CDRDatabase");
			dbconfig.put("CDRDatabase", property);	
			
			} catch (IOException e) {
				Setup.log.error("Unable to find the properties file for properties");
				e.printStackTrace();
				
			}
		
			return dbconfig;
	   }
}
