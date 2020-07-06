package ro.internship.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import ro.internship.program.App;
import ro.internship.storage.DataStorage;

public class FileProcessor {

	// function for reading data from the JSON file;
	public static synchronized void readFromJSON(int id, File file) throws IOException, ParseException {
		
		Object obj = new JSONParser().parse(new FileReader(file));

		JSONObject jo = (JSONObject) obj;
		
		JSONArray ja = (JSONArray) jo.get("USERS");
		
		JSONObject jsonUser = (JSONObject) ja.get(id);
				
		System.out.println(jsonUser.toJSONString());
	}
	
	// function for updating 10 random users and writing them back in the JSON file;
	@SuppressWarnings("unchecked")
	public static synchronized void updateJSONUser(String id, File file) throws FileNotFoundException, IOException, ParseException {
		
		Object obj = new JSONParser().parse(new FileReader(file));

		JSONObject jo = (JSONObject) obj;
		
		JSONArray ja = (JSONArray) jo.get("USERS");
		
		JSONObject jsonUser = (JSONObject) ja.get(App.getId());	
		if (jsonUser.get("id").equals(id)) {
			jsonUser.put("firstName", App.getUsersToUpdate().get(App.getUpdateId()).getFirstName());
			jsonUser.put("lastName", App.getUsersToUpdate().get(App.getUpdateId()).getLastName());
			jsonUser.put("birthday", App.getUsersToUpdate().get(App.getUpdateId()).getBirthday().toString());
				
			App.incrementUpdateId();
			@SuppressWarnings("resource")
			FileWriter fileW = new FileWriter(file);
	        fileW.write(jo.toJSONString());
	        fileW.flush();
		}
	}
}
