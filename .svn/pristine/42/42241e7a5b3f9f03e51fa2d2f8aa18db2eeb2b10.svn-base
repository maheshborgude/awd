package buisness.util;

import java.util.ArrayList;
import java.util.List;

public class TestCaseStep {
	
	private String action;
	private String elementmethod;
	private String locator;
	private List<String> data; 
	private String locatorValue;
    
	public TestCaseStep(String action, String elementmethod, String locator,  String locatorValue) {
		this.data = new ArrayList<>();
		this.action = action;
		this.elementmethod = elementmethod;
		this.locator = locator;
		this.locatorValue = locatorValue;
	}
	
	public TestCaseStep(String action, String elementmethod, String locator,  String locatorValue,String data) {
		super();
		this.data = new ArrayList<>();
		this.action = action;
		this.elementmethod = elementmethod;
		this.locator = locator;
		this.data.add(data);
		this.locatorValue = locatorValue;
	}
    
	public TestCaseStep(String action, String elementmethod, String locator,  String locatorValue,String data1, String data2) 
	{
		super();
		this.data = new ArrayList<>();
		this.action = action;
		this.elementmethod = elementmethod;
		this.locator = locator;
		if(data1!= null)
			this.data.add(data1);
		else
			this.data.add("");
		if(data2!= null)
			this.data.add(data2);
		else
			this.data.add("");
		this.locatorValue = locatorValue;
	}

	public void addData(String data) {
		this.data.add(data);
	}

	public String getAction() {
		return action;
	}

	public String getElementmethod() {
		return elementmethod;
	}

	public String getLocator() {
		return locator;
	}

	public List<String> getData() {
		return data;
	}

	public String getLocatorValue() {
		return locatorValue;
	}
    
    
}
