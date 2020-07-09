package ro.internship.program;

import ro.internship.services.ThreadUserUpdate;
import ro.management.storage.UserStorage;

public class App {

	public static void main(String[] args) throws InterruptedException {

		// Load storage at app start
		UserStorage.loadStorage();

		// start the game
		Thread t1 = new ThreadUserUpdate(1, 5);
		t1.start();
		Thread t2 = new ThreadUserUpdate(1, 10);
		t2.start();
		Thread t3 = new ThreadUserUpdate(1, 20);
		t3.start();

		Thread.sleep(1000);

		// Save the storage when the app is finished
		UserStorage.saveStorage();
	}
}
