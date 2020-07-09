package ro.management.services;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileProcessorTest {

	// creating the needed fields;
	FileProcessor test;
	File myFile;
	PrintWriter pw;
	String textToWrite;
	Scanner sc;
	String myFileName;
	
	// initializing every field before every test;
	@BeforeEach
	void initFields() throws FileNotFoundException {
		
		test = new FileProcessor();
		// creating a new file for testing purposes;
		myFile = new File("testFile.txt");
		
		// getting the name of said file;
		myFileName = "testFile.txt";
		textToWrite = "$test###";
		
		sc = new Scanner(myFile);
		pw = new PrintWriter(myFile);	
	}

	// testing the writeStringToFile method;
	@SuppressWarnings("static-access")
	@Test
	void testWriteStringToFile() {
		test.writeStringToFile(textToWrite, myFile);
		// getting the output from the method;
		String output = null;
		while (sc.hasNextLine()) {
			output = sc.nextLine();
		}
		assertEquals(textToWrite, output);
	}

	// testing the readStringToFile method;
	@SuppressWarnings("static-access")
	@Test
	void testReadStringFromFile() {
		test.writeStringToFile(textToWrite, myFile);
		// getting the output from the method;
		String output = test.readStringFromFile(myFileName).replaceAll("\\s", "");

		assertEquals(textToWrite, output);
	}

}
