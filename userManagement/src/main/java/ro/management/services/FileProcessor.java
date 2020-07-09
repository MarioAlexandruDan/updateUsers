package ro.management.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileProcessor {
	
	private static File jsonFile = new File("./../UsersDB.json");
	private static String jsonFileName = "./../UsersDB.json";
	
	public static File getJsonFile() {

		return jsonFile;
	}

	public static String getJsonFileName() {
		
		return jsonFileName;
	}
	
	public static void writeStringToFile(String textToWrite, File myFile) {

		PrintWriter pw;
		try {

			pw = new PrintWriter(myFile);
			pw.write(textToWrite);

			pw.flush();
			pw.close();

		} catch (FileNotFoundException e) {

			System.out.println("PROBLEM WITH FILE");
			e.printStackTrace();
		}
	}

	public static String readStringFromFile(String fileName) {

		StringBuilder contentBuilder = new StringBuilder();

		try (Stream<String> stream = Files.lines(Paths.get(fileName), StandardCharsets.UTF_8)) {
			stream.forEach(s -> contentBuilder.append(s).append("\n"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return contentBuilder.toString();
	}
}
