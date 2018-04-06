package buisness.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestCase implements  Iterator<TestCaseStep>
{

	private List<TestCaseStep> steps ;
	private int currentNode;
	private int index;
	
	public TestCase() {
		steps = new ArrayList<TestCaseStep>();
		this.currentNode=0;
		this.index=0;
	}
	
	/**
	 * Step can be added to TestCases which are stored sequencially
	 * 
	 * @param step - Object of Step that we want to add to testcase
	 * 		
	 */
	public void add(TestCaseStep step) 
	{
		index++;
		steps.add(step);
		
	}
	
	public int getCurrentNode() {
		return currentNode;
	}

	@Override
	public boolean hasNext() 
	{
		if(currentNode < index)
			return true;
		else
			return false;
	}
	@Override
	public TestCaseStep next() 
	{
		return steps.get(currentNode++);
	}

	
	
	
	
	
}
