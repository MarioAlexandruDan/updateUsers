package ro.internship.Utils;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import ro.internship.classes.User;

public class Utils {

	public static int randBetween(int start, int end) {

		return start + (int) Math.round(Math.random() * (end - start));
	}

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

		String[] firstName = { "Larry", "Sally", "Jack", "Rachel" };
		String[] lastName = { "McDonald", "Marshall", "Lee", "Jackson", "Graham", "Davies" };

		for (int i = 0; i < 100; i++) {
			String record = String.format("%016d", i + 1);
			Users.put(i, new User(firstName[randBetween(0, firstName.length - 1)],
					lastName[randBetween(0, lastName.length - 1)], randomBirthday(), record));
		}

		return Users;
	}
	
	public static Map<Integer, User> generateAnonUsers() {
		Map<Integer, User> Users = new HashMap<Integer, User>();
		LocalDate date = randomBirthday();
		for (int i = 0; i < 10; i++) {
			String record = String.format("%04d", i + 1);
			Users.put(i, new User("John", "Doe", date, record));
		}

		return Users;
	}

	public static Set<String> generateRandomIds() {
		Random rand = new Random();

		Set<String> randomIds = new TreeSet<String>();
		while(randomIds.size() < 11) {
			
			int aux = rand.nextInt(100);
			String record = String.format("%016d", aux + 1);
			randomIds.add(record);
		}

		
		return randomIds;	
	}

}
