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

	private static Map<Integer, User> usersToUpdate = Utils.generateUsers();

	private static ArrayList<String> randomIds = DataStorage.getRandomIds();

	private volatile static int id = 0;

	private volatile static int updateId = 0;

	public synchronized static Map<Integer, User> getUsersToUpdate() {
		
		return usersToUpdate;
	}

	public synchronized static ArrayList<String> getRandomIds() {
		
		return randomIds;
	}
	
	// Getters pentru a returna id-ul incrementat
	public synchronized static int getNextId() {

		return id++;
	}

	public synchronized static int getNextUpdateId() {

		return updateId++;
	}

	public synchronized static void incrementUpdateId() {

		updateId++;
	}

	public synchronized static int getUpdateId() {

		return updateId;
	}

	// Getters pentru a returna id-ul;
	public synchronized static int getId() {

		return id;
	}

	public static void main(String[] args) throws InterruptedException {

		for (int i = 0; i < 10; i++) {
			usersToUpdate.get(i).setId(randomIds.get(i).toString());
		}

		System.out.println(Arrays.toString(randomIds.toArray()));
		for (int i = 0; i < 10; i++) {
			usersToUpdate.get(i).getData();
		}

		while (id < 100) {
//			System.out.println(id);
			Thread t1 = new Thread(new ThreadReader(), "ATypeThread1");
			t1.start();
			t1.join();
			
			Thread t2 = new Thread(new ThreadUpdater(), "BTypeThread1");
			t2.start();
			t2.join();
		}
	}
}