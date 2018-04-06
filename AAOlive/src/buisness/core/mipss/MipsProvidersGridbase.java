package buisness.core.mipss;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import buisness.awadhesh.datastructures.mips.Mipsprovidergrid;
import buisness.core.DashboardUI;
import buisness.managers.DatabaseManger;
import configuration.Setup;

abstract public class MipsProvidersGridbase extends DashboardUI {

	/**
	 * This class compare Data row of MIPS Provider
	 * 
	 * @param locator
	 * @return Object of specified class
	 */

	public Mipsprovidergrid getWebGrid(String elementmethod, String locator) {
		System.out.printf("the captured elementmethod is " + elementmethod);
		System.out.printf("the captured x path is " + locator);
		Setup.log.trace(locator);
		if (locator != null)

		{
			Mipsprovidergrid mipsprovidergrid = new Mipsprovidergrid();
			try {
				List<WebElement> rows = getWebElements(elementmethod, locator);
				System.out.println("Number of rows in Grid:" + rows.size());
				for (WebElement table : rows) {
					String PROVIDERNAME = table.findElement(By.xpath("./td[2]/span")).getText();
					String PROVIDERNAMET = super.trimMultiSpace(PROVIDERNAME).trim();
					Setup.log.info(PROVIDERNAMET);
					System.out.println("Print from webgrid:" + PROVIDERNAMET);

					String MIPSELIGIBILITY = table.findElement(By.xpath("./td[3]/span")).getText();
					String MIPSELIGIBILITYT = super.trimMultiSpace(MIPSELIGIBILITY).trim();
					Setup.log.info(MIPSELIGIBILITYT);

					String NPI = table.findElement(By.xpath("./td[4]/span")).getText();
					Setup.log.info(NPI);

					String TIN = table.findElement(By.xpath("./td[5]/span/span")).getText();
					Setup.log.info(TIN);

					String QUALITY = table.findElement(By.xpath("./td[6]/span")).getText();
					String QUALITYT = super.trimMultiSpace(QUALITY).trim();
					Setup.log.info(QUALITYT);

					String ACI = table.findElement(By.xpath("./td[7]/span")).getText();
					String ACIT = super.trimMultiSpace(ACI).trim();
					Setup.log.info(ACIT);

					String IA = table.findElement(By.xpath("./td[8]/span")).getText();
					String IAT = super.trimMultiSpace(IA).trim();
					Setup.log.info(IAT);

					String MIPSFINALSCORE = table.findElement(By.xpath("./td[9]/span")).getText();
					String MIPSFINALSCORET = super.trimMultiSpace(MIPSFINALSCORE).trim();
					Setup.log.info(MIPSFINALSCORET);

					String SUBMISSIONSTATUS = table.findElement(By.xpath("./td[12]/span")).getText();
					String SUBMISSIONSTATUST = super.trimMultiSpace(SUBMISSIONSTATUS).trim();
					Setup.log.info(SUBMISSIONSTATUST);

					// Mipsprovidergrid.add(PROVIDERNAME,
					// MIPSELIGIBILITY,NPI,TIN,QUALITY,ACI,IA);
					//// PROVIDERNAME,
					// MIPSELIGIBILITY,NPI,TIN,QUALITY,ACI,IA,MIPSFINALSCORE,SUBMISSIONSTATUS
					mipsprovidergrid.add(PROVIDERNAMET, MIPSELIGIBILITYT, NPI, TIN, QUALITYT, ACIT, IAT,
							MIPSFINALSCORET, SUBMISSIONSTATUST);
				}
			} catch (Exception e) {
				Setup.log.error(e);
				Setup.log.error("Please check xpath in ObjectRepositary.Properties file ");
			}
			return mipsprovidergrid;
		} else {
			Setup.log.error("The Xpath of WebGrid is incorrect or missing ");
			return null;
		}

	}

	/**
	 * This method is used to get data from Database and return a object with
	 * Grid value
	 * <p>
	 * This class compare Data row of Location popup present on Dashboards >>
	 * Practice Location popup present on selecting measure
	 * 
	 * @return Object of specified class
	 */

	public Mipsprovidergrid getDatabaseGrid(String query) {
		System.out.println("Passed query is: " + query);
		// DatabaseManger.SQLserverConnection();
		ResultSet resultSet = DatabaseManger.exeQuery(query);
		Mipsprovidergrid mipsprovidergrid = new Mipsprovidergrid();

		Setup.log.trace(query);
		if (resultSet != null) {
			try {
				while (resultSet.next()) {

					String PROVIDERNAME = resultSet.getString("PROVIDERNAME");
					System.out.println("Print from DB Grid:" + PROVIDERNAME);
					String MIPSELIGIBILITY = resultSet.getString("MIPSELIGIBILITY");
					System.out.println(MIPSELIGIBILITY);
					String NPI = resultSet.getString("NPI");
					System.out.println(NPI);
					String TIN = resultSet.getString("TIN");
					System.out.println(TIN);
					String QUALITY = resultSet.getString("QUALITY");
					System.out.println(QUALITY);
					String ACI = resultSet.getString("ACI");
					System.out.println(ACI);
					String IA = resultSet.getString("IA");
					System.out.println(IA);
					String MIPSFINALSCORE = resultSet.getString("MIPSFINALSCORE");
					System.out.println(MIPSFINALSCORE);
					String SUBMISSIONSTATUS = resultSet.getString("SUBMISSIONSTATUS");
					System.out.println(SUBMISSIONSTATUS);

					/// Mipsprovidergrid.add(PROVIDERNAMET,
					/// MIPSELIGIBILITYT,NPI,TIN,QUALITYT,ACIT,IAT)

					mipsprovidergrid.add(PROVIDERNAME, MIPSELIGIBILITY, NPI, TIN, QUALITY, ACI, IA, MIPSFINALSCORE,
							SUBMISSIONSTATUS);
				}

			} catch (SQLException ex) {
				Setup.log.error("Please check query in 'Queries.properties.");
				Setup.testcase.fail();
			} catch (Exception excp) {
				Setup.log.error("query in 'Queries.properties is correct.");
				Setup.testcase.fail();
			}
			return mipsprovidergrid;
		}

		else {
			Setup.log.error("Nothing to return hence return the NULL");
			return null;
		}
	}
}
