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
	
	public static JSONObject getJSONObject() {
		return jo;
	}
	
	public static JSONArray getJSONArray() {
		return ja;
	}
	
	public static String getUserById(int id) {
		return users.get(id).getId();
	}
	
	public static File getJSONFile() {
		return jsonFile;
	}
}