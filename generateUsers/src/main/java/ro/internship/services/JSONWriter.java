package ro.internship.services;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import ro.internship.App;
import ro.internship.classes.User;
import ro.internship.storage.DataStorage;

public class JSONWriter {
	
	public static void writeToJSON() throws FileNotFoundException{
		
		// gets a user from the main users collection;
		User tempUser = DataStorage.getUsers().get(App.getNextId());

		// puts a user's data in a map;
		Map<String, String> m = new LinkedHashMap<String, String>(4);
		m.put("firstName", tempUser.getFirstName());
		m.put("lastName", tempUser.getLastName());
		m.put("birthday", tempUser.getBirthday().toString());
		m.put("id", tempUser.getId());

		// puts the map in the JSON array;
		DataStorage.getJSONArray().add(m);
		
		// uploads the JSON array into the main JSON object;
		DataStorage.getJSONObject().put("USERS", DataStorage.getJSONArray());
		
		// actually printing to the file;
		PrintWriter pw = new PrintWriter(DataStorage.getJSONFile());
		pw.write(DataStorage.getJSONObject().toJSONString());

		pw.flush();
		pw.close();
	}

	
}
