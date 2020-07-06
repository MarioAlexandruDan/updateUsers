package ro.internship.storage;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import ro.internship.Utils.Utils;
import ro.internship.classes.User;

public class DataStorage {

	private static Map<Integer, User> users = new HashMap<Integer, User>(Utils.generateUsers());
	
	private static JSONObject jo = new JSONObject();
	
	private static JSONArray ja = new JSONArray();
	
	private static File jsonFile = new File("./../UsersDB.json");
	
	public static Map<Integer, User> getUsers() {
		return users;
	}
	
	// returns primary JSON object in which we upload the JSON array;
	public static JSONObject getJSONObject() {
		return jo;
	}
	
	// returns the JSON array that's used for loading users to the JSON file;
	public static JSONArray getJSONArray() {
		return ja;
	}
	
	// returns the directory of the JSON file;
	public static File getJSONFile() {
		return jsonFile;
	}
}