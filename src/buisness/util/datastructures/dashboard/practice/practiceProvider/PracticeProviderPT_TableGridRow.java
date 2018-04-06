package buisness.util.datastructures.dashboard.practice.practiceProvider;

import configuration.Setup;

/**
 * This class contain Table Rows logic  for Practice >> Provider View
 * This class is used to compare Performance table rows from UI and DB.
 * @author Ashwini.Gore
 * Created date : 1/12/2017
 */

public class PracticeProviderPT_TableGridRow implements Comparable<PracticeProviderPT_TableGridRow> {
	private String Quarter;
	private String All;
	private String Met;
	private String NotMet;
	private String Percentage;
	static int i=0;

	PracticeProviderPT_TableGridRow(String Quarter, String All, String Met, String NotMet,String Percentage) 
	{
		this.Quarter = Quarter;
		this.All = All;
		this.Met = Met;
		this.NotMet = NotMet;
		this.Percentage = Percentage;
	}

	public String getQuarter() {
		return Quarter;
	}

	public String getAll() {
		return All;
	}

	public String getMet() {
		return Met;
	}

	public String getNotMet() {
		return NotMet;
	}
	public String getPercentage() {
		return Percentage;
	}

	public int compareTo(PracticeProviderPT_TableGridRow target) 
{        i++;
		System.out.println("Table Row No-"+i+" UI and DB data");
   
		if (this.Quarter.compareToIgnoreCase(target.Quarter) == 0) 
		{   
			System.out.println("UI Quarter: "+ this.Quarter+"\tDB Quarter: "+target.Quarter);
			if (this.All.compareToIgnoreCase(target.All) == 0) 
			{
				System.out.println("UI All:     "+ this.All+"\tDB All:       "+target.All);
				if (this.Met.compareToIgnoreCase(target.Met) == 0) 
				{
					System.out.println("UI Met:     "+ this.Met+"\tDB Met:       "+target.Met);
					if (this.NotMet.compareToIgnoreCase(target.NotMet) == 0)
					{
					    System.out.println("UI NotMet:     "+ this.NotMet+"\tDB NotMet: "+target.NotMet);
						if (this.Percentage.compareToIgnoreCase(target.Percentage) == 0)
						{
							System.out.println("UI Percentage: "+ this.Percentage+"\tDB Percentage: "+target.Percentage+"\n");
							return 0;
					    } else 
					    {
						     Setup.log.debug("Data in Percentage column does not match for " + this.Percentage + " " + target.Percentage);
						     return -1;
					     }
				    } else 
				    {
					      Setup.log.debug("Data NotMet column does not match for " + this.NotMet + " " + target.NotMet);
					      return -1;
				    }
			    } else 
			    {
				  Setup.log.debug("Data in Met column does not match for " + this.Met + " " + target.Met);
				  return -1;
			     }
		} else 
		{
			Setup.log.debug("Data in All column does not match for " + this.All + " " + target.All);
			return -1;
			
		 } 
	}else
	{
		Setup.log.debug("Data in Quarter column does not match for " + this.Quarter + " " + target.Quarter);
		return -1;
	}
		
}	
	
}
