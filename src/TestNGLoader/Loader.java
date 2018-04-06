package TestNGLoader;


import java.util.ArrayList;
import java.util.List;

import buisness.managers.CustomReportManager;
import buisness.managers.ExcelReportManager;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.google.common.collect.LinkedListMultimap;

import buisness.Listeners.TestWatcher;
import buisness.managers.EmailReportManager;
import configuration.Setup;
///import TestNGLoader.SplashScreen;


public class Loader  extends Setup {

	public static void main(String[] args)  {
	//	SplashScreen screen = SplashScreen.getSplashScree();
		LoaderUtlity lc = new LoaderUtlity();
		XmlSuite suite = new XmlSuite();
		suite.setName("Login");
		LinkedListMultimap<String, String> TestCasesMap = lc.readSuiteTestCase("testsuit2.xml");
		lc.getSuiteName("testsuit2.xml");
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		Setup.log.debug("Test Cases to run:-");
	//	screen.loadScreen("Test Cases to run:-");
		for(String key: TestCasesMap.keySet())
		{
			if(lc.testCaseAllowedToRun(key))
			{
				System.out.println("\t� " + key);
		//		screen.appendText("\t " + key);
				
				XmlTest test = new XmlTest(suite);
				test.setName(key);
				for(String Value : TestCasesMap.get(key))
				{
					List<XmlClass> classes = new ArrayList<XmlClass>();
					classes.add(new XmlClass(Value));
					test.setXmlClasses(classes);
				}
			}
		}

		suites.add(suite);
		TestNG tng = new TestNG();
		tng.setXmlSuites(suites);
		tng.addListener(new TestWatcher());
		tng.addListener(new CustomReportManager());
		tng.addListener(new ExcelReportManager());
		tng.addListener(new EmailReportManager());
	//	screen.stop();
		tng.run();
	}
}
