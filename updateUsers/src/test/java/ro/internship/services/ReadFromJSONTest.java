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
import ro.intrenship.classes.User;

import ro.internship.storage.DataStorage;

public class ReadFromJSONTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	// {"birthday":"1993-07-20","firstName":"Sally", "lastName":"Jackson","id":"0000000000000001"}
	@Test
	public void test() throws IOException, ParseException {
		FileProcessor test = new FileProcessor();
		LocalDate date = LocalDate.of(2001, Month.APRIL, 12);
		User tempUser = new User("0000000000000001", "John", "Doe", date);
		
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
		
		test.readFromJSON(0, jsonFile);
		
		assertEquals("{\"birthday\":\""+ tempUser.getBirthday() +"\",\"firstName\":\"" + tempUser.getFirstName() +"\",\"lastName\":\"" + tempUser.getLastName() + "\",\"id\":\"" + tempUser.getId() + "\"}\r\n" + "", systemOutRule.getLog());
	}

}
