package ro.internship.program;

import java.util.Map;

import ro.intrenship.classes.*;
import ro.internship.storage.DataStorage;
import ro.internship.services.*;

public class App {

	public static void main(String[] args) {

		Map<Integer, User> tenUsers = Utils.generateUsers();

		for(int i = 0; i < 10; i++) {
			tenUsers.get(i).getData();
		}
	}
}
