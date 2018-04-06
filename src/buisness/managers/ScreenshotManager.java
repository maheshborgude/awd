package buisness.managers;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import configuration.Setup;

public class ScreenshotManager {

	static final Date Now = new Date();
	public static int sequence=1;
	
	public ScreenshotManager(){}
	
	public ScreenshotManager(String Testcase) {
		File scrFile = ((TakesScreenshot)Setup.driver).getScreenshotAs(OutputType.FILE);
    	String username = System.getProperty("user.name");
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MMM-dd hh-mm a");
    	
/*		String destDir = System.getProperty("user.dir")+"\\Screenshots\\" + username + "\\"
					+ dateFormat.format(Now)  + "\\" + Testcase.split("-",2)[0] ;    //\\192.168.105.22\Testing\Testing\Automation\AAO Demo Smoke Test\Screenshot*/

    	
    	///change for screenshot folder -----
    	//svn://192.168.105.14/Testing/Automation/Delivery/SampleProject/test-output/Screenshots
		///String destDir = "\\192.168.105.22\\Testing\\Testing\\Automation\\AAO Demo Smoke Test\\Screenshot" + username + "\\"+ dateFormat.format(Now)  + "\\" + Testcase.split("-",2)[0] ;
    	String destDir = "\\192.168.105.14\\Testing\\Automation\\Delivery\\SampleProject\\test-output\\Screenshots\\" + username + "\\"+ dateFormat.format(Now)  + "\\" + Testcase.split("-",2)[0] ;
    	System.out.println(destDir);
		new File(destDir).mkdirs();

		String destFile =  Testcase + ".png";
        try {
			FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
			
		} catch (IOException e) {
			Setup.log.error(e.getMessage());
		}
		
	}
	/**
	 * 
	 * @param
	 */
	public void capture(String fileName)
	{
		File scrFile = ((TakesScreenshot)Setup.driver).getScreenshotAs(OutputType.FILE);
    	String username = System.getProperty("user.name");
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MMM-dd hh-mm a");
    	
/*		String destDira = System.getProperty("user.dir")+"\\Screenshots\\" + username + "\\"
					+ dateFormat.format(Now)  + "\\" + fileName.split("-",2)[0] ;
		*/
    	///update by awadhesh to make screenshots come to a desired folder
    	/*
		String destDir =  "\\\\192.168.105.22\\Testing\\Testing\\Automation\\AAO Demo Smoke Test" +"\\Screenshots\\" + username + "\\"
				+ dateFormat.format(Now)  + "\\" + fileName.split("-",2)[0] ;
				*/
    	String destDir =  "\\192.168.105.14\\Testing\\Automation\\Delivery\\SampleProject\\test-output\\Screenshots\\" + username + "\\"
				+ dateFormat.format(Now)  + "\\" + fileName.split("-",2)[0] ;
    	


		new File(destDir).mkdirs();
		
		String destFile =  sequence +") " + fileName + ".png";
		sequence++;
        try {
			FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
			Setup.log.debug("Screenshot Saved : " + destFile );
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void captureStep(String scriptname,int StepNumber,String action,String result)
	{
		String fileName = scriptname + "- Step " + StepNumber + "_Action " + action + "_Status "+result;
		capture(fileName);
	}
}
