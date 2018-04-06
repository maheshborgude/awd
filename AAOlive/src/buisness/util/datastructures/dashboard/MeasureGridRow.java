package buisness.util.datastructures.dashboard;
import configuration.Setup;

/**
 * This class is used to compare Measure grid of Dashboard>>Provider or Dashboard>>Location from the UI and Database <p>
 * This class implements Comparable<MeasureGridRow>
 * @author Sachin.Gawade
 * Updated Date 2 March 2016
 */

public class MeasureGridRow implements Comparable<MeasureGridRow>
{
	
	private String	 measureID;
	private String measureName;
	private String registryBenchmark;
	private String performance;
	/**
	 * Parameterized MeasureGridRow constructor
	 * @param measureID: Measure Id
	 * @param measureName: Measure name
	 * @param registryBenchmark: Registry benchmark for the measure
	 * @param performance: Performance for the measure
	 */
	MeasureGridRow(String measureID,String measureName,String registryBenchmark,String performance)
	{
		this.measureID = measureID;
		this.measureName = measureName; 
		this.registryBenchmark = registryBenchmark;
		this.performance = performance;
	}
	
/**
 * @return measureID of measure
 */
	public String getMeasureID() {
		return measureID;
	}

	/**
	 * @return measureName of measure
	 */
	public String getMeasureName() {
		return measureName;
	}

	/**
	 * @return Registry Benchmark of measure
	 */
	public String getRegistryBenchmark() {
		return registryBenchmark;
	}

	/**
	 * @return Performance of measure
	 */
	public String getPerformance() {
		return performance;
	}

	/**
	 * This method is used to compare the one object with target object or specified object <p>
	 * returns 0 if all data match<p>
	 * returns 1 if data does not match<p>
	 */
	
	@Override
	public int compareTo(MeasureGridRow target) 
	{
		if(this.measureID.equals(target.measureID))
		{
			if(this.measureName.equals(target.measureName))
			{
				if(this.registryBenchmark.equals(target.registryBenchmark))
				{
					if(this.performance .equals(target.performance))
					{
						return 0;
						}
					else
					{
						 Setup.log.debug("Data in performance column does not match for "+this.performance+" "+target.performance);
						return 1;
					}
				}
				else {
					 Setup.log.debug("Data in Registry Bench mark column does not match for "+this.registryBenchmark+" "+target.registryBenchmark);
					return 1;
				}
			}
			else {
				 Setup.log.debug("Data in Measure name column does not match for "+this.measureName+" "+target.measureName);
				return 1;
			}
			
		}
		else {
			 Setup.log.debug("Data in measureID column does not match for "+this.measureID+" "+target.measureID);
			return 1;
		}
	}
	
}
