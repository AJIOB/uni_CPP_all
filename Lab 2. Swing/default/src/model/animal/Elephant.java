package model.animal;

/**
 * Created by Alex on 21.02.2017.
 */
public class Elephant extends Mammal {
    private int numOfTrunks = 1;

    public Elephant(String name) {
        super(name, 4);
    }

    public int getNumOfTrunks() {
        return numOfTrunks;
    }

    /**
     * Use elephant's trunk
     *
     * @return Message from trunk
     */
    public String useTrunk() {
        return "У-у-у-у";
    }
}
