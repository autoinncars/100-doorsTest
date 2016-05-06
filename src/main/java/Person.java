import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 5/5/16.
 */
public class Person {
    List<Doors> door = new ArrayList<Doors>();


    public List<Doors> createAndOpenAllDoors() {
        for (int i = 0; i < 100; i++) {
            door.add(new Doors());
            door.get(i).string = "open";
            door.get(i).numOfDoorToggles = door.get(i).numOfDoorToggles + 1;
        }
        return door;
    }

    public List<Doors> toggleDoors(int passNumber) {
        for (int k = 1; k < passNumber; k++) {
            for (int i = k; i < 100; i += k + 1) {
                if (door.get(i).numOfDoorToggles % 2 != 0) {
                    door.get(i).string = "closed";
                    door.get(i).numOfDoorToggles = door.get(i).numOfDoorToggles + 1;
                } else {
                    door.get(i).string = "open";
                    door.get(i).numOfDoorToggles = door.get(i).numOfDoorToggles + 1;
                }
            }
        }
        return door;
    }
}

