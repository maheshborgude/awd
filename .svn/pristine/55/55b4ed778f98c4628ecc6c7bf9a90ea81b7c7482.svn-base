package buisness.managers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.testng.*;
import org.testng.internal.Utils;
import org.testng.xml.XmlSuite;

/**
 *
 * @author abhishek.gaikwad
 *
 */
public class EmailReportManager  implements IReporter{
	@Override
	public void generateReport(List<XmlSuite> arg0, List<ISuite> suites, String arg2) {
		EmailManager em = new EmailManager();
		em.sendMail(getReport(suites));
	}

	/**
	 *
	 * @author Update Rakesh.Kulkarni
	 * Date : 10-5-2016
	 * Add Calculated time for execution column
	 * @author probeer.roy Updated Date: 19 Dec 2017
	 */
	private String startHtmlTable()
	{
		String msg;
		msg = "<table cellspacing=\"1\" cellpadding=\"4\" border=\"1\" bordercolor=\"#224466\" width=\"100%\" >";
		msg = msg + "<tr bgcolor=\"#6998EA\">";
		msg = msg + "<th>Test Cases</th>";
		msg = msg + "<th>Test Data</th>";
		msg = msg + "<th>Expected Result</th>";
		msg = msg + "<th>Actual Result</th>";
		msg = msg + "<th>Execution Start Time<br/></th>";
		msg = msg + "</tr>";
		return msg;
	}
	/**
	 *
	 * @author Update Rakesh.Kulkarni
	 * Date : 10-5-2016
	 * Remove Start date and End date time column
	 * @author probeer.roy Updated Date: 19 Dec 2017
	 */
	public String getReport(List<ISuite> suites)
	{
		String msg;
		//msg = startHtmlTable();
		msg = writeHeader();
		msg = msg +writeMetaData();
		msg = msg +startHtmlTable();
/*		String Fixp="LoginGroup";
		int z=1;*/
		for(ISuite s: suites)
		{
			for ( ISuiteResult r : s.getResults().values())
			{
			    ITestContext i = r.getTestContext();
				for( ITestResult res: i.getPassedTests().getAllResults())
				{
					msg = msg + "<tr>";
					String testName=i.getName();
					List<String> elephantList3 = OtherClass(testName);
					String name = elephantList3.get(0);
					String result = elephantList3.get(1);
					msg = msg + "<td>" + name + "</td>";
					msg = msg + "<td>" + Utils.escapeHtml(Utils.toString(res.getParameters())) + "</td>";
					msg = msg + "<td>" + result + "</td>";
					msg = msg + "<td><center><font color=\"green\"><b>" + (res.getStatus() == 1 ? "Pass" : "Pass")
							+ "</b></font></center></td>";
					msg = msg + "<td>" + i.getStartDate().toLocaleString() + "</td>";
					msg = msg + "</tr>";
				/*	j++;*/
				}
				for( ITestResult res: i.getFailedTests().getAllResults())
				{
					msg = msg + "<tr>";
					String testName=i.getName();
					List<String> elephantList3 = OtherClass(testName);
					String name = elephantList3.get(0);
					String result = elephantList3.get(1);
					msg = msg + "<td>" + name + "</td>";
					msg = msg + "<td>" + Utils.escapeHtml(Utils.toString(res.getParameters())) + "</td>";
					msg = msg + "<td>" + result + "</td>";
					msg = msg + "<td><center><font color=\"red\"><b>" + (res.getStatus() == 1 ? "Fail" : "Fail")
							+ "</b></font></center></td>";
					msg = msg + "<td>" + i.getStartDate().toLocaleString() + "</td>";
					msg = msg + "</tr>";
				}
			}
		}
		msg = msg + "</table>";
		msg = msg + ("<h3>Regards,</h3>");
		msg = msg + ("<h5>Automation Team - Delivery</h5>");
		msg = msg + ("<img src=\"http://figmd.com/wp-content/themes/FIGmd/img/logo.png\">");
		return msg;
	}
	protected PrintWriter createWriter(String outdir) throws IOException {
		new File(outdir).mkdirs();
		return new PrintWriter(new BufferedWriter(new FileWriter(new File(
				outdir, "CustomReportForAAO"
				+ ".html"))));
	}
	private String writeHeader()
	{
		String msg="";
	
		msg = msg + ("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1//EN\" \"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\">");
		msg = msg + ("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
		msg = msg + ("<head>");
		msg = msg + ("<title>Test Execution Report of AAO</title>");
		msg = msg + ("</head>");
		msg = msg + ("<body>");
        return msg;
	}
	/**
	 * writes additional details like Executor name
	 * @throws IOException
	 * this method will cretae table for Execution details in HTML file.
	 * @author probeer.roy Updated date: 19 Dec 2017
	 */
	private String writeMetaData() {
		String msg = "";
		String Module = "AAO Automation";
		String Verision = "1.0";
		msg = msg + "<table cellspacing=\"1\" cellpadding=\"4\" border=\"1\" width=\"Auto\">";
		msg = msg + "<tr bgcolor=\"#6998EA\"><th colspan=\"2\">Execution Details</th></tr>";
		msg = msg + "<tr><td>Test Executor</td><td>" + System.getProperty("user.name") + "</td></tr>";
		msg = msg + "<tr><td>Module</td><td>" + Module + "</td></tr>";
		msg = msg + "<tr><td>Version</td><td>" + Verision + "</td></tr>";
		msg = msg + "<tr><td>Date and Time</td><td>" + new Date() + "</td></tr>";
		msg = msg + "</table>";

		try {
			msg = msg + ("<h5><a href=\"" + new ConfigurationManager().read_Configfile("url")
					+ "\">Go to application</a></h5>");
		} catch (Exception e) {
			msg = msg + ("Unable to retrive URL link");
		}

		return msg;
	}
	public static int[] splitToComponentTimes(int biggy)
	{
		long longVal = biggy;//.longValue();
		int hours = (int) longVal / 3600;
		int remainder = (int) longVal - hours * 3600;
		int mins = remainder / 60;
		remainder = remainder - mins * 60;
		int secs = remainder;

		int[] ints = {hours , mins , secs};
		return ints;
	}

	private String getDurationString(int seconds) {

		int hours = seconds / 3600;
		int minutes = (seconds % 3600) / 60;
		seconds = seconds % 60;
		String h=twoDigitString(hours);
		String m=twoDigitString(minutes);
		String s=twoDigitString(seconds);
		return h+ " : " + m + " : " + s;
	}
	private String twoDigitString(int number) {

		if (number == 0) {
			return "00";
		}

		if (number / 10 == 0) {
			return "0" + number;
		}

		return String.valueOf(number);
	}
	/**
	 *
	 * @author Rakesh.Kulkarni
	 *
	 */
	public List<String> OtherClass(String input)
	{

		List<String> elephantList = Arrays.asList(input.split(":"));
		System.out.println(elephantList);
		try {
			String name = elephantList.get(0);
			String result = elephantList.get(1);
			System.out.println(name + " and " + result);
		} catch (Exception e) {
			String result = "Result Not Defined";
			List<String> elephantList1 = new ArrayList<String>(1);
			elephantList1.add(0,input);
			elephantList1.add(1,result);
			return elephantList1;
		}
		return elephantList;
	}
}
