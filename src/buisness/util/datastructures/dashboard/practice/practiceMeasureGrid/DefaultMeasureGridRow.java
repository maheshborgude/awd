package buisness.util.datastructures.dashboard.practice.practiceMeasureGrid;

import configuration.Setup;

public class DefaultMeasureGridRow implements Comparable<DefaultMeasureGridRow> {
	private String id;
	private String measure;
	private String performance;
	private String reg_avg;
	
	DefaultMeasureGridRow(String id, String measure, String performance, String reg_avg) {
		this.id = id;
		this.measure = measure;
		this.performance = performance;
		this.reg_avg = reg_avg;

	}

	public String getID() {
		return id;
	}

	public String getMeasure() {
		return measure;
	}

	public String getRegAvg() {
		return performance;
	}

	public String getRegBench() {
		return reg_avg;
	}

	@Override
	public int compareTo(DefaultMeasureGridRow target) {
		//System.out.println("Compare To method of DefaultMeasureGridRow row invoked.'");
		if (this.id.compareToIgnoreCase(target.id) == 0) {
			if (this.measure.compareToIgnoreCase(target.measure) == 0) {
				if (this.performance.compareToIgnoreCase(target.performance) == 0) {
					if (this.reg_avg.compareToIgnoreCase(target.reg_avg) == 0) {

						return 0;
					} else {
						Setup.log.debug("Registry average of measure does not match for " + this.reg_avg + " " + target.reg_avg);
						return 1;
					}
				} else {
					Setup.log.debug(
							"Performance of measure does not match for " + this.performance + " " + target.performance);
					return 1;
				}
			} else {
				Setup.log.debug("Measure name does not match for " + this.measure + " " + target.measure);
				return 1;
			}
		} else {
			Setup.log.debug("Measure ID does not match for " + this.id + " " + target.id);
			return 1;
		}
	}
	// TODO Auto-generated method stub

}
