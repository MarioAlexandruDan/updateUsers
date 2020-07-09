package ro.management.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ro.management.classes.User;

class UtilsTest {

	// creating the needed fields;
	Integer id;
	String formatedId;
	int totalUsersToGenerate;
	List<User> users = new ArrayList<User>();
	int start;
	int end;
	Utils test;
	String birthday;
	
	// initializing every field before every test;
	@BeforeEach
	public void initFields() {
		
		birthday = "";
		test = new Utils();
		id = 12;
		totalUsersToGenerate = 123;
		start = 1;
		end = 100;
		formatedId = "0000000000000012";
	}
	
	// testing out the randomBirthday method to check if it returns the same type of object (String);
	@SuppressWarnings("static-access")
	@Test
	void testRandomBirthday() {
		
		String output = test.randomBirthday();
		assertEquals(birthday.getClass(), output.getClass());
	}

	// testing the randBetween function to check if it returns a number between the start and end numbers;
	@SuppressWarnings("static-access")
	@Test
	void testRandBetween() {
		
		int output = test.randBetween(start, end);
		
		if (output < start) {
			fail("Your output should be higher than " + start);
		}
		if (output > end) {
			fail("Your output should be lower than " + end);
		}
		
	}

	// testing the generateUsers method to check if it has the required size;
	@SuppressWarnings("static-access")
	@Test
	void testGenerateUsers() {
		
		users = test.generateUsers(totalUsersToGenerate);
		int output = users.size();
		
		assertEquals(totalUsersToGenerate, output);
	}
	
	// testing the formatId method to check if it returns the number in the correct format;
	@SuppressWarnings("static-access")
	@Test
	void testFormatId() {
		
		String output = test.formatId(id).toString();
		assertEquals(formatedId, output);
	}

}
