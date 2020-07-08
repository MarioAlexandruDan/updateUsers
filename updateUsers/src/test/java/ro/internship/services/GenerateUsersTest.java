package ro.internship.services;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import ro.internship.classes.User;

public class GenerateUsersTest {

    @Test
    public void test() {

        Utils test = new Utils();

        Map<Integer, User> users = test.generateUsers();

        if (users.isEmpty()) {
            fail("Your Map doesn't contain any users");
        }

        for (int i = 0; i < users.size(); i++) {
            if (Integer.parseInt(users.get(i).getId()) < 0) {
                fail("The user " + i + " id can't be less than 0");
            }
            if (Integer.parseInt(users.get(i).getId()) > 10) {
                fail("The user " + i + " id can't be more than 10");
            }
            if (Integer.parseInt(users.get(i).getId()) != i + 1) {
                fail("The user " + i + " id is not matching correct id");
            }
            if(users.get(i).getFirstName().isEmpty()) {
                fail("The user " + i + "dosen't have a first name");
            }
            if(users.get(i).getLastName().isEmpty()) {
                fail("The user " + i + "dosen't have a last name");
            }
            if(users.get(i).getBirthday().toString().isEmpty()) {
                fail("The user " + i + "dosen't have a birthday");
            }
        }
    }

}