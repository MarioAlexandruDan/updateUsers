package ro.internship.services;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import ro.internship.classes.User;
import ro.internship.storage.DataStorage;
import static org.junit.Assert.*;

import org.junit.Test;

public class UpdateJSONUserTest {

	@Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	// {"birthday":"1993-07-20","firstName":"Sally", "lastName":"Jackson","id":"0000000000000001"}
	@Test
	public void test() throws IOException, ParseException {
		FileProcessor test = new FileProcessor();
		LocalDate date = LocalDate.of(2001, Month.APRIL, 12);
		User tempUser = new User("0000000000000001", "John", "Doe", date);
		User userToUpdate = new User("0000000000000001", "Jane", "Doe", date);
		
		Map<String, String> m = new LinkedHashMap<String, String>(4);
		m.put("firstName", tempUser.getFirstName());
		m.put("lastName", tempUser.getLastName());
		m.put("birthday", tempUser.getBirthday().toString());
		m.put("id", tempUser.getId());

		JSONArray arr = new JSONArray();
		arr.add(m);
		
		JSONObject obj = new JSONObject();
		obj.put("USERS", arr);
		
		PrintWriter pw = new PrintWriter("TestingUsers.json");
		pw.write(obj.toJSONString());

		pw.flush();
		pw.close();
		
		File jsonFile = new File("TestingUsers.json");
		
		test.updateJSONUser("0000000000000001", jsonFile, userToUpdate);
		
//		assertEquals(userToUpdate.getBirthday(), tempUser.getBirthday());
//		assertEquals(userToUpdate.getFirstName(), tempUser.getFirstName());
//		assertEquals(userToUpdate.getLastName(), tempUser.getLastName());
	}

}
