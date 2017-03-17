package AJIOB.model.uni.people;

import AJIOB.exceptions.NoInitException;
import AJIOB.model.uni.teaching.Exam;
import AJIOB.model.uni.teaching.Subject;
import AJIOB.view.MainShell;

import java.util.ArrayList;

import static java.lang.Math.random;

/**
 * Created by AJIOB on 07.03.2017.
 */
public class HeadOfDepartment extends Worker {
    private ArrayList<Subject> subjects = new ArrayList<>();
    private ArrayList<Educator> educators = new ArrayList<>();

    public HeadOfDepartment(final String name) {
        super(name, "HeadOfDepartment");
    }

    public HeadOfDepartment(final Person p) {
        super(p, "HeadOfDepartment");
    }

    /**
     * Set exam of subject
     *
     * @param subj Examining subject
     * @return Is exam setted
     */
    public boolean appointExam(final Subject subj) {
        if (!subjects.contains(subj)) {
            return false;
        }

        int randRes = (int) (random() * educators.size());
        if (randRes >= educators.size()) {
            randRes = 0;
        }

        Exam exam;

        try {
            exam = MainShell.getUniversity().createExam(subj, educators.get(randRes));
        } catch (NoInitException e) {
            e.printStackTrace();
            return false;
        }

        educators.get(randRes).addExam(exam);

        return true;
    }

    /**
     * Add subject to head of department
     *
     * @param subj Subject to add
     */
    public void addSubject(final Subject subj) {
        subjects.add(subj);
    }

    public final ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public ArrayList<Educator> getEducators() {
        return educators;
    }
}
