package ro.management.services;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileProcessorTest {

	FileProcessor test;
	File myFile;
	PrintWriter pw;
	String textToWrite;
	Scanner sc;

	@BeforeEach
	void initFields() throws FileNotFoundException {
		test = new FileProcessor();
		myFile = new File("testFile.json");
		textToWrite = "$test###";

		sc = new Scanner(myFile);

		try {
			pw = new PrintWriter(myFile);	
		} catch (Exception e) {
			fail("PROBLEM WITH CREATING THE PRINT WRITER");
			e.printStackTrace();
		}
	}

	@SuppressWarnings("static-access")
	@Test
	void testWriteStringToFile() {
		test.writeStringToFile(textToWrite, myFile);
		String output = null;
		while (sc.hasNextLine()) {
			output = sc.nextLine();
		}

		assertEquals(textToWrite, output);

	}

	@Test
	void testReadStringFromFile() {

	}

}
