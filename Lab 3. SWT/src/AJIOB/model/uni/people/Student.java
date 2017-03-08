package AJIOB.model.uni.people;

import AJIOB.model.uni.books.GradeBook;

/**
 * Created by AJIOB on 07.03.2017.
 */
public class Student {
    private final String name;
    private final GradeBook gradeBook;

    public Student(String name, GradeBook gradeBook) {
        this.name = name;
        this.gradeBook = gradeBook;
    }

    public void passExam() {
        //todo
    }

}
