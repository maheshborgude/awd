package buisness.util.datastructures.dashboard.practice.practiceProvider;

import java.util.Comparator;
import configuration.Setup;

public class PracticeProviderPopUpViewGridRow implements Comparable<PracticeProviderPopUpViewGridRow>
{
	private String providerName;
	private String All;
	private String Met;
	private String NotMet;
	private String Performance;
	private String registryAverage;
	static int i=0;

	PracticeProviderPopUpViewGridRow(String providerName, String All, String Met, String NotMet,String Performance,String registryAverage) 
	{
		this.providerName =providerName;
		this.All = All;
		this.Met = Met;
		this.NotMet = NotMet;
		this.Performance = Performance;
		this.registryAverage=registryAverage;
	}

	public String getproviderName() {
		return providerName;
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
	public String getPerformance() {
		return Performance;
	}
	public String getregistryAverage() {
		return registryAverage;
	}

	public int compareTo(PracticeProviderPopUpViewGridRow target) 
{        i++;
		System.out.println("Table Row No-"+i+" UI and DB data");
	
		if (this.providerName.compareToIgnoreCase(target.providerName) == 0) 
		{   
			System.out.println("UI providerName:"+ this.providerName+"\tDB providerName:"+target.providerName);
			if (this.All.compareToIgnoreCase(target.All) == 0) 
			{
				System.out.println("UI All:"+ this.All+"\tDB All:"+target.All);
				if (this.Met.compareToIgnoreCase(target.Met) == 0) 
				{
					System.out.println("UI Met:"+ this.Met+"\tDB Met:"+target.Met);
					if (this.NotMet.compareToIgnoreCase(target.NotMet) == 0)
					{
					    System.out.println("UI NotMet:"+ this.NotMet+"\tDB NotMet:"+target.NotMet);
						if (this.Performance.compareToIgnoreCase(target.Performance) == 0)
						{
							System.out.println("UI Percentage:"+ this.Performance+"\tDB Performance:"+target.Performance);
							if(this.registryAverage.compareToIgnoreCase(target.registryAverage) == 0)
							{
								System.out.println("UI registryAverage:"+ this.registryAverage+"\tDB registryAverage:"+target.registryAverage+"\n");
								return 0;
							}
							else
							{
								Setup.log.error("Data in registryAverage column does not match for " + this.registryAverage + " " + target.registryAverage);
							     return -1;
							}
							
					    } else 
					    {
						     Setup.log.error("Data in Percentage column does not match for " + this.Performance + " " + target.Performance);
						     return -1;
					     }
				    } else 
				    {
					      Setup.log.error("Data NotMet column does not match for " + this.NotMet + " " + target.NotMet);
					      return -1;
				    }
			    } else 
			    {
				  Setup.log.error("Data in Met column does not match for " + this.Met + " " + target.Met);
				  return -1;
			     }
		} else 
		{
			Setup.log.error("Data in All column does not match for " + this.All + " " + target.All);
			return -1;
			
		 } 
	}else
	{
		Setup.log.error("Data in Provicer Name column does not match for " + this.providerName + " " + target.providerName);
		return -1;
	}
}


}
