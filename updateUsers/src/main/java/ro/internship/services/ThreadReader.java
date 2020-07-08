package ro.internship.services;

import ro.internship.program.App;
import ro.internship.storage.DataStorage;

public class ThreadReader extends Thread{
	
	private final int count;
	
	public ThreadReader(int count) {
		this.count = count;
	}

	public void run() {

		try {
			FileProcessor.readFromJSON(App.getNextId(), DataStorage.getJsonFile(), DataStorage.getFormatedIds(), count);
		} catch (Exception e) {
			System.out.println("================== ERROR ==================");
			System.out.println(e.getMessage());
		}
	}

}
