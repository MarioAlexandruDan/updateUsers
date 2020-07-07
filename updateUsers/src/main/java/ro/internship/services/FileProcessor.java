package ro.internship.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import ro.internship.program.App;
import ro.internship.storage.DataStorage;
import ro.intrenship.classes.User;

public class FileProcessor {

	// function for reading data from the JSON file;
	public static synchronized void readFromJSON(int id, File file, ArrayList<String> idList) throws IOException, ParseException {
		try {
		    ObjectMapper objectMapper = new ObjectMapper();
		    
		    JsonNode node = objectMapper.readTree(DataStorage.getJsonFile());
		    
		    System.out.println(node.get(idList.get(id)).get("id"));

		    
		    
//		    InputStream fileInputStream = new FileInputStream(DataStorage.getJsonFile());
//		    User user = objectMapper.readValue(fileInputStream, User.class);
//		    fileInputStream.close();
		    
		    
		} catch(Exception e) {
			System.out.println("oh god please no: " + e.getMessage());
		}
	    

	}
	
	// function for updating 10 random users and writing them back in the JSON file;
	@SuppressWarnings("unchecked")
	public static synchronized void updateJSONUser(String id, File file, User userToUpdate) throws FileNotFoundException, IOException, ParseException {
		
//	    ObjectMapper objectMapper = new ObjectMapper();
		
		Object obj = new JSONParser().parse(new FileReader(file));

		JSONObject jo = (JSONObject) obj;
		
		JSONArray ja = (JSONArray) jo.get("USERS");
		
		JSONObject jsonUser = (JSONObject) ja.get(App.getId());	
		
		if (jsonUser.get("id").equals(id)) {
			jsonUser.put("firstName", userToUpdate.getFirstName());
			jsonUser.put("lastName", userToUpdate.getLastName());
			jsonUser.put("birthday", userToUpdate.getBirthday().toString());
				
			App.incrementUpdateId();
			@SuppressWarnings("resource")
			FileWriter fileW = new FileWriter(file);
	        fileW.write(jo.toJSONString());
	        fileW.flush();
		}
	}
}
