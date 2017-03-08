package AJIOB.model.uni;

import AJIOB.model.uni.books.GradeBook;
import AJIOB.model.uni.buildings.Building;
import AJIOB.model.uni.people.Person;
import AJIOB.model.uni.people.Student;
import AJIOB.model.uni.people.Worker;
import AJIOB.model.uni.teaching.Exam;
import AJIOB.model.uni.teaching.Subject;

import java.util.List;

/**
 * Created by AJIOB on 07.03.2017.
 */
public class University implements Building {
    private final String name;

    private final double length;
    private final double width;

    private List<Worker> workers;
    private List<Subject> subjects;
    private List<Exam> exams;
    private List<GradeBook> gradeBooks;
    private List<Student> students;

    public University(String name, double length, double width) {
        this.name = name;
        this.length = length;
        this.width = width;
    }

    @Override
    public double getSquare() {
        return length * width;
    }

    /**
     * Enroll new student
     *
     * @param futureStudent Person that will be a student
     */
    public void enrollStudent(Person futureStudent) {
        //TODO
    }

    /**
     * Make new record book for student
     *
     * @return New record book
     */
    public GradeBook getNewRecordBook() {
        //TODO
        return new GradeBook(null);
    }

    /**
     * Making exam (and adding it in schedule)
     *
     * @param subj Subject, that students will pass
     * @return New exam
     */
    public Exam createExam(final Subject subj) {
        //TODO
        return new Exam(new Subject(""), null, null);
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public List<GradeBook> getGradeBooks() {
        return gradeBooks;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public List<Worker> getWorkers() {
        return workers;
    }
}
