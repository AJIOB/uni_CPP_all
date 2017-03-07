package AJIOB.model.uni.buildings;

import AJIOB.model.uni.books.GradeBook;
import AJIOB.model.uni.people.Person;
import AJIOB.model.uni.teaching.Exam;
import AJIOB.model.uni.teaching.Subject;

/**
 * Created by AJIOB on 07.03.2017.
 */
public class University implements Building {
    private final String name;

    public University(String name) {
        this.name = name;
    }

    @Override
    public double getSquare() {
        //TODO
        return 0;
    }

    /**
     * Enroll new student
     * @param futureStudent Person that will be a student
     */
    public void enrollStudent(Person futureStudent) {
        //TODO
    }

    /**
     * Make new record book for student
     * @return New record book
     */
    public GradeBook getRecordBook() {
        //TODO
        return new GradeBook("");
    }

    /**
     * Making exam (and adding it in schedule)
     * @param subj Subject, that students will pass
     * @return New exam
     */
    public Exam createExam(final Subject subj) {
        //TODO
        return new Exam(new Subject(""), null, null);
    }

    public String getName() {
        return name;
    }
}
