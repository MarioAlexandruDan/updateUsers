package ro.internship.storage;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import ro.internship.services.*;
import ro.intrenship.classes.*;

public class DataStorage {

	private static Map<Integer, User> users = new HashMap<Integer, User>(Utils.generateUsers());

	private static JSONObject jo = new JSONObject();

	private static ArrayList<String> randomIds = new ArrayList<String>(Utils.generateRandomIds());

	private static File jsonFile = new File("./../UsersDB.json");
	
	private static JSONArray ja = new JSONArray();

	private static ArrayList<String> formatedIds = new ArrayList<String>(Utils.generateFormatedIds());
	
	private static volatile Map<String, User> userStorage = new HashMap<String, User>();
	
	public static ArrayList<String> getFormatedIds() {
		return formatedIds;
	}
	
	public static Map<Integer, User> getUsers() {

		return users;
	}
	
	public static Map<String, User> getUserStorage() {
		
		return userStorage;
	}

	public static ArrayList<String> getRandomIds() {

		return randomIds;
	}
	
	public static File getJsonFile() {
		
		return jsonFile;
	}
	
	public static void setJsonFile(File file) {
		jsonFile = file;
	}
	
	// returns primary JSON object in which we upload the JSON array;
	public static JSONObject getJSONObject() {
		return jo;
	}
	
	// returns the JSON array that's used for loading users to the JSON file;
	public static JSONArray getJSONArray() {
		return ja;
	}
}
