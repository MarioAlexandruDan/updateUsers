package ro.internship.program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import ro.intrenship.classes.*;
import ro.internship.storage.DataStorage;
import ro.internship.services.*;

public class App {

	private volatile static int id = 0;

	private volatile static int updateId = 0;
	
	// Getters pentru a returna id-ul incrementat
	public synchronized static int getNextId() {

		return id++;
	}
	
	public synchronized static int getNextUpdateId() {
		
		return id++;
	}

	// Getters pentru a returna id-ul;
	public synchronized static int getId() {

		return id;
	}

	public static void main(String[] args) throws InterruptedException {

		Map<Integer, User> usersToUpdate = Utils.generateUsers();

		ArrayList<String> randomIds = DataStorage.getRandomIds();

		for (int i = 0; i < 10; i++) {
			usersToUpdate.get(i).setId(randomIds.get(i).toString());
		}

		System.out.println(Arrays.toString(randomIds.toArray()));
		for (int i = 0; i < 10; i++) {
			usersToUpdate.get(i).getData();
		}
		
		while(id < 100) {
//			System.out.println(id);
			Thread t1 = new Thread(new ThreadReader(), "ATypeThread1");
			t1.start();
			t1.join();
		}
	}
}