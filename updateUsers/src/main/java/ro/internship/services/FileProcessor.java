package ro.internship.services;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import ro.internship.storage.*;

public class FileProcessor {

	public static void readFromJSON(int id) throws IOException, ParseException {
		Object obj = new JSONParser().parse(new FileReader("./../UsersDB.json"));

		JSONObject jo = (JSONObject) obj;
		
		System.out.println(DataStorage.getJSONObject().get(DataStorage.getUserById(id)));
	}
	
}
