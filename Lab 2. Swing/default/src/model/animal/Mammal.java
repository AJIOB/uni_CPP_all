package model.animal;

/**
 * Created by Alex on 21.02.2017.
 */
public class Mammal extends Animal {
    private int numOfArms;

    public Mammal(String name, int numOfArms) {
        super(1,2, 4, 123, name);

        this.numOfArms = numOfArms;
    }

    public int getNumOfArms() {
        return numOfArms;
    }
}
