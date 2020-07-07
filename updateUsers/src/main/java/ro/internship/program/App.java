package ro.internship.program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import ro.intrenship.classes.*;
import ro.internship.storage.DataStorage;
import ro.internship.services.*;

public class App {

	private static Map<Integer, User> usersToUpdate = Utils.generateUsers();

	private static ArrayList<String> randomIds = DataStorage.getRandomIds();

	private volatile static int id = 0;

	private volatile static int updateId = 0;

	// getters used for the ids;
	public synchronized static Map<Integer, User> getUsersToUpdate() {
		
		return usersToUpdate;
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

//		Utils.generateFormatedIds(DataStorage.getFormatedIds());

//		 runs the 10 threads, one for reading the data and the other one for updating 10 random users;
		while (id < 100) {
			
			Thread t1 = new Thread(new ThreadReader(), "ATypeThread1");
			t1.start();
			t1.join();
			Thread t6 = new Thread(new ThreadUpdater(), "BTypeThread1");
			t6.start();
			t6.join();
//			
//			Thread t2 = new Thread(new ThreadReader(), "ATypeThread1");
//			t2.start();
//			t2.join();
//			Thread t7 = new Thread(new ThreadUpdater(), "BTypeThread1");
//			t7.start();
//			t7.join();
//			
//			Thread t3 = new Thread(new ThreadReader(), "ATypeThread1");
//			t3.start();
//			t3.join();
//			Thread t8 = new Thread(new ThreadUpdater(), "BTypeThread1");
//			t8.start();
//			t8.join();
//			
//			Thread t4 = new Thread(new ThreadReader(), "ATypeThread1");
//			t4.start();
//			t4.join();
//			Thread t9 = new Thread(new ThreadUpdater(), "BTypeThread1");
//			t9.start();
//			t9.join();
//			
//			Thread t5 = new Thread(new ThreadReader(), "ATypeThread1");
//			t5.start();
//			t5.join();
//			Thread t10 = new Thread(new ThreadUpdater(), "BTypeThread1");
//			t10.start();
//			t10.join();
		}
		System.out.println(DataStorage.getUserStorage().toString());
		System.out.println(Arrays.toString(randomIds.toArray()));
	}
}