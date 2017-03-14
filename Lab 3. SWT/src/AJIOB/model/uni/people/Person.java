package AJIOB.model.uni.people;

/**
 * Created by AJIOB on 07.03.2017.
 */
public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    Person(Person person) {
        name = person.name;
    }

    public String getName() {
        return name;
    }
}
