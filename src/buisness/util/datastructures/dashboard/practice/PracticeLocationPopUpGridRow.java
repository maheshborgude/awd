package buisness.util.datastructures.dashboard.practice;
/**
 * This class is used to compare current row with Target row
 * This class compare row of Data row of Location PopUp  present on Dashboards >> Practice
 * @author rakesh.kulkarni
 * Date 21/03/2016
 */
public class PracticeLocationPopUpGridRow implements Comparable<PracticeLocationPopUpGridRow> {
	private String 	LocationName;
	private String 	Qualified;
	private String 	Met;
	private String 	NotMet;
	private String  Performance;
	private String 	RegistryBenchmark;
	/**
	 * parameterized constructor with parameter
	 * @param LocationName : Provider name
	 * @param Qualified : Provider Npi
	 * @param Met : Provider Tin
	 * @param NotMet : Status of DRCF for Submission.
	 * @param Performance : Status of DRCF for Submission
	 * @param RegistryBenchmark : Status of DRCF for Submission
	 */
	PracticeLocationPopUpGridRow(String LocationName, String Qualified, String Met, String NotMet,String Performance,String RegistryBenchmark)
	{
		this.LocationName = LocationName;
		this.Qualified = Qualified;
		this.Met = Met;
		this.NotMet = NotMet;
		this.Performance=Performance;
		this.RegistryBenchmark=RegistryBenchmark;

	}
	@Override
	public int compareTo(PracticeLocationPopUpGridRow target) {

	  return(this.LocationName.compareTo(target.LocationName))
					+(this.Qualified.compareTo(target.Qualified))
					+(this.Met.compareTo(target.Met))
					+(this.NotMet.compareTo(target.NotMet))
			  		+(this.Performance.compareTo(target.Performance))
			  		+(this.RegistryBenchmark.compareTo(target.RegistryBenchmark));
	}
    /**
     * Method to return LocationName
     * @return name
     */
	public String getLocationName() {
		return LocationName;
	}
    /**
     * Method to return Qualified
     * @return Npi
     */
	public String getQualified() {
		return Qualified;
	}
    /**
     * Method to return Met
     * @return lastName
     */
	public String getMet() {
		return Met;
	}
    /**
     * Method to return NotMet
     * @return practiceID
     */
	public String getNotMet() {
		return NotMet;
	}
	/**
	 * Method to return Performance
	 * @return name
	 */
	public String getPerformance() {
		return Performance;
	}
	/**
	 * Method to return RegistryBenchmark
	 * @return name
	 */
	public String getRegistryBenchmark() {
		return RegistryBenchmark;
	}
}

