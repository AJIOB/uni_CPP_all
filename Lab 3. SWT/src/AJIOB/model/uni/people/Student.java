package AJIOB.model.uni.people;

import AJIOB.model.uni.books.GradeBook;

import static java.lang.Math.random;

/**
 * Created by AJIOB on 07.03.2017.
 */
public class Student extends Person {
    private final GradeBook gradeBook;

    public Student(String name, GradeBook gradeBook) {
        super(name);
        this.gradeBook = gradeBook;
    }

    public Student(Person person, GradeBook gradeBook) {
        super(person);
        this.gradeBook = gradeBook;
    }

    /**
     * Student passing exam
     *
     * @return Answer on exam
     */
    public String passExam() {
        int lengthOfAnswer = (int) (random() * 10);
        char[] str = new char[lengthOfAnswer];
        return new String(str);
    }

    public GradeBook getGradeBook() {
        return gradeBook;
    }
}
