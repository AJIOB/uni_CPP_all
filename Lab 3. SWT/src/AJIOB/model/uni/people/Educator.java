package AJIOB.model.uni.people;

import AJIOB.model.uni.teaching.Exam;

import java.util.ArrayList;

/**
 * Created by AJIOB on 07.03.2017.
 */
public class Educator extends Worker {
    private ArrayList<Exam> exams;

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
}
