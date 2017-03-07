package AJIOB.model.uni.people;

import AJIOB.model.uni.books.GradeBook;

/**
 * Created by AJIOB on 07.03.2017.
 */
public class Student {
    private final String name;
    private final GradeBook recBook;

    public Student(String name, GradeBook recBook) {
        this.name = name;
        this.recBook = recBook;
    }

    public void passExam() {
        //todo
    }

}
