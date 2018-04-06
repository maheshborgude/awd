package buisness.util.datastructures.dashboard;

import configuration.Setup;

/**
 *This class is used to compare Dashboard>>Provider Measure Computation grid from the UI and Database 
 *This class implements Comparable<MeasureComputationSummaryGridRow>
 *Compare To method of Comparable<T> interface compare source row and target row
 * @author Sachin.Gawade
 * Updated Date 3 March 2016
 */


public class MeasureComputationSummaryGridRow implements Comparable<MeasureComputationSummaryGridRow>{
	
	private String monquat;
	private String allmeasures;
	private String met;
	private String notmet;
	private String percentage;
	
	/**
	 * Parameterized MeasureComputationSummaryRow Constructor
	 * @param monquat: Month or Quarter
	 * @param allmeasures: All measure count
	 * @param met: Met count
	 * @param notmet: Not met count
	 * @param percentage: Percentage
	 */
	public MeasureComputationSummaryGridRow(String monquat, String allmeasures, String met, String notmet, String percentage)
	{
		this.monquat = monquat;
		this.allmeasures = allmeasures;
		this.met = met;
		this.notmet = notmet;
		this.percentage = percentage;
	} 
	
/**
 * @return Month or Quarter
 */
	public String getMonQuat() 
	{
		return monquat;
	}

	/**
	 * @return all measures count
	 */
	public String getAllMeasures() 
	{
		return allmeasures;
	}

	/**
	 * @return met count
	 */
	public String getMet() 
	{
		return met;
	}

	/**
	 * @return not met count
	 */
	public String getNotMet() 
	{
		return notmet;
	}

	/**
	 * @return met Percentage
	 */
	public String getPercentage() 
	{
		return percentage;
	}
	
	@Override
	public String toString()
	{
		return "[" + monquat + "," + allmeasures+ "," +met+ "," + notmet+ "," + percentage+ "]";
	}

	@Override
	public int compareTo(MeasureComputationSummaryGridRow target)
	{
		if(this.monquat.equals(target.getMonQuat()))
		{
			if(this.allmeasures.equals(target.getAllMeasures()))
			{
				if(this.monquat.equals(target.getMonQuat()))
				{
					if(this.notmet.equals(target.getNotMet()))
					{
						if(this.percentage.equals(target.getPercentage()))
						{
						return 0;
						}
						else{
							Setup.log.debug("Data in Percentage column does not match for "+this.percentage+" "+target.getPercentage());
							return 1;
						}
					}
					else
					{
						 Setup.log.debug("Data in Date of Birth column does not match for "+this.notmet+" "+target.getNotMet());
						return 1;
					}
				}
				else {
					 Setup.log.debug("Data in Gender column does not match for "+this.met+" "+target.getMet());
					return 1;
				    }
				
				}
			else {
				 Setup.log.debug("Data in Mrn column does not match for "+this.allmeasures+" "+target.getAllMeasures());
				return 1;
				  }
		}
		else {
			 Setup.log.debug("Data in Name column does not match for "+this.percentage+" "+target.getPercentage());
			 return 1;
			  }
		
	}
	
	
}
