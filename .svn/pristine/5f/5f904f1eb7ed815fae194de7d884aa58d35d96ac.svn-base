package TestNGLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.common.collect.LinkedListMultimap;

import buisness.frameworkengine.ExcelReader;
import buisness.managers.ConfigurationManager;

public class LoaderUtlity {
	
	private HashMap<String, String> ScenarioSheetRunMode;

	
	LoaderUtlity()
	{
		SetAllowedtoRunScenarios();
	}
	
	
	private void SetAllowedtoRunScenarios()
	{
		ConfigurationManager rd=new ConfigurationManager();
	    ExcelReader ex= new ExcelReader();
	    ScenarioSheetRunMode = new HashMap<>();
		try
		{
			String file=System.getProperty("user.dir")+rd.read_Configfile("scenarios_excel");
			int row_no=ex.get_row_count(file, "Login")+1;
			for(int i=1;i<row_no;i++)
			{
				String TestCaseName=ex.getexceldata(file, "Login", i, 1); 
				String run_mode=ex.getexceldata(file, "Login", i, 2); 
				ScenarioSheetRunMode.put(TestCaseName, run_mode);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void MainLoader()
	{
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		
		for(String suitePath : getAllSuitesFilePath())
			suites.add(getSuite(suitePath));
		TestNG tng = new TestNG();
		tng.setXmlSuites(suites);
		tng.run();
	}	
	public List<String> getAllSuitesFilePath()
	{
		List<String> suites = new ArrayList<String>();
		try{
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse (new File("testng.xml"));
			doc.getDocumentElement ().normalize ();
			NodeList Suitenodes = doc.getElementsByTagName("suite-file");
			for(int i=0;i<Suitenodes.getLength();i++)
			{
				Node suiteNode = Suitenodes.item(i);
				suites.add(suiteNode.getAttributes().getNamedItem("path").getNodeValue());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return suites;
	}
	
	public String getSuiteName(String FilePath)
	{
		try{
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse (new File(FilePath));
			doc.getDocumentElement ().normalize ();
			Element Suite = doc.getDocumentElement();
			return Suite.getAttribute("name");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "Something Invaild happed in loading testSuite";
		
	}
	public XmlSuite getSuite(String FilePath)
	{
		XmlSuite suite = new XmlSuite();
		LinkedListMultimap<String, String> TestCasesMap = readSuiteTestCase(FilePath);	
		for (String key: TestCasesMap.keySet())
		{
			if(testCaseAllowedToRun(key))
			{
				XmlTest test = new XmlTest(suite);
				test.setName(key);
				for(String Value : TestCasesMap.get(key))
				{
					List<XmlClass> classes = new ArrayList<XmlClass>();
					classes.add(new XmlClass(Value));
					test.setXmlClasses(classes) ;
					System.out.println(Value);
				}
				suite.addTest(test);
			}
			System.out.println(key);
		}
		return suite;
	}

	public boolean ScenariosAllowedToRun(String testCase)
	{
		/*PropertiesReader rd=new PropertiesReader();
	    ExcelReader ex= new ExcelReader();
		try
		{
			String file=System.getProperty("user.dir")+rd.read_Configfile("scenarios_excel");
			int row_no=ex.get_row_count(file, "Login")+1;
			for(int i=1;i<row_no;i++)
			{
				String TestCaseName=ex.getexceldata(file, "Scenarios", i, 1); 
				String run_mode=ex.getexceldata(file, "Scenarios", i, 2); 
				
				if(run_mode.equalsIgnoreCase("N") && TestCaseName.equals(testCase))
					  return false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return true;*/
		if(ScenarioSheetRunMode.get(testCase).equals("N"))
			return false;
		return true;
	}
	
	public boolean testCaseAllowedToRun(String testCase)
	{
		ConfigurationManager rd=new ConfigurationManager();
	    ExcelReader ex= new ExcelReader();
		try
		{
			String file=System.getProperty("user.dir")+rd.read_Configfile("scenarios_excel");
			
			int row_no=ex.get_row_count(file, "Login")+1;
			for(int i=1;i<row_no;i++)
			{
				String TestCaseName=ex.getexceldata(file, "Login", i, 1); 
				String run_mode=ex.getexceldata(file, "Login", i, 2); 
				
				if(run_mode.equalsIgnoreCase("N") && TestCaseName.equals(testCase))
					  return false;
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}
	
	public LinkedListMultimap<String, String> readSuiteTestCase(String FilePath)
	{
		LinkedListMultimap<String, String> TestCasesMap = LinkedListMultimap.create();
		try{
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		Document doc = docBuilder.parse (new File(FilePath));
		doc.getDocumentElement ().normalize ();
		NodeList Testnodes = doc.getElementsByTagName("test");
		
		for (int i = 0; i < Testnodes.getLength(); i++) 
		{
			Node test = Testnodes.item(i);
			NamedNodeMap Testattrib = test.getAttributes();
			if (test.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) test;
				NodeList classes = element.getElementsByTagName("class");
				for(int j=0; j< classes.getLength() ;j++)
				{
					Node classNode = classes.item(j);
					NamedNodeMap classattrib = classNode.getAttributes();
					String ClassPath = classattrib.getNamedItem("name").getNodeValue();
					String TestName = Testattrib.getNamedItem("name").getNodeValue();
					TestCasesMap.put(TestName, ClassPath);
				}
			}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return TestCasesMap;
	}
	
	
}
