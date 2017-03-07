package AJIOB.model.uni.teaching;

import AJIOB.model.uni.people.Educator;
import AJIOB.model.uni.people.Student;

import java.util.List;

/**
 * Created by AJIOB on 07.03.2017.
 */
public class Exam {
    private final Subject subject;
    private final Educator educator;
    private final List<Student> students;
    private boolean isPassed;

    public Exam(Subject subject, Educator educator, List<Student> students) {
        this.subject = subject;
        this.educator = educator;
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Subject getSubject() {
        return subject;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean passed) {
        isPassed = passed;
    }

    /**
     * Start current exam
     */
    public void startExam() {
        //TODO
    }
}
