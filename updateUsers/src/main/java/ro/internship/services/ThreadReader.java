package ro.internship.services;

import ro.internship.program.App;

public class ThreadReader extends FileProcessor implements Runnable {

	public void run() {

		try {
			readFromJSON(App.getNextId());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
