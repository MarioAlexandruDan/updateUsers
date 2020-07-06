package ro.internship.services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
		
		JSONObject jsonUser = (JSONObject) ja.get(App.getId());
		
//		System.out.println(jsonUser);
		
		if (jsonUser.get("id").equals(id)) {
			
			System.out.println("================");
			App.getUsersToUpdate().get(Integer.parseInt(id)).getData();
			System.out.println("================");
			
			jsonUser.put("firstName", App.getUsersToUpdate().get(Integer.parseInt(id)).getFirstName());
			jsonUser.put("lastName", App.getUsersToUpdate().get(Integer.parseInt(id)).getLastName());
			jsonUser.put("birthday", App.getUsersToUpdate().get(Integer.parseInt(id)).getBirthday().toString());

			System.out.println(jsonUser.toJSONString());
			System.out.println("yeet");
			App.incrementUpdateId();
			
	        FileWriter file = new FileWriter("./../UsersDB.json");
	        file.write(jo.toJSONString());
	        file.flush();
			
			
			
		}

//		System.out.println(jsonUser.get("id") + " ======== " + id);
	
	}
	
}
