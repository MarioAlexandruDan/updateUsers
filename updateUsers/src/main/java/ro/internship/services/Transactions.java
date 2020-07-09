package ro.internship.services;

import ro.management.classes.User;
import ro.management.storage.UserStorage;

public class Transactions {

  public static synchronized void updateUserBalance(Integer userId, Integer amountToIncrement) {

    User user = UserStorage.getRecord(userId);
    user.setTotalAmount(user.getTotalAmount() + amountToIncrement);
    UserStorage.setRecord(user);
  }
}
