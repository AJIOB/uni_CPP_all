package AJIOB.model.uni.people;

import AJIOB.model.uni.buildings.ClassRoom;

import java.util.ArrayList;

/**
 * Created by AJIOB on 07.03.2017.
 */
public class Engineer extends Worker {

    private ArrayList<ClassRoom> rooms;

    public Engineer(final String name, ArrayList<ClassRoom> rooms) {
        super(name, "Engineer");
        this.rooms = rooms;
    }
}
