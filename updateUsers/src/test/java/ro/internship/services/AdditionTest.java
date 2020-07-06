package ro.internship.services;

import static org.junit.Assert.*;

import org.junit.Test;

public class AdditionTest {

	@Test
	public void test() {
		Utils test = new Utils();
		
		int result = test.addTwoNums(1, 2);
		assertEquals(3, result);
		
		result = test.addTwoNums(0, 26);
		assertEquals(26, result);
		
		result = test.addTwoNums(-12, 12);
		assertEquals(0, result);
		
	}

}
