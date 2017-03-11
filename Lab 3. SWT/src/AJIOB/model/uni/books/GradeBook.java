package AJIOB.model.uni.books;

import AJIOB.model.uni.people.Person;
import AJIOB.model.uni.teaching.Mark;

import java.util.ArrayList;

/**
 * Created by AJIOB on 07.03.2017.
 */
public class GradeBook {
    static int currentMaxNumber;

    private final int gradeBookNumber;
    private final Person person;
    private ArrayList<Mark> marks;

    public GradeBook(final Person person) {
        this.person = person;
        this.gradeBookNumber = getNextNumber();
    }

    /**
     * Generate next grade book gradeBookNumber
     *
     * @return next grade book number
     */
    private static int getNextNumber() {
        return ++currentMaxNumber;
    }

    public final Person getPerson() {
        return person;
    }

    public int getGradeBookNumber() {
        return gradeBookNumber;
    }

    public final ArrayList<Mark> getMarks() {
        return marks;
    }

    /**
     * Write mark to grade book
     *
     * @param mark Mark to add
     */
    public void addMark(final Mark mark) {
        marks.add(mark);
    }
}
