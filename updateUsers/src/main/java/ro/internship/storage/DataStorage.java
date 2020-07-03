package ro.internship.storage;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import ro.internship.services.*;
import ro.intrenship.classes.*;

public class DataStorage {

	private static Map<Integer, User> users = new HashMap<Integer, User>(Utils.generateUsers());

//	private static JSONObject jo = new JSONObject();

	private static Set<String> randomIds = new TreeSet<String>(Utils.generateRandomIds());

//	private static JSONArray ja = new JSONArray();

	public static Map<Integer, User> getUsers() {

		return users;
	}

	public static String getUserById(int id) {

		return users.get(id).getId();
	}

	public static Set<String> getRandomIds() {

		return randomIds;
	}
	
//	public static JSONObject getJSONObject() {
//		return jo;
//	}
//	
//	public static JSONArray getJSONArray() {
//		return ja;
//	}
}
