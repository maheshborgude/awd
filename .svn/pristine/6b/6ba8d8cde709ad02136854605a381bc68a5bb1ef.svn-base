package buisness.frameworkengine;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import buisness.keywords.Common;
import buisness.keywords.login.Login;
import buisness.managers.ConfigurationManager;
import buisness.managers.ScreenshotManager;
import configuration.Setup;

public class TestExecutor {

	private ExcelReader exe = new ExcelReader();
	private String scriptname = null;
	private ConfigurationManager rd = new ConfigurationManager();
	private String result = null;

	private static ScreenshotManager SS = new ScreenshotManager();

	public void testexecute(String filelocation, String scriptnm) throws IOException, InvalidFormatException {
		try {
			scriptname = scriptnm;
			int nosteps = exe.get_row_count(filelocation, scriptname) + 1;
			Setup.log.debug("\nFor script " + scriptname);
			Setup.testcase = new SoftAssert();
			for (int i = 1; i < nosteps; i++) {
				String action = exe.getexceldata(filelocation, scriptname, i, 1);
				String elementmethod = exe.getexceldata(filelocation, scriptname, i, 2);
				String locator = exe.getexceldata(filelocation, scriptname, i, 3);

				Common c;
				if (filelocation.toLowerCase().contains("login.xlsx")) {
					c = new Login();
					result = c.meth(elementmethod, action, locator);
				}
				// else
				// if(filelocation.toLowerCase().contains("administartion"))
				// {
				// if(filelocation.toLowerCase().contains("User Management"))
				// {
				// c = new buisness.keywords.administration.UserManagement();
				// result = c.meth(elementmethod, action, locator);
				// }
				else if (filelocation.toLowerCase().contains("administration"))

					if (filelocation.toLowerCase().contains("location")) {
						c = new buisness.keywords.administration.Location();
						result = c.meth(elementmethod, action, locator);
					} else if ((filelocation.toLowerCase().contains("pro"))) {
						if (filelocation.toLowerCase().contains("clinicianportal")) {
							c = new buisness.keywords.pro.ClinicianPortal();
							result = c.meth(elementmethod, action, locator);
						} else if (filelocation.toLowerCase().contains("Dashboard")) {
							if (filelocation.toLowerCase().contains("PracticeMeasureGrid")) {
								c = new buisness.keywords.dashboard.Practice();
								result = c.meth(elementmethod, action, locator);

							}
							if (filelocation.toLowerCase().contains("Provider")) {
								c = new buisness.keywords.dashboard.Provider();
								result = c.meth(elementmethod, action, locator);

							}
						}

						/*
						 * else if(filelocation.toLowerCase().contains(
						 * "forgotpassword")) { c = new
						 * Action_Forgot_Password(); result =
						 * c.meth(elementmethod, action, locator); } else
						 * if((filelocation.toLowerCase().contains("dashboard"))
						 * ) {
						 * if(filelocation.toLowerCase().contains("provider")) {
						 * c = new Action_Dashboard_Provider(); result =
						 * c.meth(elementmethod, action, locator); } else
						 * if(filelocation.toLowerCase().contains("practice")) {
						 * c = new Action_Dashboard_Practice(); result =
						 * c.meth(elementmethod, action, locator); } } else
						 * if(filelocation.toLowerCase().contains(
						 * "administartion")) {
						 * if(filelocation.toLowerCase().contains(
						 * "usermanagement")) { c = new
						 * Action_Administration_UserManagement(); result =
						 * c.meth(elementmethod, action, locator); } else
						 * if(filelocation.toLowerCase().contains("practice")) {
						 * c = new Action_Administration_Practice(); result =
						 * c.meth(elementmethod, action, locator); } }
						 */

						SS.capture(scriptname + "- Step " + i + "_Action " + action + "_Status " + result);
						Setup.log.info("Step " + i + "\tAction: " + action + "\tStatus: " + result);
						if (result.contains("Fail")) {
							// Setup.log.error("Step " + i + "\tAction: " +
							// action + "\tStatus: "+result);
							String POF = exe.getexceldata(filelocation, scriptname, i, 6);
							if (POF.equalsIgnoreCase("N")) {
								Setup.log.warn("Step " + i + " failed!! Not allowed for proceed further");
								Assert.fail("Step " + i + "\tAction: " + action + "\tStatus: " + result);
								return;
							}
							Setup.log.warn("Step " + i + " failed!! Allowed for proceed further");
						} else if (result.equalsIgnoreCase("Pass Not Allowed to Proceed")) {
							Setup.log.warn("Step " + i + " Passed!! Not allowed for proceed further");
							return;
						} else {
							Setup.log.info("Step " + i + "\tAction: " + action + "\tStatus: " + result);
						}
					}
			}
		} catch (Exception e) {
			Setup.log.fatal(e.toString());
		}
	}

