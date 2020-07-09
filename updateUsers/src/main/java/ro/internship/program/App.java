package ro.internship.program;

import java.util.List;
import ro.internship.classes.User;
import ro.internship.services.ThreadUserUpdate;
import ro.internship.services.Utils;
import ro.internship.storage.DataStorage;

public class App {

  public static void main(String[] args) throws InterruptedException {

    // Load storage at app start
    DataStorage.loadStorage();

    // create users
    //    List<User> myInitialData = Utils.generateUsers(5);
    //    for (User user : myInitialData) {
    //      DataStorage.setRecord(user);
    //    }

    // start the game
    Thread t1 = new ThreadUserUpdate(1, 5);
    t1.start();
    Thread t2 = new ThreadUserUpdate(1, 10);
    t2.start();
    Thread t3 = new ThreadUserUpdate(1, 20);
    t3.start();

    Thread.sleep(1000);

    //
    DataStorage.saveStorage();
  }
}
