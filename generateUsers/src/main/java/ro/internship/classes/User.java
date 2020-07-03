package ro.internship.classes;

import java.time.LocalDate;

public class User {

	// Fields necesare pentru un user: prenume, nume si data nasterii;
	private String firstName;
	private String lastName;
	private LocalDate birthday;
	private String id;
	
	// Constructor pentru clasa User;
	public User(String firstName, String lastName, LocalDate birthday, String id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.id = id;
	}

	/** @return the firstName */
	public String getFirstName() {
		return firstName;
	}

	/** @param firstName the firstName to set */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/** @return the lastName */
	public String getLastName() {
		return lastName;
	}

	/** @param lastName the lastName to set */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/** @return the birthday */
	public LocalDate getBirthday() {
		return birthday;
	}

	/** @param birthday the birthday to set */
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	/** @return the id */
	public String getId() {
		return id;
	}

	/** @param id the id to set */
	public void setId(String id) {
		this.id = id;
	}
	
	public void getData() {
		System.out.println(this.id + "{ firstName: " + this.firstName + "; lastName: " + this.lastName + "; birthday: " + this.birthday + " }");
	}
}
