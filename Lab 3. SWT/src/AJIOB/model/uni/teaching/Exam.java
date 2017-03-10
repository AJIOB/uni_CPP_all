package AJIOB.model.uni.teaching;

import AJIOB.model.uni.people.Educator;
import AJIOB.model.uni.people.Student;

import java.util.ArrayList;

/**
 * Created by AJIOB on 07.03.2017.
 */
public class Exam {
    private final Subject subject;
    private final Educator educator;
    private final ArrayList<Student> students;
    private boolean isPassed;

    public Exam(Subject subject, Educator educator, ArrayList<Student> students) {
        this.subject = subject;
        this.educator = educator;
        this.students = students;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public Subject getSubject() {
        return subject;
    }

    public Educator getEducator() {
        return educator;
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

    @Override
    public String toString() {
        return ("Subject: " + subject.getName() + "Educator: " + educator.getName());
    }
}
