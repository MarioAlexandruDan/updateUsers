package ro.internship.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import ro.internship.classes.User;
import ro.internship.program.App;
import ro.internship.storage.DataStorage;

public class FileProcessor {

	// function for reading data from the JSON file;
	public static synchronized void readFromJSON(int id, File file, int count, User userToUpdate) throws IOException, ParseException {
		try {
		    ObjectMapper objectMapper = new ObjectMapper();
		    JsonNode usr = objectMapper.readTree(DataStorage.getJsonFile()).get(DataStorage.getFormatedIds().get(id));
		    
//		    JsonNode node = objectMapper.readTree(DataStorage.getJsonFile());
		    
		    String month = null;
		    DateFormatSymbols dfs = new DateFormatSymbols();
		    String[] months = dfs.getMonths();
		    int m = Integer.parseInt(usr.get("birthday").get("monthValue").toString());
		    if (m >= 1 && m <= 12 ) {
		        month = months[m-1];
		    }
		    month = month.toUpperCase();
		    
		    User jsonUser = new User(usr.get("id").toString(), usr.get("firstName").toString(), usr.get("lastName").toString(), LocalDate.of(Integer.parseInt(usr.get("birthday").get("year").toString()), Month.valueOf(month), Integer.parseInt(usr.get("birthday").get("dayOfMonth").toString())));
		    jsonUser.setId(jsonUser.getId().replaceAll("\"", ""));
		    DataStorage.getUserStorage().put(jsonUser.getId(), jsonUser);
		    
		    if(jsonUser.getId().equals(App.getRandomIds().get(App.getUpdateId()).toString())) {
                System.out.println("merge");
                jsonUser.setFirstName(userToUpdate.getFirstName());
                jsonUser.setLastName(userToUpdate.getLastName());
                jsonUser.setBirthday(userToUpdate.getBirthday());
    		    App.incrementUpdateId();
            }
		    System.out.println(jsonUser.toString());
		    
		} catch(Exception e) {
			e.getStackTrace();
		}
	}
	/*
	// function for updating 10 random users and writing them back in the JSON file;
	public static synchronized void updateJSONUser(String id, File file, User userToUpdate) throws FileNotFoundException, IOException, ParseException {
		
		ObjectMapper objectMapper = new ObjectMapper();
	    
//	    JsonNode node = objectMapper.readTree(DataStorage.getJsonFile());
	    JsonNode usr = objectMapper.readTree(DataStorage.getJsonFile()).get(DataStorage.getFormatedIds().get(Integer.parseInt(id)));
	    
	    String month = "";
	    DateFormatSymbols dfs = new DateFormatSymbols();
	    String[] months = dfs.getMonths();
	    int m = Integer.parseInt(usr.get("birthday").get("monthValue").toString());
	    if (m >= 1 && m <= 12 ) {
	        month = months[m-1];
	    }
	    month = month.toUpperCase();
	    
	    User jsonUser = new User(usr.get("id").toString(), usr.get("firstName").toString(), usr.get("lastName").toString(), LocalDate.of(Integer.parseInt(usr.get("birthday").get("year").toString()), Month.valueOf(month), Integer.parseInt(usr.get("birthday").get("dayOfMonth").toString())));
	    jsonUser.setId(jsonUser.getId().replaceAll("\"", ""));
		
//	    User tempUser = new User(jsonUser.getId(), jsonUser.getFirstName(), jsonUser.getLastName(), jsonUser.getBirthday());
	    
	    if (Integer.parseInt(jsonUser.getId()) == Integer.parseInt(id)) {
	    	
	    	jsonUser.setBirthday(userToUpdate.getBirthday());
	    	jsonUser.setFirstName(userToUpdate.getFirstName());
	    	jsonUser.setLastName(userToUpdate.getLastName());
	    	System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" + jsonUser.toString());

	    	App.incrementUpdateId();
			@SuppressWarnings("resource")
			FileWriter fileW = new FileWriter(file);
	    	DataStorage.getUserStorage().replace(jsonUser.getId(), jsonUser);
			fileW.write(objectMapper.writeValueAsString(DataStorage.getUserStorage()));
	        fileW.flush();
	        
		}

//	    System.out.println(usr.get("id").toString());
//	    System.out.println(Month.valueOf(usr.get("birthday").get("month").toString()));
	} */
}
