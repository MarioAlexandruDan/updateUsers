package ro.internship.services;

import ro.internship.program.App;
import ro.internship.storage.DataStorage;

public class ThreadReader extends FileProcessor implements Runnable {

	public void run() {

		try {
			readFromJSON(App.getNextId(), DataStorage.getJsonFile());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
