package buisness.util.datastructures.dashboard.provider;

import configuration.Setup;

/**
 * This class is used to compare Dashboard>>Provider or Dashboard>>Location grid
 * from the UI and Database This class implements Comparable
 * <LocationProviderGridRow>
 * 
 * @author Sachin.Gawade Date 1 March 2016
 * @author probeer.roy Updated Date: 18 December 2017
 */

public class ProviderViewGridRow implements Comparable<ProviderViewGridRow> {

	private String providername;
	private String exceeding;
	private String withinrange;
	private String below;

	/**
	 * Parameterized ProviderLocationGridRow constructor
	 * 
	 * @param name:
	 *            Provider name
	 * @param exceeding:
	 *            Exceeding count
	 * @param below:
	 *            Below count
	 */
	ProviderViewGridRow(String providername, String exceeding, String withinrange, String below) {
		this.providername = providername;
		this.exceeding = exceeding;
		this.withinrange = withinrange;
		this.below = below;
	}

	/**
	 * @return Provider or Location name
	 */
	public String getName() {
		return providername;
	}

	/**
	 * @return Exceeding count
	 */
	public String getExceeding() {
		return exceeding;
	}

	/**
	 * @return Exceeding count
	 */
	public String getWithinRange() {
		return withinrange;
	}

	/**
	 * @return Below count
	 */
	public String getBelow() {
		return below;
	}

	/**
	 * This method is used to compare the one object with target object or
	 * specified object
	 * <p>
	 * 
	 * @param exactmatch:
	 *            Row to compare with returns 0 if location/provider, exceeding,
	 *            below matches
	 *            <p>
	 *            returns 1 if location/provider, exceeding, below not matches
	 *            <p>
	 */
	@Override
	public int compareTo(ProviderViewGridRow target) {

		try {
			if (this.providername.compareToIgnoreCase(target.providername) == 0) {

				if (this.exceeding.compareToIgnoreCase(target.exceeding) == 0) {
					
					if (this.withinrange.compareToIgnoreCase(target.withinrange) == 0) {
						
						if (this.below.compareToIgnoreCase(target.below) == 0) {
							
							return 0;
						} else {
							Setup.log.debug(
									"Data in Below column does not match for " + this.below + " " + target.below);
							return 1;
						}
					} else {
						Setup.log.debug("Data in Within Range column does not match for " + this.withinrange + " "
								+ target.withinrange);
						return 1;
					}
				} else {
					Setup.log.debug(
							"Data in Exceeding column does not match for " + this.exceeding + " " + target.exceeding);
					return 1;
				}
			} else {
				Setup.log.debug("Data in Provider Name column does not match for " + this.providername + " "
						+ target.providername);
				return 1;
			}
		} catch (NullPointerException e) {
			Setup.log.error("Null data is being compared.");
			return 1;
		}

	}
}
