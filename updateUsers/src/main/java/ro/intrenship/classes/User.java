package ro.intrenship.classes;

import java.time.LocalDate;

public class User {

	private String id;
	private String firstName;
	private String lastName;
	private LocalDate birthday;

	public User(String id, String firstName, String lastName, LocalDate birthday) {

		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
	}

	public void setId(String id) {

		this.id = id;
	}

	public void setFirstName(String firstName) {

		this.firstName = firstName;
	}

	public void setLastName(String lastName) {

		this.lastName = lastName;
	}

	public void setBirthday(LocalDate birthday) {

		this.birthday = birthday;
	}

	public String getId() {

		return id;
	}

	public String getFirstName() {

		return firstName;
	}

	public String getLastName() {

		return lastName;
	}

	public LocalDate getBirthday() {

		return birthday;
	}

	//For returning all the data form and User
	public void getData() {

		System.out.println(this.id + "{ firstName: " + this.firstName + "; lastName: " + this.lastName + "; birthday: "
				+ this.birthday + " }");
	}
}
