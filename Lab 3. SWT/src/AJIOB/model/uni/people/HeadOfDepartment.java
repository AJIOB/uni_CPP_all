package AJIOB.model.uni.people;

import AJIOB.model.uni.teaching.Subject;

import java.util.List;

/**
 * Created by AJIOB on 07.03.2017.
 */
public class HeadOfDepartment extends Worker {
    private List<Subject> subjects;

    HeadOfDepartment(final String name) {
        super(name, "HeadOfDepartment");
    }

    /**
     * Set exam of subject
     *
     * @param subj Examining subject
     * @return Is exam setted
     */
    public boolean appointExam(final Subject subj) {
        //todo

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

    public final List<Subject> getSubjects() {
        return subjects;
    }
}
