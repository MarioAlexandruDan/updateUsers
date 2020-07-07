package ro.internship.Utils;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import ro.internship.classes.User;

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
    LocalDate birthday =
        LocalDate.of(
            gc.get(Calendar.YEAR), (gc.get(Calendar.MONTH) + 1), gc.get(Calendar.DAY_OF_MONTH));

    return birthday;
  }

  // function that returns a map of 100 Users;
  public static Map<Integer, User> generateUsers() {

    Map<Integer, User> Users = new HashMap<Integer, User>();

    String[] firstName = {"Larry", "Sally", "Jack", "Rachel"};
    String[] lastName = {"McDonald", "Marshall", "Lee", "Jackson", "Graham", "Davies"};

    for (int i = 0; i < 100; i++) {
      String record = String.format("%016d", i + 1);
      Users.put(
          i,
          new User(
              firstName[randBetween(0, firstName.length - 1)],
              lastName[randBetween(0, lastName.length - 1)],
              randomBirthday(),
              record));
    }

    return Users;
  }

  public static User generateUser(int userId) {

    String[] firstName = {"Larry", "Sally", "Jack", "Rachel"};
    String[] lastName = {"McDonald", "Marshall", "Lee", "Jackson", "Graham", "Davies"};

    return new User(
        firstName[randBetween(0, firstName.length - 1)],
        lastName[randBetween(0, lastName.length - 1)],
        randomBirthday(),
        String.format("%016d", userId));
  }
}
