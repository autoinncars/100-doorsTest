import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 5/5/16.
 */
public class PersonTest {
    int passNumber;
    List<Doors> door;
    Person person = new Person();
    List<String> expected = new ArrayList<String>();
    List<String> actual = new ArrayList<String>();


    @org.junit.Test
    public void personCheckAllDoorsToBeOpenPassOne() throws Exception {
        door = person.createAndOpenAllDoors();
        for (int i = 0; i < 100; i++) {
            expected.add("open");
        }
        for (Doors d : door) {
            actual.add(d.string);
        }

        assertEquals(expected, actual);
    }

    @Test
    public void personCheckEverySecondDoorToBeClosedPassTwo() throws Exception {
        person.createAndOpenAllDoors();
        door = person.toggleDoors(2);
        for (int i = 0; i < 100; i++) {
            expected.add("open");
        }
        for (int i = 1; i < 100; i += 2) {
            expected.set(i, "closed");
        }

        for (Doors d : door) {
            actual.add(d.string);
        }

        assertEquals(expected, actual);
    }

    @Test
    public void personTogglesDoorsPassTree() throws Exception {
        person.createAndOpenAllDoors();
        door = person.toggleDoors(3);
        for (int i = 0; i < 100; i++) {
            expected.add("open");
        }
        for (int i = 1; i < 100; i += 2) {
            expected.set(i, "closed");
        }
        for (int i = 2; i < expected.size(); i += 3) {
            if (expected.get(i).equals("open")) {
                expected.set(i, "closed");
            } else {
                expected.set(i, "open");
            }
        }
        for (Doors d : door) {
            actual.add(d.string);
        }
        assertEquals(expected, actual);
    }

    @Test
    public void personTogglesDoorsPassFour() throws Exception {
        person.createAndOpenAllDoors();
        door = person.toggleDoors(100);
        for (int i = 0; i < 100; i++) {
            expected.add("open");
        }
        for (passNumber = 1; passNumber < 100; passNumber++) {
            for (int i = passNumber; i < 100; i += passNumber + 1) {
                if (expected.get(i).equals("open")) {
                    expected.set(i, "closed");
                } else {
                    if (expected.get(i).equals("closed")) {
                        expected.set(i, "open");
                    }
                }
            }
        }
        for (Doors d : door) {
            actual.add(d.string);
        }
        int i = 1;
        for (String str : actual) {
         System.out.println(i + " " + str);
         i++;
         }

        assertEquals(expected, actual);
    }
}
