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

	// Getters pentru a returna id-ul incrementat
	public synchronized static int getNextId() {

		return id++;
	}

	// Getters pentru a returna id-ul;
	public synchronized static int getId() {

		return id;
	}

	public static void main(String[] args) {

		Map<Integer, User> tenUsers = Utils.generateUsers();

		Set<String> randomIds = DataStorage.getRandomIds();

		ArrayList randomIdsList = new ArrayList(randomIds);

		Collections.sort(randomIdsList);

		for (int i = 0; i < 10; i++) {
			tenUsers.get(i).setId(randomIdsList.get(i).toString());
		}

		System.out.println(Arrays.toString(randomIdsList.toArray()));

		for (int i = 0; i < 10; i++) {
			tenUsers.get(i).getData();
		}

	}
}