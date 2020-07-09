package ro.internship;

import java.io.IOException;

import ro.management.classes.User;
import ro.management.services.FileProcessor;
import ro.management.services.Utils;
import ro.management.storage.UserStorage;

public class App {

	private static volatile int id = 0;

	public static synchronized int getId() {

		return id;
	}

	public static synchronized void incId() {

		id++;
	}

	public static void main(String[] args) throws IOException {

		// runs the app until every user is written to the file;
		while (true) {

			// gets a user from the main users collection;
			User tempUser = Utils.generateUsers(id + 1).get(id);

			// add user to in memory database
			UserStorage.setRecord(tempUser);

			System.out.println("Start Writing user " + tempUser.toString());

			// save at the end
			FileProcessor.writeStringToFile(UserStorage.getStorageAsString(), FileProcessor.getJsonFile());

			if (UserStorage.size() == 100)
				break;
			else
				incId();
		}

		System.out.println("DB: " + UserStorage.getStorageAsString());

	}
}
