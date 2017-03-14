package AJIOB.model.uni.people;

import AJIOB.model.uni.teaching.Exam;
import AJIOB.model.uni.teaching.Mark;

import java.util.ArrayList;

/**
 * Created by AJIOB on 07.03.2017.
 */
public class Educator extends Worker {
    private final ArrayList<Exam> exams = new ArrayList<>();

    public Educator(String name) {
        super(name, "Educator");
    }

    /**
     * Adding exam to schedule of teacher
     *
     * @param exam Adding exam
     */
    public void addExam(Exam exam) {
        exams.add(exam);
    }

    /**
     * Take exam if this exam corresponds this educator
     *
     * @param exam Exam to take
     * @return Is exam taken
     */
    public boolean takeExam(Exam exam) {
        boolean res = exams.remove(exam);

        for (Student s : exam.getStudents()) {
            s.getGradeBook().addMark(new Mark(s.passExam().length(), exam.getSubject()));
        }

        return res;
    }
}
