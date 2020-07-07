package ro.internship.services;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class GenerateRandomIdsTest {

    @Test
    public void test() {

        Utils test = new Utils();

        ArrayList<String> randomIdsList = test.generateRandomIds();

        for (int i = 0; i < randomIdsList.size(); i++) {
            if (randomIdsList.get(i).isEmpty()) {
                fail("We found a empty spot in the list at index : " + i);
            }
            if(i > 1 && Integer.parseInt(randomIdsList.get(i - 1)) > Integer.parseInt(randomIdsList.get(i))) {
                fail("The List is not sorted");
            }
        }

    }

}
