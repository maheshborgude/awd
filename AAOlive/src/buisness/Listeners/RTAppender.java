package buisness.Listeners;

import java.io.IOException;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;
import com.figmd.local.rt.RTTicketCreator;

public class RTAppender extends ConsoleAppender{


	public RTAppender() {
		super.name = "RT Appender";
	}

	@Override
	public void append(LoggingEvent event) {
		super.append(event);
		if(event.getLevel()==Level.ERROR||
				event.getLevel()==Level.FATAL || event.getLevel()==Level.WARN)
			try {
				String message = "\nLevel: " + event.getLevel();
				message = message + "\nDate and Time:" + event.getTimeStamp();
				message = message + "\nException:\n";
				message = message + (String) event.getMessage();
				RTTicketCreator.create("IRIS - " + event.getLevel(), message);
			} catch (IOException e) { //IGNORE	
				
			}
	}

	
}
