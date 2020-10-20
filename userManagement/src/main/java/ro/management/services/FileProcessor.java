package ro.management.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ro.management.program.App;

public class FileProcessor {

	private static File jsonFile = new File("./../UsersDB.json");
	private static String jsonFileName = "./../UsersDB.json";
	private final static Logger logger = LogManager.getLogger(App.class);

	public static File getJsonFile() {
		
		logger.debug("Returning the JSON file: " + jsonFile);
		return jsonFile;
	}

	public static String getJsonFileName() {

		return jsonFileName;
	}

	public static void writeStringToFile(String textToWrite, File myFile) {

		PrintWriter pw;
		try {

			logger.debug("Writing text to file: " + textToWrite);

			pw = new PrintWriter(myFile);
			pw.write(textToWrite);

			pw.flush();
			pw.close();

		} catch (FileNotFoundException e) {

			logger.error("PROBLEM WITH FILE");
			System.out.println("PROBLEM WITH FILE");
			e.printStackTrace();
		}
	}

	public static String readStringFromFile(String fileName) {

		StringBuilder contentBuilder = new StringBuilder();

		try (Stream<String> stream = Files.lines(Paths.get(fileName), StandardCharsets.UTF_8)) {
			logger.debug("Iterating over the contentBuilder");
			stream.forEach(s -> contentBuilder.append(s).append("\n"));
		} catch (IOException e) {
			logger.error("PROBLEM WITH FILE");
			e.printStackTrace();
		}

		return contentBuilder.toString();
	}
}
