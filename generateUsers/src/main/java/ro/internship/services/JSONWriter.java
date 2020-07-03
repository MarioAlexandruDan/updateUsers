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

//		String localId = String.format("%016d", Problema.getNextWriterId());
		
		User tempUser = DataStorage.getUsers().get(App.getNextId());
		
		Map<String, String> m = new LinkedHashMap<String, String>(4);
		m.put("firstName", tempUser.getFirstName());
		m.put("lastName", tempUser.getLastName());
		m.put("birthday", tempUser.getBirthday().toString());
		m.put("id", tempUser.getId());

		DataStorage.getJSONArray().add(m);
		
		DataStorage.getJSONObject().put("USERS", DataStorage.getJSONArray());
		
		PrintWriter pw = new PrintWriter(DataStorage.getJSONFile());
		pw.write(DataStorage.getJSONObject().toJSONString());

		pw.flush();
		pw.close();
	}

	
}
