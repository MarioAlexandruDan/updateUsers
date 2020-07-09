package ro.internship.services;

import ro.internship.classes.User;
import ro.internship.storage.DataStorage;

public class Transactions {

  public static synchronized void updateUserBalance(Integer userId, Integer amountToIncrement) {

    User user = DataStorage.getRecord(userId);
    user.setTotalAmount(user.getTotalAmount() + amountToIncrement);
    DataStorage.setRecord(user);
  }
}
