
package buisness.managers;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import configuration.Setup;

public class EmailManager {

	private final String host;
	private String from;
	private String to;
	private String subject;
	private String cc;

	public EmailManager() {
		ConfigurationManager cm = new ConfigurationManager();
		from = cm.read_Configfile("from");
		subject = cm.read_Configfile("subject");
		to = cm.read_Configfile("to");
		cc = cm.read_Configfile("cc");
		host = "192.168.105.10"; 
	}

	private Properties initializeProperties() {
		Properties props = new Properties();
		props.put("mail.smtp.host", "192.168.105.10");
		props.put("mail.smtp.port", "25");
		return props;
	}

	private Session createSession() {

		return Session.getInstance(initializeProperties());
	}

	private Message createMessage() {
		return new MimeMessage(createSession());
	}

	public boolean sendMail(String emailContent) {
		Message message = createMessage();
		try {

			try {
				message.setFrom(new InternetAddress(from));
			} catch (AddressException e) {
				Setup.log.error("Please verify the from address in Application config");
			}

			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));

			// Set Subject: header field
			message.setSubject(subject);

			// Create the message part
			BodyPart messageBodyPart = new MimeBodyPart();
			// Now set the actual message
			// messageBodyPart.setText(emailContent);
			messageBodyPart.setContent(emailContent, "text/html");
			// Create a multipar message
			Multipart multipart = new MimeMultipart();
			// Set text message part
			multipart.addBodyPart(messageBodyPart);

			// Part two is attachment
			messageBodyPart = new MimeBodyPart();
			Thread.sleep(60000);
			String filename = System.getProperty("user.dir")
					+ "\\test-output\\TestAutomationReports\\ReportForAAO.xlsx";
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName("ReportForAAO.xlsx");
			// messageBodyPart.setFileName("AAODemoExcel Report.xlsx");
			multipart.addBodyPart(messageBodyPart);

			// Part three is attachment
			messageBodyPart = new MimeBodyPart();

			String filenametext = System.getProperty("user.dir")
					+ "\\test-output\\CustomReportForAAO.html";

			DataSource source1 = new FileDataSource(filenametext);
			messageBodyPart.setDataHandler(new DataHandler(source1));
			messageBodyPart.setFileName("CustomReportForAAO.html");
			multipart.addBodyPart(messageBodyPart);

			// Send the complete message parts
			message.setContent(multipart);
			Transport.send(message);
			System.out.println("Email along with test execution reports has been sent to recipients. ");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		} catch (InterruptedException Int) {
			Setup.log.debug("Exception in thread.sleep");
		}
		return false;
	}

	public boolean sendMail(String to, String cc, String subject, String emailContent) {
		this.to = to;
		this.cc = cc;
		this.subject = subject;
		return sendMail(emailContent);
	}
}
