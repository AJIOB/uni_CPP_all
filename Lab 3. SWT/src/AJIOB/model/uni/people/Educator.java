package AJIOB.model.uni.people;

import AJIOB.model.uni.people.Worker;
import AJIOB.model.uni.teaching.Exam;

import java.util.List;

/**
 * Created by AJIOB on 07.03.2017.
 */
public class Educator extends Worker {
    private List<Exam> exams;

    Educator(String name) {
        super(name);
    }

    /**
     * Adding exam to schedule of teacher
     * @param exam Adding exam
     */
    public void addExam(Exam exam) {
        exams.add(exam);
    }
}
