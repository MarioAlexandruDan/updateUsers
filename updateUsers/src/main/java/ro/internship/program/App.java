package ro.internship.program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import ro.internship.storage.DataStorage;
import ro.internship.classes.*;
import ro.internship.services.*;

public class App {

	private static int count = 1;
	
	private static Map<Integer, User> usersToUpdate = Utils.generateUsers();

	private static ArrayList<String> randomIds = DataStorage.getRandomIds();

	private volatile static int id = 0;

	private volatile static int updateId = 0;

	// getters used for the ids;
	public synchronized static Map<Integer, User> getUsersToUpdate() {
		
		return usersToUpdate;
	}

	public synchronized static int getNextCount() {
		
		return count++;
	}
	
	public synchronized static ArrayList<String> getRandomIds() {
		
		return randomIds;
	}
	
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

	public synchronized static int getId() {

		return id;
	}

	public static void main(String[] args) throws InterruptedException {

		for (int i = 0; i < 10; i++) {
			usersToUpdate.get(i).setId(randomIds.get(i).toString());
		}
		
		while (id < 100) {
			
			Thread t1 = new Thread(new ThreadReader(count), "ATypeThread1");
			t1.start();

			Thread t2 = new Thread(new ThreadReader(count), "ATypeThread2");
			t2.start();
			
			Thread t3 = new Thread(new ThreadReader(count), "ATypeThread3");
			t3.start();
			
			Thread t4 = new Thread(new ThreadReader(count), "ATypeThread4");
			t4.start();

			Thread t5 = new Thread(new ThreadReader(count), "ATypeThread5");
			t5.start();
			
			Thread t6 = new Thread(new ThreadReader(count), "ATypeThread6");
			t6.start();

			Thread t7 = new Thread(new ThreadReader(count), "ATypeThread7");
			t7.start();
			
			Thread t8 = new Thread(new ThreadReader(count), "ATypeThread8");
			t8.start();
			
			Thread t9 = new Thread(new ThreadReader(count), "ATypeThread9");
			t9.start();

			Thread t10 = new Thread(new ThreadReader(count), "ATypeThread10");
			t10.start();
		}

//		System.out.println(DataStorage.getUserStorage().toString());
//		System.out.println(Arrays.toString(randomIds.toArray()));
	}
}