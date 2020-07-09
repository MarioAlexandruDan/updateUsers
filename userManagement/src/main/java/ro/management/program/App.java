package ro.management.program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ro.management.services.Utils;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		final Logger logger = LogManager.getLogger(App.class);

		logger.debug("Implemented log4j");
		System.out.println("IMPLEMENTED USERMANAGEMENT JAR FILE");
		logger.debug("Implemented log4j again");
	}
}
