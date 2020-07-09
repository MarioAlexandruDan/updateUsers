package ro.internship.classes;

public class User {

  private Integer id;
  private String firstName;
  private String lastName;
  private String birthday;
  private Integer totalAmount;

  public User() {}

  public User(Integer id, String firstName, String lastName, String birthday, Integer totalAmount) {

    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthday = birthday;
    this.totalAmount = totalAmount;
  }

  public void setId(Integer id) {

    this.id = id;
  }

  public void setFirstName(String firstName) {

    this.firstName = firstName;
  }

  public void setLastName(String lastName) {

    this.lastName = lastName;
  }

  public void setBirthday(String birthday) {

    this.birthday = birthday;
  }

  public Integer getId() {

    return id;
  }

  public String getFirstName() {

    return firstName;
  }

  public String getLastName() {

    return lastName;
  }

  public String getBirthday() {

    return birthday;
  }

  /** @return the totalAmount */
  public Integer getTotalAmount() {
    return totalAmount;
  }

  /** @param totalAmount the totalAmount to set */
  public void setTotalAmount(Integer totalAmount) {
    this.totalAmount = totalAmount;
  }

  @Override
  public String toString() {

    return "\""
        + this.id
        + "\""
        + ":{\"firstName\":"
        + this.firstName
        + ",\"lastName\":"
        + this.lastName
        + ",\"birthday\":"
        + this.birthday
        + ",\"count\":"
        + this.totalAmount
        + "}";
  }
}
