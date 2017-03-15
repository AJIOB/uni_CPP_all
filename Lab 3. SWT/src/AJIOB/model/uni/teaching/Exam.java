package AJIOB.model.uni.teaching;

import AJIOB.exceptions.NoInitException;
import AJIOB.model.uni.people.Educator;
import AJIOB.model.uni.people.Student;
import AJIOB.view.MainShell;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by AJIOB on 07.03.2017.
 */
public class Exam {
    private final Subject subject;
    private final Educator educator;
    private final ArrayList<Student> students = new ArrayList<>();
    private boolean isPassed;

    public Exam(Subject subject, Educator educator, Student[] students) {
        this.subject = subject;
        this.educator = educator;
        if (students != null) {
            Collections.addAll(this.students, students);
        }
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

    /**
     * Returns is exam passed
     *
     * @return Is exam passed
     */
    public boolean isPassed() {
        return isPassed;
    }

    /**
     * Set is exam passed
     *
     * @param passed Is exam passed
     */
    public void setPassed(boolean passed) {
        isPassed = passed;
    }

    /**
     * Start current exam
     */
    public void startExam() {
        System.out.println("Exam " + subject.getName() + " is started");
        if (!educator.takeExam(this)) {
            return;
        }

        try
        {
            MainShell.getUniversity().getExams().remove(this);
        } catch (NoInitException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return ("Subject: " + subject.getName() + "Educator: " + educator.getName());
    }
}
