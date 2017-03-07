package AJIOB.model.uni.teaching;

/**
 * Created by AJIOB on 07.03.2017.
 */
public class Subject {
    private final String name;

    public Subject(final String name){
        this.name = name;
    }

    /**
     * Returns name of subject
     * @return Name of subject
     */
    public String getName() {
        return name;
    }
}
