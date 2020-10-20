package ro.management.storage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ro.management.classes.User;
import ro.management.program.App;
import ro.management.services.FileProcessor;
import ro.management.services.Utils;

public class UserStorage {

	final static Logger logger = LogManager.getLogger(App.class);

	private static volatile Map<String, User> userStorage = new HashMap<String, User>();

	public static Map<String, User> getUserStorage() {
		
		logger.debug("Returning the map of users (userStorage): " + userStorage);
		return userStorage;
	}

	public static User getRecord(Integer userId) {

		return userStorage.get(Utils.formatId(userId));
	}

	public static void setRecord(User user) {

		userStorage.put(Utils.formatId(user.getId()), user);
	}

	public static String getStorageAsString() {

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			
			return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userStorage);

		} catch (JsonProcessingException e) {
			
			logger.error("ERROR IN WRITING USERS TO FILE");
			e.printStackTrace();
		}

		return null;
	}

	public static int size() {
		return userStorage.size();
	}

	public static void saveStorage() {

		FileProcessor.writeStringToFile(getStorageAsString(), FileProcessor.getJsonFile());
	}

	public static void loadStorage() {

		String fileContent = FileProcessor.readStringFromFile(FileProcessor.getJsonFileName());

		ObjectMapper objectMapper = new ObjectMapper();
		try {

			userStorage = objectMapper.readValue(fileContent, new TypeReference<Map<String, User>>() {
			});

		} catch (IOException e) {
			
			logger.error("PROBLEM WITH CONVERSION FROM FILE CONTENT TO MY MAP");
			e.printStackTrace();
			System.out.println("PROBLEM WITH CONVERSION FROM FILE CONTENT TO MY MAP");
		}
	}

	@SuppressWarnings("unused")
	private static void printMap(String idToFind) {

		Iterator<Entry<String, User>> it = userStorage.entrySet().iterator();

		while (it.hasNext()) {

			Map.Entry<String, User> pair = it.next();
			System.out.println(pair.getKey() + " = " + pair.getValue().toString());
		}
	}
}
