package ro.internship.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ro.management.classes.User;
import ro.management.program.App;
import ro.management.storage.UserStorage;

public class Transactions {

	final static Logger logger = LogManager.getLogger(App.class);

	public static synchronized void updateUserBalance(Integer userId, Integer amountToIncrement) {

		User user = UserStorage.getRecord(userId);
		logger.debug("Added user to storage: " + user.toString());
		user.setTotalAmount(user.getTotalAmount() + amountToIncrement);
		logger.debug("Increased totalAmount: " + user.getTotalAmount());
		UserStorage.setRecord(user);
		logger.debug("Updated user: " + user.toString());
	}
}
