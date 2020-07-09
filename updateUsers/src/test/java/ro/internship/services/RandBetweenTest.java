package ro.internship.services;

import static org.junit.Assert.*;

import org.junit.Test;

import ro.management.services.Utils;

public class RandBetweenTest {

	@Test
	public void test() {
		Utils test = new Utils();
		
		int minStart = 1956;
		int maxStart = 2002;
		
		int result = test.randBetween(minStart, maxStart);
		
		if (result < minStart) {
			fail("Your number should be at least 1956");
		}
		
		if (result > maxStart) {
			fail("Your number should be at max 2002");
		}
		
	}

}
