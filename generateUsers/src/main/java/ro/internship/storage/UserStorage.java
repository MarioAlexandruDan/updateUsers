package ro.internship.storage;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ro.internship.classes.User;

public class UserStorage {

  private static volatile Map<String, User> userStorage = new HashMap<String, User>();

  public static void addRecord(User user) {

    userStorage.put(user.getId(), user);
  }

  public static User getRecord(String userId) {

    return userStorage.get(userId);
  }

  public static String getStorageAsString() {

    ObjectMapper objectMapper = new ObjectMapper();
    try {

      return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userStorage);

    } catch (JsonProcessingException e) {

      e.printStackTrace();
    }

    return null;
  }

  public static int size() {
    return userStorage.size();
  }
}