	public void testexecute(String filelocation, String scriptnm, Hashtable<String, String> Table)
			throws IOException, InvalidFormatException {

		try {
			scriptname = scriptnm;
			int nosteps = exe.get_row_count(filelocation, scriptname) + 1;
			Setup.log.info("\nFor script " + scriptname);
			Setup.testcase = new SoftAssert();
			for (int i = 1; i < nosteps; i++) {
				String action = exe.getexceldata(filelocation, scriptname, i, 1);
				String elementmethod = exe.getexceldata(filelocation, scriptname, i, 2);
				String locator = exe.getexceldata(filelocation, scriptname, i, 3);
				String data = Table.get(exe.getexceldata(filelocation, scriptname, i, 4));
				String data1 = Table.get(exe.getexceldata(filelocation, scriptname, i, 5));
				String locatorValue = rd.read_ObjectRepositoryfile(locator);

				Common c;
				if (filelocation.toLowerCase().contains("login.xlsx")) {
					c = new Login();
					result = c.meth(elementmethod, action, locatorValue, data, data1);
				}

				// else
				// if(filelocation.toLowerCase().contains("administration"))
				// {
				// if(filelocation.toLowerCase().contains("usermanagement"))
				// {
				// c = new buisness.keywords.administration.UserManagement();
				// result = c.meth(elementmethod, action, locatorValue,
				// data,data1);
				// }

				else if (filelocation.toLowerCase().contains("administration")) {
					if (filelocation.toLowerCase().contains("location")) {
						c = new buisness.keywords.administration.Location();
						result = c.meth(elementmethod, action, locatorValue, data, data1);
					}

					else if (filelocation.toLowerCase().contains("provider")) {
						c = new buisness.keywords.administration.Provider();
						result = c.meth(elementmethod, action, locatorValue, data, data1);
					} else if (filelocation.toLowerCase().contains("practice")) {
						c = new buisness.keywords.administration.Practice();
						result = c.meth(elementmethod, action, locatorValue, data, data1);
					}

					else if (filelocation.toLowerCase().contains("groupmanagement")) {
						c = new buisness.keywords.administration.GroupManagement();
						result = c.meth(elementmethod, action, locatorValue, data, data1);
					} else if (filelocation.toLowerCase().contains("authorization")) {
						c = new buisness.keywords.administration.Practice();
						result = c.meth(elementmethod, action, locatorValue, data, data1);
					}
				} else if (filelocation.toLowerCase().contains("gpro")) {
					c = new buisness.keywords.gprosubmission.Gprosubmission();
					result = c.meth(elementmethod, action, locatorValue, data, data1);
				}

				else if (filelocation.toLowerCase().contains("pqrssubmission")) {
					if (filelocation.toLowerCase().contains("submission")) {
						c = new buisness.keywords.pqrssubmission.Submission();
						result = c.meth(elementmethod, action, locatorValue, data, data1);
					}
				} else if (filelocation.toLowerCase().contains("rpc")) {
					if (filelocation.toLowerCase().contains("map")) {
						c = new buisness.keywords.rpc.map.Map();
						result = c.meth(elementmethod, action, locatorValue, data, data1);
					}
					if (filelocation.toLowerCase().contains("resetpracticekey")) {
						c = new buisness.keywords.rpc.resetpracticekey.ResetPracticeKey();
						result = c.meth(elementmethod, action, locatorValue, data, data1);
					}
				} else if (filelocation.toLowerCase().contains("analytics")) {
					if (filelocation.toLowerCase().contains("myanalytics")) {
						c = new buisness.keywords.analytics.MyAnalytics();
						result = c.meth(elementmethod, action, locatorValue, data, data1);
					}
					if (filelocation.toLowerCase().contains("registrydatadictionary")) {
						c = new buisness.keywords.analytics.RegistryDataDictionary();
						result = c.meth(elementmethod, action, locatorValue, data, data1);
					}
					if (filelocation.toLowerCase().contains("sharedanalytics")) {
						c = new buisness.keywords.analytics.SharedAnalytics();
						result = c.meth(elementmethod, action, locatorValue, data, data1);
					}
				} else if (filelocation.toLowerCase().contains("mips")) {
					if (filelocation.toLowerCase().contains("mipsprovider")) {
						c = new buisness.keywords.mips.MipsProvider();
						result = c.meth(elementmethod, action, locatorValue, data, data1);
					}

				}

				else if (filelocation.toLowerCase().contains("patientoutreach")) {
					if (filelocation.toLowerCase().contains("outreachconfiguration")) {
						c = new buisness.keywords.administration.Location();
						result = c.meth(elementmethod, action, locatorValue, data, data1);
					}
					if (filelocation.toLowerCase().contains("outreachauthorization")) {
						c = new buisness.keywords.administration.Location();
						result = c.meth(elementmethod, action, locatorValue, data, data1);
					}
					if (filelocation.toLowerCase().contains("outreachhistory")) {
						c = new buisness.keywords.administration.Location();
						result = c.meth(elementmethod, action, locatorValue, data, data1);
					}
					if (filelocation.toLowerCase().contains("packagecreation")) {
						c = new buisness.keywords.administration.Location();
						result = c.meth(elementmethod, action, locatorValue, data, data1);
					}
					if (filelocation.toLowerCase().contains("packagesubscription")) {
						c = new buisness.keywords.administration.Location();
						result = c.meth(elementmethod, action, locatorValue, data, data1);
					}
				}

				/*
				 * else
				 * if(filelocation.toLowerCase().contains("forgotpassword")) { c
				 * = new ForgotPassword(); result = c.meth(elementmethod,
				 * action, locatorValue, data,data1); }
				 */

				else if ((filelocation.toLowerCase().contains("dashboard"))) {
					if (filelocation.toLowerCase().contains("provider")) {
						c = new buisness.keywords.dashboard.Provider();
						result = c.meth(elementmethod, action, locatorValue, data, data1);
					}
					if (filelocation.toLowerCase().contains("practice")) {
						c = new buisness.keywords.dashboard.Practice();
						result = c.meth(elementmethod, action, locatorValue, data, data1);
					}
					if (filelocation.toLowerCase().contains("location")) {
						c = new buisness.keywords.dashboard.Location();
						result = c.meth(elementmethod, action, locatorValue, data, data1);
					}

					/*
					 * else if(filelocation.toLowerCase().contains("practice"))
					 * { c = new practice(); result = c.meth(elementmethod,
					 * action, locatorValue,data,data1); }
					 */
				} else if ((filelocation.toLowerCase().contains("pro"))) {
					if (filelocation.toLowerCase().contains("clinicianportal")) {
						c = new buisness.keywords.pro.ClinicianPortal();
						result = c.meth(elementmethod, action, locatorValue, data, data1);
					}

				} else if (filelocation.toLowerCase().contains("Dashboard")) {
					if (filelocation.toLowerCase().contains("PracticeMeasureGrid")) {
						c = new buisness.keywords.dashboard.Practice();
						result = c.meth(elementmethod, action, locatorValue, data);

					}if (filelocation.toLowerCase().contains("Provider")) {
						c = new buisness.keywords.dashboard.Provider();
						result = c.meth(elementmethod, action, locatorValue, data);

					}
				}

				/*
				 * else if(filelocation.toLowerCase().contains("Location")) { c
				 * = new Location(); result = c.meth(elementmethod, action,
				 * locatorValue); }
				 * 
				 * 
				 * 
				 * }
				 */
				/*
				 * else if(filelocation.toLowerCase().contains("submission")) {
				 * c = new Submission(); result = c.meth(elementmethod, action,
				 * locatorValue); } /* else
				 * if(filelocation.toLowerCase().contains("administartion")) {
				 * if(filelocation.toLowerCase().contains("usermanagement")) { c
				 * = new Action_Administration_UserManagement(); result =
				 * c.meth(elementmethod, action, locatorValue, data,data1); }
				 * else if(filelocation.toLowerCase().contains("practice")) { c
				 * = new Action_Administration_Practice(); result =
				 * c.meth(elementmethod, action, locatorValue, data,data1); } }
				 */

				else {
					String errormsg = "No action class found for keywords in TestExecutor";
					System.err.println(errormsg);
					Setup.log.error(errormsg);
					break;
				}

				SS.captureStep(scriptname, i, action, result);
				if (result.contains("Fail")) {
					System.err.println(
							"Step " + i + "\tAction: " + action + "\tLocator: " + locator + "\tStatus: " + result);
					System.err.flush();
					Setup.log.error(
							"Step " + i + "\tAction: " + action + "\tLocator: " + locator + "\tStatus: " + result);
					String POF = exe.getexceldata(filelocation, scriptname, i, 6).toLowerCase();
					if (POF.equalsIgnoreCase("n")) {
						System.out.println("Step " + i + " failed!! Not allowed for proceed further");
						Assert.fail("Step " + i + "\tAction: " + action + "\tStatus: " + result);
						return;
					} else if (POF.contains("onfailgotostep")) {
						int jumpStep = Integer.parseInt(POF.replaceAll("[^\\d]", ""));
						System.out.println("Step Failed juming to step: " + jumpStep--);
						i = jumpStep;
					} else
						System.out.println("Step " + i + " failed!! Allowed for proceed further");
				} else if (result.equalsIgnoreCase("Pass Not Allowed to Proceed")) {
					System.out.println("Step " + i + " Passed!! Not allowed for proceed further");
					return;
				} else {
					System.out.println(
							"Step " + i + "\tAction: " + action + "\tLocator: " + locator + "\tStatus: " + result);
					//Setup.log.info("Step " + i + "\tAction: " + action + "\tStatus: " + result);
				}
			}
		} catch (Exception e) {
			System.out.println("error: " + e);
			e.printStackTrace();
			Setup.log.fatal(e.toString());
		}
		ScreenshotManager.sequence = 1;
		System.out.println("");
		for (int i = 0; i < 100; i++)
			System.out.print("*");

	}
}
