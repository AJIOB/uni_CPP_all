package AJIOB.model.uni.people;

/**
 * Created by AJIOB on 07.03.2017.
 */
abstract public class Person {
    private String name;

    Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
