package ro.internship.services;

public class ThreadUserUpdate extends Thread {

	private int userId;

	private int amountToIncrement;

	public ThreadUserUpdate(int userId, int amountToIncrement) {
		this.userId = userId;
		this.amountToIncrement = amountToIncrement;
	}

	public void run() {

		Transactions.updateUserBalance(userId, amountToIncrement);
	}
}
