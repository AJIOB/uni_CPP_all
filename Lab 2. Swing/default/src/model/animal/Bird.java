package model.animal;

/**
 * Created by Alex on 21.02.2017.
 */
public class Bird extends Animal {
    private int numOfWings;

    public Bird(final String name, final int numOfWings) {
        super(10, 20, 30, 40, name);

        this.numOfWings = numOfWings;
    }

    public int getNumOfWings() {
        return numOfWings;
    }
}
