package ro.internship.services;
import static org.junit.Assert.*;

import ro.management.classes.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

public class UserTest {

	// create a test user
	private User testUser;

	// create a null user
	private User nullUser;

	// create a static user with predefined values
	private static User user = new User(14, "Mirel", "Corbu", "1979-05-24", 10);

	// testing the null user constructor
	@Test
	public void nullUserConstructor_test() throws NoSuchFieldException, IllegalAccessException {

		nullUser = new User();
		if (nullUser.getId() != null) {
			fail("Your user should have a null value as id");
		}
		if (nullUser.getFirstName() != null) {
			fail("Your user should have a null value as first name");
		}
		if (nullUser.getLastName() != null) {
			fail("Your user should have a null value as last name");
		}
		if (nullUser.getBirthday() != null) {
			fail("Your user should have a null value as birthday");
		}
		if (nullUser.getTotalAmount() != null) {
			fail("Your user should have a null value as total amount");
		}
	}

	// testing the user constructor
	@Test
	public void userConstructor_test() throws NoSuchFieldException, IllegalAccessException {

		testUser = new User(13, "Marius", "Patrascu", "1985-01-23", 85);
		assertEquals("13", testUser.getId().toString());
		assertEquals("Marius", testUser.getFirstName());
		assertEquals("Patrascu", testUser.getLastName());
		assertEquals("1985-01-23", testUser.getBirthday());
		assertEquals("85", testUser.getTotalAmount().toString());
	}

	// testing the set id method
	@Test
	public void setId_test() throws NoSuchFieldException, IllegalAccessException {

		user.setId(14);
		assertEquals("14", user.getId().toString());
	}

	// testing the get id method
	@Test
	public void getId_test() throws NoSuchFieldException, IllegalAccessException {

		assertEquals("14", user.getId().toString());
	}

	// testing the set first name method
	@Test
	public void setFirstName_test() throws NoSuchFieldException, IllegalAccessException {

		user.setFirstName("Mirel");
		assertEquals("Mirel", user.getFirstName());
	}

	// testing the get first name method
	@Test
	public void getFirstName_test() throws NoSuchFieldException, IllegalAccessException {

		assertEquals("Mirel", user.getFirstName());
	}

	// testing the set last name method
	@Test
	public void setLastName_test() throws NoSuchFieldException, IllegalAccessException {

		user.setLastName("Corbu");
		assertEquals("Corbu", user.getLastName());
	}

	// testing the get last name method
	@Test
	public void getLastName_test() throws NoSuchFieldException, IllegalAccessException {

		assertEquals("Corbu", user.getLastName());
	}

	// testing the set birthday method
	@Test
	public void setBirthday_test() throws NoSuchFieldException, IllegalAccessException {

		user.setBirthday("1979-05-24");
		assertEquals("1979-05-24", user.getBirthday());
	}

	// testing the get birthday method
	@Test
	public void getBirthday_test() throws NoSuchFieldException, IllegalAccessException {

		assertEquals("1979-05-24", user.getBirthday());
	}

	// testing the total amount method
	@Test
	public void setTotalAmount_test() throws NoSuchFieldException, IllegalAccessException {

		user.setTotalAmount(125);
		assertEquals("125", user.getTotalAmount().toString());
	}

	// testing the total amount method
	@Test
	public void getTotalAmount_test() throws NoSuchFieldException, IllegalAccessException {

		assertEquals("125", user.getTotalAmount().toString());
	}

	// testing the to string method
	@Test
	public void toString_test() {

		assertEquals("\"14\":{\"firstName\":\"Mirel\",\"lastName\":\"Corbu\",\"birthday\":1979-05-24,\"count\":125}" + "",
				user.toString());
	}
}
