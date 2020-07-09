package ro.internship.storage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ro.internship.classes.User;
import ro.internship.services.FileProcessor;
import ro.internship.services.Utils;

public class DataStorage {

  private static volatile Map<String, User> userStorage = new HashMap<String, User>();

  public static Map<String, User> getUserStorage() {

    return userStorage;
  }

  public static User getRecord(Integer userId) {

    return userStorage.get(Utils.formatId(userId));
  }

  public static void setRecord(User user) {

    userStorage.put(Utils.formatId(user.getId()), user);
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

  public static void saveStorage() {

    FileProcessor.writeStringToFile(getStorageAsString());
  }

  public static void loadStorage() {

    String fileContent = FileProcessor.readStringFromFIle();

    ObjectMapper objectMapper = new ObjectMapper();
    try {

      userStorage = objectMapper.readValue(fileContent, new TypeReference<Map<String, User>>() {});

    } catch (IOException e) {

      e.printStackTrace();
      System.out.println("PROBLEM WITH CONVERSION FROM FILE CONTENT TO MY MAP");
    }
  }

  private static void printMap(String idToFind) {

    Iterator<Entry<String, User>> it = userStorage.entrySet().iterator();

    while (it.hasNext()) {

      Map.Entry<String, User> pair = it.next();
      System.out.println(pair.getKey() + " = " + pair.getValue().toString());
    }
  }
}
