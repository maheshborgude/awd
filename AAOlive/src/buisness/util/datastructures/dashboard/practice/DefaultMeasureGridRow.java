package buisness.util.datastructures.dashboard.practice;

import configuration.Setup;

public class DefaultMeasureGridRow implements Comparable<DefaultMeasureGridRow> {
	private String ID;
	private String Measure;
	private String Reg_Avg;
	private String Reg_Bench;

	DefaultMeasureGridRow(String ID, String Measure, String Reg_Avg, String Reg_Bench) {
		this.ID = ID;
		this.Measure = Measure;
		this.Reg_Avg = Reg_Avg;
		this.Reg_Bench = Reg_Bench;

	}

	public String getID() {
		return ID;
	}

	public String getMeasure() {
		return Measure;
	}

	public String getRegAvg() {
		return Reg_Avg;
	}

	public String getRegBench() {
		return Reg_Bench;
	}

	@Override
	public int compareTo(DefaultMeasureGridRow target) {
		System.out.println("Compare To method of 'patient visit row invoked.'");
		System.out.println(this.ID);
		System.out.println(target.ID);

		if (this.ID.compareToIgnoreCase(target.ID) == 0) {
			System.out.println(this.Measure);
			System.out.println(target.Measure);
			if (this.Measure.compareToIgnoreCase(target.Measure) == 0) {
				if (this.Reg_Avg.compareToIgnoreCase(target.Reg_Avg) == 0) {
					if (this.Reg_Bench.compareToIgnoreCase(target.Reg_Bench) == 0) {

						return 0;
					} else {
						Setup.log.debug("Data in Register ID column does not match for " + this.ID + " " + target.ID);
						return 1;
					}
				} else {
					Setup.log.debug(
							"Data in Patient ID column does not match for " + this.Measure + " " + target.Measure);
					return 1;
				}
			} else {
				Setup.log.debug("Data in Birthdate column does not match for " + this.Reg_Avg + " " + target.Reg_Avg);
				return 1;
			}
		} else {
			Setup.log.debug("Data in Visit Date column does not match for " + this.Reg_Bench + " " + target.Reg_Bench);
			return 1;
		}
	}
	// TODO Auto-generated method stub

}
