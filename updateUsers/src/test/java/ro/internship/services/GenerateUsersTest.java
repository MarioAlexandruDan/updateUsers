package ro.internship.services;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import ro.intrenship.classes.User;

public class GenerateUsersTest {

	@Test
	public void test() {

		Utils test = new Utils();
		
		Map<Integer, User> users = test.generateUsers();
		
		if (users.isEmpty()) {
			fail("Your Map doesn't contain any users");
		}
		
		if (users.size() != 10) {
			fail("You should have exactly 10 users");
		}
		
	}

}
