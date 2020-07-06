package ro.internship.storage;

import java.util.ArrayList;
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

	private static JSONObject jo = new JSONObject();

	private static ArrayList<String> randomIds = new ArrayList<String>(Utils.generateRandomIds());

	private static JSONArray ja = new JSONArray();

	public static Map<Integer, User> getUsers() {

		return users;
	}

	public static String getUserById(int id) {

		return users.get(id).getId();
	}

	public static ArrayList<String> getRandomIds() {

		return randomIds;
	}
	
	public static JSONObject getJSONObject() {
		return jo;
	}
	
	public static JSONArray getJSONArray() {
		return ja;
	}
}
