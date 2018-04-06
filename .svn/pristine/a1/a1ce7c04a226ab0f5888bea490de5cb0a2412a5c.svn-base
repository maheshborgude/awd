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
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.internal.Utils;
import org.testng.xml.XmlSuite;

/**
 * 
 * @author abhishek.gaikwad
 *
 */
public class CustomReportManager implements IReporter {

	private PrintWriter out;

	@SuppressWarnings("deprecation")
	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory)

	{

		try {
			ExcelReportManager e = new ExcelReportManager();

			out = createWriter(outputDirectory);
		} catch (IOException e) {
			System.out.println("output file: " + e);
			return;
		}
		writeHeader();
		writeMetaData();
		startHtmlTable();
		for (ISuite s : suites) {
			for (ISuiteResult r : s.getResults().values()) {
				ITestContext i = r.getTestContext();
				for (ITestResult res : i.getPassedTests().getAllResults()) {
					out.println("<tr>");

					String testName = i.getName();
					List<String> elephantList3 = OtherClass(testName);
					String name = elephantList3.get(0);
					String result = elephantList3.get(1);

					out.println("<td>" + name + "</td>");
					out.println("<td>" + Utils.escapeHtml(Utils.toString(res.getParameters())) + "</td>");
					out.println("<td>" + result + "</td>");

					out.println("<td><center><font color=\"green\"><b>" + (res.getStatus() == 1 ? "Pass" : "Pass")
							+ "</b></font></center></td>");
					out.println("<td>" + i.getStartDate().toLocaleString() + "</td>");
					// out.println("<td>"+i.getEndDate().toLocaleString()+"</td>");
					out.println("</tr>");
				}

				for (ITestResult res : i.getFailedTests().getAllResults()) {

					out.println("<tr>");

					String testName = i.getName();
					List<String> elephantList3 = OtherClass(testName);
					String name = elephantList3.get(0);
					String result = elephantList3.get(1);

					out.println("<td>" + name + "</td>");
					out.println("<td>" + Utils.escapeHtml(Utils.toString(res.getParameters())) + "</td>");
					out.println("<td>" + result + "</td>");
					out.println("<td><center><font color=\"red\"><b>" + (res.getStatus() == 1 ? "Fail" : "Fail")
							+ "</b></font></center></td>");
					out.println("<td>" + i.getStartDate().toLocaleString() + "</td>");
					// out.println("<td>"+i.getEndDate().toLocaleString()+"</td>");
					out.println("</tr>");
				}
			}
		}
		out.close();
	}

	/**
	 * 
	 * @param outdir
	 *            The output directory where the generated report is to be saved
	 * @return
	 * @throws IOException
	 */
	protected PrintWriter createWriter(String outdir) throws IOException {
		new File(outdir).mkdirs();
		return new PrintWriter(new BufferedWriter(new FileWriter(new File(outdir, "CustomReportForAAO"// +sd.format(now)
				+ ".html"))));
	}

	private void writeHeader() {
		out.println(
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1//EN\" \"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\">");
		out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
		out.println("<head>");
		out.println("<title>Test Execution Report</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<img src=\"http://figmd.com/wp-content/themes/FIGmd/img/logo.png\">");
		out.flush();
	}

	/**
	 * writes additional details like Executor name
	 * 
	 * @throws IOException
	 */
	private void writeMetaData() {
		String Module = "AAO Automation";
		String Verision = "1.0";
		out.println("<table cellspacing=\"1\" cellpadding=\"4\" border=\"1\" width=\"Auto\">");
		out.println("<tr bgcolor=\"#6998EA\"><th colspan=\"2\">Execution Details</th></tr>");
		out.println("<tr><td>Test Executor</td><td>" + System.getProperty("user.name") + "</td></tr>");
		out.println("<tr><td>Module</td><td>" + Module + "</td></tr>");
		out.println("<tr><td>Version</td><td>" + Verision + "</td></tr>");
		out.println("<tr><td>Date and Time</td><td>" + new Date() + "</td></tr>");
		out.println("</table>");

		try {
			out.println("<h5><a href=\"" + new ConfigurationManager().read_Configfile("url")
					+ "\">Go to application</a></h5>");
		} catch (Exception e) {
			System.out.println("Unable to retrive URL link");
		}

	}

	private void startHtmlTable() {
		out.println("<table cellspacing=\"0\" cellpadding=\"4\" border=\"1\" bordercolor=\"#224466\" width=\"100%\" >");
		out.println("<tr bgcolor=\"#6998EA\">");
		out.println("<th>Test Cases</th>");
		out.println("<th>Test Data</th>");
		out.println("<th>Expected Result</th>");
		out.println("<th>Actual Result</th>");
		out.println("<th>Execution Start Time</th>");
		// out.println("<th>End Date and Time</th>");
		out.println("</tr>");
	}

	public List<String> OtherClass(String input) {

		List<String> elephantList = Arrays.asList(input.split(":"));
		try {
			String name = elephantList.get(0);
			String result = elephantList.get(1);
			System.out.println(name + " and " + result);
		} catch (Exception e) {
			String result = "Result Not Defined";
			List<String> elephantList1 = new ArrayList<String>(1);
			elephantList1.add(0, input);
			elephantList1.add(1, result);
			return elephantList1;
		}
		return elephantList;
	}
}
