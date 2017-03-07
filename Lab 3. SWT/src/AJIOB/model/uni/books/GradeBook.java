package AJIOB.model.uni.books;

import AJIOB.model.uni.teaching.Mark;

import java.util.List;

/**
 * Created by AJIOB on 07.03.2017.
 */
public class GradeBook {
    static int currentMaxNumber;

    private final int recBookNumber;
    private String name;
    private List<Mark> marks;

    public GradeBook(final String studentName) {
        this.name = studentName;
        this.recBookNumber = getNextNumber();
    }

    /**
     * Generate next grade book recBookNumber
     * @return next grade book number
     */
    private static int getNextNumber() {
        return ++currentMaxNumber;
    }

    public String getStudentName() {
        return name;
    }

    public int getGradeBookNumber() {
        return recBookNumber;
    }

    public final List<Mark> getMarks() {
        return marks;
    }

    /**
     * Write mark to grade book
     * @param mark Mark to add
     */
    public void addMark(final Mark mark) {
        marks.add(mark);
    }
}
