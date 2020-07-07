package ro.internship;

import java.io.IOException;
import ro.internship.Utils.Utils;
import ro.internship.classes.User;
import ro.internship.services.UserFileWritter;
import ro.internship.storage.UserStorage;

public class App {

  private static volatile int id = 0;

  public static synchronized int getId() {
    
    id++;
    return id;
  }
  
  public static synchronized void incId() {
	  id++;
  }

  public static void main(String[] args) throws IOException {

    // runs the app until every user is written to the file;
    while (true) {

      // gets a user from the main users collection;
      User tempUser = Utils.generateUser(getId());

      // add user to in memory database
      UserStorage.addRecord(tempUser);

      System.out.println("Start Writing user " + tempUser.toString());

      // save at the end
      UserFileWritter.writeToJSON(UserStorage.getStorageAsString());

      if (UserStorage.size() == 100) break;
    }
    
    System.out.println("DB: " + UserStorage.getStorageAsString());
    
  }
}
