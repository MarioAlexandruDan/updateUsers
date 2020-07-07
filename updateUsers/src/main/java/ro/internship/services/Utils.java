package ro.internship.services;

import java.awt.List;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import ro.intrenship.classes.*;

public class Utils {

	// function that generates a random number between "start" and "end";
	public static int randBetween(int start, int end) {

		return start + (int) Math.round(Math.random() * (end - start));
	}

	// function that generates a random birthday date for an user;
	private static LocalDate randomBirthday() {

		GregorianCalendar gc = new GregorianCalendar();
		int year = randBetween(1956, 2002);
		gc.set(Calendar.YEAR, year);
		int dayOfYear = randBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));
		gc.set(Calendar.DAY_OF_YEAR, dayOfYear);
		LocalDate birthday = LocalDate.of(gc.get(Calendar.YEAR), (gc.get(Calendar.MONTH) + 1),
				gc.get(Calendar.DAY_OF_MONTH));

		return birthday;
	}

	public static Map<Integer, User> generateUsers() {

		Map<Integer, User> Users = new HashMap<Integer, User>();

		String[] firstName = { "Andrei", "Alex", "Andreea", "Florin" };
		String[] lastName = { "Popa", "Vasile", "Gheorghe", "Ilie", "Iconaru", "Ene" };

		for (int i = 0; i < 10; i++) {
			String record = String.format("%016d", i + 1);
			Users.put(i, new User(record, firstName[randBetween(0, firstName.length - 1)], lastName[randBetween(0, lastName.length - 1)], randomBirthday()));
		}

		return Users;
	}
	
	// function that generates a list of 10 ids
	public static ArrayList<String> generateRandomIds() {

		Set<String> randomIds = new TreeSet<String>();
		while (randomIds.size() < 10) {

			int aux = Utils.randBetween(1, 99);
			String record = String.format("%016d", aux);
			randomIds.add(record);
		}
		
		ArrayList randomIdsList = new ArrayList(randomIds);
		Collections.sort(randomIdsList);

		return randomIdsList;
	}
	
	public static ArrayList<String> generateFormatedIds() {
		ArrayList<String> ids = new ArrayList<String>();
		for(int i = 0; i < 100; i++) {
			ids.add(String.format("%016d", i));
		}
		return ids;
	}
	
}
