package ro.internship.services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import ro.internship.program.App;
import ro.internship.storage.*;

public class FileProcessor {

	public static synchronized void readFromJSON(int id) throws IOException, ParseException {
		Object obj = new JSONParser().parse(new FileReader("./../UsersDB.json"));

		JSONObject jo = (JSONObject) obj;
		
		JSONArray ja = (JSONArray) jo.get("USERS");
		
		JSONObject jsonUser = (JSONObject) ja.get(id);
		
//		jsonUser.put("firstName", "Andrei");
//		jsonUser.put("lastName", "Andrei");
		
		System.out.println(jsonUser.toJSONString());
	}
	
	public static synchronized void updateJSONUser(String id) throws FileNotFoundException, IOException, ParseException {
		Object obj = new JSONParser().parse(new FileReader("./../UsersDB.json"));

		JSONObject jo = (JSONObject) obj;
		
		JSONArray ja = (JSONArray) jo.get("USERS");
		
		JSONObject jsonUser = (JSONObject) ja.get(App.getNextUpdateId());
		
		if (id.equals(jsonUser.get("id"))) {
			jsonUser.put("firstName", "Andrei");
			jsonUser.put("lastName", "Andrei");
			
		}
	}
	
}
