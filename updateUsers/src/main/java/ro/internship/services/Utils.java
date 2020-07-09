package ro.internship.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import ro.internship.classes.User;

public class Utils {

  // function that generates a random number between "start" and "end";
  public static int randBetween(int start, int end) {

    return start + (int) Math.round(Math.random() * (end - start));
  }

  // function that generates a random birthday date for an user;
  private static String randomBirthday() {

    GregorianCalendar gc = new GregorianCalendar();
    int year = randBetween(1956, 2002);
    gc.set(Calendar.YEAR, year);
    int dayOfYear = randBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));
    gc.set(Calendar.DAY_OF_YEAR, dayOfYear);
    LocalDate birthday =
        LocalDate.of(
            gc.get(Calendar.YEAR), (gc.get(Calendar.MONTH) + 1), gc.get(Calendar.DAY_OF_MONTH));

    return birthday.toString();
  }

  public static List<User> generateUsers(int totalUsersToGenerate) {

    List<User> users = new ArrayList<User>();

    String[] firstName = {"Andrei", "Alex", "Andreea", "Florin"};
    String[] lastName = {"Popa", "Vasile", "Gheorghe", "Ilie", "Iconaru", "Ene"};

    for (int i = 1; i <= totalUsersToGenerate; i++) {

      users.add(
          new User(
              i,
              firstName[randBetween(0, firstName.length - 1)],
              lastName[randBetween(0, lastName.length - 1)],
              randomBirthday(),
              10));
    }

    return users;
  }

  public static String formatId(Integer id) {

    return String.format("%016d", id);
  }
}
